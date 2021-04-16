package seedu.duke.exception;

public class SaveDataException extends StorageOperationException {
    @Override
    public String getMessage() {
        return "Oops! An Error occurred while saving current data :(";
    }
}
