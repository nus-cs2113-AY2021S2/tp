package seedu.exceptions;

public class EmptyListException extends HealthVaultException {
    public String getMessage() {
        return "OOPS!!! The list is empty!";
    }
}
