package seedu.connoisseur.commandlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import seedu.connoisseur.review.Review;

import java.util.ArrayList;

public class CommandListTest {

    public ArrayList<Review> reviewList;

    @BeforeEach
    public void setUp() throws Exception {
        Review reviewa = new Review("superman", "category", 5, "description");
        Review reviewb = new Review("avengers", "category", 5, "description");
        reviewList.add(reviewa);
        reviewList.add(reviewb);
    }

    @Test
    public void deleteReview_reviewExists_removesNormally() throws Exception {
        int numberOfReviewsBeforeRemoval = reviewList.size();
        String title = "superman";
        reviewList.remove(title);

        assertFalse(reviewList.contains(title));

        int numberOfReviewsAfterRemoval = reviewList.size();
        assertEquals(numberOfReviewsBeforeRemoval - 1, numberOfReviewsAfterRemoval);

    }
}
