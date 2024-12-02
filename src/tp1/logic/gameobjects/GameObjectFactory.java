package tp1.logic.gameobjects;

import java.util.Arrays;
import java.util.List;

import tp1.exceptions.ObjectParseException;
import tp1.exceptions.offBoardException;
import tp1.logic.GameWorld;
import tp1.logic.Position;

public class GameObjectFactory {

    public static GameObject parse(String[] input, GameWorld game) throws ObjectParseException, offBoardException {
        List<GameObject> AVAILABLE_OBJECTS = Arrays.asList(
            new Wall(new Position(0,0)),
            new Lemming(new Position(0,0), game),
            new MetalWall(new Position(0,0)),
            new ExitDoor(new Position(0,0))
        );

        try {
            int i = 0;
            while (i < AVAILABLE_OBJECTS.size() &&
                !AVAILABLE_OBJECTS.get(i).toString(input[1])) {
                i++;
            }

            if (i < AVAILABLE_OBJECTS.size()) {
                try {
                    return AVAILABLE_OBJECTS.get(i).parse(input, game);
                } catch (offBoardException e) {
                    throw new offBoardException(e.getMessage());
                }
            } else {
                throw new ObjectParseException("Unknown game object: " + input[1]);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(input[1]);
            throw new ObjectParseException("Error parsing object: Invalid input format", e);
        }
    }
}