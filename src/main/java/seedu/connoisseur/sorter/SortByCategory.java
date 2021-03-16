package seedu.connoisseur.sorter;

import java.util.Comparator;

import seedu.connoisseur.review.Review;

/**
 * Sort reviews by category. 
 */
public class SortByCategory implements Comparator<Review> {
    /**
     * Compare reviews by category. Returns in alphabetical order. 
     */
    public int compare(Review a, Review b) {
        return a.getCategory().compareTo(b.getCategory());
    }
}