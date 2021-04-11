package seedu.duke.exception;

public class ExceedTimeInOneDayException extends Exception{
    public ExceedTimeInOneDayException(){
    }

    public String toStinrg() {
        return "Exceeds 24 hours in one day";
    }
}
