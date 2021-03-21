package seedu.connoisseur.commandlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.connoisseur.review.Review;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class CommandListTest {

    public ArrayList<Review> reviewList;

    @BeforeEach
    public void setUp() throws Exception {
        Review review = new Review("superman", "category", 5, "description");
        reviewList.add(review);
    }

    @Test
    public void deleteReview_reviewExists_removesNormally() throws Exception {
        int numberOfReviewsBeforeRemoval = reviewList.size();
        String Title = "superman";
        reviewList.remove(Title);

        assertFalse(reviewList.contains(Title));

        int numberOfReviewsAfterRemoval = reviewList.size();
        assertEquals(numberOfReviewsBeforeRemoval - 1, numberOfReviewsAfterRemoval);

    }
}
