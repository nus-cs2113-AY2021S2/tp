package seedu.duke.command;

import seedu.duke.email.EmailManager;
import seedu.duke.utilities.Storage;
import seedu.duke.utilities.Ui;

public class ExitCommand extends Command {
    public ExitCommand(String s) {
        super(s);
    }

    public void execute(EmailManager tasks, Ui ui, Storage storage) {
        ui.printGoodBye();
        System.exit(0);
    }
}
