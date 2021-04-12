package seedu.exceptions.doctorappointment;

import seedu.exceptions.HealthVaultException;

/**
 * Exception to handle invalid Doctor Id when Id not found in staff Data base.
 */
public class DocIdNotFoundException extends HealthVaultException {
    private String idType;

    public DocIdNotFoundException(String idType) {
        this.idType = idType;
    }

    /**
     * Returns the  error message.
     *
     * @return Error Message.
     */
    public String getMessage() {
        return "The " + idType + " ID does not exist in the Staff Database!";
    }
}
