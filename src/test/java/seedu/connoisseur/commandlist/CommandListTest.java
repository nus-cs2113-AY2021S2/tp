package seedu.connoisseur.commandlist;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import seedu.connoisseur.ui.Ui;
import seedu.connoisseur.storage.Storage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandListTest {
    private Ui ui = new Ui(false);
    private Storage storage = new Storage(ui);
    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeAll
    public static void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterAll
    public static void cleanUpStreams() {
        System.setOut(System.out);
    }

    @Test
    public void sanityCheck() {
        System.out.print("hello");
        assertEquals("hello", outContent.toString());
    }

    @Test
    public void listReviews_noReviews_noReviewsFound() {
        new CommandList(ui, storage).listReviews("ANY_SORT_METHOD");
        assertEquals("No reviews found. :(\r\n", outContent.toString());
    }
}
