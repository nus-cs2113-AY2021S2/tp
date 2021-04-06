package seedu.exceptions;

public class DeliveryAlreadyCompletedException extends Exception {
    @Override
    public String getMessage() {
        return "Delivery is already completed! Please choose a different delivery number!";
    }
}
