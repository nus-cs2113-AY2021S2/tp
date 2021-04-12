package seedu.duke.command;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.duke.email.EmailManager;
import seedu.duke.utilities.Storage;
import seedu.duke.utilities.Ui;
import seedu.duke.email.Deleted;
import seedu.duke.email.Email;
import seedu.duke.email.Inbox;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class DeleteCommandTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private ArrayList<Email> emails = new ArrayList<>();
    private EmailManager emailManager = new EmailManager();
    private Ui ui = new Ui();
    private Storage storage = new Storage();


    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
        ArrayList<String> to = new ArrayList<>();
        to.add("456@gmail.com");
        emails.add(new Inbox("123@gmail.com", to, "S1", "2012-01-01", "C1", false));
        emails.add(new Inbox("123@gmail.com", to, "S2", "2012-01-02", "C2", false));
        emails.add(new Deleted("123@gmail.com", to, "S3", "2012-01-03", "C3", false));
        emailManager.setListedEmailsList(emails);

    }

    @Test
    void execute_validIndex_success() {
        new DeleteCommand("delete 1").execute(emailManager, ui, storage);

        Assert.assertEquals("Move this email to deleted folder", outputStreamCaptor.toString()
                .trim());
    }

    @Test
    void execute_deletedIndex_message() {
        new DeleteCommand("delete 3").execute(emailManager, ui, storage);

        Assert.assertEquals("Move this email from deleted folder", outputStreamCaptor.toString()
                .trim());
    }

    @Test
    void execute_invalidIndex_message() {
        new DeleteCommand("delete 4").execute(emailManager, ui, storage);

        Assert.assertEquals("OOPS!!! The Email ID that you DELETE is invalid.", outputStreamCaptor.toString()
                .trim());
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}
