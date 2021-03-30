package seedu.exceptions.patient;

import seedu.exceptions.DukeException;

public class InvalidGenderException extends DukeException {

    @Override
    public void getError(String input) {
        System.out.println("OOPS! Your gender input is invalid! " +
                "Please ensure that the gender is \"M\", \"F\" or \"Others\"!");
    }
}
