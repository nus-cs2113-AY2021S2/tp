package seedu.allinonenus.capcalculatorclasses.exceptionsforcapcalculator;

public class InvalidYearAndSemException extends Exception {
    public InvalidYearAndSemException() {
        super("Incorrect input! Please enter the correct Year and Sem inputs again:\n");
    }

}
