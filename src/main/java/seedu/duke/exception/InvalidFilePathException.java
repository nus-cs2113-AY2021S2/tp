package seedu.duke.exception;

public class InvalidFilePathException extends StorageOperationException {
    @Override
    public String getMessage() {
        return "Oops! An Error occurred while creating directory or file :(";
    }
}
