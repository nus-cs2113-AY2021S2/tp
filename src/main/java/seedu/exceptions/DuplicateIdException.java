package seedu.exceptions;

/**
 * Exception to handle duplicate ID when adding objects.
 */
public class DuplicateIdException extends HealthVaultException {

    private String idType;

    /**
     * Constructor for DuplicateIDException.
     *
     * @param idType Type of ID (Nurse/Doctor/Patient) input.
     */
    public DuplicateIdException(String idType) {
        this.idType = idType;
    }


    /**
     * Returns the error message with crafted based on ID type.
     *
     * @return Error Message.
     */
    public String getMessage() {
        return "The " + idType + " ID has already been taken! Use a different ID!";
    }
}