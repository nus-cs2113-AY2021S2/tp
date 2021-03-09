package seedu.duke.sorter;

import java.util.Comparator;

import seedu.duke.review.Review;

public class SortByDateLatest implements Comparator<Review> {
    public int compare(Review a, Review b) {
        return b.date.compareTo(a.date);
    }
}