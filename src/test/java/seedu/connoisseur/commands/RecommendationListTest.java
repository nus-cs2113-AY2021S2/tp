//@@author {jhjhjajh}

package seedu.connoisseur.commands;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.connoisseur.recommendation.Recommendation;
import seedu.connoisseur.review.Review;
import seedu.connoisseur.ui.Ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RecommendationListTest {

    Ui ui = new Ui();
    ReviewList reviewList = new ReviewList(ui);
    RecommendationList recommendationList = new RecommendationList(ui, reviewList);

    @BeforeEach
    public void setUp() {
        Review reviewa = new Review("superman", "category", 5, "description");
        Review reviewb = new Review("avengers", "category", 5, "description");
        reviewList.reviews.add(reviewa);
        reviewList.reviews.add(reviewb);
    }

    @Test
    public void listRecommendations_noRecommendationsExist() {
        int recommendationSize = 0;
        assertEquals(recommendationSize, recommendationList.recommendations.size());
    }

    @Test
    public void checkAndPrintDuplicate() {
        assertFalse(recommendationList.checkAndPrintDuplicateRecommendation("Avengers"));
        Recommendation recommendationA = new Recommendation("superman", "category", "5", "10", "Friend", "NA");
        recommendationList.recommendations.add(recommendationA);
        assertTrue(recommendationList.checkAndPrintDuplicateRecommendation("sUperMan"));
    }

    @Test
    public void checkPriceValidity_valid() {
        assertTrue(recommendationList.checkPriceValidity(20));
    }

    @Test
    public void checkPriceValidity_invalid() {
        assertFalse(recommendationList.checkPriceValidity(-100));
    }

    @Test
    public void deleteReview_recommendationExists_removesNormally() {
        Recommendation recommendationA = new Recommendation("superman", "category", "5", "10", "Friend", "NA");
        recommendationList.recommendations.add(recommendationA);
        final int numberOfRecommendationsBeforeRemoval = recommendationList.recommendations.size();
        String title = "superman";
        recommendationList.deleteRecommendation(title);
        Boolean contains = false;
        for (int i = 0; i < recommendationList.recommendations.size(); i++) {
            if (recommendationList.recommendations.get(i).getTitle().equals(title)) {
                contains = true;
            }
        }
        assertFalse(contains);

        int numberOfRecommendationsAfterRemoval = recommendationList.recommendations.size();
        assertEquals(numberOfRecommendationsBeforeRemoval - 1, numberOfRecommendationsAfterRemoval);
    }
}