package seedu.exceptions.nurseschedules;

import seedu.exceptions.DukeException;

public class WrongInputsException extends DukeException {
    public String getMessage() {
        return "OOPS! Please check to see if your command is properly formatted!";
    }
}
