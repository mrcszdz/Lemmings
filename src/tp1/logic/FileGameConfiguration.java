package tp1.logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import tp1.exceptions.GameLoadException;
import tp1.exceptions.ObjectParseException;
import tp1.exceptions.offBoardException;
import tp1.logic.gameobjects.GameObject;
import tp1.logic.gameobjects.GameObjectFactory;

public class FileGameConfiguration {
	private int cycle, numLemmingsBoard, numLemmingsDead, numLemmingsEscaped, numLemmingsToWin;
	private List<GameObject> gameObjects;
	private String fileName;
	private GameWorld game;
	
	 	public int getCycle() {
	        return cycle;
	    }

	    public int getNumLemmingsBoard() {
	        return numLemmingsBoard;
	    }

	    public int getNumLemmingsDead() {
	        return numLemmingsDead;
	    }

	    public int getNumLemmingsEscaped() {
	        return numLemmingsEscaped;
	    }

	    public int getNumLemmingsToWin() {
	        return numLemmingsToWin;
	    }

	    public List<GameObject> getGameObjects() {
	        return gameObjects;
	    }

	    public String getFileName() {
	        return fileName;
	    }

	    public GameWorld getGame() {
	        return game;
	    }
	
	public FileGameConfiguration(String fileName, GameWorld game) throws GameLoadException{
			String[] objectInfo;
			String line;
			
			
			try(Scanner s = new Scanner(new File(fileName))){
				line = s.nextLine();
				objectInfo = line.split(" ");
                cycle = Integer.parseInt(objectInfo [0]);
                numLemmingsBoard = Integer.parseInt(objectInfo [1]);
                numLemmingsDead = Integer.parseInt(objectInfo [2]);
                numLemmingsEscaped = Integer.parseInt(objectInfo [3]);
                numLemmingsToWin = Integer.parseInt(objectInfo [4]);
                while (s.hasNextLine()) {
                    line = s.nextLine();
                objectInfo = line.split(" ");
                GameObject objeto = GameObjectFactory.parse(objectInfo, game);
                gameObjects.add(objeto);
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


