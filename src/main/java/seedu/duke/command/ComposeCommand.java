package seedu.duke.command;


import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;

import seedu.duke.email.EmailManager;
import seedu.duke.utilities.Parser;
import seedu.duke.utilities.Storage;
import seedu.duke.utilities.Ui;
import seedu.duke.email.Draft;
import seedu.duke.email.Email;

public class ComposeCommand extends Command {

    public ComposeCommand(String s) {
        super(s);
    }

    public void execute(EmailManager emails, Ui ui, Storage storage) {
        try {
            ui.printComposeUI();
            Scanner in = new Scanner(System.in);
            ArrayList<String> to = Parser.parseRecipients(in.nextLine());
            String subject = in.nextLine().trim();
            String inputContent = in.nextLine().trim();
            String content = "";
            while (!inputContent.equals("/end")) {
                content += inputContent + "\n";
                inputContent = in.nextLine().trim();
            }

            assert !content.endsWith("/end") : "The ending command \"/end\" is in content";
            String userEmail = storage.getEmailAccount();
            String time = String.valueOf(LocalDateTime.now().withNano(0));
            Email draftEmail = new Draft(userEmail, to, subject, time, content, false);
            emails.addToDraft(draftEmail);
            checkEmailValidity(to);
            checkSubjectValidity(subject);
            checkContentValidity(content);
            storage.updateAllTypeEmails(emails.getEmailsList());
            ui.printEmailDrafted(draftEmail);
        } catch (NullPointerException e) {
            ui.showMissingInputMessage();
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

    private void checkEmailValidity(ArrayList<String> to) {
        if (!Parser.checkEmailsValidity(to)) {
            Ui.showInvalidEmailAddressWarning();
        }
    }
}
