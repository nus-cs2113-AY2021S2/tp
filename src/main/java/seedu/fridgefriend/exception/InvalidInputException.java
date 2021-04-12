package seedu.fridgefriend.exception;


//@author SimJJ96
/**
 * Signals that the format of the input is incorrect.
 */
public class InvalidInputException extends Exception {
    private static final String errorMessage = "Sorry my friend, you have entered an invalid input.\n"
            + "Enter 'help' for more information about the correct input format.";

    public InvalidInputException() {
        super(errorMessage);
    }
    //@@author

    //@@author Vinci-Hu
    public InvalidInputException(String message) {
        super(message);
    }
}
