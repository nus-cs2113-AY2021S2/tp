package seedu.exceptions.nurseschedules;

import seedu.exceptions.HealthVaultException;

public class PatientIdNotFound extends HealthVaultException {
    public String getMessage() {
        return "PatientID does not exist! Please check Patient List and try again!";
    }
}
