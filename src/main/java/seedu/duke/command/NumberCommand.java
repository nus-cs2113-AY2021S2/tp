package seedu.duke.command;

import seedu.duke.email.EmailManager;
import seedu.duke.utilities.Storage;
import seedu.duke.utilities.Ui;
import seedu.duke.exceptions.InvalidInputException;

public class NumberCommand extends Command {
    private static final int STARTINDEXOFEMAILTYPE = 7;

    public NumberCommand(String s) {
        super(s);
    }

    public void execute(EmailManager emails, Ui ui, Storage storage) {
        try {
            String emailType = this.getUserInput().toLowerCase().substring(STARTINDEXOFEMAILTYPE).trim();
            int totalEmails = 0;

            switch (emailType) {
            case ("archive"):
                totalEmails = emails.getNumOfArchiveEmails();
                break;
            case ("deleted"):
                totalEmails = emails.getNumOfDeletedEmails();
                break;
            case ("draft"):
                totalEmails = emails.getNumOfDraftEmails();
                break;
            case ("allemails"):
                totalEmails = emails.getNumOfEmails();
                break;
            case ("inbox"):
                totalEmails = emails.getNumOfInboxEmails();
                break;
            case ("junk"):
                totalEmails = emails.getNumOfJunkEmails();
                break;
            case ("sent"):
                totalEmails = emails.getNumOfSentEmails();
                break;
            default:
                throw new InvalidInputException(); //throw exception
            }
            assert totalEmails >= 0 : "total emails < 0";
            ui.printNumberOfEmails(totalEmails, emailType);
        } catch (InvalidInputException e) {
            Ui.showInvalidListTypeMessage();
        } catch (StringIndexOutOfBoundsException e) {
            Ui.showInvalidListTypeMessage();
        }

    }

}
