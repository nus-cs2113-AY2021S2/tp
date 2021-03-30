package seedu.exceptions.patient;

import seedu.exceptions.HealthVaultException;

public class InvalidAgeException extends HealthVaultException {

    @Override
    public void getError(String input) {
        System.out.println("OOPS! Your age input is invalid! " +
                "Please ensure that the age is an integer between 0 and 150!");
    }
}
