package exceptions;

/**
 * Represents the exceptions to be thrown by class methods to catch predictable errors
 */
public class DukeExceptions extends Exception {
    // Exception when invalid instructions are provided

    private String exceptionMessage;

    public DukeExceptions(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public String getMessage() {
        return this.exceptionMessage;
    }
}
