package seedu.duke.command;

import seedu.duke.email.EmailManager;
import seedu.duke.utilities.Storage;
import seedu.duke.utilities.Ui;

/**
 * Prints the help menu.
 */
public class HelpCommand extends Command {

    public HelpCommand(String s) {
        super(s);
    }

    /**
     * Calls ui to print the pre-defined help menu.
     *
     * @param emails  email object
     * @param ui      ui object
     * @param storage storage object
     */
    public void execute(EmailManager emails, Ui ui, Storage storage) {
        ui.printMenu();
    }

}
