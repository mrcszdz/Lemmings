package tp1.control;

import tp1.logic.Game;
import tp1.view.GameView;

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
		if (this.game.getCycle()==0) {
			this.commandHelp();
		}
		System.out.println("Command > ");
		
		boolean valid = false;
		String command = "";
		
		while (!valid) {
			this.getUserCommand(command);
		}
		
		if (command == "h") {
			this.commandHelp();
		}
		else if (command ==  "r") {
			//this.game.reset();
		}
		else if (command ==  "e") {
			//this.game.exit();
		}
		
		this.update();
		
	}
	
	private boolean getUserCommand(String command) {
		//ISSUE #1 REGEX INPUT
		boolean valid = true;
		command = "h";
		
		return valid;
	}
	
	private void commandHelp() {
		System.out.println("Available commands:\n"
				+ "[r]eset: start a new game\n"
				+ "[h]elp: print this help message\n"
				+ "[e]xit: end the execution of the game\n"
				+ "[n]one | \"\": skips cycle");
	}
	
	private void update() {
		this.game.update();
	}
	
	public void run() {
		view.showWelcome();
		while (this.game.play) {
			view.showGame();
			this.getPrompt();
		}
		view.showEndMessage();
	}

}
