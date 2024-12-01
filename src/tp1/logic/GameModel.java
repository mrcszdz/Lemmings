package tp1.logic;

import tp1.exceptions.GameLoadException;
import tp1.exceptions.offBoardException;
import tp1.logic.lemmingRoles.LemmingRole;

public interface GameModel {

	boolean isPlay();
	public boolean setRole(Position pos, LemmingRole role) throws offBoardException;
	void exit();
	void update();
	void reset();
	GameObjectContainer getGameContainer();	
	public void load(String fileName) throws GameLoadException;
}
