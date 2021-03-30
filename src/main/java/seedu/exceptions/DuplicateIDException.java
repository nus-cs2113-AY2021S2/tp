package seedu.exceptions;

public class DuplicateIDException extends HealthVaultException {

    public DuplicateIDException(String error) {
        this.error = error;
    }

    @Override
    public void getError(String input) {
        super.getError(input);
    }
}
