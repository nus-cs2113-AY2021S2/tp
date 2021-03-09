package seedu.duke.sorter;

import java.util.Collections;
import java.util.ArrayList;

import seedu.duke.review.Review;

public class Sorter {
    enum SortMethod {
        STARS,
        CATEGORY,
        TITLE,
        DATE_LATEST,
        DATE_EARLIEST
    }

    private SortMethod sortMethod;

    /**
     * Constructor for Sorter class.
     * @param sortMethod specify default sort method
     */
    public Sorter(SortMethod sortMethod) {
        this.sortMethod = sortMethod;
    }

    /**
     * Change default sort method for this instance. 
     * @param sortMethod SortMethod to be saved
     */
    public void changeSortMethod(SortMethod sortMethod) {
        this.sortMethod = sortMethod;
    }

    /**
     * Sorts the reviewList based on the saved sort method. 
     * @param reviewList reviewList to be sorted
     * @return sorted review list
     */
    public ArrayList<Review> sort(ArrayList<Review> reviewList) {
        switch (this.sortMethod) {
        case STARS:
            sortByStars(reviewList);
            break;
        case CATEGORY:
            sortByCategory(reviewList);
            break;
        case TITLE:
            sortByTitle(reviewList);
            break;
        case DATE_EARLIEST:
            sortByDateEarliest(reviewList);
            break;
        default:
            sortByDateLatest(reviewList);
            break;
        }
        return reviewList;
    }

    /**
     * Sorts the reviewList by the sort method specified. 
     * @param reviewList reviewList to be sorted
     * @param sortMethod method to sort
     * @return sorted review list
     */
    public ArrayList<Review> sort(ArrayList<Review> reviewList, SortMethod sortMethod) {
        switch (sortMethod) {
        case STARS:
            sortByStars(reviewList);
            break;
        case CATEGORY:
            sortByCategory(reviewList);
            break;
        case TITLE:
            sortByTitle(reviewList);
            break;
        case DATE_EARLIEST:
            sortByDateEarliest(reviewList);
            break;
        default:
            sortByDateLatest(reviewList);
            break;
        }
        return reviewList;
    }

    private ArrayList<Review> sortByStars(ArrayList<Review> reviewList) {
        Collections.sort(reviewList, new SortByStars());
        return reviewList;
    }

    private ArrayList<Review> sortByCategory(ArrayList<Review> reviewList) {
        Collections.sort(reviewList, new SortByCategory());
        return reviewList;
    }

    private ArrayList<Review> sortByTitle(ArrayList<Review> reviewList) {
        Collections.sort(reviewList, new SortByTitle());
        return reviewList;
    }

    private ArrayList<Review> sortByDateEarliest(ArrayList<Review> reviewList) {
        Collections.sort(reviewList, new SortByDateEarliest());
        return reviewList;
    }

    private ArrayList<Review> sortByDateLatest(ArrayList<Review> reviewList) {
        Collections.sort(reviewList, new SortByDateLatest());
        return reviewList;
    }
}
