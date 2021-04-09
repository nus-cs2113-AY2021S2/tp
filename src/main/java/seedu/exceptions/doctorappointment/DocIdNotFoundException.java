package seedu.exceptions.doctorappointment;

import seedu.exceptions.HealthVaultException;

public class DocIdNotFoundException extends HealthVaultException {
    private String IdType;

    public DocIdNotFoundException(String IdType) {
        this.IdType = IdType;
    }

    public String getMessage() {
        return "The " + IdType + " ID does not exist in the Staff Database!";
    }
}
