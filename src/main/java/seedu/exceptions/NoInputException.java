package seedu.exceptions;

public class NoInputException extends HealthVaultException {
    public String getMessage() {
        return "There is an empty field in the input! All fields must be filled!";
    }
}
