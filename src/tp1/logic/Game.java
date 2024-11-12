package tp1.logic;

import java.util.List;

import tp1.logic.gameobjects.GameObject;
import tp1.logic.gameobjects.Lemming;
import tp1.view.Messages;

public class Game implements GameModel, GameStatus, GameWorld {

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

	private int lemmingsAlive = 0;
	private int lemmingsDead = 0;
	
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
		
		else if(this.nLevel == 3) {
			this.gameContainer.initGame3();
			this.spawn = new Position(2, 3);
			this.spawnDir = Direction.RIGHT;
		}
		
		else if(this.nLevel == 4) {
			this.gameContainer.initGame4();
			this.spawn = new Position(3, 3);
			this.spawnDir = Direction.LEFT;
		}
		
		else if(this.nLevel == 5) {
			this.gameContainer.initGame5();
			this.spawn = new Position(0, 8);
			this.spawnDir = Direction.RIGHT;
		}
		
		else{
			this.gameContainer.initGame0();
			this.spawn = new Position(2, 3);
			this.spawnDir = Direction.RIGHT;
		}
	}
	
	public void exit() {
		this.play = false;
		System.out.println("Exiting game ...");
	}
	
	public void reset() {
		this.gameContainer.reset();
		this.initGame();
		this.lemmingsAlive = 0;
		this.lemmingsDead = 0;
		this.escaped = 0;
		this.cycle = 0;
		this.nLevel = 1;
		System.out.println("Game reseted!");
	}
	
	public void update() {
		this.gameContainer.update();
		if(this.cycle  == 0) {
			Lemming lemming = new Lemming(this.spawn, this);
			this.gameContainer.add(lemming);
			this.lemmingsAlive ++;
		}
		this.cycle ++;
		this.play = !this.playerLooses() && !this.playerWins();
	}
	
	@Override
	public int getCycle() {
		return this.cycle;
	}
	@Override
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
		return this.lemmingsAlive;
	}

	public int numLemmingsDead() {
		return this.lemmingsDead;
	}

	public void lemmingDies() {
		this.lemmingsDead ++;
		this.lemmingsAlive --;
	}

	public int numLemmingsExit() {
		return this.escaped;
	}

	public boolean isInAir(Position pos) {
	    List<GameObject> objects = this.getGameContainer().getObjects();
	    int i = 0;
	    boolean inAir = true;
	    
	    while (i < objects.size() && inAir) {
	        if (pos.translate(Direction.DOWN).equals(objects.get(i).getPos())) {
	            inAir = false;
	        }
	        i++;
	    }
	    return inAir;
	}
	
	public boolean lemmingArrived(Lemming lemming) {
		return lemming.escaped();
	}

	public int numLemmingsToWin() {
		return 2;
	}

	public String positionToString(int col, int row) {
		int i = 0;
		Boolean found = false;
		String ret = Messages.EMPTY;
		Position targetPos = new Position(col, row);
		List<GameObject> objects = this.getGameContainer().getObjects();
		
		while(i < objects.size() && !found) {
			found  = objects.get(i).getPos().equals(targetPos);
			if(found) {
				return objects.get(i).toString();
			} 
			i++;
		}
		
		return ret;

	}
	
	public void addEscaped() {
		this.lemmingsAlive --;
		this.escaped++;
	}

	public boolean playerWins() {
		return this.escaped >= this.numLemmingsToWin();
	}

	public boolean playerLooses() {
		return this.numLemmingsDead() >= this.maxLemmingsDead;
	}
}
