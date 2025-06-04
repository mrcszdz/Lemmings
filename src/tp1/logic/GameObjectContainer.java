package tp1.logic;

import java.util.ArrayList;
import java.util.List;
import tp1.logic.gameobjects.*;

public class GameObjectContainer {
	
	private List<GameObject> gameObjects;
	
	
	public GameObjectContainer() {
		gameObjects = new ArrayList<>();
	}
	
	public void initGame0() {

	    for (int col = 8; col <= 10; col++) {
	        Position position = new Position(col, 1);
	        Wall wall = new Wall(position);
	        this.add(wall);
    }

	    for (int col = 2; col <= 4; col++) {
	        Position position = new Position(col, 4);
	        Wall wall = new Wall(position);
	        this.add(wall);
	    }

		for (int col = 2; col <= 4; col++) {
	        Position position = new Position(col, 6);
	        MetalWall wall = new MetalWall(position);
	        this.add(wall);
	    }

	    for (int col = 4; col <= 7; col++) {
	        Position position = new Position(col, 6);
	        Wall wall = new Wall(position);
	        this.add(wall);
	    }
	    
	    for (int col = 7; col <= 7; col++) {
	        Position position = new Position(col, 5);
	        Wall wall = new Wall(position);
	        this.add(wall);
	    }
	    
	    for (int col = 0; col <= 1; col++) {
	        Position position = new Position(col, 9);
	        Wall wall = new Wall(position);
	        this.add(wall);
	    }
		
	    for (int col = 8; col <= 9; col++) {
	        Position position = new Position(col, 9);
	        Wall wall = new Wall(position);
	        this.add(wall);
	    }
	    for (int col = 8; col <= 8; col++) {
	        Position position = new Position(col, 8);
	        Wall wall = new Wall(position);
	        this.add(wall);
	    }

	    Position position = new Position(4,5);
	    ExitDoor exit = new ExitDoor(position);
		this.add(exit);
	}
	
	public void initGame1() {

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

	    
	}

	public void initGame2() {

		    for (int col = 5; col <= 8; col++) {
		        Position position = new Position(col, 1);
		        Wall wall = new Wall(position);
		        this.add(wall);
		    }

		    for (int col = 2; col <= 3; col++) {
		        Position position = new Position(col, 2);
		        Wall wall = new Wall(position);
		        this.add(wall);
		    }

		    for (int col = 4; col <= 6; col++) {
		        Position position = new Position(col, 3);
		        Wall wall = new Wall(position);
		        this.add(wall);
		    }
		    
		    Position position = new Position(7, 8);
			ExitDoor exit = new ExitDoor(position);
			this.add(exit);

	}
	
	public void initGame3() {

	    for (int col = 8; col <= 10; col++) {
	        Position position = new Position(col, 1);
	        Wall wall = new Wall(position);
	        this.add(wall);
    }

	    for (int col = 2; col <= 4; col++) {
	        Position position = new Position(col, 4);
	        Wall wall = new Wall(position);
	        this.add(wall);
	    }

	    for (int col = 4; col <= 6; col++) {
	        Position position = new Position(col, 6);
	        Wall wall = new Wall(position);
	        this.add(wall);
	    }
	    
	    for (int col = 7; col <= 7; col++) {
	        Position position = new Position(col, 7);
	        Wall wall = new Wall(position);
	        this.add(wall);
	    }
	    
	    for (int col = 0; col <= 1; col++) {
	        Position position = new Position(col, 9);
	        Wall wall = new Wall(position);
	        this.add(wall);
	    }
		
	    for (int col = 7; col <= 9; col++) {
	        Position position = new Position(col, 9);
	        Wall wall = new Wall(position);
	        this.add(wall);
	    }
	    for (int col = 9; col <= 9; col++) {
	        Position position = new Position(col, 8);
	        Wall wall = new Wall(position);
	        this.add(wall);
	    }

	    Position position = new Position(7,8);
	    ExitDoor exit = new ExitDoor(position);
		this.add(exit);
	}
	
	public void initGame4() {

	    for (int col = 8; col <= 10; col++) {
	        Position position = new Position(col, 1);
	        Wall wall = new Wall(position);
	        this.add(wall);
    }

	    for (int col = 2; col <= 4; col++) {
	        Position position = new Position(col, 4);
	        Wall wall = new Wall(position);
	        this.add(wall);
	    }

	    for (int col = 4; col <= 6; col++) {
	        Position position = new Position(col, 6);
	        Wall wall = new Wall(position);
	        this.add(wall);
	    }
	    
	    for (int col = 7; col <= 7; col++) {
	        Position position = new Position(col, 7);
	        Wall wall = new Wall(position);
	        this.add(wall);
	    }
	    
	    for (int col = 7; col <= 9; col++) {
	        Position position = new Position(col, 9);
	        Wall wall = new Wall(position);
	        this.add(wall);
	    }
	    for (int col = 9; col <= 9; col++) {
	        Position position = new Position(col, 8);
	        Wall wall = new Wall(position);
	        this.add(wall);
	    }

	    Position position = new Position(7,8);
	    ExitDoor exit = new ExitDoor(position);
		this.add(exit);
	}
	
	public void initGame5() {

	    for (int col = 8; col <= 10; col++) {
	        Position position = new Position(col, 1);
	        Wall wall = new Wall(position);
	        this.add(wall);
    }

	    for (int col = 2; col <= 4; col++) {
	        Position position = new Position(col, 4);
	        Wall wall = new Wall(position);
	        this.add(wall);
	    }

	    for (int col = 4; col <= 7; col++) {
	        Position position = new Position(col, 6);
	        Wall wall = new Wall(position);
	        this.add(wall);
	    }
	    
	    for (int col = 7; col <= 7; col++) {
	        Position position = new Position(col, 5);
	        Wall wall = new Wall(position);
	        this.add(wall);
	    }
	    
	    for (int col = 0; col <= 1; col++) {
	        Position position = new Position(col, 9);
	        Wall wall = new Wall(position);
	        this.add(wall);
	    }
		
	    for (int col = 8; col <= 9; col++) {
	        Position position = new Position(col, 9);
	        Wall wall = new Wall(position);
	        this.add(wall);
	    }
	    for (int col = 8; col <= 8; col++) {
	        Position position = new Position(col, 8);
	        Wall wall = new Wall(position);
	        this.add(wall);
	    }

	    Position position = new Position(4,5);
	    ExitDoor exit = new ExitDoor(position);
		this.add(exit);
	}
	
	public void add(GameObject gameObject) {
		this.gameObjects.add(gameObject);
	}

	public void update() {
		for (int i=0; i<this.gameObjects.size(); i++) {
			this.gameObjects.get(i).update();
		}
		for (int i=0; i<this.gameObjects.size(); i++) {
			if (!this.gameObjects.get(i).isVivo()) {
				this.gameObjects.remove(i);
			}
		}
	}
	
	public List<GameObject> getObjects() {
		List<GameObject> copy = new ArrayList<GameObject>();
		for (int i=0; i<this.gameObjects.size(); i++) {
			GameObject objectCopy = this.gameObjects.get(i).deepCopy();
			copy.add(objectCopy);
		}
        return copy;
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
