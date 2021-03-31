package seedu.exceptions;

public class CorruptedFileException extends HealthVaultException {

    private String file;

    public CorruptedFileException(String file) {
        this.file = file;
    }

    public String getMessage() {
        return "The file " + this.file + " is corrupted";
    }
}
