package seedu.exceptions.patient;

import seedu.exceptions.HealthVaultException;

public class InvalidIDValueException extends HealthVaultException {

    public InvalidIDValueException(String error) {
        this.error = error;
    }

    public String getMessage() {
        return "Looks like your ID value is incorrect! \n" +
                "Please ensure that the ID includes 5 numbers after \"P\"! \n" +
                "eg. P12345 or P67891";
    }
}
