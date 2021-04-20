package seedu.duke.command;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.duke.email.Deleted;
import seedu.duke.email.Email;
import seedu.duke.email.EmailManager;
import seedu.duke.email.Inbox;
import seedu.duke.utilities.Storage;
import seedu.duke.utilities.Ui;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class FindCommandTest {
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
        emails.add(new Inbox("123@gmail.com", to, "S1", "2021-02-20T06:30:00", "C1", false));
        emails.add(new Inbox("123@gmail.com", to, "S2", "2021-02-20T07:30:00", "C2", false));
        emails.add(new Deleted("123@gmail.com", to, "S3", "2021-02-20T08:30:00", "C3", false));
        emailManager.setListedEmailsList(emails);

    }

    @Test
    void execute_foundKeyword_success() {
        new FindCommand("find c3").execute(emailManager, ui, storage);

        Assertions.assertEquals("1. [Deleted][UNREAD]\n"
                        + "|| Subject: S3\n"
                        + "|| From: 123@gmail.com --> To: [456@gmail.com]\n"
                        + "|| Time: 2021-02-20T08:30:00\n"
                        + "|| Tags: []",
                outputStreamCaptor.toString().trim());
    }

    @Test
    void execute_notFoundKeyword_message() {
        new FindCommand("find hello").execute(emailManager, ui, storage);

        Assert.assertEquals("No matching emails found.", outputStreamCaptor.toString()
                .trim());
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}
