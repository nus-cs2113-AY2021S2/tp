package seedu.exceptions.patient;

import seedu.exceptions.DukeException;

public class EmptyInputException extends DukeException {

    @Override
    public void getError(String input) {
        System.out.println("OOPS! You have an empty field! All fields must be filled!");
    }
}
