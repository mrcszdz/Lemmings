package tp1.control;

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
	
	private void getPrompt() {		
		String command = this.view.getPrompt()[0].toLowerCase();

		if (command.equals("h") 
		|| command.equals("help")) {
			this.commandHelp();
		}
		else if (command.equals("r") 
		|| command.equals("reset")) {
			this.game.reset();
		}
		else if (command.equals("e") 
		|| command.equals("exit")) {
			this.game.exit();
		}
		else if (command.equals("n") 
		|| command.equals("none") 
		|| command.equals(" ") 
		|| command.equals("")) {
			Controller.clearScreen();
			this.update();
			this.view.showGame();
		}
		else {
			System.out.println(Messages.ERROR);
		}
		
	}

	public static void clearScreen() {
		for (int i = 0; i < 50; i++) {
			System.out.println();
		}
	}

	private void commandHelp() {
		System.out.println(this.game.help());
				
	}
	
	private void update() {
		this.game.update();
	}
	
	public void run() {
		this.view.showWelcome();
		this.view.showGame();
		while (this.game.isPlay()) {
			this.getPrompt();
		}
		this.view.showEndMessage();
	}

}
