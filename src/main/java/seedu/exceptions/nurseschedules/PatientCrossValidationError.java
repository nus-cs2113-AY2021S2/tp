package seedu.exceptions.nurseschedules;

import seedu.exceptions.HealthVaultException;

public class PatientCrossValidationError extends HealthVaultException {

    /**
     * Returns the error message.
     *
     * @return error message
     */
    public String getMessage() {
        return "Patient file is not loaded, Patient ID cannot be validated."
                + System.lineSeparator() + "Please delete data/Patient.txt before trying again";
    }
}
