package seedu.duke.command;

import com.sun.jdi.InvalidTypeException;
import seedu.duke.email.Email;
import seedu.duke.email.EmailManager;
import seedu.duke.utilities.Storage;
import seedu.duke.utilities.Ui;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SortCommand extends Command {
    private static final int STARTINDEXOFSORTTYPE = 5;

    public SortCommand(String s) {
        super(s);
    }

    private static Logger LOGGER = Logger.getLogger(SortCommand.class.getName());

    public void execute(EmailManager emails, Ui ui, Storage storage) {
        LOGGER.setLevel(Level.INFO);
        LOGGER.info("Logger Name: " + LOGGER.getName());

        try {
            String sortType = this.getUserInput().toLowerCase().trim().substring(STARTINDEXOFSORTTYPE);
            emails.setListedType("sorted");
            LOGGER.config("sortType might not be valid due to constant STARTINDEXOFSORTTYPE");
            LOGGER.info("sortType interpreted: " + sortType);
            if (sortType.equalsIgnoreCase("sender")) {
                emails.sortBySender();
            } else if (sortType.equalsIgnoreCase("time")) {
                emails.sortByTime();
            } else {
                throw new InvalidTypeException();
            }
            storage.updateAllTypeEmails(emails.getEmailsList());
            ui.printEmailsSorted(sortType);
            ArrayList<Email> emailsToPrint = emails.getAllEmails();
            emails.printEmailByType(emailsToPrint);
        } catch (InvalidTypeException e) {
            ui.showMessageForInvalidSortTypeInput();
            LOGGER.severe("sortType is wrong.");
        } catch (StringIndexOutOfBoundsException e) {
            ui.showMessageForEmptySortType();
            LOGGER.severe("sortType is empty.");
        }
    }

}
