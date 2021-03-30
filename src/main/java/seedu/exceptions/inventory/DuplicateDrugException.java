package seedu.exceptions.inventory;
import seedu.exceptions.HealthVaultException;
public class DuplicateDrugException extends HealthVaultException {
    public DuplicateDrugException(String error) {
        this.error = error;
    }
    @Override
    public void getError(String input) {
        super.getError(input);
    }

}
