package seedu.duke.command;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.duke.email.EmailManager;
import seedu.duke.utilities.Storage;
import seedu.duke.utilities.Ui;
import seedu.duke.email.Email;
import seedu.duke.email.Draft;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComposeCommandTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private ArrayList<Email> emails = new ArrayList<>();
    private EmailManager emailManager = new EmailManager();
    private Ui ui = new Ui();
    private Storage storage = new Storage();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void testComposeConstructor() {
        // action
        String from = "senderEmail.com";
        ArrayList<String> to = new ArrayList<>();
        to.add("receiverEmail.com");
        String subject = "this is Subject";
        String time = "timeComposed";
        String content = "sample line 1" + "\n" + "sample line 2.";

        Email draftEmail = new Draft(from, to, subject, time, content, false);

        assertEquals(draftEmail.getFrom(), from);
        assertEquals(draftEmail.getTo(), to);
        assertEquals(draftEmail.getSubject(), subject);
        assertEquals(draftEmail.getTime(), time);
        assertEquals(draftEmail.getContent(), content);
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

}