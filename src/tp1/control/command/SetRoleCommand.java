package tp1.control.command;

import java.util.List;

import tp1.exceptions.CommandExecuteException;
import tp1.exceptions.CommandParseException;
import tp1.exceptions.GameModelException;
import tp1.exceptions.RoleParseException;
import tp1.logic.Game;
import tp1.logic.GameModel;
import tp1.logic.Position;
import tp1.logic.gameobjects.GameObject;
import tp1.logic.lemmingRoles.LemmingRole;
import tp1.logic.lemmingRoles.LemmingRoleFactory;
import tp1.view.GameView;
import tp1.view.Messages;

public class SetRoleCommand extends Command {

	private static final String NAME = "setrole";
	private static final String SHORTCUT = "sr";
	private static final String DETAILS =  "[s]et[R]ole ROLE ROW COL";
	private static final String HELP = "sets the lemming in position (ROW,COL) to role ROLE\r\n" + 
				"      [D]own [C]aver: Lemming caves downwards\n" +
                 "      [P]arachuter: Lemming falls with a parachute\r\n" +
                "      [W]alker: Lemming that walks";
    private Position position;
    private LemmingRole role;


	public SetRoleCommand(){
		super(NAME, SHORTCUT, DETAILS, HELP);
        this.position = null;
        this.role = null;
	}

	public Command parse(String[] input) throws CommandParseException{
		String command = input[0].toLowerCase();

		if (this.matchCommand(command)) {
			if(input.length!=4) throw new CommandParseException(Messages.COMMAND_INCORRECT_PARAMETER_NUMBER);
			try {	
				LemmingRole newRole = LemmingRoleFactory.parse(input[1]);
				int row = (input[2].toUpperCase().charAt(0)-'A');
				int col = Integer.parseInt(input[3])-1;
				Position newPos = new Position(col, row);
				this.role = newRole;
				this.position = newPos;
				return this;
				}	
			catch (NumberFormatException e) {
				throw new CommandParseException(Messages.INVALID_POSITION.formatted(Messages.POSITION.formatted((input[2]).toString(), input[3].toString())), e);
				} 
			catch (RoleParseException e) {
				throw new CommandParseException("Invalid command parameters", e);
			}
			}
		return null;
	}

    protected boolean matchCommand(String type) {
    	String com = type.toLowerCase();
		return com.equals("s") || com.equals("sr") || com.equals("setrole");
	}
	
	public void execute(GameModel game, GameView gameView) throws CommandExecuteException{
		if (this.role == null) {
	        throw new CommandExecuteException("Unknown Role");
	    }
        
        try{
			if (game.setRole(this.position, this.role)) {
				game.update();
        		gameView.showGame();
			}
        	else {
				System.out.println(Messages.ERROR.formatted("No lemming in position %s admits role %s".formatted(Messages.POSITION.formatted(position.getRow(), position.getCol()), role)));
			}
        }catch (GameModelException obe) {
        	throw new CommandExecuteException("Command execute problem", obe);
        }
        
        
        this.position = null;
        this.role = null;
	}
	
}	

