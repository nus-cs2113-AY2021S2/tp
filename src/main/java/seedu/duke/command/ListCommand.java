package seedu.duke.command;

import seedu.duke.email.EmailManager;
import seedu.duke.utilities.Parser;
import seedu.duke.utilities.Storage;
import seedu.duke.utilities.Ui;
import seedu.duke.email.Email;

import java.util.ArrayList;

/**
 * Allows user to print the specific email type they would like to check.
 */
public class ListCommand extends Command {
    public ListCommand(String s) {
        super(s);
    }

    /**
     * Retrieve the email type the user wants to print and get the email manager to print the specified email type.
     *
     * @param emails email object
     * @param ui ui object
     * @param storage storage object
     */
    @Override
    public void execute(EmailManager emails, Ui ui, Storage storage) {
        try {
            ArrayList<Email> emailTypeToPrint = Parser.getTypeToList(emails, userInput);
            emails.printEmailByType(emailTypeToPrint);
        } catch (AssertionError e1) {
            Ui.showInvalidListTypeMessage();
        }


    }
}
