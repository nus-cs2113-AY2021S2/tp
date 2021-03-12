package seedu.connoisseur.sorter;

import java.util.Comparator;

import seedu.connoisseur.review.Review;

public class SortByCategory implements Comparator<Review> {
    public int compare(Review a, Review b) {
        return a.getCategory().compareTo(b.getCategory());
    }
}