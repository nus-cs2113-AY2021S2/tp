package seedu.connoisseur.sorter;

import seedu.connoisseur.review.Review;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SortByCategoryTest {
    @Test
    public void sortByCategory_movieFood_true() {
        SortByCategory sort = new SortByCategory();
        Review a = new Review("Title", "Movie", 5, "Description", "Date");
        Review b = new Review("Title", "Food", 5, "Description", "Date");
        assertTrue(sort.compare(a,b) > 0, "Food should come before movie");
    }
}
