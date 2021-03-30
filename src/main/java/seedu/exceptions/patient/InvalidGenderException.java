package seedu.exceptions.patient;

import seedu.exceptions.HealthVaultException;

public class InvalidGenderException extends HealthVaultException {

    @Override
    public void getError(String input) {
        System.out.println("OOPS! Your gender input is invalid! " +
                "Please ensure that the gender is \"M\", \"F\" or \"Others\"!");
    }
}
