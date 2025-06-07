package tp1.logic.gameobjects;

import tp1.exceptions.ObjectParseException;
import tp1.exceptions.offBoardException;
import tp1.logic.GameWorld;
import tp1.logic.Position;
import tp1.logic.lemmingRoles.LemmingRole;

public abstract class GameObject implements GameItem {
	protected Position pos;
	protected boolean vivo;
	protected GameWorld game;
	
	public abstract GameObject parse(String[] line, GameWorld game) throws ObjectParseException, offBoardException;
	
	public abstract GameObject deepCopy();

	public GameObject(Position pos) {
		this.pos = pos;
		this.vivo = true;
	}
	
	public boolean isVivo() {
        return vivo;
    }

	public void setPos(Position pos) {
    	this.pos = pos;
    }
	
	public void setVivo(boolean vivo) {
    	this.vivo = vivo;
    }
	
	public Position getPos() {
		return this.pos;
	}
	
	public abstract void update();

	public boolean setRole(LemmingRole role) {
		return false;
	}

	public abstract Boolean toString(String string);
}
