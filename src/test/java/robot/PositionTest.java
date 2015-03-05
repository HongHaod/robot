package robot;

import static org.junit.Assert.*;

import org.junit.Test;

public class PositionTest {

	@Test
	public void shouldIncreaseXcoordinateWhenAddX() {
		final int increment = 3;
		final Position position = new Position(1, 2);
		final Position newPostion = position.addX(increment);
		
		assertEquals(position.getX() + increment, newPostion.getX());
		assertEquals(position.getY(), newPostion.getY());
	}

	@Test
	public void shouldIncreaseYcoordinateWhenAddY() {
		final int increment = 3;
		final Position position = new Position(1, 2);
		final Position newPostion = position.addY(increment);
		
		assertEquals(position.getX(), newPostion.getX());
		assertEquals(position.getY() + increment, newPostion.getY());
	}
	
	@Test
	public void shouldReturnPositionString() {
		final Position position = new Position(2, 3);
		assertEquals("2,3", position.toString());
	}

}
