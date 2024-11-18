package lemmings.tp1.control;

import lemmings.tp1.command.Command;
import lemmings.tp1.command.CommandGenerator;
import lemmings.tp1.logic.GameModel;
import lemmings.tp1.view.GameView;
import lemmings.tp1.view.Messages;

/**
 *  Accepts user input and coordinates the game execution logic
 */
public class Controller {

	private GameModel game;
	private GameView view;

	public Controller(GameModel game, GameView view) {
		this.game = game;
		this.view = view;
	}
	

	public static void clearScreen() {
		for (int i = 0; i < 50; i++) {
			System.out.println();
		}
	}

	public void run() {
		this.view.showWelcome();
		this.view.showGame();
		while (this.game.isPlay()) {
			String[] userWords = this.view.getPrompt();
			Command command = CommandGenerator.parse(userWords);

			if (command != null) 
				command.execute(game, view);
			else 
				view.showError(Messages.UNKNOWN_COMMAND.formatted(userWords[0]));
		}
		this.view.showEndMessage();
	}

}
