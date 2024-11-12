package command;

import tp1.logic.GameModel;
import tp1.view.GameView;
import tp1.view.Messages;

public class HelpCommand extends NoParamsCommand {

	private static final String NAME = Messages.COMMAND_HELP_NAME;
	private static final String SHORTCUT = Messages.COMMAND_HELP_SHORTCUT;
	private static final String DETAILS = Messages.COMMAND_HELP_DETAILS;
	private static final String HELP = Messages.COMMAND_HELP_HELP;
	//private Object view;

	public HelpCommand(){
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	protected boolean matchCommand(String type) {
		return type.equals("h") || type.equals("help");
	}
	
	
	public void execute(GameModel game, GameView gameView) {
		System.out.println(CommandGenerator.commandHelp());
	}
}