//@@author Rye98
package seedu.duke.exception;

public class EmptyFavouriteException extends NusMazeException {
    @Override
    public String getMessage() {
        return "Oops! You don't have any favourite route!";
    }
}
