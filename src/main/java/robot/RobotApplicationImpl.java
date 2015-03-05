package robot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RobotApplicationImpl implements RobotApplication {
    private TableGrid tableGrid;
    private Map<String, Robot> robotMap;

    public RobotApplicationImpl() {
        this.tableGrid = new TableGrid();
        robotMap = new HashMap<String, Robot>();
    }

    @Override
    public Robot createRobot(final String name) {
        Robot robot = getRobot(name);
        if (robot == null) {
            robot = new Robot(name);
            robotMap.put(name, robot);
        } else {
            throw new RobotAlreadyExistException("Robot " + name + " already existed");
        }
        return robot;
    }
    
    public Robot getRobot(final String name) {
        return robotMap.get(name);
    }

    @Override
    public String[] getRobotNames() {
        return new ArrayList<String>(robotMap.keySet()).toArray(new String[0]);
    }

    public void move(final Robot robot) {
        if (!robot.isPlaced()) {
            return;
        }

        final Position currentPosition = robot.getPosition();
        Position newPosition = null;

        switch (robot.getDirection()) {
        case NORTH:
            newPosition = currentPosition.addY(1);
            break;
        case SOUTH:
            newPosition = currentPosition.addY(-1);
            break;
        case WEST:
            newPosition = currentPosition.addX(-1);
            break;
        case EAST:
            newPosition = currentPosition.addX(1);
            break;
        }

        if (tableGrid.isPositionOnTable(newPosition.getX(), newPosition.getY())) {
            robot.setPosition(newPosition);
        } else {
            throw new RuntimeException("Invalid move, new Position (" + newPosition + ") is off the table");
        }
    }

    public void place(final Robot robot, int xPosition, int yPosiiton, String direction) {
        final Position newPosition = new Position(xPosition, yPosiiton);
        final Direction newDireciton = Direction.valueOf(direction);
        if (tableGrid.isPositionOnTable(xPosition, yPosiiton)) {
            robot.setPosition(newPosition);
            robot.setDirection(newDireciton);
        }
    }

    public String report(final Robot robot) {
        return robot.getPosition() + "," + robot.getDirection();
    }

    public void left(final Robot robot) {
        if (robot.isPlaced()) {
            final Direction newDirection = robot.getDirection().rotate(Rotation.LEFT);
            robot.setDirection(newDirection);
        }

    }

    public void right(final Robot robot) {
        if (robot.isPlaced()) {
            final Direction newDirection = robot.getDirection().rotate(Rotation.RIGHT);
            robot.setDirection(newDirection);
        }
    }

}
