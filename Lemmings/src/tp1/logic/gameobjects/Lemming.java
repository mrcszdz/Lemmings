package tp1.logic.gameobjects;

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
	//TODO fill your code
	
	public Lemming(Position pos, Game game) {
		this.vivo = true;
		this.dir = Direction.RIGHT;
		this.caida = 0;
		this.rol = new WalkerRole();
		this.game = game;
		this.pos = pos;
		
	}
	public void update() {
		if	(this.vivo) {
			String accion = this.rol.action(this.pos, this.game.gameContainer.getWalls());
			if (accion == "caer") {
				
			}
		}
	}
	
}
