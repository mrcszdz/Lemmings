package tp1.logic;

public interface GameModel {

	boolean isPlay();

	void exit();
	void update();
	void reset();
	GameObjectContainer getGameContainer();
	
}
