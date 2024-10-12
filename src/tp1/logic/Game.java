package tp1.logic;

import java.util.List;

import tp1.logic.gameobjects.ExitDoor;
import tp1.logic.gameobjects.Lemming;
import tp1.logic.gameobjects.Wall;
import tp1.view.Messages;

public class Game {

	public static final int DIM_X = 10;
	public static final int DIM_Y = 10;
	private boolean play = true;
	private int nLevel;
	private int cycle = 0;
	private GameObjectContainer gameContainer;
	private Position spawn;
	private int escaped = 0;

	public Game(int nLevel) {
		this.nLevel = nLevel;
		this.gameContainer = new GameObjectContainer();
		this.spawn = new Position(3, 3);
	}
	
	public void exit() {
		this.play = false;
	}
	
	public void reset() {
		this.gameContainer.reset();
		this.cycle = 0;
		this.nLevel = 1;
	}
	
	public void update() {
		if(this.cycle % 3 == 0) {
			Lemming lemming = new Lemming(this.spawn, this);
			this.gameContainer.add(lemming);
		}
		this.gameContainer.update();
		this.cycle ++;
	}
	
	public int getCycle() {
		// TODO Auto-generated method stub
		return this.cycle;
	}
	
	public boolean isPlay() {
        return play;
    }

    public int getnLevel() {
        return nLevel;
    }

    public GameObjectContainer getGameContainer() {
        return gameContainer;
    }

	public int numLemmingsInBoard() {
		// TODO Auto-generated method stub
		return this.gameContainer.getLemmings().size() - this.numLemmingsDead();
	}

	public int numLemmingsDead() {
		int cont = 0;
		List<Lemming> lemmings = this.gameContainer.getLemmings();
		for	(int i = 0; i < lemmings.size(); i++) {
			if(!lemmings.get(i).isVivo()) {
				cont++;
			}
		}
		return cont;
	}

	public int numLemmingsExit() {
		return this.escaped;
	}


	public int numLemmingsToWin() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String positionToString(int col, int row) {
		int i = 0;
		Boolean found = false;
		String ret = Messages.EMPTY;
		List<Lemming> lemmings = this.gameContainer.getLemmings();
		List<Wall> walls = this.gameContainer.getWalls();
		List<ExitDoor> exitdoors = this.gameContainer.getExitDoors();
		
		while(i < exitdoors.size() && !found) {
			found  = exitdoors.get(i).getPos().getCol() == col &&
					exitdoors.get(i).getPos().getRow() == row;
			if(found) ret = Messages.EXIT_DOOR;
			i++;
		}
		i = 0;
		
		while(i < lemmings.size() && !found) {
			found  = lemmings.get(i).getPos().getCol() == col &&
				lemmings.get(i).getPos().getRow() == row;
			if(found && lemmings.get(i).isVivo()) ret = lemmings.get(i).getRol().getIcon(lemmings.get(i));
			i++;
		}
		i = 0;
		while(i < walls.size() && !found) {
			found  = walls.get(i).getPos().getCol() == col &&
				walls.get(i).getPos().getRow() == row;
			if(found) ret = Messages.WALL;
			i++;
		}
		
		
		
		
		return ret;

	}
	
	public void addEscaped() {
		this.escaped++;
	}

	public boolean playerWins() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean playerLooses() {
		// TODO Auto-generated method stub
		return false;
	}

	public String help() {
		// TODO Auto-generated method stub
		return null;
	}

}
