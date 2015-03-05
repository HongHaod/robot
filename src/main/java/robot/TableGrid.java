package robot;

public class TableGrid {
    
    private static final int DEFAULT_X_DIMENSION = 5;
    private static final int DEFAULT_Y_DIMENSION = 5;
    
	final int minimumXCoordinate = 0;
	final int minimumYCoordinate = 0;
	
	private int maximumXCoordinate;
	private int maximumYCoordinate;
	
	public TableGrid(final int xDimension, final int yDimension) {
		maximumXCoordinate = minimumXCoordinate + xDimension;
		maximumYCoordinate = minimumYCoordinate + yDimension;
	}
	
	public TableGrid() {
        this(DEFAULT_X_DIMENSION, DEFAULT_Y_DIMENSION);
    }

	public int getMinimumXCoordinate() {
		return minimumXCoordinate;
	}

	public int getMinimumYCoordinate() {
		return minimumYCoordinate;
	}

	public int getMaximumXCoordinate() {
		return maximumXCoordinate;
	}

	public int getMaximumYCoordinate() {
		return maximumYCoordinate;
	}

	public boolean isPositionOnTable(final int x, final int y) {
		return x >= minimumXCoordinate && x <= maximumXCoordinate && y >= minimumYCoordinate && y <= maximumYCoordinate;
	}

}
