package command;

import tp1.logic.Game;
import tp1.view.GameView;

public abstract class Command {
	private String name;
	private String shortcut;
	private String details;
	private String help;
	
	public Command(String name, String shortcut, String details, String help) {
		this.name = name;
		this.shortcut = shortcut;
		this.details = details;
		this.help = help;
	}
	
	protected abstract boolean matchCommand(String type);
	
	public abstract Command parse(String[] input);
	
	public abstract void execute(Game game, GameView gameView);
	
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


