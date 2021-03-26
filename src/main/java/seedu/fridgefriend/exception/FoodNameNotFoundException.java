package seedu.fridgefriend.exception;

/**
 * Signal that the input string of Food is not found in the collection.
 */
public class FoodNameNotFoundException extends Exception {
    private static final String errorMessage = "Food specified not found.";

    public FoodNameNotFoundException() {
        super(errorMessage);
    }
}