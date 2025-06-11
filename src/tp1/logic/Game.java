package tp1.logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import tp1.exceptions.CommandExecuteException;
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
	private Direction spawnDir = Direction.RIGHT; 
	private int escaped = 0;
	private int maxLemmingsDead = 5;
	private int lemmingsToWin = 2;
	private int lemmingsAlive = 0;
	private int lemmingsDead = 0;
	private GameConfiguration conf = FileGameConfiguration.NONE;
	
	public Game(int nLevel) {
		this.nLevel = nLevel;
		this.gameContainer = new GameObjectContainer();
		this.initGame();
	}
	
	public void initGame() {
		
		if(this.nLevel == 00) {
			this.gameContainer.initGame0(this);
			lemmingsAlive = 3;
		}
		else if(this.nLevel == 01) {
			this.gameContainer.initGame1(this);
			lemmingsAlive = 4;
		}
		
		else if(this.nLevel == 02) {
			this.gameContainer.initGame2(this);
			lemmingsAlive = 6;
		}
		
		else{
			this.gameContainer.initGame1(this);
			lemmingsAlive = 3;
			
		}
	}
	
	public void exit() {
		this.play = false;
		System.out.println("Exiting game ...");
	}
	
	public void reset() {
		if (this.conf == FileGameConfiguration.NONE) {
			this.lemmingsAlive = 0;
			this.lemmingsDead = 0;
			this.escaped = 0;
			this.cycle = 0;
			this.gameContainer.reset();
			this.initGame();
		} 
		else {
			this.gameContainer = new GameObjectContainer();

			this.cycle = this.conf.getCycle();
			this.lemmingsAlive = this.conf.numLemmingsInBoard();
			this.lemmingsDead = this.conf.numLemmingsDead();
			this.lemmingsToWin = this.conf.numLemmingsToWin();
			this.escaped = this.conf.numLemmingsExit();
			
			for(int i = 0; i < this.conf.getGameContainer().size(); i++) {
				this.gameContainer.add(this.conf.getGameContainer().get(i)); 
			}
		}
	}
	
	public void update() {
		this.gameContainer.update();
		this.cycle ++;
		this.play = numLemmingsInBoard() != 0;
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
		this.conf = config;
		this.cycle = config.getCycle();
		this.lemmingsAlive = config.numLemmingsInBoard();
		this.lemmingsDead = config.numLemmingsDead();
		this.lemmingsToWin = config.numLemmingsToWin();
		this.escaped = config.numLemmingsExit();

		for(int i = 0; i < config.getGameContainer().size(); i++) {
			this.gameContainer.add(config.getGameContainer().get(i)); 
		}
	}
	
	public boolean setRole(Position pos, LemmingRole role) throws offBoardException {
	boolean success = false;
	int i = 0;

	if(pos.overflowX(Game.DIM_X) || pos.overflowY(Game.DIM_Y)) throw new offBoardException("Position %s off the board.".formatted(Messages.POSITION.formatted(pos.getRow(), pos.getCol())));
	while (i < this.gameContainer.size() && !success) {
		if (pos.equals(this.gameContainer.get(i).getPos())) {
			success = this.gameContainer.get(i).setRole(role);
		}
		i++;
    }
	return success;
    }
	
	public boolean isInAir(Position pos) {
	    int i = 0;
	    boolean inAir = true;
	    
	    while (i < gameContainer.size() && inAir) {
	        if (pos.translate(Direction.DOWN).equals(gameContainer.get(i).getPos()) && gameContainer.get(i).isSolid()) {
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
		
		for (int i=0; i<gameContainer.size();i++) {
			found  = gameContainer.get(i).getPos().equals(targetPos);
			if(found) {
				String c = gameContainer.get(i).toString();
				ret += c;
				if ((c=="B") || (c =="ᗺ")) {
					lemmins += c;
				}
				else {
					org += c;
				}
			} 
		}
		
		return lemmins.length() < 3 ? ret : org+lemmins.length();

	}
	
	public void addEscaped() {
		this.lemmingsAlive --;
		this.escaped++;
	}

	public boolean playerWins() {
		return this.escaped >= this.numLemmingsToWin();
	}

	public boolean playerLooses() {
		return this.numLemmingsDead() >= this.maxLemmingsDead || (this.numLemmingsInBoard() == 0 && this.escaped < this.numLemmingsToWin());
	}
}
