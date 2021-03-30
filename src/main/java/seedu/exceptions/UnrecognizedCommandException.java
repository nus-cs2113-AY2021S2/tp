package seedu.exceptions;

public class UnrecognizedCommandException extends HealthVaultException {

    public String getMessage() {
        return "OOPS! Your command may not be valid! \n" +
                "Please check the list of available commands using \"help\"";
    }
}
