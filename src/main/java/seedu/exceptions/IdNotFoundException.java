package seedu.exceptions;

/**
 * Exception to handle any Find Command that returns nothing.
 */
public class IdNotFoundException extends HealthVaultException {
    private String idType;

    /**
     * Constructor for IDNotFoundException class.
     *
     * @param idType Type of ID (Nurse/Doctor/Patient) input.
     */
    public IdNotFoundException(String idType) {
        this.idType = idType;
    }

    public String getMessage() {
        return "The " + idType + " ID does not exist!";
    }
}
