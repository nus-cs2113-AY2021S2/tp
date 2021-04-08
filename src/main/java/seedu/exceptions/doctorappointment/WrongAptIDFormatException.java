package seedu.exceptions.doctorappointment;

import seedu.exceptions.HealthVaultException;

public class WrongAptIDFormatException extends HealthVaultException {
    public String getMessage() {
        return "Error in Appointment ID input\nPlease input with the following format [A][5 digit ID number]";
    }
}
