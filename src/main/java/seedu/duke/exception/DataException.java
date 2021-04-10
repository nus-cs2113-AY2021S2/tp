package seedu.duke.exception;

import seedu.duke.Constants;

@SuppressWarnings("serial")
public class DataException extends BaseException {
    public static enum Type {
        NO_PATIENT_LOADED(Constants.INVALID_INPUT_NO_PATIENT_LOADED),
        EMPTY_DESCRIPTION(Constants.INVALID_INPUT_EMPTY_DESCRIPTION),
        NO_RECORD_FOUND(Constants.DATA_NO_RECORD_FOUND),
        FUTURE_DATE(Constants.INVALID_FUTURE_DATE);

        public final String message;

        private Type(String message) {
            this.message = message;
        }
    }

    /**
     * This is the constructor of the exception class for invalid input.
     * @param type type of invalid input received from user
     */
    public DataException(Type type) {
        this(type, null);
    }

    /**
     * This is the constructor of the exception class for invalid input, with a cause as parameter.
     * @param type type of invalid input received from user
     * @param cause cause of this subclass of exception being thrown
     */
    public DataException(Type type, Throwable cause) {
        super(Constants.INVALID_INPUT, type.message, cause);
    }
}
