package seedu.duke.command;

import seedu.duke.email.EmailManager;
import seedu.duke.utilities.Parser;
import seedu.duke.utilities.Storage;
import seedu.duke.utilities.Ui;
import seedu.duke.email.Email;

import java.util.ArrayList;

public class FindCommand extends Command {
    public FindCommand(String s) {
        super(s);
    }

    public void execute(EmailManager emails, Ui ui, Storage storage) {
        ArrayList<Email> listedEmails = emails.getListedEmailsList();
        if (listedEmails == null) {
            String feedback = "You have to list emails first" + System.lineSeparator()
                    + "=> list emails" + System.lineSeparator();
            ui.printFeedback(feedback);
            return;
        }

        String keyword = Parser.removeCommand(userInput).trim().toLowerCase();
        ArrayList<Email> findEmails = emails.findByString(listedEmails, keyword);
        if (findEmails.size() == 0) {
            System.out.println("No matching emails found.");
        } else {
            emails.printEmailByType(findEmails);
        }

    }
}
