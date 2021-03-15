package seedu.connoisseur.sorter;

import java.util.Comparator;

import seedu.connoisseur.review.Review;

/**
 * Sort reviews by rating. 
 */
public class SortByRating implements Comparator<Review> {
    /**
     * Comparator function for comparing review ratings, returns higher rating first. 
     */
    public int compare(Review a, Review b) {
        return b.getRating() - a.getRating();
    }
}