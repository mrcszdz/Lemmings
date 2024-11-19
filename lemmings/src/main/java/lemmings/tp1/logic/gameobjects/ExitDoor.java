package lemmings.tp1.logic.gameobjects;

import lemmings.tp1.logic.Position;
import lemmings.tp1.view.Messages;

public class ExitDoor extends GameObject {

	public ExitDoor(Position pos) {
		super(pos);
	}
	
	public void update () {
		
	}

	public String toString() {
		return Messages.EXIT_DOOR;
	}
	

	public boolean receiveInteraction(GameItem other) {
        return other.interactWith(this);
    }

    public boolean interactWith(Wall wall) {
        return false;
    };

    public boolean interactWith(ExitDoor door) {
        return false;
    };

    public boolean interactWith(MetalWall wall) {
        return false;
    }

    public boolean interactWith(Lemming lemming) {
        return true;
    }

    public boolean isSolid() {
        return false;
    }
	public boolean isAlive() {
        return false;
    }
	public boolean isExit() {
        return false;
    }
	public boolean isInPosition(Position pos) {
        return false;
    }
}