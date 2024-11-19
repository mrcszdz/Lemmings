package lemmings.tp1.command;

import lemmings.tp1.logic.GameModel;
import lemmings.tp1.view.GameView;
import lemmings.tp1.view.Messages;

public class ResetCommand extends NoParamsCommand {

	private static final String NAME = Messages.COMMAND_RESET_NAME;
	private static final String SHORTCUT = Messages.COMMAND_RESET_SHORTCUT;
	private static final String DETAILS = Messages.COMMAND_RESET_DETAILS;
	private static final String HELP = Messages.COMMAND_RESET_HELP;

	public ResetCommand(){
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	protected boolean matchCommand(String type) {
		return type.equals("r") || type.equals("reset");
	}
	
	public void execute(GameModel game, GameView gameView) {
		game.reset();
		gameView.showGame();
	}
}	

