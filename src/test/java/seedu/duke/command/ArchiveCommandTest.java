package seedu.duke.command;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.duke.email.EmailManager;
import seedu.duke.utilities.Storage;
import seedu.duke.utilities.Ui;
import seedu.duke.email.Archive;
import seedu.duke.email.Email;
import seedu.duke.email.Inbox;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class ArchiveCommandTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private ArrayList<Email> emails = new ArrayList<>();
    private EmailManager emailManager;
    private Ui ui = new Ui();
    private Storage storage = new Storage();


    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
        ArrayList<String> to = new ArrayList<>();
        to.add("456@gmail.com");
        emails.add(new Inbox("123@gmail.com", to, "S1", "2012-01-01", "C1", false));
        emails.add(new Inbox("123@gmail.com", to, "S2", "2012-01-02", "C2", false));
        emails.add(new Archive("123@gmail.com", to, "S3", "2012-01-03", "C3", false));
        emailManager = new EmailManager();
        emailManager.setListedEmailsList(emails);

    }

    @Test
    void execute_validIndex_success() {
        new ArchiveCommand("archive 1").execute(emailManager, ui, storage);

        Assert.assertEquals("Move this email to archive folder", outputStreamCaptor.toString()
                .trim());
    }

    @Test
    void execute_archivedIndex_message() {
        new ArchiveCommand("archive 3").execute(emailManager, ui, storage);

        Assert.assertEquals("This email is already in archive folder", outputStreamCaptor.toString()
                .trim());
    }

    @Test
    void execute_invalidIndex_message() {
        new ArchiveCommand("archive 4").execute(emailManager, ui, storage);

        Assert.assertEquals("OOPS!!! The Email ID that you ARCHIVE is invalid.", outputStreamCaptor.toString()
                .trim());
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}
