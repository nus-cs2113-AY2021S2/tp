package seedu.fridgefriend.exception;


//@author SimJJ96
/**
 * Signals that the format of the input is incorrect.
 */
public class InvalidInputException extends Exception {
    private static final String errorMessage = "Sorry my friend, please give a valid input.\n"
            + "You can enter 'help' command for the correct format. ";

    public InvalidInputException() {
        super(errorMessage);
    }
    //@@author

    //@@author Vinci-Hu
    public InvalidInputException(String message) {
        super(message);
    }
}
