package seedu.connoisseur.sorter;

import java.util.Comparator;

import seedu.connoisseur.review.Review;

public class SortByDateLatest implements Comparator<Review> {
    public int compare(Review a, Review b) {
        return b.getDate().compareTo(a.getDate());
    }
}