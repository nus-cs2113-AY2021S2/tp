package seedu.fridgefriend.exception;

/**
 * Signals that the food category does not match any existing category.
 */
public class InvalidFoodCategoryException extends Exception {
    
    private static final String messagePart1 = "Sorry my friend, ''";
    private static final String messagePart2 = "'' is not a valid category.";

    public InvalidFoodCategoryException(String invalidCategory) {
        super(messagePart1 + invalidCategory + messagePart2);
    }
    
}
