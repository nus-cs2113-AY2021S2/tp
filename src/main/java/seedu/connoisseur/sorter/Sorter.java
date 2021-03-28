package seedu.connoisseur.sorter;

import java.util.Collections;
import java.util.ArrayList;

import seedu.connoisseur.review.Review;

public class Sorter {

    public SortMethod sortMethod;

    /**
     * Constructor for Sorter class.
     *
     * @param sortMethod specify default sort method
     */
    public Sorter(SortMethod sortMethod) {
        this.sortMethod = sortMethod;
    }

    /**
     * Converts a string to sort method. 
     * @param sortMethod sort method as a string
     * @return sort method
     */
    public static SortMethod stringToSortMethod(String sortMethod) {
        switch (sortMethod) {
        case "rating":
            return SortMethod.RATING;
        case "category":
            return SortMethod.CATEGORY;
        case "title":
            return SortMethod.TITLE;
        case "earliest":
            return SortMethod.EARLIEST;
        case "latest":
            return SortMethod.LATEST;
        default:
            return null;
        }
    }

    /**
     * Converts sort method to a readable string. 
     * @param sortMethod sort method
     * @return sort method as a string
     */
    public static String sortMethodToString(SortMethod sortMethod) {
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
     * Get sort method as string.
     *
     * @return SortMethod as a String
     */
    public String getSortMethod() {
        return sortMethodToString(sortMethod);
    }

    /**
     * Change default sort method for this instance.
     *
     * @param sortMethod SortMethod to be saved
     */
    public void changeSortMethod(String sortMethod) {
        this.sortMethod = stringToSortMethod(sortMethod);
    }

    /**
     * Sorts the reviewList based on the saved sort method.
     *
     * @param reviewList reviewList to be sorted
     * @return sorted review list
     */
    public ArrayList<Review> sortReview(ArrayList<Review> reviewList) {
        reviewList = sortReview(reviewList, sortMethodToString(this.sortMethod));
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
