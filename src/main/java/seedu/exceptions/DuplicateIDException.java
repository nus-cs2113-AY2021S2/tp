package seedu.exceptions;

public class DuplicateIDException extends HealthVaultException {
<<<<<<< HEAD

    private String IDType;

    public DuplicateIDException(String IDType) {
        this.IDType = IDType;
    }

=======
    private String IDType;
    public DuplicateIDException(String IDType) {
        this.IDType = IDType;
    }
>>>>>>> c4330f9184f2e4edabe7a52ab14246137fa9b62e
    public String getMessage() {
        return "The " + IDType + " has already been taken! Use a different ID!";
    }
}