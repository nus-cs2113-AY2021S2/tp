package seedu.duke.command;

import com.sun.jdi.InvalidTypeException;
import seedu.duke.email.EmailManager;
import seedu.duke.utilities.Parser;
import seedu.duke.utilities.Storage;
import seedu.duke.utilities.Ui;
import seedu.duke.email.Email;
import seedu.duke.exceptions.InvalidIndexException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EditCommand extends Command {

    public EditCommand(String s) {
        super(s);
    }

    private static Logger LOGGER = Logger.getLogger(EditCommand.class.getName());

    @Override
    public void execute(EmailManager emails, Ui ui, Storage storage) {
        LOGGER.setLevel(Level.INFO);
        LOGGER.info("Logger Name: " + LOGGER.getName());

        if (!emails.getListedType().equals("draft")) {
            String feedback = "You have to list DRAFT emails first" + System.lineSeparator()
                    + "=> list draft" + System.lineSeparator();
            ui.printFeedback(feedback);
            return;
        }

        ArrayList<Email> draftedEmails = emails.getDraftEmails();
        if (draftedEmails.isEmpty()) {
            String feedback = "You have no emails to edit.";
            ui.printFeedback(feedback);
            return;
        }

        try {
            LOGGER.warning("Can cause InvalidIndexException");
            int index = Parser.extractIndex(userInput);
            if (index <= 0 || index > draftedEmails.size()) {
                throw new InvalidIndexException();
            }
            Email draftEmail = draftedEmails.get(index - 1);
            ui.printEditEmail();
            Scanner in = new Scanner(System.in);
            LOGGER.warning("Can cause InvalidEditTypeException");
            String editType = in.nextLine().trim();
            processEditCommand(draftEmail, in, editType);
            storage.updateAllTypeEmails(emails.getEmailsList());
            ui.printEmailEditedMessage(editType);
        } catch (InvalidIndexException e) {
            e.showErrorMessage("EDIT");
            LOGGER.log(Level.SEVERE, "Exception occurred", e);
        } catch (InvalidTypeException e) {
            ui.showMessageForInvalidEditTypeInput();
            LOGGER.log(Level.SEVERE, "Exception occurred", e);
        }
    }

    private void processEditCommand(Email draftEmail, Scanner in, String editType) throws InvalidTypeException {
        switch (editType) {
        case "to":
            ArrayList<String> to = Parser.parseRecipients(in.nextLine());
            draftEmail.setTo(to);
            checkEmailValidity(to);
            break;
        case "subject":
            String subject = in.nextLine();
            draftEmail.setSubject(subject);
            checkSubjectValidity(subject);
            break;
        case "content":
            String inputContent = in.nextLine();
            String content = "";
            while (!inputContent.startsWith("/end")) {
                content += inputContent + "\n";
                inputContent = in.nextLine();
            }
            draftEmail.setContent(content);
            checkContentValidity(content);
            break;
        default:
            throw new InvalidTypeException();
        }

        String time = String.valueOf(LocalDateTime.now().withNano(0));
        draftEmail.setTime(time);
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

    private void checkEmailValidity(ArrayList<String> to) {
        if (!Parser.checkEmailsValidity(to)) {
            Ui.showInvalidEmailAddressWarning();
        }
    }
}
