package seedu.duke.exceptions.nurseschedules;

import seedu.duke.exceptions.DukeException;

public class EmptyListException extends DukeException {
    public String getMessage() {
        return "No schedules are found in the system!";
    }
}
