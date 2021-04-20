package seedu.duke.command;

import seedu.duke.email.EmailManager;
import seedu.duke.utilities.Storage;
import seedu.duke.utilities.Ui;

public abstract class Command {
    protected String userInput;

    public String getUserInput() {
        return userInput;
    }

    public void setUserInput(String userInput) {
        this.userInput = userInput;
    }

    public Command(String s) {
        userInput = s;
    }

    public abstract void execute(EmailManager tasks, Ui ui, Storage storage);
}
