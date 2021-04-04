package seedu.duke.exception;

public class LoadDataException extends StorageOperationException {
    @Override
    public String getMessage() {
        return "\u274C An Error occurred while loading %s data. It has been cleared to default!";
    }
}
