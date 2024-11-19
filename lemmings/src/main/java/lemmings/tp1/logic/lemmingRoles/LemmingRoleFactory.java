package lemmings.tp1.logic.lemmingRoles;

import java.util.Arrays;
import java.util.List;

public class LemmingRoleFactory {
    private static final List<LemmingRole> AVAILABLE_ROLES = Arrays.asList(
        new WalkerRole(),
        new ParachuteRole(),
        new DownCaverRole()
    );

    public static LemmingRole parse(String input) {
        int i = 0;
        while (i < AVAILABLE_ROLES.size() &&
            !AVAILABLE_ROLES.get(i).parse(input)) {
        	i++;
        }
        return i < AVAILABLE_ROLES.size() ? AVAILABLE_ROLES.get(i) : null; 
    }

    
}
