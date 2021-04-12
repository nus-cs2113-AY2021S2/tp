package seedu.exceptions.nurseschedules;

import seedu.exceptions.HealthVaultException;

public class NurseIdNotFound extends HealthVaultException {

    /**
     * Returns the error message.
     *
     * @return error message
     */
    public String getMessage() {
        return "NurseID does not exist! Please check Staff List and try again!";
    }
}
