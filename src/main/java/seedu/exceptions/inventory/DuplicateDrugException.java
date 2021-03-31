package seedu.exceptions.inventory;
import seedu.exceptions.HealthVaultException;
public class DuplicateDrugException extends HealthVaultException {
    public DuplicateDrugException() {
    }
    @Override
    public void getError(String input) {
        super.getError(input);
    }

}
