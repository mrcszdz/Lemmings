package tp1.control.command;

import tp1.exceptions.CommandExecuteException;
import tp1.exceptions.GameLoadException;
import tp1.logic.GameModel;
import tp1.view.GameView;
import tp1.view.Messages;

public class LoadCommand extends Command{ 
private static final String NAME = "Load";
private static final String SHORTCUT = "l";
private static final String DETAILS =  "[l]oad <fileName>";
private static final String HELP = "load the game configuration from text file <fileName>";
private String fileName;

public LoadCommand() {
	super(NAME, SHORTCUT, DETAILS, HELP);
	this.fileName = null;
}
public LoadCommand(String fileName){
	super(NAME, SHORTCUT, DETAILS, HELP);
	this.fileName = fileName;
}

public Command parse(String[] input){
	String command = input[0].toLowerCase();

if (this.matchCommand(command) && input.length==2) {	
	this.fileName = input[1];
	return this;
	}
return null;
}

protected boolean matchCommand(String type) {
	return type.equals("l") || type.equals("load");
}

public void execute(GameModel game, GameView gameView) throws CommandExecuteException{
	try{
		game.load(this.fileName);
		gameView.showGame();
	}
	catch(GameLoadException e){
		throw new CommandExecuteException("Invalid file \""+this.fileName+"\" configuration\n"+Messages.ERROR.formatted(e.getMessage()));
	}
	
	}

}	

