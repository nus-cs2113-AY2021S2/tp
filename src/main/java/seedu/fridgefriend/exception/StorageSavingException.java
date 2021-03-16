package seedu.fridgefriend.exception;

/**
 * Indicates that an error occured while loading the saved data.
 */
public class StorageSavingException extends Exception {
    private static final String errorMessage = "There was an error saving the data for FridgeFriend!\n";

    public StorageSavingException(Exception e) {
        super(errorMessage + e.getLocalizedMessage());
    }
}
