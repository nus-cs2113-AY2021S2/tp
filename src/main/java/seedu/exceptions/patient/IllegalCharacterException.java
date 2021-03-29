package seedu.exceptions.patient;

import seedu.exceptions.DukeException;

public class IllegalCharacterException extends DukeException {

    @Override
    public void getError(String input) {
        System.out.println("OOPS! You have an illegal character in your: " +
                "name or illness or medication required fields");
    }
}
