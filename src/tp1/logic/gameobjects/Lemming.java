package tp1.logic.gameobjects;

import java.util.regex.*;

import tp1.exceptions.CommandParseException;
import tp1.exceptions.ObjectParseException;
import tp1.exceptions.RoleParseException;
import tp1.exceptions.offBoardException;
import tp1.logic.Direction;
import tp1.logic.Game;
import tp1.logic.GameWorld;
import tp1.logic.Position;
import tp1.logic.lemmingRoles.LemmingRole;
import tp1.logic.lemmingRoles.LemmingRoleFactory;
import tp1.logic.lemmingRoles.WalkerRole;
import tp1.view.Messages;

public class Lemming extends GameObject { 
	private Direction dir;
	private int caida;
	private LemmingRole rol;
	private boolean escaped;
	
	public Lemming(Position pos, GameWorld game) {
		super(pos);
		this.dir = game.getSpawnDir();
		this.caida = 0;
		this.rol = new WalkerRole();
		this.game = game;
		this.escaped = false;		
	}
	
    public Lemming deepCopy() {
        Lemming copy = new Lemming(pos, dir, caida, rol, game);
        return copy;
    }

	public Lemming(Position pos, Direction dir, int caida, LemmingRole rol, GameWorld game) {
		super(pos);
		this.dir = dir;
		this.caida = caida;
		this.rol = rol;
		this.game = game;
		this.escaped = false;		
	}
	
	public GameObject parse(String[] line, GameWorld game) throws ObjectParseException, offBoardException{
		try{
			Lemming lemming = new Lemming(Lemming.getPositionFrom(line[0]), 
		
            Lemming.getLemmingDirectionFrom(line[2]),
            Lemming.getLemmingHeigthFrom(line[3]),
            Lemming.getLemmingRoleFrom(line[4]), game);
			return lemming;
		}
		catch(ObjectParseException e) {
			throw new ObjectParseException(e.getMessage());
		}
		catch(offBoardException e) {
			throw new offBoardException(e.getMessage());
		}
	}

	private static Position getPositionFrom(String line) throws offBoardException, ObjectParseException {
		Position pos;
		int row, col;
		
		String numericRegex = "^\\(-?\\d+,-?\\d+\\)$";
        String letterRegex = "^\\(?[A-Za-z],?-?\\d+\\)?$";

        Pattern numericPattern = Pattern.compile(numericRegex);
        Pattern letterPattern = Pattern.compile(letterRegex);


        if (numericPattern.matcher(line).matches()) {
            row = Integer.parseInt(line.split(",")[0].substring(1));
            col = Integer.parseInt(line.split(",")[1].substring(0, line.split(",")[1].length() - 1));
        } 
        else if (letterPattern.matcher(line).matches()) {
            try {
                row = line.split(",")[0].substring(1).toUpperCase().charAt(0)-'A';
                col = Integer.parseInt(line.split(",")[1].substring(0, line.split(",")[1].length() - 1));
            }
            catch (NumberFormatException e) {
                throw new ObjectParseException("Invalid coordinate format: " + line);
            }
        } 
        else {
            throw new ObjectParseException("Incorrect position format: " + line);
        }
    
        pos = new Position(col, row);
    
        // Validate if position is within the board dimensions
        if (pos.overflowX(Game.DIM_X) || pos.overflowY(Game.DIM_Y)) {
            throw new offBoardException("Object position is off board: %s".formatted(Messages.POSITION.formatted(pos.getRow(), pos.getCol())));
        }
    
        return pos;
	}
		
	 private static Direction getLemmingDirectionFrom(String line) throws ObjectParseException { 
		 if(line.equals("RIGHT")) return Direction.RIGHT;
		 else if(line.equals("LEFT")) return Direction.LEFT;
         else if (line.equals("UP") || line.equals("DOWN")) throw new ObjectParseException ("Invalid lemming direction: "+line);
		 else throw new ObjectParseException ("Unknown object direction: "+line);
	}
	
	 private static int getLemmingHeigthFrom(String line) throws ObjectParseException {
        try {
            return Integer.parseInt(line);
        }
		catch (NumberFormatException e) {
            if (line.length()==1) {
                return line.charAt(0) - 'A';
            }
            else {
                throw new ObjectParseException("Invalid height format : "+line);
            }
        }
	 }
	 
	 private static LemmingRole getLemmingRoleFrom(String line) throws ObjectParseException {
		 try{
			 LemmingRole newRole = LemmingRoleFactory.parse(line);
			 return newRole;
		 }
		 catch(RoleParseException e) {
			 throw new ObjectParseException(e.getMessage());
		 }
	 }
	 
    public boolean escaped() {
        return this.escaped;
    }
    
    public Direction getDir() {
        return dir;
    }

    public int getCaida() {
        return caida;
    }

    public LemmingRole getRol() {
        return rol;
    }

    public GameWorld getGame() {
        return game;
    }
    
    public void setCaida(int i) {
    	this.caida = i;
    }
    
    public void setDir(Direction dir) {
        this.dir = dir;
    }
    
	public void update() {
		if (this.vivo) {
            boolean interaction = this.game.getGameContainer().receiveInteractionsFrom(this);
            if (!interaction) {
                this.rol.play(this);
            }
		}
	}

	@Override
    public String toString() {
        return this.getRol().getIcon(this);
    }
    
    
    public Boolean toString(String input) {
        return input.equals("Lemming");
    } 
	 
    @Override
    public boolean setRole(LemmingRole role) {
        this.rol = role;
        return true;
    }
	
    public void disableRole() {
        this.rol = new WalkerRole();
    }

    public boolean receiveInteraction(GameItem other) {
        return other.interactWith(this);
    }

    public boolean interactWith(Wall wall) {
       if(this.getGame().isInAir(this.pos)) return false;
       else return this.rol.interactWith(wall, this);
    };

    public boolean interactWith(ExitDoor door) {
        if (this.isInPosition(door.getPos())) {
            this.getGame().getGameContainer().getObjects().remove(this);
            this.getGame().addEscaped();
            this.escaped = true;
            return true;
        } 
        return false;
    };

    public boolean interactWith(MetalWall wall) {
        return this.rol.interactWith(wall, this);
    }

    public boolean interactWith(Lemming lemming) {
        return false;
    }

    public boolean isSolid() {
        return false;
    }
	public boolean isAlive() {
        return true;
    }
	public boolean isExit() {
        return true;
    }
	public boolean isInPosition(Position pos) {
        return this.pos.equals(pos);
    }
}

