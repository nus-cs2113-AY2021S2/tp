package seedu.duke.exception;

public class InvalidRepeatEntryException extends Exception {
    @Override
    public String getMessage() {
        return "PLEASE ENTER A NUMBER INSTEAD!";
    }
}
