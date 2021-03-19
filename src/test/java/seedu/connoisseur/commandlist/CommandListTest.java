package seedu.connoisseur.commandlist;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import seedu.connoisseur.ui.Ui;
import seedu.connoisseur.storage.Storage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandListTest {
    private Ui ui = new Ui(false);
    private Storage storage = new Storage(ui);
    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public static void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
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
        assertEquals("You have no reviews, type 'new' to start!\r\n", outContent.toString());
    }
}
