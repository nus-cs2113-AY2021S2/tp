package seedu.connoisseur.commandlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.Before;
import org.junit.After;
import seedu.connoisseur.review.Review;
import seedu.connoisseur.storage.Storage;
import seedu.connoisseur.ui.Ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class CommandListTest {

    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    Ui ui = new Ui();
    Storage storage = new Storage(ui);
    CommandList commandList = new CommandList(ui, storage);

    @BeforeEach
    public void setUp() {
        Review reviewa = new Review("superman", "category", 5, "description");
        Review reviewb = new Review("avengers", "category", 5, "description");
        commandList.reviewList.add(reviewa);
        commandList.reviewList.add(reviewb);
    }

    @Test
    public void deleteReview_reviewExists_removesNormally() {
        int numberOfReviewsBeforeRemoval = commandList.reviewList.size();
        String title = "superman";
        commandList.deleteReview(title);

        assertFalse(commandList.reviewList.contains(title));

        int numberOfReviewsAfterRemoval = commandList.reviewList.size();
        assertEquals(numberOfReviewsBeforeRemoval - 1, numberOfReviewsAfterRemoval);
    }


    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void listReview_noReviewsExist() {

        setUpStreams();
        System.out.print("You have no reviews, type 'new' to start!");
        assertEquals("You have no reviews, type 'new' to start!", outContent.toString());
        restoreStreams();

    }

    @Test
    void checkAndPrintDuplicate() {
        CommandList commandList = new CommandList(new ArrayList<String>(), new Ui(), new Storage(new Ui()));
        commandList.reviewList = new ArrayList<Review>();
        assertFalse(commandList.checkAndPrintDuplicate("Avengers"));
    }
}
