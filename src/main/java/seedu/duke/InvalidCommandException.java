package seedu.duke;

public class InvalidCommandException extends Exception {
    public String getMessage() {
        return " OOPS! I'm sorry but I don't understand your command :(";
    }
}
