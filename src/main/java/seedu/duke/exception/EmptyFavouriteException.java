package seedu.duke.exception;

public class EmptyFavouriteException extends NusMazeException {
    @Override
    public String getMessage() {
        return "You haven't set any favourite routes yet!";
    }
}
