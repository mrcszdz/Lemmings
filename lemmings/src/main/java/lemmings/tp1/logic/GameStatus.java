package lemmings.tp1.logic;

public interface GameStatus {

	boolean playerWins();
	boolean playerLooses();
	String positionToString(int col, int row);
	int getCycle();
	int numLemmingsInBoard();
	int numLemmingsDead();
	int numLemmingsExit();
	int numLemmingsToWin();
}
