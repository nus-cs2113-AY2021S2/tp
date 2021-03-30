package seedu.exceptions.doctorappointment;

public class InvalidGenderException extends Exception {
    public String getMessage(){
        return "Sorry please type in M or F for gender." ;
    }
}