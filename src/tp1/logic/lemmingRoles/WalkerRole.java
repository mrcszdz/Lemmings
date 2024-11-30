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
import tp1.view.Messages;

public class WalkerRole implements LemmingRole{
    public boolean parse(String input) {
		return input.toLowerCase().equals("w") || input.toLowerCase().equals("walker");
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
	            this.move(lemming);
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
		if(lemming.getCaida() != 0) {
            newPos = lemming.getPos().translate(Direction.DOWN);
		}
		
		else {
			newPos = lemming.getPos().translate(lemming.getDir());
		}
		
		if(newPos.overflowY(Game.DIM_Y)) {
			
			lemming.setVivo(false);
			lemming.getGame().lemmingDies();
		}
		else if(newPos.overflowX(Game.DIM_X - 1)) {
			if (lemming.getDir() == Direction.LEFT) {
				lemming.setDir(Direction.RIGHT);
			}
			else {
				lemming.setDir(Direction.LEFT);
			}
		}
		
		else {
			lemming.setPos(newPos);
		}
	}
	
	public String getIcon( Lemming lemming ) {
		String icon = "ᗺ";
		List<GameObject> objects = lemming.getGame().getGameContainer().getObjects();
		int count = 0;
		
		for	(int i = 0; i < objects.size(); i++) {
			if(lemming.getPos().equals(objects.get(i).getPos()) && lemming!=objects.get(i)) {
				count++;
			}
		}
		
		if(lemming.getDir().equals(Direction.RIGHT)) icon = "B";
		return icon;
	}

	public boolean receiveInteraction(GameItem other, Lemming lemming) {
		return false;
	}

	public boolean interactWith(Lemming receiver, Lemming lemming) {
		return false;
	}
	public boolean interactWith(Wall wall, Lemming lemming) {
		Position newPos = lemming.getPos().translate(lemming.getDir());
        boolean collision = newPos.equals(wall.getPos());
		if (collision) {
			if (lemming.getDir() == Direction.LEFT) {
				lemming.setDir(Direction.RIGHT);
			}
			else {
				lemming.setDir(Direction.LEFT);
			}
		}
		return collision;
	}
	public boolean interactWith(ExitDoor door, Lemming lemming) {
		return false;
	}

	public boolean interactWith(MetalWall wall, Lemming lemming) {
		return false;
	}
}
