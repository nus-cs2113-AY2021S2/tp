package seedu.duke.common;

import java.util.ArrayList;

public class SanitiseInput {
    //@H-horizon
    public static boolean sanitiseInput(String input) {

        ArrayList<String> invalidCharacters = new ArrayList<>();
        initialiseInvalidCharactersList(invalidCharacters);
        String[] words;
        for (String invalidCharacter : invalidCharacters) {
            words = input.split(invalidCharacter);
            if (words.length > 0) {
                return true;
            }
        }
        return false;
    }

    private static void initialiseInvalidCharactersList(ArrayList<String> invalidCharacters) {
        invalidCharacters.add("/");
        invalidCharacters.add("\\\\");
        invalidCharacters.add(":");
        invalidCharacters.add("*");
        invalidCharacters.add("?");
        invalidCharacters.add("\"");
        invalidCharacters.add("<");
        invalidCharacters.add(">");
        invalidCharacters.add("|");
    }
}
