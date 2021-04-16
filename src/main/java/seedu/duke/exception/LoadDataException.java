package seedu.duke.exception;

public class LoadDataException extends StorageOperationException {
    @Override
    public String getMessage() {
        return "[ ] An Error occurred while loading %s data. It has been cleared to default!";
    }
}
