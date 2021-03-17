package seedu.duke.exception;

public class RepeatEntryOutOfBoundException extends Exception {
    @Override
    public String getMessage() {
        return "ERROR, NO ENTRY AVAILABLE.";
    }
}
