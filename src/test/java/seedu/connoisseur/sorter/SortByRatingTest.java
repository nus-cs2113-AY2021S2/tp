package seedu.connoisseur.sorter;

import seedu.connoisseur.review.Review;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SortByRatingTest {
    @Test
    public void sortByRating_lowHigh_true() {
        SortByRating sort = new SortByRating();
        Review a = new Review("Title", "Category", 1, "Description", "Date");
        Review b = new Review("Title", "Category", 5, "Description", "Date");
        assertTrue(sort.compare(a,b) > 0, "5 should be higher than 1 when sorting by ratings");
    }
}
