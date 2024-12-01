package tp1.logic;

import tp1.exceptions.GameLoadException;

public interface GameWorld {
    public void initGame();
    public GameObjectContainer getGameContainer();
    public Direction getSpawnDir();
    public void addEscaped();
    public void lemmingDies();
    public boolean isInAir(Position pos);
    public void load(String fileName) throws GameLoadException;
}
