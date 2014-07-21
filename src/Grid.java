public class Grid {

	Cell[][] cells;
	private int gridSize;

	public Grid(int[][] seed, int gridSize) {
		this.gridSize = gridSize;
		cells = new Cell[gridSize][gridSize];
		for (int i = 0; i < gridSize; i++) {
			for (int j = 0; j < gridSize; j++) {
				cells[i][j] = new Cell(this, i, j);
				if (seed[i][j] == 1)
					cells[i][j].setLife(true);
			}
		}
	}

	public int neighbourCount(int i, int j) {
		return getNeighboursInAboveLine(i, j) + getNeighboursInSameLine(i, j)
				+ getNeighboursCountInBelowLine(i, j);
	}

	public void proceedNextGeneration() {
		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells[i].length; j++) {
				cells[i][j].determineNextState();
			}
		}
		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells[i].length; j++) {
				cells[i][j].updateToNextGen();
			}
		}
		showNextGeneration();
	}

	private int getNeighboursCountInBelowLine(int i, int j) {
		// TODO Auto-generated method stub
		int count = 0;
		if (i < gridSize-1) {
			int k = 0;
			if (j != 0)
				k = j - 1;
			for (; k <= j + 1 && k < gridSize; k++)
				if (cells[i + 1][k].isAlive())
					count++;
		}
		return count;
	}

	private int getNeighboursInSameLine(int i, int j) {
		// TODO Auto-generated method stub
		int count = 0;
		if (j != 0 && cells[i][j - 1].isAlive())
			count++;
		if (j != cells.length - 1 && cells[i][j + 1].isAlive())
			count++;

		return count;
	}

	private int getNeighboursInAboveLine(int i, int j) {
		// TODO Auto-generated method stub
		int count = 0;
		if (i > 0) {
			int k = 0;
			if (j != 0)
				k = j - 1;
			for (; k <= j + 1 && k < cells[i].length; k++)
				if (cells[i - 1][k].isAlive())
					count++;
		}
		return count;
	}

	private void showNextGeneration() {
		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells[i].length; j++) {
				cells[i][j].display();
			}
			IOWrapper.println("");
		}
	}

}
