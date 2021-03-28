package seedu.connoisseur.sorter;

import java.util.Collections;
import java.util.ArrayList;

import seedu.connoisseur.recommendation.Recommendation;
import seedu.connoisseur.review.Review;
import seedu.connoisseur.ui.Ui;

public class Sorter {

    public SortMethod sortMethod;
    private Ui ui;

    /**
     * Constructor for Sorter class.
     *
     * @param sortMethod specify default sort method
     */
    public Sorter(SortMethod sortMethod) {
        this.sortMethod = sortMethod;
    }

    /**
     * Get sort method as string.
     *
     * @return SortMethod as a String
     */
    public String getSortMethod() {
        String sortMethodString;
        switch (sortMethod) {
        case RATING:
            sortMethodString = "rating";
            break;
        case CATEGORY:
            sortMethodString = "category";
            break;
        case TITLE:
            sortMethodString = "title";
            break;
        case EARLIEST:
            sortMethodString = "earliest";
            break;
        case LATEST:
            sortMethodString = "latest";
            break;
        default:
            sortMethodString = "";
        }
        return sortMethodString;
    }

    /**
     * Change default sort method for this instance.
     *
     * @param sortMethod SortMethod to be saved
     */
    public void changeSortMethod(String sortMethod) {
        switch (sortMethod) {
        case "rating":
            this.sortMethod = SortMethod.RATING;
            break;
        case "category":
            this.sortMethod = SortMethod.CATEGORY;
            break;
        case "title":
            this.sortMethod = SortMethod.TITLE;
            break;
        case "earliest":
            this.sortMethod = SortMethod.EARLIEST;
            break;
        case "latest":
            this.sortMethod = SortMethod.LATEST;
            break;
        default:
            break;
        }
    }

    /**
     * Sorts the reviewList based on the saved sort method.
     *
     * @param reviewList reviewList to be sorted
     * @return sorted review list
     */
    public ArrayList<Review> sortReview(ArrayList<Review> reviewList) {
        switch (this.sortMethod) {
        case RATING:
            sortByRating(reviewList);
            break;
        case CATEGORY:
            sortByCategory(reviewList);
            break;
        case TITLE:
            sortByTitle(reviewList);
            break;
        case EARLIEST:
            sortByEarliest(reviewList);
            break;
        default:
            sortByLatest(reviewList);
            break;
        }
        return reviewList;
    }

    /**
     * Sorts the reviewList by the sort method specified.
     *
     * @param reviewList reviewList to be sorted
     * @param sortMethod method to sort
     * @return sorted review list
     */
    public ArrayList<Review> sortReview(ArrayList<Review> reviewList, String sortMethod) {
        switch (sortMethod) {
        case "rating":
            sortByRating(reviewList);
            break;
        case "category":
            sortByCategory(reviewList);
            break;
        case "title":
            sortByTitle(reviewList);
            break;
        case "earliest":
            sortByEarliest(reviewList);
            break;
        case "latest":
            sortByLatest(reviewList);
            break;
        default:
            break;
        }
        return reviewList;
    }

    private static ArrayList<Review> sortByRating(ArrayList<Review> reviewList) {
        Collections.sort(reviewList, new SortByRating());
        return reviewList;
    }

    private static ArrayList<Review> sortByCategory(ArrayList<Review> reviewList) {
        Collections.sort(reviewList, new SortByCategory());
        return reviewList;
    }

    private static ArrayList<Review> sortByTitle(ArrayList<Review> reviewList) {
        Collections.sort(reviewList, new SortByTitle());
        return reviewList;
    }

    private static ArrayList<Review> sortByEarliest(ArrayList<Review> reviewList) {
        Collections.sort(reviewList, new SortByEarliest());
        return reviewList;
    }

    private static ArrayList<Review> sortByLatest(ArrayList<Review> reviewList) {
        Collections.sort(reviewList, new SortByLatest());
        return reviewList;
    }
}
