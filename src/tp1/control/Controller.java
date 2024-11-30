package tp1.control;

import tp1.control.command.Command;
import tp1.control.command.CommandGenerator;
import tp1.exceptions.CommandException;
import tp1.logic.GameModel;
import tp1.view.GameView;
import tp1.view.Messages;

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
	

	public void run() {
			
		this.view.showWelcome();
		this.view.showGame();
		while (this.game.isPlay()) {
			
			try {
				String[] userWords = this.view.getPrompt();
				Command command = CommandGenerator.parse(userWords);
		
				if (command != null)
					command.execute(game, view);
				else 
					view.showError(Messages.UNKNOWN_COMMAND.formatted(userWords[0]));
			}
			catch(CommandException e){
				view.showError(e.getMessage());
	 			Throwable cause = e.getCause();
	 			if (cause != null) 
	 			    view.showError(cause.getMessage());
			}
		}
		this.view.showEndMessage();
	}

}
