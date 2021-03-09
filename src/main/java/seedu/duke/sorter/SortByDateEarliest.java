package seedu.duke.sorter;

import java.util.Comparator;

import seedu.duke.review.Review;

public class SortByDateEarliest implements Comparator<Review> {
    public int compare(Review a, Review b) {
        return a.date.compareTo(b.date);
    }
}