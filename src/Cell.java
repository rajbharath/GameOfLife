public class Cell {
	private boolean currentLifeStatus;
	private boolean nextGenStatus;
	private Grid grid;
	private int i, j;

	public Cell(Grid grid, int i, int j) {
		// TODO Auto-generated constructor stub
		this.grid = grid;
		this.i = i;
		this.j = j;
	}

	public boolean isAlive() {
		return currentLifeStatus;
	}

	public int getNeighBourCount() {
		return grid.neighbourCount(i, j);
	}

	public void setLife(boolean life) {
		this.currentLifeStatus = life;
	}

	public void determineNextState() {
		nextGenStatus = Rule.getNextGenState(currentLifeStatus, getNeighBourCount());

	}

	public void display() {
		if (currentLifeStatus)
			IOWrapper.print(1 + " ");
		else
			IOWrapper.print(0 + " ");
	}

	public void updateToNextGen() {
		currentLifeStatus = nextGenStatus;
	}

}
