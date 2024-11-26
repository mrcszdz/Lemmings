package tp1.control.command;

import java.util.Arrays;
import java.util.List;

import tp1.exceptions.CommandExecuteException;
import tp1.exceptions.CommandParseException;
import tp1.view.Messages;

public class CommandGenerator {

    private static final List<Command> AVAILABLE_COMMANDS = Arrays.asList(
    	new SetRoleCommand(),
    	new UpdateCommand(),
        new ResetCommand(),
        new HelpCommand(),
        new ExitCommand()
    );
    
    public static Command parse(String[] commandWords) {
    	try {
    		int i = 0;
            while (i < AVAILABLE_COMMANDS.size() &&
            		AVAILABLE_COMMANDS.get(i).parse(commandWords) == null) {
            	i++;
            }
            return i < AVAILABLE_COMMANDS.size() ? AVAILABLE_COMMANDS.get(i) : null; 
    	}
    	catch (CommandParseException e) {
    		System.out.println("PARSE ERROR");
    		return null;
    	}
    	/*final (CommandExecuteException e) {
    		System.out.println("EXECUTION ERROR");
    	}*/
    }
    
    public static String commandHelp() {
    	String help = Messages.HELP_AVAILABLE_COMMANDS + "\n";
    	for (int i = 0; i < AVAILABLE_COMMANDS.size(); i++) {
    		help += "\t"+AVAILABLE_COMMANDS.get(i).getDetails() + ": " + AVAILABLE_COMMANDS.get(i).getHelp() + "\n";
    	}
    	return help;
    }
    
}
