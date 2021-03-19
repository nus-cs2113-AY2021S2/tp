package seedu.connoisseur.sorter;

import seedu.connoisseur.review.Review;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SortByDateLatestTest {
    @Test
    public void sortByDateLatest_comparison_true() {
        SortByDateLatest sort = new SortByDateLatest();
        Review a = new Review("Title", "Category", 5, "Description", "Jan 30 2021 12:00 PM");
        Review b = new Review("Title", "Category", 5, "Description", "Jan 1 2021 12:00 PM");
        assertTrue(sort.compare(a,b) < 0, "Jan 30 should be before Jan 1");
    }

    @Test
    public void sortByDateLatest_invalidDate_returnZero() {
        SortByDateLatest sort = new SortByDateLatest();
        Review a = new Review("Title", "Category", 5, "Description", "Jan 30 WRONGFORMAT");
        Review b = new Review("Title", "Category", 5, "Description", "Jan 1 WRONGFORMAT");
        assertTrue(sort.compare(a,b) == 0, "Invalid date should not be compared");
    }
}
