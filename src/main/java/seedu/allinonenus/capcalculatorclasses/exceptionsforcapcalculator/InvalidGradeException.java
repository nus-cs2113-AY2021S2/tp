package seedu.allinonenus.capcalculatorclasses.exceptionsforcapcalculator;

public class InvalidGradeException extends Exception {

    public InvalidGradeException() {
        super("Invalid grade entered, please try again\n");
    }

}
