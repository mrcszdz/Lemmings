package tp1.logic.gameobjects;

import tp1.logic.Game;
import tp1.logic.Position;

public abstract class GameObject {
	protected Position pos;
	protected boolean vivo;
	protected Game game;
	
	public GameObject(Position pos) {
		this.pos = pos;
		this.vivo = true;
	}
	
	public Game getGame() {
		return this.game;
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
}
