package tp1.logic;

public interface GameModel {
	public boolean isPlay();
	public void update();
	public void reset();
	public void exit();
	public int numLemmingsToWin();
}
