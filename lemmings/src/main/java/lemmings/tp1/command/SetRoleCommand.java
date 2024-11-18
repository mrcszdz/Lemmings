package lemmings.tp1.command;

import java.util.List;

import lemmings.tp1.logic.Game;
import lemmings.tp1.logic.GameModel;
import lemmings.tp1.logic.Position;
import lemmings.tp1.logic.gameobjects.GameObject;
import lemmings.tp1.logic.lemmingRoles.LemmingRole;
import lemmings.tp1.logic.lemmingRoles.LemmingRoleFactory;
import lemmings.tp1.view.GameView;

public class SetRoleCommand extends Command {

	private static final String NAME = "setrole";
	private static final String SHORTCUT = "sr";
	private static final String DETAILS =  "[s]et[R]ole | \\\"\\\"\"";
	private static final String HELP = "   [s]et[R]ole ROLE ROW COL: sets the lemming in position (ROW,COL) to role ROL\r\n" + 
                "      [D]own [C]aver: Lemming caves downwards\n"+            
                "      [P]arachuter: Lemming falls with a parachute\n" +
                "      [W]alker: Lemming that walks";
    private Position position;
    private LemmingRole role;


	public SetRoleCommand(){
		super(NAME, SHORTCUT, DETAILS, HELP);
        this.position = null;
        this.role = null;
	}

	public Command parse(String[] input) {
        String command = input[0].toLowerCase();

        if (this.matchCommand(command) && input.length==4) {
            LemmingRole newRole = LemmingRoleFactory.parse(input[1]);
            Position newPos = new Position(Integer.parseInt(input[3]) - 1, input[2].charAt(0) - 'A');
            this.role = newRole;
            this.position = newPos;
            return this;
        }
        return null;
    }

    protected boolean matchCommand(String type) {
		return type.equals("s") || type.equals("sr") || type.equals("setrole");
	}
	
	public void execute(GameModel game, GameView gameView) {
		boolean valid = true;
        if (this.role == null) {
            valid = false;
            System.out.println("[ERROR] Error: Unknown Role");
        }
        if(this.position.overflowX(Game.DIM_X) || this.position.overflowY(Game.DIM_Y)) {
			valid = false;
            System.out.println("[ERROR] Error: SetRoleCommand error (Incorrect position or no object in that position admits that role)");
		}
        if (valid) {
            List<GameObject> objects = game.getGameContainer().getObjects();
            int i = 0;
            boolean success = false;
            
            while (i < objects.size() && !success) {
                if (this.position.equals(objects.get(i).getPos())) {
                    success = objects.get(i).setRole(this.role);
                }
                i++;
            }
            gameView.showGame();
            if (success) {
                System.out.println("Succesfully set new role. "); 
            }
            else {
                System.out.println("No lemming in such coords.");
            }
            this.position = null;
            this.role = null;
        }
	}
}	

