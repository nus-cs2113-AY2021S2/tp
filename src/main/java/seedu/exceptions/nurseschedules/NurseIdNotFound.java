package seedu.exceptions.nurseschedules;

import seedu.exceptions.DukeException;

public class NurseIdNotFound extends DukeException {
    public String getMessage() {
        return "NurseID does not exist! Please check ID and try again!";
    }
}
