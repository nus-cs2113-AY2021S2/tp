package seedu.exceptions;

public class IllegalCharacterException extends HealthVaultException {

    private String errorField;

    public IllegalCharacterException(String errorField) {
        this.errorField = errorField;
    }
    public String getMessage() {
        return "You have an illegal character in your: " + errorField;
    }
}
