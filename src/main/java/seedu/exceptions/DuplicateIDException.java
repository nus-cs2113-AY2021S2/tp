package seedu.exceptions;

/**
 * Exception to handle duplicate ID when adding objects.
 */
public class DuplicateIDException extends HealthVaultException {

    private String IDType;

    /**
     * Constructor for DuplicateIDException.
     *
     * @param IDType Type of ID (Nurse/Doctor/Patient) input.
     */
    public DuplicateIDException(String IDType) {
        this.IDType = IDType;
    }


    /**
     * Returns the error message with crafted based on ID type.
     *
     * @return Error Message.
     */
    public String getMessage() {
        return "The " + IDType + " ID has already been taken! Use a different ID!";
    }
}