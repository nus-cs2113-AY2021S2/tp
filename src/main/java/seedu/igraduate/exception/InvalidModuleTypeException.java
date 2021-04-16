package seedu.igraduate.exception;

/**
 * The exception is thrown if the module type input is invalid.
 */
public class InvalidModuleTypeException extends Exception {
    private static final String INVALID_MODULE_TYPE_ERROR_MESSAGE = "The module type you have"
            + " entered is invalid. \nThe supported module types for add are: ue, ge, core and math.";

    //@@author kewenlok
    public InvalidModuleTypeException() {
        super(INVALID_MODULE_TYPE_ERROR_MESSAGE);
    }
}
