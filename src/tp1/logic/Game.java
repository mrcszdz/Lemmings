package tp1.logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import tp1.exceptions.GameLoadException;
import tp1.exceptions.ObjectParseException;
import tp1.exceptions.offBoardException;
import tp1.logic.gameobjects.GameObject;
import tp1.logic.gameobjects.GameObjectFactory;
import tp1.logic.gameobjects.Lemming;
import tp1.logic.lemmingRoles.LemmingRole;
import tp1.view.Messages;

public class Game implements GameModel, GameStatus, GameWorld, GameConfiguration {

	public static final int DIM_X = 10;
	public static final int DIM_Y = 10;
	private boolean play = true;
	private int nLevel;
	private int cycle;
	private GameObjectContainer gameContainer;
	private Direction spawnDir; 
	private int escaped = 0;
	private int maxLemmingsDead = 5;
	private int lemmingsToWin = 2;
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
			
			this.spawnDir = Direction.RIGHT;
			
			Position pos1 = new Position(2,3);
			Lemming lemming1 = new Lemming(pos1, this);
			this.gameContainer.add(lemming1);
			this.lemmingsAlive ++;
			
			Position pos2 = new Position(9,0);
			Lemming lemming2 = new Lemming(pos2, this);
			this.gameContainer.add(lemming2);
			this.lemmingsAlive ++;
			
			Position pos3 = new Position(0,8);
			Lemming lemming3 = new Lemming(pos3, this);
			this.gameContainer.add(lemming3);
			this.lemmingsAlive ++;
			
			Position pos4 = new Position(3,3);
			Lemming lemming4 = new Lemming(pos4, this);
			this.gameContainer.add(lemming4);
			this.lemmingsAlive ++;
		}
		else if(this.nLevel == 2) {
			this.gameContainer.initGame2();
		}
		
		else if(this.nLevel == 3) {
			this.gameContainer.initGame3();
		}
		
		else if(this.nLevel == 4) {
			this.gameContainer.initGame4();
		}
		
		else if(this.nLevel == 5) {
			this.gameContainer.initGame5();
		}
		
		else{
			this.gameContainer.initGame0();
		}
	}
	
	public void exit() {
		this.play = false;
		System.out.println("Exiting game ...");
	}
	
	public void reset() {
		this.lemmingsAlive = 0;
		this.lemmingsDead = 0;
		this.escaped = 0;
		this.cycle = 0;
		this.nLevel = 1;
		this.gameContainer.reset();
		this.initGame();
		System.out.println("Game reseted!");
	}
	
	public void update() {
		this.gameContainer.update();
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

	public void load(String fileName) throws GameLoadException {
		this.gameContainer = new GameObjectContainer();

		FileGameConfiguration config = new FileGameConfiguration(fileName, this);
		this.cycle = config.getCycle();
		this.lemmingsAlive = config.getNumLemmingsBoard();
		this.lemmingsDead = config.getNumLemmingsDead();
		this.lemmingsToWin = config.getNumLemmingsToWin();
		this.escaped = config.getNumLemmingsEscaped();
		for(int i = 0; i < config.getGameObjects().size(); i++) {
		this.gameContainer.add(config.getGameObjects().get(i)); 
		}
	}
	
	public boolean setRole(Position pos, LemmingRole role) throws offBoardException {
	boolean success = false;
	int i = 0;
	
	List<GameObject> objects = this.getGameContainer().getObjects();
     
	if(pos.overflowX(Game.DIM_X) || pos.overflowY(Game.DIM_Y))
	throw new offBoardException("Position %s off the board.".formatted(Messages.POSITION.formatted(pos.getRow(), pos.getCol())));
	while (i < objects.size() && !success) {
         if (pos.equals(objects.get(i).getPos())) {
             success = objects.get(i).setRole(role);
         }
         i++;
     	}
	if(!success) 
		throw new offBoardException("No lemming in position %s admits role %s".formatted(Messages.POSITION.formatted(pos.getRow(), pos.getCol()), role));
     	return true;
     }
	
	public boolean isInAir(Position pos) {
	    List<GameObject> objects = this.getGameContainer().getObjects();
	    int i = 0;
	    boolean inAir = true;
	    
	    while (i < objects.size() && inAir) {
	        if (pos.translate(Direction.DOWN).equals(objects.get(i).getPos()) && objects.get(i).isSolid()) {
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
		return this.lemmingsToWin;
	}

	public String positionToString(int col, int row) {
		Boolean found = false;
		String ret = Messages.EMPTY;
		String org = Messages.EMPTY;
		String lemmins = "";
		Position targetPos = new Position(col, row);
		List<GameObject> objects = this.getGameContainer().getObjects();
		
		for (int i=0; i<objects.size();i++) {
			found  = objects.get(i).getPos().equals(targetPos);
			if(found) {
				String c = objects.get(i).toString();
				ret += c;
				if ((c=="B") || (c =="ᗺ")) {
					lemmins += c;
				}
				else {
					org += c;
				}
			} 
		}
		
		return lemmins.length() <3 ? ret : org+lemmins.length();

	}
	
	public void addEscaped() {
		this.lemmingsAlive --;
		this.escaped++;
	}

	public boolean playerWins() {
		return this.escaped >= this.numLemmingsToWin();
	}

	public boolean playerLooses() {
		return this.numLemmingsDead() >= this.maxLemmingsDead || this.numLemmingsInBoard() == 0;
	}
}
