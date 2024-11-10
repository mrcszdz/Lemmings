package tp1.logic;

import tp1.logic.gameobjects.Lemming;

public interface GameStatus {
	public int getCycle();
	public String positionToString(int col, int row);
	public int numLemmingsInBoard();
	public int numLemmingsDead();
	public int numLemmingsExit();
	public int numLemmingsToWin();
	public boolean playerWins();
	public boolean playerLooses();
	public boolean isPlay();
	public int getnLevel();
	public Direction getSpawnDir();
	public GameObjectContainer getGameContainer();
	public boolean isInAir(Position pos);
	public boolean lemmingArrived(Lemming lemming);
	public void addEscaped();
}
