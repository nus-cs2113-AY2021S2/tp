package seedu.duke.exception;

public class EmptyDailyRouteException extends NusMazeException {
    @Override
    public String getMessage() {
        return "Oops! You haven't planned any daily routes yet :(";
    }
}
