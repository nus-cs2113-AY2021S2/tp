package seedu.exceptions;

public class DeliveryOutOfBoundsException extends Exception {
    @Override
    public String getMessage() {
        return "Enter a valid delivery number, you must.";
    }
}
