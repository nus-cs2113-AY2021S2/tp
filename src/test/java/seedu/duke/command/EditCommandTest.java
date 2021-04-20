package seedu.duke.command;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.duke.email.Draft;
import seedu.duke.email.Email;
import seedu.duke.email.EmailManager;
import seedu.duke.utilities.Storage;
import seedu.duke.utilities.Ui;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;

public class EditCommandTest {
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
        ArrayList<String> to = new ArrayList<>();
        to.add("456@gmail.com");
        emails.add(new Draft("testC@gmail.com", to, "S1", "2020-4-23+01:00", "C1", false));
        emails.add(new Draft("testA@gmail.com", to, "S2", "2020-4-30+01:00", "C2", false));
        emails.add(new Draft("testB@gmail.com", to, "S3", "2019-4-23+03:00", "C3", false));
        emailManager.setEmailsList(emails);
        emailManager.setListedType("draft");
    }

    @Test
    void execute_InvalidIndex_fail() {
        new EditCommand("edit -1").execute(emailManager, ui, storage);
        String expectedOutput = "OOPS!!! The Email ID that you EDIT is invalid.";
        Assertions.assertEquals(expectedOutput, outputStreamCaptor.toString()
                .trim());
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}
