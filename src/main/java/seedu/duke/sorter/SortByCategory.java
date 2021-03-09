package seedu.duke.sorter;

import java.util.Comparator;

import seedu.duke.review.Review;

public class SortByCategory implements Comparator<Review> {
    public int compare(Review a, Review b) {
        return a.category.compareTo(b.category);
    }
}