package seedu.duke.exception;

public class InvalidDayException extends Exception {
    @Override
    public String getMessage() {
        return "Invalid day! Please enter the 'Day' command to retry!";
    }
}
