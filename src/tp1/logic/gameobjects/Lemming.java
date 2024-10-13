package tp1.logic.gameobjects;

import java.util.List;

import tp1.logic.Direction;
import tp1.logic.Game;
import tp1.logic.Position;

public class Lemming {
	private Position pos; 
	private boolean vivo;
	private Direction dir;
	private int caida;
	private WalkerRole rol;
	private Game game;
	private boolean escaped;
	
	public Lemming(Position pos, Game game) {
		this.vivo = true;
		this.dir = Direction.RIGHT;
		this.caida = 0;
		this.rol = new WalkerRole();
		this.game = game;
		this.pos = pos;
		this.escaped = false;
		
	}
	
	public Position getPos() {
        return pos;
    }

    public boolean isVivo() {
        return vivo;
    }

    public boolean escaped() {
        return this.escaped;
    }
    
    public Direction getDir() {
        return dir;
    }
    public void setPos(Position pos) {
    	this.pos = pos;
    }
    public int getCaida() {
        return caida;
    }

    public WalkerRole getRol() {
        return rol;
    }

    public Game getGame() {
        return game;
    }

    public void setVivo(boolean vivo) {
    	this.vivo = vivo;
    }
    
    public void setCaida(int i) {
    	this.caida = i;
    }
    
    public void setDir(Direction dir) {
        this.dir = dir;
    }
    
	public void update() {
		int i = 0;
		List<ExitDoor> exitdoors =  this.game.getGameContainer().getExitDoors();
		if (this.vivo) {
			while(i <exitdoors.size() && !this.escaped) {
				if (this.pos.equals(exitdoors.get(i).getPos())) {
					this.escaped = true;
				}
				i++;
			}
			if(!this.escaped)
				this.rol.play(this);
			else {
				this.game.getGameContainer().getLemmings().remove(this);
				this.game.addEscaped();
			}
		}
	}
	
}
