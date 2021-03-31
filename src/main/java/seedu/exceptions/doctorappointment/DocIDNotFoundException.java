package seedu.exceptions.doctorappointment;

import seedu.exceptions.HealthVaultException;

public class DocIDNotFoundException extends HealthVaultException {
    private String IDType;

    public DocIDNotFoundException(String IDType) {
        this.IDType = IDType;
    }

    public String getMessage() {
        return "The " + IDType + " ID does not exist in the Staff Database!";
    }
}
