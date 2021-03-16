package seedu.connoisseur.commandlist;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.connoisseur.ui.Ui;
import seedu.connoisseur.storage.Storage;

public class CommandListTest {
    private Ui ui = new Ui(true);
    private Storage storage = new Storage(ui);
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    public void listReviews_noReviews_noReviewsFound() {
        new CommandList(ui, storage).listReviews("ANY_SORT_METHOD");
        assertEquals("No reviews found. :(", outContent.toString());
    }
}
