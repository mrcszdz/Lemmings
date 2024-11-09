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
	    for (int col = 2; col <= 5; col++) {
	        Position position = new Position(col, 1);
	        Wall wall = new Wall(position);
	        this.add(wall);
	    }
	    
	    for (int col = 0; col <= 0; col++) {
	        Position position = new Position(col, 2);
	        Wall wall = new Wall(position);
	        this.add(wall);
	    }
	    
	    for (int col = 0; col <= 2; col++) {
	        Position position = new Position(col, 3);
	        Wall wall = new Wall(position);
	        this.add(wall);
	    }
	    
	    for (int col = 2; col <= 6; col++) {
	        Position position = new Position(col, 4);
        Wall wall = new Wall(position);
        this.add(wall);
	    }

	    Position position = new Position(6,3);
	    ExitDoor exit = new ExitDoor(position);
		this.add(exit);
	
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
			
		}
	}
	
	public List<GameObject> getObjects() {
		return this.gameObjects;
	}
	
	public void reset() {
		List<GameObject> newList = new ArrayList<>();
		for (int i=0; i<this.gameObjects.size(); i++) {
			if(!(this.gameObjects.get(i) instanceof Lemming)) {
				newList.add(this.gameObjects.get(i));
			}
		}
		this.gameObjects = newList;
	}
	
	public ArrayList<GameObject> filterType(Class<?> type) {
		ArrayList<GameObject> newList = new ArrayList<>();
		for (int i=0; i<this.gameObjects.size(); i++) {
			if(type.isAssignableFrom(this.gameObjects.get(i).getClass())) {
				newList.add(this.gameObjects.get(i));
			}
		}
		return newList;
	}
}
