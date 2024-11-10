package tp1.logic.lemmingRoles;

import java.util.List;

import tp1.logic.Direction;
import tp1.logic.Game;
import tp1.logic.Position;
import tp1.logic.gameobjects.GameObject;
import tp1.logic.gameobjects.Lemming;
import tp1.logic.gameobjects.Wall;

public class WalkerRole {
    
	public void play(Lemming lemming) {
	    Position pos = lemming.getPos();
	    boolean cayendo = lemming.getGame().isInAir(pos);

	    if (!cayendo) {
	        if (lemming.getCaida() > 2) {
	            lemming.setVivo(false);
	        } else {
	            lemming.setCaida(0);
	            Position newPos = pos.translate(lemming.getDir());
	            List<GameObject> walls = lemming.getGame().getGameContainer().filterType(Wall.class);
	            boolean pared = false;
	            int j = 0;

	            while (j < walls.size() && !pared) {
	                if (newPos.equals(walls.get(j).getPos())) {
	                    pared = true;
	                }
	                j++;
	            }

	            if (pared) {
	                if (lemming.getDir() == Direction.LEFT) {
	                    lemming.setDir(Direction.RIGHT);
	                } else {
	                    lemming.setDir(Direction.LEFT);
	                }
	            } else {
	                this.move(lemming);
	            }
	        }
	    } else {
	        this.caer(lemming);
	    }
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
		lemming.setPos(newPos);
		if(newPos.overflow(Game.DIM_X, Game.DIM_Y)) {
			lemming.setVivo(false);
		}
	}
	
	public String getIcon( Lemming lemming ) {
		String icon = "ᗺ";
		 List<GameObject> lemmings = lemming.getGame().getGameContainer().filterType(Lemming.class);
		int count = 0;
		
		for	(int i = 0; i < lemmings.size(); i++) {
			if(lemming.getPos().equals(lemmings.get(i).getPos())) {
				count++;
			}
		}
		if(count == 2) icon = "Bᗺ";
		else if(count > 2) icon = Integer.toString(count);
		
		else if(lemming.getDir().equals(Direction.RIGHT)) icon = "B";
		return icon;
	}
}
