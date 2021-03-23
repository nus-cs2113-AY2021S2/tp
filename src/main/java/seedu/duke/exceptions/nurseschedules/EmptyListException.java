package seedu.duke.exceptions.nurseschedules;

import seedu.duke.exceptions.HealthVaultException;

public class EmptyListException extends HealthVaultException {
    public String getMessage() {
        return "No schedules are found in the system!";
    }
}
