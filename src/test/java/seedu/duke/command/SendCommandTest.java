package seedu.duke.command;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.duke.email.Draft;
import seedu.duke.email.Email;
import seedu.duke.email.EmailManager;
import seedu.duke.email.Sent;
import seedu.duke.utilities.Storage;
import seedu.duke.utilities.Ui;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SendCommandTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private ArrayList<Email> emails = new ArrayList<>();
    private EmailManager emailManager = new EmailManager();
    private Ui ui = new Ui();
    private Storage storage = new Storage();
    private ArrayList<String> to = new ArrayList<>();
    private Email email1;
    private Email email2;
    private Email email3;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
        to.add("12312@gmail.com");
        emails.add(email1 = new Draft("testC@gmail.com", to, "S1", "2020-4-23+01:00", "C1", false));
        emails.add(email2 = new Draft("testA@gmail.com", to, "S2", "2020-4-30+01:00", "C2", false));
        emails.add(email3 = new Sent("testB@gmail.com", to, "S3", "2019-4-23+03:00", "C3", false));
        emailManager.setEmailsList(emails);
        emailManager.setListedType("draft");
    }

    @Test
    void execute_sendRecipient_success() {
        new SendCommand("send 1").execute(emailManager, ui, storage);
        String time = emailManager.getSentEmails().get(1).getTime();
        Email sentEmail1 = new Sent("testC@gmail.com", to, "S1", time, "C1", false);
        ArrayList<Email> sentEmails = new ArrayList<>(Arrays.asList(email3, sentEmail1));
        Assertions.assertEquals(emailManager.getSentEmails().toString(), sentEmails.toString());
    }

    @Test
    void execute_sendRecipients_success() {
        new SendCommand("send 1 2").execute(emailManager, ui, storage);
        String time1 = emailManager.getSentEmails().get(1).getTime();
        String time2 = emailManager.getSentEmails().get(2).getTime();
        Email sentEmail1 = new Sent("testC@gmail.com", to, "S1", time1, "C1", false);
        Email sentEmail2 = new Sent("testA@gmail.com", to, "S2", time2, "C2", false);
        ArrayList<Email> sentEmails = new ArrayList<Email>(Arrays.asList(email3, sentEmail1, sentEmail2));
        Assertions.assertEquals(emailManager.getSentEmails().toString(), sentEmails.toString());
    }

    @Test
    void execute_InvalidIndex_fail() {
        new SendCommand("send -1").execute(emailManager, ui, storage);
        String expectedOutput = "OOPS!!! The Email ID that you SENT is invalid.";
        Assertions.assertEquals(expectedOutput, outputStreamCaptor.toString()
                .trim());
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}