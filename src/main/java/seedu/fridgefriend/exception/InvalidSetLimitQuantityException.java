package seedu.fridgefriend.exception;

//@@author SimJJ96
public class InvalidSetLimitQuantityException extends Exception {
    private static final String errorMessage = "Sorry my friend, the quantity "
            + "must be an integer more than or equal to 0.";

    public InvalidSetLimitQuantityException() {
        super(errorMessage);
    }

    public InvalidSetLimitQuantityException(String message) {
        super(message);
    }

}
