package seedu.duke.command;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.duke.email.Email;
import seedu.duke.email.EmailManager;
import seedu.duke.email.Inbox;
import seedu.duke.utilities.Storage;
import seedu.duke.utilities.Ui;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class TagCommandTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private EmailManager emailManager = new EmailManager();
    private Ui ui = new Ui();
    private Storage storage = new Storage();


    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
        ArrayList<Email> emails = new ArrayList<>();

        ArrayList<String> to = new ArrayList<>();
        ArrayList<String> tag = new ArrayList<>();
        to.add("456@gmail.com");
        tag.add("tag1");

        Email email1 = new Inbox("123@gmail.com", to, "S1", "2012-01-01", "C1", false);
        emails.add(email1);

        Email email2 = new Inbox("123@gmail.com", to, "S2", "2012-01-02", "C2", false);
        email2.setTags(tag);
        emails.add(email2);

        emailManager.setListedEmailsList(emails);
    }

    @Test
    void execute_validIndex_success() {
        new TagCommand("tag 1 tag1 tag2").execute(emailManager, ui, storage);

        Assertions.assertEquals("You have successfully set the following tags [tag1, tag2]",
                outputStreamCaptor.toString().trim());
    }

    @Test
    void execute_invalidIndex_message() {
        new TagCommand("tag 3 tag1").execute(emailManager, ui, storage);

        Assertions.assertEquals("OOPS!!! The Email ID that you TAG is invalid.",
                outputStreamCaptor.toString().trim());
    }

    @Test
    void execute_removeTag_success() {
        new TagCommand("tag 2").execute(emailManager, ui, storage);

        Assertions.assertEquals("You have successfully removed tags",
                outputStreamCaptor.toString().trim());
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}
