package seedu.connoisseur.sorter;

import java.util.Comparator;

import seedu.connoisseur.review.Review;

/**
 * Sort reviews by title. 
 */
public class SortByTitle implements Comparator<Review> {
    /**
     * Comparator function for comparing review titles, returns in alphabetical order. 
     */
    public int compare(Review a, Review b) {
        return a.getTitle().compareTo(b.getTitle());
    }
}