package seedu.exceptions.nurseschedules;

import seedu.exceptions.HealthVaultException;

public class NurseCrossValidationError extends HealthVaultException {
    public String getMessage() {
        return "Staff file is not loaded, Nurse ID cannot be validated."
                + System.lineSeparator() + "Please delete data/Staff.txt before trying again";
    }
}
