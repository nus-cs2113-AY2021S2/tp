package seedu.exceptions.doctorappointment;

public class InvalidDateException extends Exception {
    public String getMessage(){
        return "Sorry please the date in the correct format of DDMMYYYY.";
    }
}
