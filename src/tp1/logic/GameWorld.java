package tp1.logic;

public interface GameWorld {
    public void initGame();
    public GameObjectContainer getGameContainer();
    public Direction getSpawnDir();
    public void addEscaped();
    public void lemmingDies();
    public boolean isInAir(Position pos);
}
