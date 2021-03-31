package seedu.exceptions.doctorappointment;

import seedu.exceptions.HealthVaultException;

public class AppointmentIDTakenException extends HealthVaultException {
    public String getMessage(){return "Sorry, Appointment ID is already in the system.";}
}
