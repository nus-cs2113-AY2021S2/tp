package seedu.exceptions.doctorappointment;

public class InvalidIDException extends Exception {
    public String getMessage(){
        return "Sorry this ID is invalid" ;
    }
}
