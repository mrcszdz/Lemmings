package command;

import java.util.Arrays;
import java.util.List;

public class CommandGenerator {

    private static final List<Command> AVAILABLE_COMMANDS = Arrays.asList(
        new UpdateCommand(),
        new ResetCommand(),
        new HelpCommand(),
        new ExitCommand()
    );
    
    public static Command parse(String[] commandWords) {
        int i = 0;
        while (i < AVAILABLE_COMMANDS.size() &&
        		AVAILABLE_COMMANDS.get(i).parse(commandWords) == null) {
        	i++;
        }
        return AVAILABLE_COMMANDS.get(i); 
    }
    
    public static String commandHelp() {
    	
    }
}
