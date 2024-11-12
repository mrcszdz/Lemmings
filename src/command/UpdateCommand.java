package command;

import tp1.control.Controller;
import tp1.logic.GameModel;
import tp1.view.GameView;
import tp1.view.Messages;


 public class UpdateCommand extends NoParamsCommand {

	private static final String NAME = Messages.COMMAND_UPDATE_NAME;
	private static final String SHORTCUT = Messages.COMMAND_UPDATE_SHORTCUT;
	private static final String DETAILS = Messages.COMMAND_UPDATE_DETAILS;
	private static final String HELP = Messages.COMMAND_UPDATE_HELP;

	public UpdateCommand(){
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	protected boolean matchCommand(String type) {
		return type.equals("n") 
	|| type.equals("none") 
	|| type.equals(" ") 
	|| type.equals("");
	}
	
	
	
	public void execute(GameModel game, GameView gameView) {
		Controller.clearScreen();
		game.update();
		gameView.showGame();
	}
}	
