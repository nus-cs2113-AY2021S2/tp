package seedu.connoisseur.commandlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import seedu.connoisseur.review.Review;
import seedu.connoisseur.storage.Storage;
import seedu.connoisseur.ui.Ui;

import java.util.ArrayList;

import java.io.PrintStream;
import java.io.ByteArrayOutputStream;

public class CommandListTest {

    public ArrayList<Review> reviewList = new ArrayList<Review>();
    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    Ui ui = new Ui();
    Storage storage = new Storage(ui);
    CommandList commandList = new CommandList(ui, storage);

    @BeforeEach
    public void setUp() {
        Review reviewa = new Review("superman", "category", 5, "description");
        Review reviewb = new Review("avengers", "category", 5, "description");
        reviewList.add(reviewa);
        reviewList.add(reviewb);
    }

    @Test
    public void deleteReview_reviewExists_removesNormally() {
        int numberOfReviewsBeforeRemoval = reviewList.size();
        String title = "superman";
        commandList.deleteReview(title);

        assertFalse(reviewList.contains(title));

        int numberOfReviewsAfterRemoval = reviewList.size();
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
}
