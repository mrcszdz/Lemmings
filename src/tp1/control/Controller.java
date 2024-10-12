package tp1.control;

import java.util.Scanner;

import tp1.logic.Game;
import tp1.view.GameView;

/**
 *  Accepts user input and coordinates the game execution logic
 */
public class Controller {

	private Game game;
	private GameView view;
	private Scanner scanner = new Scanner(System.in);

	public Controller(Game game, GameView view) {
		this.game = game;
		this.view = view;
	}
	
	private void getPrompt() {
		if (this.game.getCycle()==0) {
			this.commandHelp();
		}
		System.out.println("Command > ");
		
		String command = this.getUserCommand(scanner);
		
		if (command.equals("h")) {
			this.commandHelp();
		}
		else if (command.equals("r")) {
			this.game.reset();
		}
		else if (command.equals("e")) {
			this.game.exit();
		}
		else this.update();
		
	}
	
	private String getUserCommand(Scanner scanner) {
		String command = "h";
		//ISSUE #1 REGEX INPUT			
			command = scanner.next();
		return command;				
	}
	
	private void commandHelp() {
		System.out.println("Available commands:\n"
				+ "[r]eset: start a new game\n"
				+ "[h]elp: print this help message\n"
				+ "[e]xit: end the execution of the game\n"
				+ "[n]one | \"\": skips cycle"
				+ "\n"
				+ "\n");
				
	}
	
	private void update() {
		this.game.update();
	}
	
	public void run() {
		this.view.showWelcome();
		while (this.game.isPlay()) {
			this.view.showGame();
			this.getPrompt();
		}
		this.scanner.close();
		this.view.showEndMessage();
	}

}
