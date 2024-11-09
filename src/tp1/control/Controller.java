package tp1.control;

import command.Command;
import command.CommandGenerator;
import tp1.logic.Game;
import tp1.view.GameView;
import tp1.view.Messages;

/**
 *  Accepts user input and coordinates the game execution logic
 */
public class Controller {

	private Game game;
	private GameView view;

	public Controller(Game game, GameView view) {
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
