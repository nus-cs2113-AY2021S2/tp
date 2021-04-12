package seedu.exceptions.nurseschedules;

import seedu.exceptions.HealthVaultException;

public class PatientIdNotFound extends HealthVaultException {

    /**
     * Returns the error message.
     *
     * @return error message
     */
    public String getMessage() {
        return "PatientID does not exist! Please check Patient List and try again!";
    }
}
