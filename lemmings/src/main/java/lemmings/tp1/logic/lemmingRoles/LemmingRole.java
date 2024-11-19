package lemmings.tp1.logic.lemmingRoles;
import lemmings.tp1.logic.gameobjects.ExitDoor;
import lemmings.tp1.logic.gameobjects.GameItem;
import lemmings.tp1.logic.gameobjects.Lemming;
import lemmings.tp1.logic.gameobjects.MetalWall;
import lemmings.tp1.logic.gameobjects.Wall;

public interface LemmingRole {

    public void start( Lemming lemming );
    public void play( Lemming lemming );
    public String getIcon( Lemming lemming );
    public boolean parse(String input);

    public boolean receiveInteraction(GameItem other, Lemming lemming);
	public boolean interactWith(Lemming receiver, Lemming lemming);
	public boolean interactWith(Wall wall, Lemming lemming);
	public boolean interactWith(ExitDoor door, Lemming lemming);
    public boolean interactWith(MetalWall wall, Lemming lemming);
}