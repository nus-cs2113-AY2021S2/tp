package seedu.exceptions.nurseschedules;

import seedu.exceptions.HealthVaultException;

public class NurseIdNotFound extends HealthVaultException {
    public String getMessage() {
        return "NurseID does not exist! Please check Staff List and try again!";
    }
}
