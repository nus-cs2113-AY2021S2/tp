package seedu.duke.common;

import java.util.ArrayList;

public class InputValidator {
    //@@author H-horizon
    public static boolean hasInvalidCharacter(String input) {

        ArrayList<String> invalidCharacters = new ArrayList<>();
        initialiseInvalidCharactersList(invalidCharacters);

        for (String invalidCharacter : invalidCharacters) {
            if (input.contains(invalidCharacter)) {
                return true;
            }
        }
        return false;
    }

    private static void initialiseInvalidCharactersList(ArrayList<String> invalidCharacters) {
        invalidCharacters.add("/");
        invalidCharacters.add("\\");
        invalidCharacters.add(":");
        invalidCharacters.add("*");
        invalidCharacters.add("?");
        invalidCharacters.add("\"");
        invalidCharacters.add("<");
        invalidCharacters.add(">");
        invalidCharacters.add("|");
    }
}
