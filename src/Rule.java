public class Rule {
	public static boolean getNextGenState(boolean currentState,
			int neighbourCount) {
		boolean nextGeneration = false;
		if (currentState) {
			switch (neighbourCount) {
			case 2:
			case 3:
				nextGeneration = currentState;
				break;
			default:
				nextGeneration = !currentState;
			}
		} else {
			if (neighbourCount == 3)
				nextGeneration = !currentState;
			else
				nextGeneration = currentState;
		}
		return nextGeneration;
	}
}
