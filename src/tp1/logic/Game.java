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
	private int maxLemmingsDead = 5;
	private Direction spawnDir;

	public Game(int nLevel) {
		this.nLevel = nLevel;
		this.gameContainer = new GameObjectContainer();
		this.initGame();
	}
	
	public void initGame() {
		if(this.nLevel == 1) {
			this.gameContainer.initGame1();
			this.spawn = new Position(5,0);
			this.spawnDir = Direction.LEFT;
		}
		else if(this.nLevel == 2) {
			this.gameContainer.initGame2();
			this.spawn = new Position(8,0);
			this.spawnDir = Direction.LEFT;
		}
		
		else{
			this.gameContainer.initGame0();
			this.spawn = new Position(3,2);
			this.spawnDir = Direction.RIGHT;
		}
	}
	
	public void exit() {
		this.play = false;
		System.out.println("Exiting game ...");
	}
	
	public void reset() {
		this.gameContainer.reset();
		this.cycle = 0;
		this.nLevel = 1;
		System.out.println("Game reseted!");
	}
	
	public void update() {
		if(this.cycle % 3 == 0) {
			Lemming lemming = new Lemming(this.spawn, this);
			this.gameContainer.add(lemming);
		}
		this.gameContainer.update();
		this.cycle ++;
		this.play = !this.playerLooses() && !this.playerWins();
	}
	
	public int getCycle() {
		return this.cycle;
	}
	
	public boolean isPlay() {
        return play;
    }

    public int getnLevel() {
        return nLevel;
    }

    public Direction getSpawnDir() {
    	return this.spawnDir;
    }
    
    public GameObjectContainer getGameContainer() {
        return gameContainer;
    }

	public int numLemmingsInBoard() {
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
		return 2;
	}

	public String positionToString(int col, int row) {
		int i = 0;
		Boolean found = false;
		String ret = Messages.EMPTY;
		Position targetPos = new Position(col, row);
		List<Lemming> lemmings = this.gameContainer.getLemmings();
		List<Wall> walls = this.gameContainer.getWalls();
		List<ExitDoor> exitdoors = this.gameContainer.getExitDoors();
		
		while(i < exitdoors.size() && !found) {
			found  = exitdoors.get(i).getPos().equals(targetPos);
			if(found) ret = Messages.EXIT_DOOR;
			i++;
		}
		i = 0;
		
		while(i < lemmings.size() && !found) {
			found  = lemmings.get(i).getPos().equals(targetPos);
			if(found && lemmings.get(i).isVivo()) ret = lemmings.get(i).getRol().getIcon(lemmings.get(i));
			i++;
		}
		i = 0;
		while(i < walls.size() && !found) {
			found  = walls.get(i).getPos().equals(targetPos);
			if(found) ret = Messages.WALL;
			i++;
		}
		
		return ret;

	}
	
	public void addEscaped() {
		this.escaped++;
	}

	public boolean playerWins() {
		return this.escaped >= this.numLemmingsToWin();
	}

	public boolean playerLooses() {
		return this.numLemmingsDead() >= this.maxLemmingsDead;
	}

	public String help() {
		return "Available commands:\n"
		+ "[r]eset: start a new game\n"
		+ "[h]elp: print this help message\n"
		+ "[e]xit: end the execution of the game\n"
		+ "[n]one | \"\": skips cycle"
		+ "\n"
		+ "\n";
	}

}
