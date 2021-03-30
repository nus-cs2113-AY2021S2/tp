package seedu.exceptions.doctorappointment;

public class AppointmentIDTakenException extends Exception {
    public String getMessage(){return "Sorry, Appointment ID is already in the system.";}
}
