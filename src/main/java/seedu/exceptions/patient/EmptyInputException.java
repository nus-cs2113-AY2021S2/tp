package seedu.exceptions.patient;

import seedu.exceptions.HealthVaultException;

public class EmptyInputException extends HealthVaultException {

    @Override
    public void getError(String input) {
        System.out.println("OOPS! You have an empty field! All fields must be filled!");
    }
}
