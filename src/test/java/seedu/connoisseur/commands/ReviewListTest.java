//@@author {jhjhjajh}

package seedu.connoisseur.commands;

import org.junit.jupiter.api.Test;

import seedu.connoisseur.review.Review;
import seedu.connoisseur.ui.Ui;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReviewListTest {

    Ui ui = new Ui();
    ReviewList reviewList = new ReviewList(ui);

    @Test
    public void listReview_noReviewsExist() {
        int reviewSize = 0;
        assertEquals(reviewSize, reviewList.reviews.size());
    }

    @Test
    public void listReview_ReviewsExist() {
        Review reviewa = new Review("superman", "category", 5, "description");
        Review reviewb = new Review("avengers", "category", 5, "description");
        reviewList.reviews.add(reviewa);
        reviewList.reviews.add(reviewb);
        int reviewSize = 2;
        assertEquals(reviewSize, reviewList.reviews.size());
    }

    @Test
    public void changeDisplayTest_asterisks() {
        reviewList.changeDisplay("asterisks");
        assertFalse(reviewList.getDisplayStars());
    }

    @Test
    public void changeDisplayTest_stars() {
        reviewList.changeDisplay("stars");
        assertTrue(reviewList.getDisplayStars());
    }

    @Test
    public void viewReview_invalidTitle() {
        assertEquals(-1, reviewList.viewReview(null));
        assertEquals(-1, reviewList.viewReview(""));
    }

    @Test
    public void viewReview_validTitle() {
        Review reviewa = new Review("superman", "category", 5, "description");
        Review reviewb = new Review("avengers", "category", 5, "description");
        reviewList.reviews.add(reviewa);
        reviewList.reviews.add(reviewb);
        assertEquals(0, reviewList.viewReview("superman"));
    }

    @Test
    void checkAndPrintDuplicate() {
        reviewList.reviews = new ArrayList<Review>();
        assertFalse(reviewList.checkAndPrintDuplicateReview("Avengers"));
        Review reviewa = new Review("superman", "category", 5, "description");
        reviewList.reviews.add(reviewa);
        assertTrue(reviewList.checkAndPrintDuplicateReview("sUperMan"));
    }

}
