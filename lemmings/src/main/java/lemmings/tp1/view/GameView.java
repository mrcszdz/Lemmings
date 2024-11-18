package lemmings.tp1.view;

import lemmings.tp1.logic.Game;
import lemmings.tp1.logic.GameStatus;

public abstract class GameView{

	protected GameStatus game;
	
	public GameView(Game game) {
		this.game = game;
	}
	
	// show methods
	public abstract void showWelcome();
	public abstract void showGame();
	public abstract void showEndMessage();
	public abstract void showError(String message);
	public abstract void showMessage(String message);

	// get data from view methods
	public abstract String[] getPrompt();
}
