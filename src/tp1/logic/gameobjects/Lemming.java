package tp1.logic.gameobjects;

import tp1.logic.Direction;
import tp1.logic.GameStatus;
import tp1.logic.Position;
import tp1.logic.lemmingRoles.WalkerRole;

public class Lemming extends GameObject { 
	private Direction dir;
	private int caida;
	private WalkerRole rol;
	private boolean escaped;
	
	public Lemming(Position pos, GameStatus game) {
		super(pos);
		this.dir = game.getSpawnDir();
		this.caida = 0;
		this.rol = new WalkerRole();
		this.game = game;
		this.escaped = false;
		
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

    public WalkerRole getRol() {
        return rol;
    }

    public GameStatus getGame() {
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
			if(this.getGame().lemmingArrived(this)) {
                this.getGame().getGameContainer().getObjects().remove(this);
                this.getGame().addEscaped();
            }
            else {
                this.rol.play(this);
            }
				
		}
	}
	
}
