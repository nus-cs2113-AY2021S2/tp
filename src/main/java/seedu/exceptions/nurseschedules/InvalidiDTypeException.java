package seedu.exceptions.nurseschedules;

import seedu.exceptions.HealthVaultException;

public class InvalidiDTypeException extends HealthVaultException {

    /**
     * Returns the error message.
     *
     * @return error message
     */
    public String getMessage() {
        return "OOPS! Looks like your ID value is incorrect! \n"
                + "Please ensure that the ID includes 5 numbers after \"N\" or \"P\" \n"
                + "eg. N12345 or P67891";
    }
}
