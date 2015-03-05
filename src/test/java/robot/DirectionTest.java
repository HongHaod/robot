package robot;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DirectionTest {

	@Test
	public void shouldRotateLelfCorrectly() {
		assertEquals(Direction.WEST, Direction.NORTH.rotate(Rotation.LEFT));
		assertEquals(Direction.NORTH, Direction.EAST.rotate(Rotation.LEFT));
		assertEquals(Direction.EAST, Direction.SOUTH.rotate(Rotation.LEFT));
		assertEquals(Direction.SOUTH, Direction.WEST.rotate(Rotation.LEFT));
	}

	@Test
	public void shouldRotateRightCorrectly() {
		assertEquals(Direction.EAST, Direction.NORTH.rotate(Rotation.RIGHT));
		assertEquals(Direction.SOUTH, Direction.EAST.rotate(Rotation.RIGHT));
		assertEquals(Direction.WEST, Direction.SOUTH.rotate(Rotation.RIGHT));
		assertEquals(Direction.NORTH, Direction.WEST.rotate(Rotation.RIGHT));
	}
	
	@Test
	public void shouldCreateValidDirecitonUsingDirectionName() {
		assertEquals(Direction.NORTH, Direction.valueOf("NORTH"));
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void shouldThrowExceptionWhenCreateDirectionWithInvalidName() {
		Direction.valueOf("InvalidDirection");
	}
}
