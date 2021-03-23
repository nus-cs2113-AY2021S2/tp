package seedu.duke.exceptions.nurseschedules;

import seedu.duke.exceptions.HealthVaultException;

public class NurseIDNotFound extends HealthVaultException {
    public String getMessage() {
        return "NurseID does not exist! Please check ID and try again!";
    }
}
