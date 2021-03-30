package seedu.duke.exception;

import seedu.duke.Constants;

@SuppressWarnings("serial")
public class StorageException extends BaseException {
    public enum Type {
        FILE_CREATION_FAIL(Constants.STORAGE_FILE_CREATION_FAIL),
        FILE_WRITE_FAIL(Constants.STORAGE_FILE_WRITE_FAIL),
        FILE_NOT_FOUND(Constants.STORAGE_FILE_NOT_FOUND),
        NULL_INSTANCE(Constants.STORAGE_NULL_INSTANCE);
        
        public final String message;

        private Type(String message) {
            this.message = message;
        }
    }

    /**
     * This is the constructor of the exception class for unexpected outcome of saving/loading events.
     * @param type type of unexpected outcome during loading/saving
     */
    public StorageException(Type type) {
        this(type, null);
    }

    /**
     * This is the constructor of the exception class for unexpected outcome of saving/loading events,
     * with a cause as parameter.
     * @param type type of unexpected outcome during loading/saving
     * @param cause cause of this subclass of exception being thrown
     */
    public StorageException(Type type, Throwable cause) {
        super(Constants.STORAGE, type.message, cause);
    }
}
