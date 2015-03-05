package robot.ui;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.StringBufferInputStream;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;


import robot.Robot;
import robot.RobotApplication;
import robot.RobotApplicationImpl;
import robot.TableGrid;

public class RobotApplicaitonEntryTest {

	private RobotApplicationEntry app;
	private RobotApplication robotApp;
	
	@Before 
	public void setUp() {
//	    robotApp = mock(RobotApplication.class);
	    final Robot robot = new Robot("Hao");
        robotApp = new RobotApplicationImpl();		
	    app = new RobotApplicationEntry(robotApp);
	    app.setRobot(robot);
	}
	
	@Test
	public void test() throws IOException {
		// setup data
		final String inputFileName = "data/input_command.txt";
		final String outputFileName = "data/output_report.txt";	
		final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		app.setInputStream(new FileInputStream(getFile(inputFileName)));
		app.setOutputStream(new PrintStream(outputStream));
		
		// process input
		app.start();
	    
	    // verify result
	    final String actualOutputString = new String(outputStream.toByteArray());
	    String expectedOutputString = FileUtils.readFileToString(getFile(outputFileName)).replaceAll("\r", "");
		assertEquals(expectedOutputString.trim(), actualOutputString.trim());
	}

	
	private File getFile(final String fileName) {
		return FileUtils.toFile(this.getClass().getClassLoader().getResource(fileName));
	}
}
