package tp1.logic.lemmingRoles;

import java.util.Arrays;
import java.util.List;

import tp1.exceptions.RoleParseException;

public class LemmingRoleFactory {
    private static final List<LemmingRole> AVAILABLE_ROLES = Arrays.asList(
        new WalkerRole(),
        new ParachuteRole(),
        new DownCaverRole()
    );

    public static LemmingRole parse(String input) throws RoleParseException {
        int i = 0;
        while (i < AVAILABLE_ROLES.size() &&
            !AVAILABLE_ROLES.get(i).parse(input)) {
        	i++;
        }
         if (i < AVAILABLE_ROLES.size())  
        	 return AVAILABLE_ROLES.get(i); 
        	 else throw new RoleParseException("Invalid lemming role: "+input); 
    }  
}
