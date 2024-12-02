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
                "\t\t[P]arachuter: Lemming falls with a parachute\r\n" +
                "\t\t[W]alker: Lemming that walks\n" +
                "\t\t[D]own[C]aver: Lemming caves downwards";
    private Position position;
    private LemmingRole role;


	public SetRoleCommand(){
		super(NAME, SHORTCUT, DETAILS, HELP);
        this.position = null;
        this.role = null;
	}

	public Command parse(String[] input) throws CommandParseException{
		String command = input[0].toLowerCase();

		if (this.matchCommand(command) && input.length==4) {
			try {	
				LemmingRole newRole = LemmingRoleFactory.parse(input[1]);
				Position newPos = new Position(Integer.parseInt(input[2])-1, input[3].charAt(0) - 'A');
				this.role = newRole;
				this.position = newPos;
				return this;
				}	
			catch (NumberFormatException e) {
				throw new CommandParseException(Messages.INVALID_POSITION.formatted(Messages.POSITION.formatted((input[2]).toString(), input[3].toString())));
				} 
			catch (RoleParseException e) {
				throw new CommandParseException(e.getMessage());
			}
			}
		return null;
	}

    protected boolean matchCommand(String type) {
		return type.equals("s") || type.equals("sr") || type.equals("setrole");
	}
	
	public void execute(GameModel game, GameView gameView) throws CommandExecuteException{
		if (this.role == null) {
	        throw new CommandExecuteException("Unknown Role");
	    }

	    if (this.position.overflowX(Game.DIM_X) || this.position.overflowY(Game.DIM_Y)) {
	        throw new CommandExecuteException("SetRoleCommand error (Incorrect position or no object in that position admits that role)");
	    }
        
        try{
        	game.setRole(this.position, this.role);
        	gameView.showGame();
            System.out.println("Succesfully set new role."); 
        }catch (GameModelException obe) {
        	throw new CommandExecuteException(obe.getMessage());
        }
        
        this.position = null;
        this.role = null;
	}
	
}	

