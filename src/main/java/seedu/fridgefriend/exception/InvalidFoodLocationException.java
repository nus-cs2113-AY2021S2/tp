package seedu.fridgefriend.exception;

//@@author leeyp
/**
 * Signals that the food category does not match any existing category.
 */
public class InvalidFoodLocationException extends Exception {

    private static final String messagePart1 = "Sorry my friend, ''";
    private static final String messagePart2 = "'' is not a valid location.";

    public InvalidFoodLocationException(String invalidLocation) {
        super(messagePart1 + invalidLocation + messagePart2);
    }

}