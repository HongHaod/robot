package robot;

public class Robot {
	private String name;
	
	private Position position = null;	
	private Direction direction = null;
	
	
	public Robot(final String name) {
		this.name = name;
	}

	public Position getPosition() {
		return position;
	}
	
	public void setPosition(final Position position) {
		this.position = position;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(final Direction direction) {
		this.direction = direction;	
	}

    public final String getName() {
        return name;
    }
	
	public boolean isPlaced() {
	    return direction != null && position != null;
	}
}
