package exceptions;

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
