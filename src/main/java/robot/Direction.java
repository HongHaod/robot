package robot;

public enum Direction {
	NORTH(0), EAST(1), SOUTH(2), WEST(3);
	
	private int clockwiseOrder;
	
	private Direction(final int clockwiseOrder) {
		this.clockwiseOrder = clockwiseOrder;
	}
	
	public Direction rotate(final Rotation rotation) {
		final Direction[] values = Direction.values();
		final int minClockwiseOrder = values[0].clockwiseOrder;
		final int maxClockwiseOrder = values[values.length - 1].clockwiseOrder;
		
		int newClockwiseOrder = clockwiseOrder;
		if (rotation == Rotation.RIGHT) {
			if (newClockwiseOrder >= maxClockwiseOrder) {
				newClockwiseOrder = minClockwiseOrder;
			} else {
				newClockwiseOrder += 1;
			}
		} else {
			if (newClockwiseOrder <= minClockwiseOrder) {
				newClockwiseOrder = maxClockwiseOrder;
			} else {
				newClockwiseOrder -= 1;
			}
		}
		return values[newClockwiseOrder];
	}
}
