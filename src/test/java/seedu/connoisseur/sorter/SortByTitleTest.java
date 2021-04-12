package seedu.connoisseur.sorter;

import seedu.connoisseur.review.Review;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SortByTitleTest {
    @Test
    public void sortByTitle_true() {
        SortByTitle sort = new SortByTitle();
        Review a = new Review("Abcde", "Category", 5, "Description", "Date");
        Review b = new Review("Zyxwv", "Category", 5, "Description", "Date");
        assertTrue(sort.compare(a,b) < 0, "A should come before z when sorting by title");
    }
}
