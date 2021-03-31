package seedu.duke.exception;

public class LoadDataException extends StorageOperationException {
    @Override
    public String getMessage() {
        return "Oops! An Error occurred while loading previous data :(";
    }
}
