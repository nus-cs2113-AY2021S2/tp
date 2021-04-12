package seedu.exceptions;


/**
 * Exception to handle any sort of listing when list is empty.
 */
public class EmptyListException extends HealthVaultException {


    /**
     * Returns the simple list empty error message.
     *
     * @return Error Message.
     */
    public String getMessage() {
        return "OOPS!!! The list is empty!";
    }
}
