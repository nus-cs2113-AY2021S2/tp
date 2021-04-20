package seedu.duke.command;

import seedu.duke.email.EmailManager;
import seedu.duke.utilities.Parser;
import seedu.duke.utilities.Storage;
import seedu.duke.utilities.Ui;
import seedu.duke.email.Archive;
import seedu.duke.email.Email;
import seedu.duke.exceptions.InvalidIndexException;

import java.util.ArrayList;

public class ArchiveCommand extends Command {
    public ArchiveCommand(String s) {
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
        try {
            int index = Parser.extractIndex(userInput);
            if (index <= 0 || index > listedEmails.size()) {
                throw new InvalidIndexException();
            }
            Email archivedEmail = listedEmails.get(index - 1);
            if (!(archivedEmail instanceof Archive)) {
                emails.deleteEmail(archivedEmail);
                emails.addToArchive(archivedEmail);
                System.out.println("Move this email to archive folder");
            } else {
                System.out.println("This email is already in archive folder");
            }
            storage.updateAllTypeEmails(emails.getEmailsList());
        } catch (InvalidIndexException e) {
            e.showErrorMessage("ARCHIVE");
        }

    }
}
