package tp1.logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import tp1.exceptions.GameLoadException;
import tp1.exceptions.ObjectParseException;
import tp1.exceptions.offBoardException;
import tp1.logic.gameobjects.GameObject;
import tp1.logic.gameobjects.GameObjectFactory;

public class FileGameConfiguration implements GameConfiguration {
	private int cycle, numLemmingsBoard, numLemmingsDead, numLemmingsEscaped, numLemmingsToWin;
	private GameObjectContainer gameObjectContainer = new GameObjectContainer();
	private String fileName;
	private GameWorld game;
	public static final GameConfiguration NONE = new FileGameConfiguration();

	public String getFile() {
		return fileName;
	}

	public int getCycle() {
		return cycle;
	}

	public int numLemmingsInBoard() {
		return numLemmingsBoard;
	}

	public int numLemmingsDead() {
		return numLemmingsDead;
	}

	public int numLemmingsExit() {
		return numLemmingsEscaped;
	}

	public int numLemmingsToWin() {
		return numLemmingsToWin;
	}

	public GameObjectContainer getGameContainer() {
		GameObjectContainer copy = new GameObjectContainer();
		for (int i=0; i<gameObjectContainer.size(); i++) {
			GameObject objectCopy = gameObjectContainer.get(i).deepCopy();
			copy.add(objectCopy);
		}
        return copy;
	}

	public String getFileName() {
		return fileName;
	}
	
	public FileGameConfiguration() {

	}
	
	public FileGameConfiguration(String fileName, GameWorld game) throws GameLoadException{
		String[] objectInfo;
		String line;
			
		try(Scanner s = new Scanner(new File(fileName))){
			line = s.nextLine();
			objectInfo = line.split(" ");
			if (objectInfo.length == 5) {
				try {
					cycle = Integer.parseInt(objectInfo [0]);
					numLemmingsBoard = Integer.parseInt(objectInfo [1]);
					numLemmingsDead = Integer.parseInt(objectInfo [2]);
					numLemmingsEscaped = Integer.parseInt(objectInfo [3]);
					numLemmingsToWin = Integer.parseInt(objectInfo [4]);
				}
				catch (NumberFormatException e) {
					throw new GameLoadException(String.format("Incorrect game status \"%s\"", line));
				}
			}
			else {
				throw new GameLoadException(String.format("Incorrect game status \"%s\"", line));
			}
			while (s.hasNextLine()) {
				line = s.nextLine();
				objectInfo = line.split("\\s+");
				GameObject objeto = GameObjectFactory.parse(objectInfo, game);
				gameObjectContainer.add(objeto);
			}	
		} 
		catch (FileNotFoundException fnf) { 
			throw new GameLoadException("File not found " + fileName);
		}
		catch (offBoardException e) {
			throw new GameLoadException(e.getMessage());
		}
		catch (ObjectParseException e) {
			throw new GameLoadException(e.getMessage());
		}
	}

}


