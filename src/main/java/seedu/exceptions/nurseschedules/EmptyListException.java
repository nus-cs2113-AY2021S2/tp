package seedu.exceptions.nurseschedules;

import seedu.exceptions.HealthVaultException;

public class EmptyListException extends HealthVaultException {

    /**
     * Returns the error message.
     *
     * @return error message
     */
    public String getMessage() {
        return "OOPS! No schedules are found in the system!";
    }
}
