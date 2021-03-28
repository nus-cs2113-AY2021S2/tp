package seedu.connoisseur.sorter;

import seedu.connoisseur.review.Review;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SortByEarliestTest {
    @Test
    public void sortByEarliest_true() {
        SortByEarliest sort = new SortByEarliest();
        Review a = new Review("Title", "Category", 5, "Description", "Jan 30 2021 12:00 PM");
        Review b = new Review("Title", "Category", 5, "Description", "Jan 1 2021 12:00 PM");
        assertTrue(sort.compare(a,b) > 0, "Jan 1 should be before Jan 30");
    }

    @Test
    public void sortByEarliest_invalidDate_returnZero() {
        SortByEarliest sort = new SortByEarliest();
        Review a = new Review("Title", "Category", 5, "Description", "Jan 30 WRONGFORMAT");
        Review b = new Review("Title", "Category", 5, "Description", "Jan 1 WRONGFORMAT");
        assertTrue(sort.compare(a,b) == 0, "Invalid date should not be compared");
    }
}
