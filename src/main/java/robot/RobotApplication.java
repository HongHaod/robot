package robot;

public interface RobotApplication {
    Robot createRobot(final String name);
    Robot getRobot(final String name);
    String[] getRobotNames();
	void move(final Robot robot);
	void place(final Robot robot, final int xPosition, final int yPosiiton, final String direction);
	String report(final Robot robot);
	void left(final Robot robot);
	void right(final Robot robot);
}
