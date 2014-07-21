public class GameOfLife {
	// get input from user

	private int gridSize = 10;
	private Grid grid;
	private int nextGenCount;

	public GameOfLife(int nextGenCount) {
		this.nextGenCount = nextGenCount;
		grid = new Grid(getCellValues(), getGridSize());
	}

	private int getGridSize() {
		return gridSize;
	}

	private int[][] getCellValues() {
		IOWrapper.println("Please enter all the cell values");
		int[][] cellValue = new int[getGridSize()][getGridSize()];
		for (int i = 0; i < getGridSize(); i++) {
			for (int j = 0; j < getGridSize(); j++) {
				cellValue[i][j] = IOWrapper.read() - 48;
			}
		}
		return cellValue;
	}

	public void start() {
		for (int i = 0; i < nextGenCount; i++) {
			grid.proceedNextGeneration();
		}
	}
}
