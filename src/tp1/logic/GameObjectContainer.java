package tp1.logic;

import java.util.ArrayList;
import java.util.List;
import tp1.logic.gameobjects.*;

public class GameObjectContainer {
	private List<Lemming> lemmings;
	private List<Wall> walls;
	private List<ExitDoor> exitdoors;
	
	public GameObjectContainer() {
		this.lemmings = new ArrayList<Lemming>();
		this.walls = new ArrayList<Wall>();
		this.exitdoors = new ArrayList<ExitDoor>();
		this.generateExitDoor();
	}
	
	private void generateExitDoor() {
		
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
	
	public void add(Lemming lemming) {
		this.lemmings.add(lemming);
	}
	public void add(Wall wall) {
		this.walls.add(wall);
	}
	public void add(ExitDoor exitdoor) {
		this.exitdoors.add(exitdoor);
	}
	public void update() {
		for (int i=0; i<this.lemmings.size(); i++) {
			this.lemmings.get(i).update();
		}
	}
	public List<Wall> getWalls() {
		return walls;
	}
	
	public List<Lemming> getLemmings() {
		return lemmings;
	} 
	
	public List<ExitDoor> getExitDoors() {
		return exitdoors;
	} 
	
	public void reset() {
		this.lemmings.removeAll(this.lemmings);
	}
}
