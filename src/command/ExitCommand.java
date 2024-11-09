package command;

import tp1.logic.Game;
import tp1.view.GameView;
import tp1.view.Messages;

public class ExitCommand {

	public class ResetCommand extends NoParamsCommand {

		private static final String NAME = Messages.COMMAND_EXIT_NAME;
		private static final String SHORTCUT = Messages.COMMAND_EXIT_SHORTCUT;
		private static final String DETAILS = Messages.COMMAND_EXIT_DETAILS;
		private static final String HELP = Messages.COMMAND_EXIT_HELP;

		public ResetCommand(){
			super(NAME, SHORTCUT, DETAILS, HELP);
		}

		protected boolean matchCommand(String type) {
			return type.equals("e") || type.equals("exit");
			}
		
		
		
		public void execute(Game game, GameView gameView) {
			game.exit();
		}
	}	
}
