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

public class DownCaverRole implements LemmingRole{
    public boolean parse(String input) {
		return input.toLowerCase().equals("dc") || input.toLowerCase().equals("downcaver");
	}
	
	public void play(Lemming lemming) {
	    Position pos = lemming.getPos();
	    boolean cayendo = lemming.getGame().isInAir(pos);

	    if (!cayendo) {
			System.out.println("FLOAT");
	        if (lemming.getCaida() > 2) {
	            lemming.setVivo(false);
				lemming.getGame().lemmingDies();
				lemming.getGame().getGameContainer().getObjects().remove(lemming);
	        } 
			else {
	            lemming.setCaida(0);
	        }
	    } else {
			System.out.println("DOWN");
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
		if(newPos.overflow(Game.DIM_X, Game.DIM_Y)) {
			lemming.setVivo(false);
			lemming.getGame().lemmingDies();
		}
	}
	
	public String getIcon( Lemming lemming ) {
		String icon = "ᗺv";
		List<GameObject> objects = lemming.getGame().getGameContainer().getObjects();
		int count = 0;
		
		for	(int i = 0; i < objects.size(); i++) {
			if(lemming.getPos().equals(objects.get(i).getPos()) && lemming!=objects.get(i)) {
				count++;
			}
		}
		if(count == 2) icon = "Bᗺv";
		else if(count > 2) icon = Integer.toString(count);
		
		else if(lemming.getDir().equals(Direction.RIGHT)) icon = "Bv";
		return icon;
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
