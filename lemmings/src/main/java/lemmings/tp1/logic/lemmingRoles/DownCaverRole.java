package lemmings.tp1.logic.lemmingRoles;

import lemmings.tp1.logic.Direction;
import lemmings.tp1.logic.Game;
import lemmings.tp1.logic.Position;
import lemmings.tp1.logic.gameobjects.ExitDoor;
import lemmings.tp1.logic.gameobjects.GameItem;
import lemmings.tp1.logic.gameobjects.Lemming;
import lemmings.tp1.logic.gameobjects.MetalWall;
import lemmings.tp1.logic.gameobjects.Wall;
import lemmings.tp1.view.Messages;

public class DownCaverRole implements LemmingRole{
    public boolean parse(String input) {
		return input.toLowerCase().equals("dc") || input.toLowerCase().equals("downcaver");
	}
	
	public void play(Lemming lemming) {
	    Position pos = lemming.getPos();
	    boolean cayendo = lemming.getGame().isInAir(pos);

	    if (!cayendo) {
	        if (lemming.getCaida() > 2) {
	            lemming.setVivo(false);
				lemming.getGame().lemmingDies();
				lemming.getGame().getGameContainer().getObjects().remove(lemming);
	        } 
			else {
	            lemming.setCaida(0);
	        }
	    } else {
	        this.caer(lemming);
	    }
	}

	public void start( Lemming lemming ) {

	}
	public void caer(Lemming lemming) {
		
		lemming.setCaida(lemming.getCaida()+1);
		this.move(lemming);
	}
	public void move(Lemming lemming) {
		Position newPos;
		newPos = lemming.getPos().translate(Direction.DOWN);
		lemming.setPos(newPos);
		if(newPos.overflowY( Game.DIM_Y)) {
			lemming.setVivo(false);
			lemming.getGame().lemmingDies();
		}
	}
	
	public String getIcon( Lemming lemming ) {
		return Messages.LEMMING_DOWN_CAVER;
	}

	public boolean receiveInteraction(GameItem other, Lemming lemming) {
		return false;
	}

	public boolean interactWith(Lemming receiver, Lemming lemming) {
		return false;
	}
	public boolean interactWith(Wall wall, Lemming lemming) {
		Position newPos = lemming.getPos().translate(Direction.DOWN);
        boolean breakable = newPos.equals(wall.getPos());
		if (breakable) {
			lemming.getGame().getGameContainer().getObjects().remove(wall);
		}
		return breakable;
	}
	public boolean interactWith(MetalWall wall, Lemming lemming) {
		Position newPos = lemming.getPos().translate(Direction.DOWN);
		boolean unbreakable = newPos.equals(wall.getPos());
		if (unbreakable) {
			lemming.disableRole();
		}
		return unbreakable;
	}
	public boolean interactWith(ExitDoor door, Lemming lemming) {
		return false;
	}
}