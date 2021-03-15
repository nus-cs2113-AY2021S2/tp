package seedu.connoisseur.sorter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

import seedu.connoisseur.review.Review;

public class SortByDateEarliest implements Comparator<Review> {
    public int compare(Review a, Review b) {
        try {
            Date dateA = new SimpleDateFormat("MMM d yyyy").parse(a.getDate());
            Date dateB = new SimpleDateFormat("MMM d yyyy").parse(b.getDate());
            return dateA.compareTo(dateB);
        } catch (ParseException e) {
            System.out.println("Wrong date format");
            return 0;
        }
    }
}