package seedu.exceptions.nurseschedules;

import seedu.exceptions.HealthVaultException;

public class InvalidScheduleException extends HealthVaultException {
    public String getMessage() {
        return "Schedule you are trying to delete does not exist!";
    }
}
