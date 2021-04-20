package seedu.duke.command;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.duke.email.EmailManager;
import seedu.duke.utilities.Storage;
import seedu.duke.utilities.Ui;
import seedu.duke.email.Archive;
import seedu.duke.email.Deleted;
import seedu.duke.email.Draft;
import seedu.duke.email.Email;
import seedu.duke.email.Inbox;
import seedu.duke.email.Junk;
import seedu.duke.email.Sent;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class ListCommandTest {
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
        emails.add(new Archive("123@gmail.com", to, "S1", "2012-01-01", "C1", false));
        emails.add(new Deleted("123@gmail.com", to, "S2", "2012-01-02", "C2", false));
        emails.add(new Email("123@gmail.com", to, "S0", "2012-01-02", "C2", false));
        emails.add(new Draft("123@gmail.com", to, "S3", "2012-01-02", "C2", false));
        emails.add(new Inbox("123@gmail.com", to, "S4", "2012-01-02", "C2", false));
        emails.add(new Junk("123@gmail.com", to, "S5", "2012-01-02", "C2", false));
        emails.add(new Sent("123@gmail.com", to, "S6", "2012-01-02", "C2", false));
        emailManager = new EmailManager(emails);

    }

    @Test
    void execute_valid_list_Archive_success() {
        new ListCommand("list archive").execute(emailManager, ui, storage);

        Assertions.assertEquals("1. [Archive][UNREAD]\n"
                        + "|| Subject: S1\n"
                        + "|| From: 123@gmail.com --> To: [456@gmail.com]\n"
                        + "|| Time: 2012-01-01\n"
                        + "|| Tags: []",
                outputStreamCaptor.toString().trim());
    }

    @Test
    void execute_valid_list_Deleted_success() {
        new ListCommand("list deleted").execute(emailManager, ui, storage);

        Assertions.assertEquals("1. [Deleted][UNREAD]\n"
                        + "|| Subject: S2\n"
                        + "|| From: 123@gmail.com --> To: [456@gmail.com]\n"
                        + "|| Time: 2012-01-02\n"
                        + "|| Tags: []",
                outputStreamCaptor.toString().trim());
    }

    @Test
    void execute_valid_list_Draft_success() {
        new ListCommand("list draft").execute(emailManager, ui, storage);

        Assertions.assertEquals("1. [Draft][UNREAD]\n"
                        + "|| Subject: S3\n"
                        + "|| From: 123@gmail.com --> To: [456@gmail.com]\n"
                        + "|| Time: 2012-01-02\n"
                        + "|| Tags: []",
                outputStreamCaptor.toString().trim());
    }

    @Test
    void execute_valid_list_Inbox_success() {
        new ListCommand("list inbox").execute(emailManager, ui, storage);

        Assertions.assertEquals("1. [Inbox][UNREAD]\n"
                        + "|| Subject: S4\n"
                        + "|| From: 123@gmail.com --> To: [456@gmail.com]\n"
                        + "|| Time: 2012-01-02\n"
                        + "|| Tags: []",
                outputStreamCaptor.toString().trim());
    }

    @Test
    void execute_valid_list_Junk_success() {
        new ListCommand("list junk").execute(emailManager, ui, storage);

        Assertions.assertEquals("1. [Junk][UNREAD]\n"
                        + "|| Subject: S5\n"
                        + "|| From: 123@gmail.com --> To: [456@gmail.com]\n"
                        + "|| Time: 2012-01-02\n"
                        + "|| Tags: []",
                outputStreamCaptor.toString().trim());
    }

    @Test
    void execute_valid_list_Sent_success() {
        new ListCommand("list sent").execute(emailManager, ui, storage);

        Assertions.assertEquals("1. [Sent][UNREAD]\n"
                        + "|| Subject: S6\n"
                        + "|| From: 123@gmail.com --> To: [456@gmail.com]\n"
                        + "|| Time: 2012-01-02\n"
                        + "|| Tags: []",
                outputStreamCaptor.toString().trim());
    }

    @Test
    void execute_invalid_list_message() {
        new ListCommand("list -1").execute(emailManager, ui, storage);

        Assert.assertEquals("OOPS!!! The Email type that you enter is invalid."
                        + System.lineSeparator()
                        + "It must be one of: [allemails, inbox, archive, deleted, draft, junk, sent]",
                outputStreamCaptor.toString()
                        .trim());
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}
