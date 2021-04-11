package seedu.connoisseur.commands;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import seedu.connoisseur.review.Review;
import seedu.connoisseur.ui.Ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.io.PrintStream;
import java.io.ByteArrayOutputStream;

public class CommandsTest {

    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    Ui ui = new Ui();
    ReviewList reviewList = new ReviewList(ui);

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outContent));
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

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

}
