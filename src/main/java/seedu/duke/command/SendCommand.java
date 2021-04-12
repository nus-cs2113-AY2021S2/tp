package seedu.duke.command;

import org.json.simple.parser.ParseException;
import seedu.duke.email.EmailManager;
import seedu.duke.exceptions.EmailNotExistException;
import seedu.duke.exceptions.InvalidEmailAddressException;
import seedu.duke.login.LoginController;
import seedu.duke.utilities.Parser;
import seedu.duke.utilities.Storage;
import seedu.duke.utilities.Ui;
import seedu.duke.email.Email;
import seedu.duke.exceptions.InvalidIndexException;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class SendCommand extends Command {
    public SendCommand(String s) {
        super(s);
    }

    public void execute(EmailManager emails, Ui ui, Storage storage) {
        if (!emails.getListedType().equals("draft")) {
            String feedback = "You have to list DRAFT emails first" + System.lineSeparator()
                    + "=> list draft" + System.lineSeparator();
            ui.printFeedback(feedback);
            return;
        }

        ArrayList<Email> draftedEmails = emails.getDraftEmails();
        if (draftedEmails.isEmpty()) {
            String feedback = "You have no emails to send.";
            ui.printFeedback(feedback);
            return;
        }

        Email[] sendEmailList;

        try {
            sendEmailList = getEmailsToSend(draftedEmails);
        } catch (InvalidIndexException e) {
            e.showErrorMessage("SENT");
            return;
        }

        assert sendEmailList != null : "sendEmailList in SendCommand is still null.";

        for (Email draftEmail : sendEmailList) {
            try {
                checkRecipientsValidity(draftEmail);
                checkSubjectValidity(draftEmail.getSubject());
                checkContentValidity(draftEmail.getContent());
                draftEmail.setTime(String.valueOf(LocalDateTime.now().withNano(0)));
                emails.deleteEmail(draftEmail);
                emails.addToSent(draftEmail);
                updateRecipientInboxes(draftEmail, emails, storage);
                ui.printEmailSent(draftEmail);
            } catch (InvalidEmailAddressException | EmailNotExistException e) {
                System.out.println(e.getMessage());
                System.out.println("This email is not sent:");
                System.out.println(draftEmail.getShortDescription());
                System.out.println("");
            }
            storage.updateAllTypeEmails(emails.getAllEmails());
        }
    }

    private Email[] getEmailsToSend(ArrayList<Email> draftedEmails) throws InvalidIndexException {
        Email[] sendEmailList = null;
        String args = Parser.removeCommand(userInput);
        int[] indices = Parser.extractMultipleIndices(args);
        sendEmailList = new Email[indices.length];
        for (int i = 0; i < indices.length; i++) {
            if (indices[i] <= 0 || indices[i] > draftedEmails.size()) {
                throw new InvalidIndexException();
            }
            sendEmailList[i] = draftedEmails.get(indices[i] - 1);
        }

        return sendEmailList;
    }

    private void updateRecipientInboxes(Email email, EmailManager senderEmails, Storage senderStorage) {
        ArrayList<String> recipients = email.getTo();
        EmailManager recipientEmails;
        Storage recipientStorage;

        for (String recipient : recipients) {
            String sender = email.getFrom();
            if (recipient.equals(sender)) {
                recipientEmails = senderEmails;
                recipientStorage = senderStorage;
            } else {
                recipientStorage = new Storage();
                try {
                    ArrayList<Email> emailList = recipientStorage.load(recipient + ".json", recipient, "");
                    recipientEmails = new EmailManager(emailList);
                } catch (IOException | ParseException e) {
                    recipientEmails = new EmailManager();
                    e.printStackTrace();
                }
            }

            recipientEmails.addToInbox(email);
            recipientStorage.updateAllTypeEmails(recipientEmails.getEmailsList());
        }
    }

    private void checkRecipientsValidity(Email draftEmail)
            throws InvalidEmailAddressException, EmailNotExistException {
        LoginController lc = new LoginController();
        for (String recipient : draftEmail.getTo()) {
            if (!Parser.checkEmailValidity(recipient)) {
                throw new InvalidEmailAddressException(recipient);
            }
            if (!lc.checkUserIdExists(recipient)) {
                throw new EmailNotExistException(recipient);
            }
        }
    }

    private void checkSubjectValidity(String subject) {
        if (subject.isBlank()) {
            Ui.showMissingSubjectWarning();
        }
    }

    private void checkContentValidity(String content) {
        if (content.isBlank()) {
            Ui.showMissingContentWarning();
        }
    }
}
