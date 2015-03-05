package robot;

public class Position {
	private int x;
	private int y;
	
	public Position (final int x, final int y) {
		this.x= x;
		this.y = y;
	}
	
	public Position addX(int increment) {
		return new Position(x + increment, y);
	}
	
	public Position addY(int increment) {
		return new Position(x, y  + increment);
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public String toString() {
		return x + "," + y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Position other = (Position) obj;
		if (x != other.x) {
			return false;
		}
		if (y != other.y) {
			return false;
		}
		return true;
	}
}
