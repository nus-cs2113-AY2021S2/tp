package seedu.connoisseur.commandlist;

import seedu.connoisseur.review.Review;
import seedu.connoisseur.storage.Storage;
import seedu.connoisseur.ui.Ui;
import seedu.connoisseur.sorter.SortMethod;
import seedu.connoisseur.sorter.Sorter;

import java.util.ArrayList;

/**
 * Class with methods for different commands.
 */
public class CommandList {
    static final int LIST_CATEGORY_INPUT_LENGTH = 4;
    static final int MAX_WHITE_SPACE = 20;

    public static ArrayList<Review> reviewList = new ArrayList<>();
    private Sorter sorter;

    /**
     * Creates tasks according to user data from files.
     *
     * @param dataReviews List of tasks from user connoisseur.txt file.
     */
    public CommandList(ArrayList<String> dataReviews) {
        for (String review : dataReviews) {
            reviewList.add(Review.textToReview(review));
        }
    }

    /**
     * Creates new tasks if no existing data in files.
     */

    public CommandList() {
        reviewList = new ArrayList<>();
        sorter = new Sorter(SortMethod.DATE_EARLIEST);
    }

    /**
     * List reviews according to different types of input.
     *
     * @param input is the listing method preferred by user. If there is no
     *              preferred listing method, default listing will be used.
     */
    public void listReviews(String input) {
        if (reviewList.size() == 0) {
            System.out.println("No reviews found. :(");
        } else {
            if (input.length() <= 0) {
                System.out.println("Catch some exception"); //remember to change this part jjbafdbal!!!
            }

            String listType = input.substring(LIST_CATEGORY_INPUT_LENGTH);
            Sorter.sort(reviewList, listType);
            System.out.println("Here are your reviews:");
            int whiteSpaceNeeded = MAX_WHITE_SPACE - 5;
            System.out.print("Title");
            while (whiteSpaceNeeded > 0) {
                System.out.print(" ");
                whiteSpaceNeeded--;
            }
            whiteSpaceNeeded = MAX_WHITE_SPACE - 6;
            System.out.print("Rating");
            while (whiteSpaceNeeded > 0) {
                System.out.print(" ");
                whiteSpaceNeeded--;
            }

            for (int i = 0; i < reviewList.size(); i++) {
                Review currentReview = reviewList.get(i);
                System.out.print((i + 1) + ". ");
                System.out.print(currentReview.getTitle());
                whiteSpaceNeeded = MAX_WHITE_SPACE - (currentReview.getTitle().length());
                while (whiteSpaceNeeded > 0) {
                    System.out.print(" ");
                    whiteSpaceNeeded--;
                }
                for (int j = 0; j < 5; j++) {
                    int numberOfShadedBoxes = currentReview.getRating();
                    if (numberOfShadedBoxes > 0) {
                        System.out.print("\u2588");
                        numberOfShadedBoxes--;
                    } else {
                        System.out.print("\u25A2");
                    }
                }
                System.out.print("    ");
                System.out.println(currentReview.getDate());
            }
        }
    }

    /**
     * Print text to help user with using the application.
     */
    public static void printHelp() {
        Ui.printHelpMessage();
    }

    /**
     * Delete review.
     */
    public void deleteReview(String title) {
        int reviewIndex = Review.getReviewIndex(title);
        if (reviewIndex == -1) {
            System.out.println("Review does not exists!");
        } else {
            reviewList.remove(reviewIndex);
            System.out.println(title + " deleted.");
        }
        Storage.saveData(reviewList);
    }

    /**
     * Sort a review based on input sort type. 
     * @param sortType sorting method to be used
     */
    public void sortReview(String sortType) {
        if (sortType.equals("stars") || sortType.equals("title") || sortType.equals("date_earliest")
                || sortType.equals("date_latest")) {
            sorter.changeSortMethod(sortType);
            System.out.print("Success! Your preferred sorting method has been saved: ");
            System.out.println(sortType.toUpperCase());
        } else {
            System.out.println(sortType + " is not valid sorting method, please try again.");
        }
        Storage.saveData(reviewList);
    }

    /**
     * Add a review. 
     * @param input review fields split by spaces
     */
    public void addReview(String input) {
        try {
            String[] review = input.split(" ", 4);
            Review r = new Review(review[0], review[1], Integer.parseInt(review[2]), review[3]);
            reviewList.add(r);
            System.out.println(review[0] + " created.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid input review, please try again.");
        }
        Storage.saveData(reviewList);

    }

    /**
     * Prints exit message. 
     */
    public static void exit() {
        Ui.printExitMessage();
    }

}