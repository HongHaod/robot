package robot.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

import robot.Robot;
import robot.RobotApplication;
import robot.RobotApplicationImpl;
import robot.TableGrid;


public class RobotApplicationEntry {
	private final RobotApplication robotApplication;
	private Robot robot;
	private BufferedReader inputReader;
	private InputStream inputStream = System.in;
	private PrintStream outputStream = System.out;
	private PrintStream errorStream = System.err;


	public RobotApplicationEntry(RobotApplication robotApplication) {
		this.robotApplication = robotApplication;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public void setOutputStream(PrintStream outputStream) {
		this.outputStream = outputStream;
	}

	public void setErrorStream(PrintStream errorStream) {
		this.errorStream = errorStream;
	}

	
	public void start() throws IOException {
		if (this.inputReader == null)
			this.inputReader = new BufferedReader(new InputStreamReader(inputStream));

		acceptInput();
	}

	public void acceptInput() throws IOException {
		String inputLine;
		while ((inputLine = inputReader.readLine()) != null) {
			processCommand(inputLine);
		}
	}

	
	private void processCommand(String inputString) {
		final String[] tokens = inputString.trim().split("\\s++");
		
		try {
			final RobotUICommand command = RobotUICommand.valueOf(tokens[0]);

			switch (command) {
			case PLACE:			
				String[] params = tokens[1].split(",");
				robotApplication.place(robot, Integer.valueOf(params[0]), Integer.valueOf(params[1]), params[2]);
				break;
			case MOVE:
				robotApplication.move(robot);
				break;
			case LEFT:
				robotApplication.left(robot);
				break;
			case RIGHT:
				robotApplication.right(robot);
				break;
			case REPORT:
				outputStream.printf("%s\n", robotApplication.report(robot));
				break;				
			}
			
		} catch (Exception e) {
			errorStream.printf("%s\n", e.getMessage());
		}
	}
	
	
	public final Robot getRobot() {
        return robot;
    }

    public final void setRobot(Robot robot) {
        this.robot = robot;
    }

    public static void main(String[] args) throws IOException {
        final String robotName = "Test-Robot";
		final RobotApplication robotAppliation = new RobotApplicationImpl();
		robotAppliation.createRobot(robotName);		
		final Robot robot = robotAppliation.getRobot(robotName);
		final RobotApplicationEntry appEntry = new RobotApplicationEntry(robotAppliation);
		appEntry.setRobot(robot);
		
		appEntry.start();
	}
	
}
