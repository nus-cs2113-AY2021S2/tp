package seedu.connoisseur.sorter;

import java.util.Comparator;

import seedu.connoisseur.review.Review;

public class SortByRating implements Comparator<Review> {
    public int compare(Review a, Review b) {
        return a.getRating() - b.getRating();
    }
}