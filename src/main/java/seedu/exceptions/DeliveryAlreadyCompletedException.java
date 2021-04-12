package seedu.exceptions;

public class DeliveryAlreadyCompletedException extends Exception {
    @Override
    public String getMessage() {
        return "Been already completed, the delivery number you entered has. Be paid extra, you will not.";
    }
}
