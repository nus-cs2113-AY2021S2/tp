package seedu.exceptions;

public class DuplicateIDException extends HealthVaultException {
    private String IDType;
    public DuplicateIDException(String IDType) {
        this.IDType = IDType;
    }
    public String getMessage() {
        return "The " + IDType + " has already been taken! Use a different ID!";
    }
}