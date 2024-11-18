package lemmings.tp1.logic.gameobjects;

import lemmings.tp1.logic.Position;
import lemmings.tp1.view.Messages;

	public class MetalWall extends GameObject{

	public MetalWall(Position pos) {
		super(pos);
		}
	
	public void update() {
		
	}

	public String toString() {
		return Messages.METALWALL;
	}

	public boolean collides(Position pos) {
        return this.pos.equals(pos);
    };

	public boolean receiveInteraction(GameItem other) {
        return other.interactWith(this);
    }

    public boolean interactWith(Wall wall) {
        return true;
    };

    public boolean interactWith(ExitDoor door) {
        return true;
    };

    public boolean interactWith(MetalWall wall) {
        return true;
    }

    public boolean interactWith(Lemming lemming) {
        return true;
    }

    public boolean isSolid() {
        return true;
    }
	public boolean isAlive() {
        return true;
    }
	public boolean isExit() {
        return true;
    }
	public boolean isInPosition(Position pos) {
        return true;
    }
}
	




