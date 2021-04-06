package seedu.exceptions;

public class DeliveryOutOfBoundsException extends Exception {
    @Override
    public String getMessage() {
        return "Please enter a valid delivery number";
    }
}
