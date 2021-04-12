package seedu.exceptions;

/**
 * Exception to handles any sort of corruption in file data that is unintended.
 */
public class CorruptedFileException extends HealthVaultException {

    private String file;

    /**
     * Constructor for exception class.
     *
     * @param file File Path to the corrupted file.
     */
    public CorruptedFileException(String file) {
        this.file = file;
    }

    /**
     * Returns the corrupted file error message with the given file path.
     *
     * @return Error Message.
     */
    public String getMessage() {
        return "The file " + this.file + " is corrupted";
    }
}
