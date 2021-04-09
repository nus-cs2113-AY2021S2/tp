package seedu.exceptions.nurseschedules;

import seedu.exceptions.HealthVaultException;

public class DuplicateScheduleException extends HealthVaultException {

    String date;

    public DuplicateScheduleException(String date) {
        this.date = date;
    }

    public String getMessage() {
        return "Patient has already been scheduled on " + date + "!";
    }
}
