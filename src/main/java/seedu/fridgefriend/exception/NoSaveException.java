package seedu.fridgefriend.exception;


public class NoSaveException extends Exception {
    private static final String errorMessage = "There was an error loading the data for FridgeFriend!\n";

    public NoSaveException() {
        super(errorMessage);
    }
}
