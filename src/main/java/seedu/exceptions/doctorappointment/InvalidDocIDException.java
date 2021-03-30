package seedu.exceptions.doctorappointment;

public class InvalidDocIDException extends Exception {
    public String getMessage(){
        return "Sorry this Doctor ID is invalid" ;
    }
}