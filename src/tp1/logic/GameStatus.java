package tp1.logic;

public interface GameStatus {
	public int getCycle();
	public int numLemmingsInBoard();
	public String positionToString(int col, int row);
}
