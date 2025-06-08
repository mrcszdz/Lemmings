package tp1.logic.lemmingRoles;

import tp1.logic.Direction;
import tp1.logic.Game;
import tp1.logic.Position;
import tp1.logic.gameobjects.ExitDoor;
import tp1.logic.gameobjects.GameItem;
import tp1.logic.gameobjects.Lemming;
import tp1.logic.gameobjects.MetalWall;
import tp1.logic.gameobjects.Wall;
import tp1.view.Messages;

public class DownCaverRole implements LemmingRole{
    public boolean parse(String input) {
		return input.toLowerCase().equals("dc") || input.toLowerCase().equals("downcaver");
	}
	
	public void play(Lemming lemming) {
	    Position pos = lemming.getPos();
        lemming.setCaida(0);
	    boolean cayendo = lemming.getGame().isInAir(pos);

	    if (!cayendo) {
	        if (lemming.getCaida() > 2) {
	            lemming.setVivo(false);
				lemming.getGame().lemmingDies();
				lemming.getGame().getGameContainer().remove(lemming);
	        } 
	    }
	    this.caer(lemming);
	}
	
	@Override
	public String toString(){
		return "DownCaver";
	}

	public void start( Lemming lemming ) {

	}
	public void caer(Lemming lemming) {
		lemming.setCaida(lemming.getCaida()+1);
		this.move(lemming);
	}
	public void move(Lemming lemming) {
		Position newPos;
		lemming.getGame().getGameContainer().receiveInteractionsFrom(lemming);
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
			wall.setVivo(false);
		}
		return false;
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
