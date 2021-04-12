package seedu.duke.exception;

import seedu.duke.Constants;

@SuppressWarnings("serial")
public abstract class BaseException extends Exception {
    public final String classMessage;

    /**
     * This is the constructor of the base exception class.
     * @param classMessage message for the subclass of exception
     * @param message message for with detail on the actual type of exception
     * @param cause cause of this subclass of exception being thrown
     */
    public BaseException(String classMessage, String message, Throwable cause) {
        super(message, cause);
        this.classMessage = classMessage;
    }

    @Override
    public String toString() {
        String errorString = classMessage + ":" + System.lineSeparator();

        String errorMessage = getMessage();
        String[] errorLines = errorMessage.split("\n");
        Boolean first = true;
        for (String errorLine : errorLines) {
            // Add a new line character for 2nd and subsequent rows
            if (first) {
                first = false;
            } else {
                errorString += System.lineSeparator();
            }
            errorString += Constants.EXCEPTION_INDENT + errorLine;
        }

        return errorString;
    }
}
