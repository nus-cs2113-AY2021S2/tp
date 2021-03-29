package seedu.exceptions.doctorappointment;

public class InvalidAppIDException extends Exception {
    public String getMessage(){
        return "Sorry this Appointment ID is invalid" ;
    }
}
