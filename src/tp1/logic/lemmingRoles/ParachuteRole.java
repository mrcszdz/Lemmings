package tp1.logic.lemmingRoles;

import java.util.List;

import tp1.logic.Direction;
import tp1.logic.Game;
import tp1.logic.Position;
import tp1.logic.gameobjects.ExitDoor;
import tp1.logic.gameobjects.GameItem;
import tp1.logic.gameobjects.GameObject;
import tp1.logic.gameobjects.Lemming;
import tp1.logic.gameobjects.MetalWall;
import tp1.logic.gameobjects.Wall;

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
	public void caer(Lemming lemming) {
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
		if(newPos.overflow(Game.DIM_X, Game.DIM_Y)) {
			lemming.setVivo(false);
			lemming.getGame().lemmingDies();
		}
	}
	public String getIcon( Lemming lemming ) {
		String icon = "ᗺP";
		List<GameObject> objects = lemming.getGame().getGameContainer().getObjects();
		int count = 0;
		
		for	(int i = 0; i < objects.size(); i++) {
			if(lemming.getPos().equals(objects.get(i).getPos()) && lemming!=objects.get(i)) {
				count++;
			}
		}
		if(count == 2) icon = "Bᗺ";
		else if(count > 2) icon = Integer.toString(count);
		
		else if(lemming.getDir().equals(Direction.RIGHT)) icon = "BP";
		return icon;
	}

	public boolean receiveInteraction(GameItem other, Lemming lemming) {
		return true;
	}

	public boolean interactWith(Lemming receiver, Lemming lemming) {
		return true;
	}
	public boolean interactWith(Wall wall, Lemming lemming) {
		return true;
	}
	public boolean interactWith(ExitDoor door, Lemming lemming) {
		return true;
	}
	public boolean interactWith(MetalWall wall, Lemming lemming) {
		return true;
	}
}
