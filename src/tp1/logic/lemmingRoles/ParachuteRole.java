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

public class ParachuteRole implements LemmingRole {
	public boolean parse(String input) {
		return input.toLowerCase().equals("p") || input.toLowerCase().equals("parachute");
	}
	public void play(Lemming lemming) {
	    Position pos = lemming.getPos();
	    boolean cayendo = lemming.getGame().isInAir(pos);

	    if (!cayendo) {
			lemming.setCaida(0);
            lemming.disableRole();
	    } else {
	        this.caer(lemming);
	    }
	}
	public void start( Lemming lemming ) {

	}
	
	@Override
	public String toString(){
		return "Parachute";
	}
	
	public void caer(Lemming lemming) {
		System.out.println("FALL");
		lemming.setCaida(1);
		this.move(lemming);
	}
	public void move(Lemming lemming) {
		Position newPos;
		if(lemming.getCaida() != 0) {
            newPos = lemming.getPos().translate(Direction.DOWN);
		}
		
		else {
			newPos = lemming.getPos().translate(lemming.getDir());
		}
		lemming.setPos(newPos);
		if(newPos.overflowY( Game.DIM_Y)) {
			lemming.setVivo(false);
			lemming.getGame().lemmingDies();
		}
	}
	public String getIcon( Lemming lemming ) {
		return Messages.LEMMING_PARACHUTE;
	}

	public boolean receiveInteraction(GameItem other, Lemming lemming) {
		return false;
	}

	public boolean interactWith(Lemming receiver, Lemming lemming) {
		return false;
	}
	public boolean interactWith(Wall wall, Lemming lemming) {
		return false;
	}
	public boolean interactWith(ExitDoor door, Lemming lemming) {
		return false;
	}
	public boolean interactWith(MetalWall wall, Lemming lemming) {
		return false;
	}
}
