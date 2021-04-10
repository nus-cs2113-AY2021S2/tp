package seedu.exceptions.nurseschedules;

import seedu.exceptions.HealthVaultException;

public class DuplicateScheduleException extends HealthVaultException {

    String date;

    /**
     * Constructor for DuplicateScheduleException.
     *
     * @param date User input date that is duplicated
     */
    public DuplicateScheduleException(String date) {
        this.date = date;
    }

    /**
     * Returns the error message.
     *
     * @return error message
     */
    public String getMessage() {
        return "Patient has already been scheduled on " + date + "!";
    }
}
