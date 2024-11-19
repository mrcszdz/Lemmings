package lemmings.tp1.logic.gameobjects;

import lemmings.tp1.logic.Position;

public interface GameItem {
	public boolean receiveInteraction(GameItem other);

	public boolean interactWith(Lemming lemming);
	public boolean interactWith(Wall wall);
	public boolean interactWith(ExitDoor door);
	public boolean interactWith(MetalWall wall);

	public boolean isSolid();
	public boolean isAlive();
	public boolean isExit();
	public boolean isInPosition(Position pos);
}