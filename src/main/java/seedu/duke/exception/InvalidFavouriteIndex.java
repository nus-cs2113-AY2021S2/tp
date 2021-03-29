package seedu.duke.exception;

import seedu.duke.exception.NusMazeException;

public class InvalidFavouriteIndex extends NusMazeException {
    @Override
    public String getMessage() {
        return "Oops! You must enter an Integer that is within the bounds!";
    }
}
