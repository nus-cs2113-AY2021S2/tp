package seedu.exceptions.doctorappointment;

import seedu.exceptions.DukeException;

public class FileCreatingErrorException extends Exception {
    public String getMessage(){return "File cannot be created";};
}
