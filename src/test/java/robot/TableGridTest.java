package robot;

import static org.junit.Assert.*;

import org.junit.Test;

public class TableGridTest {

	@Test
	public void shouldCreateTableGridWithCorrectMinAndMaxCoordinates() {
		final int xDimension = 5;
		int yDimension = 4;
		final TableGrid grid = new TableGrid(xDimension, yDimension);

		assertEquals(0, grid.getMinimumXCoordinate());
		assertEquals(xDimension, grid.getMaximumXCoordinate());
		assertEquals(0, grid.getMinimumYCoordinate());
		assertEquals(yDimension, grid.getMaximumYCoordinate());
	}

	@Test
	public void shouldReturnTrueWhenPositionInGridCoordinateRange() {
		final int xDimension = 5;
		int yDimension = 4;
		final TableGrid grid = new TableGrid(xDimension, yDimension);

		assertTrue(grid.isPositionOnTable(3, 2));
		assertTrue(grid.isPositionOnTable(xDimension, yDimension));
		assertTrue(grid.isPositionOnTable(0, 0));
	}

	@Test
	public void shouldReturnFalseWhenPositionNotInGridCoordinateRange() {
		final int xDimension = 5;
		int yDimension = 4;
		final TableGrid grid = new TableGrid(xDimension, yDimension);

		assertFalse(grid.isPositionOnTable(-1, 2));
		assertFalse(grid.isPositionOnTable(3, -1));
		assertFalse(grid.isPositionOnTable(xDimension + 1, 2));
		assertFalse(grid.isPositionOnTable(3, yDimension + 1));
	}
}
