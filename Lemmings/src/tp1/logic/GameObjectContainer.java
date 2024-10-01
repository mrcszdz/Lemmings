package tp1.logic;

import java.util.ArrayList;
import java.util.List;
import tp1.logic.gameobjects.*;

public class GameObjectContainer {
	private List<Lemming> lemmings = new ArrayList<Lemming>();
	private List<Wall> walls = new ArrayList<Wall>();
	private List<ExitDoor> exitdoors = new ArrayList<ExitDoor>();
	
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
}
