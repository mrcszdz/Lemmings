package tp1.logic.gameobjects;

import java.util.List;

import tp1.logic.Direction;
import tp1.logic.Position;

public class WalkerRole {
	private String name;
	
	public void play(Lemming lemming) {
		List<Wall> walls = lemming.getGame().getGameContainer().getWalls();
		Position pos = lemming.getPos();
		boolean cayendo = false;
		
		for	(int i = 0; i < walls.size(); i++) {
			//Check if it is in the air
			if((pos.getRow() + 1) == walls.get(i).getRow() 
				&& pos.getCol() == walls.get(i).getCol()) {
				//If it was falling from 3 blocks or more, it dies
				cayendo = true;
				
			}
		}
		if (cayendo) {
			if (lemming.getCaida() > 2) {
				lemming.setVivo(false);
			}
			//If it survived, reset fall momentum and check walls for sideways movement
			else {
				lemming.setCaida(0);
				
				int x = lemming.getPos().getCol()+lemming.getDir().getX();
				int y = lemming.getPos().getRow()+lemming.getDir().getY();
				Position newPos = new Position(x, y);
				boolean pared = false;
				
				for	(int j = 0; j < walls.size(); j++) {
					if(newPos.getRow() == walls.get(j).getRow() 
							&& newPos.getCol() == walls.get(j).getCol()) {
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
		if (lemming.getDir() != Direction.DOWN) {
			lemming.setDir(Direction.DOWN);
		}
		lemming.setCaida(lemming.getCaida()+1);
		this.move(lemming);;
	}
	public void move(Lemming lemming) {
		int x = lemming.getPos().getCol()+lemming.getDir().getX();
		int y = lemming.getPos().getRow()+lemming.getDir().getY();
		Position newPos = new Position(x, y);
		lemming.setPos(newPos);;
	}
}
