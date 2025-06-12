package tp1.logic;

import java.util.ArrayList;
import java.util.List;
import tp1.logic.gameobjects.*;
import tp1.logic.lemmingRoles.ParachuteRole;

public class GameObjectContainer {
	
	private List<GameObject> gameObjects;
	
	
	public GameObjectContainer() {
		gameObjects = new ArrayList<>();
	}
	
	public void initGame1(Game game) {

		
		Position position;
	    Wall wall;
	    MetalWall metalWall;
	    ExitDoor exit;
		
	    Position pos1 = new Position(2,3);
		Lemming lemming1 = new Lemming(pos1, game);
		this.add(lemming1);
	    
		Position pos2 = new Position(9,0);
		Lemming lemming2 = new Lemming(pos2, game);
		this.add(lemming2);
		
		 position = new Position(4, 5);
		    exit = new ExitDoor(position);
		    this.add(exit);
		    
		    for (int col = 8; col <= 9; col++) {
		        position = new Position(col, 1);
		        wall = new Wall(position);
		        this.add(wall);
		    }

		    for (int col = 2; col <= 4; col++) {
		        position = new Position(col, 4);
		        wall = new Wall(position);
		        this.add(wall);
		    }

		    for (int col = 4; col <= 7; col++) {
		        position = new Position(col, 6);
		        wall = new Wall(position);
		        this.add(wall);
		    }
		    
		    for (int col = 7; col <= 7; col++) {
		        position = new Position(col, 5);
		        wall = new Wall(position);
		        this.add(wall);
		    }

		    for (int col = 0; col <= 1; col++) {
		        position = new Position(col, 9);
		        wall = new Wall(position);
		        this.add(wall);
		    }
		    
		    for (int col = 8; col <= 9; col++) {
		        position = new Position(col, 9);
		        wall = new Wall(position);
		        this.add(wall);
		    }

		    position = new Position(8, 8);
		    wall = new Wall(position);
		    this.add(wall);
			
			Position pos3 = new Position(0,8);
			Lemming lemming3 = new Lemming(pos3, game);
			this.add(lemming3);
			
			Position pos4 = new Position(3,3);
			Lemming lemming4 = new Lemming(pos4, game);
			this.add(lemming4);
		    
		}
	public void initGame0(Game game) {
		
	    Position position;
	    Wall wall;
	    MetalWall metalWall;
	    ExitDoor exit;

	    
	    position = new Position(4, 5);
	    exit = new ExitDoor(position);
	    this.add(exit);
	    
	    for (int col = 8; col <= 9; col++) {
	        position = new Position(col, 1);
	        wall = new Wall(position);
	        this.add(wall);
	    }

	    for (int col = 2; col <= 4; col++) {
	        position = new Position(col, 4);
	        wall = new Wall(position);
	        this.add(wall);
	    }

	    for (int col = 4; col <= 7; col++) {
	        position = new Position(col, 6);
	        wall = new Wall(position);
	        this.add(wall);
	    }
	    
	    for (int col = 7; col <= 7; col++) {
	        position = new Position(col, 5);
	        wall = new Wall(position);
	        this.add(wall);
	    }

	    for (int col = 0; col <= 1; col++) {
	        position = new Position(col, 9);
	        wall = new Wall(position);
	        this.add(wall);
	    }
	    
	    for (int col = 8; col <= 9; col++) {
	        position = new Position(col, 9);
	        wall = new Wall(position);
	        this.add(wall);
	    }

	    position = new Position(8, 8);
	    wall = new Wall(position);
	    this.add(wall);

	    Position pos1 = new Position(2,3);
		Lemming lemming1 = new Lemming(pos1, game);
		this.add(lemming1);
		
		Position pos2 = new Position(9,0);
		Lemming lemming2 = new Lemming(pos2, game);
		this.add(lemming2);
		
		Position pos3 = new Position(0,8);
		Lemming lemming3 = new Lemming(pos3, game);
		this.add(lemming3);
	}

	public void initGame2(Game game) {

		  Position position;
		    Wall wall;
		    MetalWall metalWall;
		    ExitDoor exit;

		    
		    position = new Position(4, 5);
		    exit = new ExitDoor(position);
		    this.add(exit);
		    
		    position = new Position(3, 5);
	        wall = new Wall(position);
	        this.add(wall);
		    
	        position = new Position(3, 6);
	        metalWall = new MetalWall(position);
	        this.add(metalWall);
	        
		    for (int col = 8; col <= 9; col++) {
		        position = new Position(col, 1);
		        wall = new Wall(position);
		        this.add(wall);
		    }

		    for (int col = 2; col <= 4; col++) {
		        position = new Position(col, 4);
		        wall = new Wall(position);
		        this.add(wall);
		    }

		    for (int col = 4; col <= 7; col++) {
		        position = new Position(col, 6);
		        wall = new Wall(position);
		        this.add(wall);
		    }
		    
		    for (int col = 7; col <= 7; col++) {
		        position = new Position(col, 5);
		        wall = new Wall(position);
		        this.add(wall);
		    }

		    for (int col = 0; col <= 1; col++) {
		        position = new Position(col, 9);
		        wall = new Wall(position);
		        this.add(wall);
		    }
		    
		    for (int col = 8; col <= 9; col++) {
		        position = new Position(col, 9);
		        wall = new Wall(position);
		        this.add(wall);
		    }

		    position = new Position(8, 8);
		    wall = new Wall(position);
		    this.add(wall);

		    Position pos1 = new Position(2,3);
			Lemming lemming1 = new Lemming(pos1, game);
			this.add(lemming1);
			
			Position pos2 = new Position(9,0);
			Lemming lemming2 = new Lemming(pos2, game);
			this.add(lemming2);
			
			Position pos3 = new Position(0,8);
			Lemming lemming3 = new Lemming(pos3, game);
			this.add(lemming3);
		    
			Position pos4 = new Position(3,3);
			Lemming lemming4 = new Lemming(pos4, game);
			this.add(lemming4);

			Position pos6 = new Position(6,0);
			Lemming lemming6 = new Lemming(pos6, game);
			this.add(lemming6);
			
			Position pos5 = new Position(6,0);
			Lemming lemming5 = new Lemming(pos5, game);
			lemming5.setRole(new ParachuteRole());
			this.add(lemming5);
	}	
	
		public void add(GameObject gameObject) {
		this.gameObjects.add(gameObject);
	}

	public void update() {
		List<GameObject> eliminados = new ArrayList<GameObject>();
		for (int i=0; i<this.gameObjects.size(); i++) {
			this.gameObjects.get(i).update();
		}
		for (int i=0; i<this.gameObjects.size(); i++) {
			if (!this.gameObjects.get(i).isVivo() || this.gameObjects.get(i).isExit()) {
				eliminados.add(this.gameObjects.get(i))	;	
			}
		}
		this.gameObjects.removeAll(eliminados);
	}
	
	public void remove(GameObject object) {
		gameObjects.remove(object);
	}
	
	public GameObject get(int i) {
		return gameObjects.get(i);
	}
	
	public int size() {
		return gameObjects.size();
	}
	
	public void reset() {
		this.gameObjects.clear();
	}

	public boolean receiveInteractionsFrom(GameItem obj) {
		boolean anyInteraction = false;
		for (int i=0; i<this.gameObjects.size(); i++) {
			anyInteraction = anyInteraction || this.gameObjects.get(i).receiveInteraction(obj);
		}

		return anyInteraction;
	}
}
