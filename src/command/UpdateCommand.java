package command;

import tp1.control.Controller;
import tp1.logic.Game;
import tp1.view.GameView;
import tp1.view.Messages;


 public class UpdateCommand extends NoParamsCommand {

	private static final String NAME = Messages.COMMAND_NONE_NAME;
	private static final String SHORTCUT = Messages.COMMAND_NONE_SHORTCUT;
	private static final String DETAILS = Messages.COMMAND_NONE_DETAILS;
	private static final String HELP = Messages.COMMAND_NONE_HELP;

	public UpdateCommand(){
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	protected boolean matchCommand(String type) {
		return type.equals("n") 
	|| type.equals("none") 
	|| type.equals(" ") 
	|| type.equals("");
	}
	
	
	
	public void execute(Game game, GameView gameView) {
		Controller.clearScreen();
		game.update();
		gameView.showGame();
	}
}	
