package seedu.connoisseur.commands;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.Before;
import org.junit.After;

import seedu.connoisseur.commands.Commands;
import seedu.connoisseur.commands.ReviewList;
import seedu.connoisseur.review.Review;
import seedu.connoisseur.storage.Storage;
import seedu.connoisseur.ui.Ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class CommandsTest {

    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    Ui ui = new Ui();
    Storage storage = new Storage(ui);
    Commands commands = new Commands(ui, storage);
    ReviewList reviewList = new ReviewList(ui);

    @BeforeEach
    public void setUp() {
        Review reviewa = new Review("superman", "category", 5, "description");
        Review reviewb = new Review("avengers", "category", 5, "description");
        reviewList.reviews.add(reviewa);
        reviewList.reviews.add(reviewb);
    }

    @Test
    public void deleteReview_reviewExists_removesNormally() {
        final int numberOfReviewsBeforeRemoval = reviewList.reviews.size();
        String title = "superman";
        reviewList.deleteReview(title);
        Boolean contains = false;
        for (int i = 0; i < reviewList.reviews.size(); i++) {
            if (reviewList.reviews.get(i).getTitle().equals(title)) {
                contains = true;
            }
        }
        assertFalse(contains);

        int numberOfReviewsAfterRemoval = reviewList.reviews.size();
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
        reviewList.reviews = new ArrayList<Review>();
        assertFalse(reviewList.checkAndPrintDuplicateReview("Avengers"));
    }
}
