package robot;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;


public class RobotApplicationImplTest {
    
    private RobotApplication robotApp;
    private Robot robot;
    
    @Before
    public void setUp() {
    	robot = new Robot("TestRobort");
    	robotApp =  new RobotApplicationImpl();
    }
    
    @Test
    public void shouldCreateRobotWhenRobotNotExisted() {
        final String robotName = "TEST_ROBOT";       
        final Robot robot = robotApp.createRobot(robotName);
        
        assertEquals(robotName, robot.getName());
        assertSame(robot, robotApp.getRobot(robotName));     
    }
    
    @Test(expected=RobotAlreadyExistException.class)
    public void shouldThrowExceptionWhenCreateRobotAlreadyExisted() {
        final String robotName = "TEST_ROBOT";       
        robotApp.createRobot(robotName);
        robotApp.createRobot(robotName);     
    }
    
    @Test
    public void shouldReturnRobotNamesWhenGetRobotNames() {
        final String robotName = "TEST_ROBOT"; 
        
        robotApp.createRobot(robotName);        
        final String[] robotNames = robotApp.getRobotNames();
        assertArrayEquals( new String[]{robotName}, robotNames); 
    }
    
    @Test
    public void shouldReturnEmptyArrayWhenGetRobotNamesWithNoRobot() {
        assertArrayEquals( new String[]{},  robotApp.getRobotNames()); 
    }
    
    @Test
    public void shouldSetRobotPositionAndDirectionWhenPlaceWithValidCoordinatesAndDirection() {
    	// setup data
    	final int x = 2;
    	final int y = 3;
		String direciton = Direction.WEST.toString();
		
		// perform action
		robotApp.place(robot, x, y, direciton);
		
		// verify result
		assertEquals(new Position(x, y), robot.getPosition());
		assertEquals(Direction.WEST, robot.getDirection());
    }
    
    @Test
    public void shouldIgnorePlaceCommandWithInvalidPosiiton() {
    	// setup data
    	final int x = 2;
    	final int y = 3;
		String direciton = Direction.WEST.toString();
		robotApp.place(robot, x, y, direciton);
		
		// perform an invalid place
		try {
			robotApp.place(robot, -1, -1, direciton);
		} catch (Exception e) {
			// ignore excepton
		}
		
		// verify result
		assertEquals(new Position(x, y), robot.getPosition());
		assertEquals(Direction.WEST, robot.getDirection());
    }
    
    @Test
    public void shouldIgnorePlaceCommandWithInvalidDirection() {
    	// setup data
    	final int x = 2;
    	final int y = 3;
		String direciton = Direction.WEST.toString();
		robotApp.place(robot, x, y, direciton);
		
		// perform an invalid place
		try {
			robotApp.place(robot, x, y, direciton);
		} catch (Exception e) {
			// ignore excepton
		}
		
		// verify result
		assertEquals(new Position(x, y), robot.getPosition());
		assertEquals(Direction.WEST, robot.getDirection());
    }
    
    @Test
    public void shouldSetRobotToNewPositionWhenMoveWest() {
    	// setup data
    	robotApp.place(robot, 2, 3, Direction.WEST.toString());
    	final Position expectedNewPosition = new Position(1, 3);
    	  	
    	robotApp.move(robot);
    	
    	assertEquals(Direction.WEST, robot.getDirection());
    	assertEquals(expectedNewPosition, robot.getPosition());
    }
    
    @Test
    public void shouldSetRobotToNewPositionWhenMoveEast() {
    	// setup data
    	robotApp.place(robot, 2, 3, Direction.EAST.toString());
    	final Position expectedNewPosition = new Position(3, 3);    	
    	
    	robotApp.move(robot);
    	
    	assertEquals(expectedNewPosition, robot.getPosition());
    }
    
    @Test
    public void shouldSetRobotToNewPositionWhenMoveNorth() {
    	// setup data
    	robotApp.place(robot, 2, 3, Direction.NORTH.toString());
    	final Position expectedNewPosition = new Position(2, 4);    	
    	
    	robotApp.move(robot);
    	
    	assertEquals(expectedNewPosition, robot.getPosition());
    }
    
    @Test
    public void shouldSetRobotToNewPositionWhenMoveSouth() {
    	// setup data
    	robotApp.place(robot, 2, 3, Direction.SOUTH.toString());
    	final Position expectedNewPosition = new Position(2, 2);    	
    	
    	robotApp.move(robot);
    	
    	assertEquals(expectedNewPosition, robot.getPosition());
    }
	
	@Test()
	public void shouldNotThrowExceptionWhenMoveRobotWithUndefinedPosition() {
		robotApp.move(robot);
		assertNull(robot.getPosition());
		assertNull(robot.getDirection());
	}
	
	@Test(expected=RuntimeException.class)
    public void shouldThrowExceptionWhenMoveRobotOffTableGrid() {
    	robotApp.place(robot, 2, 0, Direction.SOUTH.toString());	   	
    	robotApp.move(robot);
    }
	
	@Test
	public void shouldReportRobotLocation() {
		robotApp.place(robot, 2, 3, Direction.WEST.toString());
		
		assertEquals("2,3,WEST", robotApp.report(robot));
	}
	
	
	@Test
	public void shouldRotateLeftWhenRobotPositionIsDefined() {
		// setup data
		final Direction expectedDirection = Direction.SOUTH;
		robotApp.place(robot, 2, 3, Direction.WEST.toString());
		
		// perform action
		robotApp.left(robot);
		
		// verify result
		assertEquals(expectedDirection, robot.getDirection());
	}
	
	@Test()
	public void shouldNotThrowExceptionWhenLeftWithUndefinedDirection() {
		robotApp.left(robot);	
		assertNull(robot.getDirection());
	}
	
	@Test
	public void shouldRotateRightWhenRobotPositionIsDefined() {
		// setup data
		final Direction expectedDirection = Direction.NORTH;
		robotApp.place(robot, 2, 3, Direction.WEST.toString());
		
		// perform action
		robotApp.right(robot);
		
		// verify result
		assertEquals(expectedDirection, robot.getDirection());
	}
	
	@Test()
	public void shouldNotThrowExceptionWhenRightWithUndefinedDirection() {
		robotApp.right(robot);
		assertNull(robot.getDirection());
	}
}
