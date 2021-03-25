package seedu.hdbuy.data.exception;

public class InvalidParameterException extends Exception {
    public String keyCommand;

    public InvalidParameterException(String keyCommand) {
        super("You must enter the correct number of parameters.");
        this.keyCommand = keyCommand;
    }
}
