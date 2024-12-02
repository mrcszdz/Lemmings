package tp1.logic.gameobjects;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import tp1.exceptions.ObjectParseException;
import tp1.exceptions.offBoardException;
import tp1.logic.Game;
import tp1.logic.GameWorld;
import tp1.logic.Position;
import tp1.view.Messages;

	public class MetalWall extends GameObject{

	public MetalWall(Position pos) {
		super(pos);
		}
	
	public GameObject parse(String[] line, GameWorld game) throws ObjectParseException, offBoardException{
		MetalWall Metal = new MetalWall(MetalWall.getPositionFrom(line[0]));
		return Metal;
	}
	
	private static Position getPositionFrom(String line) throws offBoardException, ObjectParseException {
		Position pos;
		int row, col;
		
		String regex = "^\\(-?\\d+,-?\\d+\\)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);

        if (matcher.matches()) {
        	row = Integer.parseInt(line.split(",")[0].substring(1));
    		col = Integer.parseInt(line.split(",")[1].substring(0, line.split(",")[1].length() - 1));
    		pos = new Position(col, row);
    		if(pos.overflowX(Game.DIM_X) || pos.overflowY(Game.DIM_Y))
    			throw new offBoardException("Position %s off the board.".formatted(Messages.POSITION.formatted(pos.getRow(), pos.getCol())));
    		else return pos;
        } 
        else {
            throw new ObjectParseException("Formato incorrecto en la posicion");
        	}  	
	}
	
	public void update() {
		
	}

	@Override
	public String toString() {
		return Messages.METALWALL;
	}
	
	public Boolean toString(String input) {
        return input.equals("MetalWall");
    } 

	public boolean collides(Position pos) {
        return this.pos.equals(pos);
    };

	public boolean receiveInteraction(GameItem other) {
        return other.interactWith(this);
    }

    public boolean interactWith(Wall wall) {
        return true;
    };

    public boolean interactWith(ExitDoor door) {
        return true;
    };

    public boolean interactWith(MetalWall wall) {
        return true;
    }

    public boolean interactWith(Lemming lemming) {
        return true;
    }

    public boolean isSolid() {
        return true;
    }
	public boolean isAlive() {
        return true;
    }
	public boolean isExit() {
        return true;
    }
	public boolean isInPosition(Position pos) {
        return true;
    }
}
	




