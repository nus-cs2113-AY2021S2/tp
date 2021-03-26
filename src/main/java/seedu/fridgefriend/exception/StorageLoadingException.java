package seedu.fridgefriend.exception;

/**
 * Indicates that an error occurred while loading the saved data.
 */
public class StorageLoadingException extends Exception {
    private static final String errorMessage = "There was an error loading the data for FridgeFriend!\n";

    public StorageLoadingException(Exception e) {
        super(errorMessage + e.getLocalizedMessage());
    }
}
