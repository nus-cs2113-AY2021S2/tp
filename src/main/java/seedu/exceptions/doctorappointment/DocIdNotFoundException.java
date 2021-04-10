package seedu.exceptions.doctorappointment;

import seedu.exceptions.HealthVaultException;

/**
 * Exception to handle invalid Doctor Id when Id not found in staff Data base.
 */
public class DocIdNotFoundException extends HealthVaultException {
    private String IdType;

    public DocIdNotFoundException(String IdType) {
        this.IdType = IdType;
    }

    /**
     * Returns the  error message.
     *
     * @return Error Message.
     */
    public String getMessage() {
        return "The " + IdType + " ID does not exist in the Staff Database!";
    }
}
