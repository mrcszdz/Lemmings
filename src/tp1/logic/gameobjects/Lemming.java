package tp1.logic.gameobjects;

import tp1.logic.Direction;
import tp1.logic.GameStatus;
import tp1.logic.Position;
import tp1.logic.lemmingRoles.LemmingRole;
import tp1.logic.lemmingRoles.WalkerRole;

public class Lemming extends GameObject { 
	private Direction dir;
	private int caida;
	private LemmingRole rol;
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

    public LemmingRole getRol() {
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
            boolean interaction = this.game.getGameContainer().receiveInteractionsFrom(this);
            if (!interaction) {
                this.rol.play(this);
            }
		}
	}

    public String toString() {
        return this.getRol().getIcon(this);
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
        return this.rol.interactWith(wall, this);
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
        return lemming.pos.equals(this.pos) && lemming!=this;
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
        return this.pos.equals(pos);
    }
}

