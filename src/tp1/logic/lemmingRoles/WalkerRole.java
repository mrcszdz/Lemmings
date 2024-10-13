package tp1.logic.lemmingRoles;

import java.util.List;

import tp1.logic.Direction;
import tp1.logic.Game;
import tp1.logic.Position;
import tp1.logic.gameobjects.Lemming;
import tp1.logic.gameobjects.Wall;

public class WalkerRole {
    
	public void play(Lemming lemming) {
        List<Wall> walls = lemming.getGame().getGameContainer().getWalls();
        Position pos = lemming.getPos();
        boolean cayendo = true;

        for (int i = 0; i < walls.size(); i++) {
            //Check if it is in the air
            if(pos.translate(Direction.DOWN).equals(walls.get(i).getPos())) {
                //If it was falling from 3 blocks or more, it dies
                cayendo = false;
            }
        }
        if (!cayendo) {
            if (lemming.getCaida() > 2) {
                lemming.setVivo(false);
            }
            //If it survived, reset fall momentum and check walls for sideways movement
            else {
                lemming.setCaida(0);
                Position newPos = lemming.getPos().translate(lemming.getDir());
                boolean pared = false;

                for (int j = 0; j < walls.size(); j++) {
                    if(newPos.equals(walls.get(j).getPos())) {
                        pared = true;
                    }
                }

                if (pared) {
                    if(lemming.getDir() == Direction.LEFT) {
                        lemming.setDir(Direction.RIGHT);
                    }
                    else {
                        lemming.setDir(Direction.LEFT);
                    }
                }
                else {
                    this.move(lemming);
                }
            }
        }
        //Fall if it is in the air
        else  {
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
		List<Lemming> lemmings = lemming.getGame().getGameContainer().getLemmings();
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
