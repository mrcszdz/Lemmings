package tp1.control.command;

import tp1.exceptions.CommandParseException;
import tp1.logic.GameModel;
import tp1.view.GameView;
import tp1.view.Messages;

public abstract class Command {
	protected String name;
	protected String shortcut;
	protected String details;
	protected String help;
	
	public Command(String name, String shortcut, String details, String help) {
		this.name = name;
		this.shortcut = shortcut;
		this.details = details;
		this.help = help;
	}
	
	protected abstract boolean matchCommand(String type);
	
	 public Command parse(String[] commandWords) throws CommandParseException {
		 	if (commandWords.length < 1 || !matchCommand(commandWords[0]))
		 		return null;
		         
		 	if (commandWords.length == 1 && matchCommand(commandWords[0]))
		 		return this;
		     
		 	throw new CommandParseException(Messages.COMMAND_INCORRECT_PARAMETER_NUMBER);
		 }
	
	public abstract void execute(GameModel game, GameView gameView);
	
	public String getName() {
		return name;
	}

	public String getShortcut() {
		return shortcut;
	}

	public String getDetails() {
		return details;
	}

	public String getHelp() {
		return help;
	}
}


