package seedu.exceptions.doctorappointment;

import seedu.exceptions.HealthVaultException;

public class FileCreatingErrorException extends HealthVaultException {
    public String getMessage(){return "File cannot be created";};
}
