package seedu.duke.command;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.duke.email.EmailManager;
import seedu.duke.utilities.Storage;
import seedu.duke.utilities.Ui;
import seedu.duke.email.Draft;
import seedu.duke.email.Email;
import seedu.duke.email.Inbox;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class NumberCommandTest {
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
        emails.add(new Draft("123@gmail.com", to, "S2", "2012-01-02", "C2", false));
        emails.add(new Draft("123@gmail.com", to, "S3", "2012-01-03", "C3", false));
        emailManager.setEmailsList(emails);

    }

    @Test
    void execute_validType_success() {
        new NumberCommand("number inbox").execute(emailManager, ui, storage);

        String expectedOutput = "You have a total of 1 INBOX emails";

        Assert.assertEquals(expectedOutput, outputStreamCaptor.toString()
                .trim());
    }

    @Test
    void executeInvalidType_message() {
        new NumberCommand("number drafts").execute(emailManager, ui, storage);

        String expectedOutput = "OOPS!!! The Email type that you enter is invalid." + System.lineSeparator()
                + "It must be one of: [allemails, inbox, archive, deleted, draft, junk, sent]";

        Assert.assertEquals(expectedOutput, outputStreamCaptor.toString()
                .trim());
    }

    @Test
    void execute_emptyFolder_message() {
        new NumberCommand("number deleted").execute(emailManager, ui, storage);

        String expectedOutput = "You have a total of 0 DELETED emails";

        Assert.assertEquals(expectedOutput, outputStreamCaptor.toString()
                .trim());
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}