package seedu.fridgefriend.exception;

public class FoodNameNotFoundException extends Exception {
    private static final String errorMessage = "Food specified not found.";

    public FoodNameNotFoundException() {
        super(errorMessage);
    }
}