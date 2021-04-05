package seedu.duke.exception;

public class InvalidDailyRouteException extends NusMazeException {
    @Override
    public String getMessage() {
        return "Invalid Block! Daily route requires at least one location for each schedule!";
    }
}
