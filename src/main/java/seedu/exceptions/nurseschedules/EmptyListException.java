package seedu.exceptions.nurseschedules;

import seedu.exceptions.DukeException;

public class EmptyListException extends DukeException {
    public String getMessage() {
        return "No schedules are found in the system!";
    }
}
