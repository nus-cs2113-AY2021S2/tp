package seedu.exceptions;

import seedu.ui.UI;

public class UnrecognizedCommandException extends HealthVaultException {

    public void getError() {
        UI.printError("OOPS! Your command may not be valid! \n" +
                "Please check the list of available commands using \"help\"");
    }
}
