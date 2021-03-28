package seedu.connoisseur.commandlist;

import seedu.connoisseur.exceptions.DuplicateException;
import seedu.connoisseur.parser.Parser;
import seedu.connoisseur.recommendation.Recommendation;
import seedu.connoisseur.review.Review;
import seedu.connoisseur.storage.Storage;
import seedu.connoisseur.ui.Ui;
import seedu.connoisseur.sorter.SortMethod;
import seedu.connoisseur.sorter.Sorter;

import java.util.ArrayList;

import static seedu.connoisseur.messages.Messages.INVALID_VIEW_TITLE;
import static seedu.connoisseur.messages.Messages.MISSING_VIEW_TITLE;
import static seedu.connoisseur.messages.Messages.INVALID_COMMAND;
import static seedu.connoisseur.messages.Messages.INVALID_DELETE_TITLE;
import static seedu.connoisseur.messages.Messages.INVALID_SORT_METHOD;
import static seedu.connoisseur.messages.Messages.CURRENT_SORT_METHOD;
import static seedu.connoisseur.messages.Messages.SORT_METHOD_PROMPT;
import static seedu.connoisseur.messages.Messages.SORT_METHOD_SUCCESS;
import static seedu.connoisseur.messages.Messages.QUICK_PROMPT;
import static seedu.connoisseur.messages.Messages.TITLE_PROMPT;
import static seedu.connoisseur.messages.Messages.CATEGORY_PROMPT;
import static seedu.connoisseur.messages.Messages.DELETE_SUCCESS;
import static seedu.connoisseur.messages.Messages.RATING_PROMPT;
import static seedu.connoisseur.messages.Messages.PRICE_PROMPT;
import static seedu.connoisseur.messages.Messages.ADD_SUCCESS;
import static seedu.connoisseur.messages.Messages.DESCRIPTION_PROMPT;
import static seedu.connoisseur.messages.Messages.RECOBY_PROMPT;
import static seedu.connoisseur.messages.Messages.MISSING_DELETE_TITLE;
import static seedu.connoisseur.messages.Messages.MISSING_EDIT_TITLE;
import static seedu.connoisseur.messages.Messages.MISSING_RECO_TITLE;


/**
 * Class with methods for different commands.
 */
public class CommandList {

    public ArrayList<Review> reviewList = new ArrayList<>();
    public ArrayList<Recommendation> recommendationList = new ArrayList<>();
    private final Sorter sorter;
    private final Ui ui;
    private final Storage storage;

    /**
     * Creates tasks according to user data from files.
     *
     * @param dataReviews List of tasks from user connoisseur.txt file.
     */
    public CommandList(ArrayList<String> dataReviews, ArrayList<String> dataRecommendations, Ui ui, Storage storage) {
        this.ui = ui;
        this.storage = storage;
        sorter = new Sorter(SortMethod.LATEST);
        if (!dataReviews.isEmpty()) {
            for (String review : dataReviews) {
                if (review.length() != 0) {
                    if (review.startsWith("SortMethod: ")) {
                        sorter.changeSortMethod(review.split(" ", 2)[1]);
                    } else {
                        reviewList.add(Review.textToReview(review));
                    }
                }
            }
        }

        if (!dataRecommendations.isEmpty()) {
            for (String recommendation : dataRecommendations) {
                if (recommendation.length() != 0) {
                    recommendationList.add(Recommendation.textToRecommendation(recommendation));
                }
            }
        }
    }

    /**
     * Creates new tasks if no existing data in files.
     */
    public CommandList(Ui ui, Storage storage) {
        this.ui = ui;
        this.storage = storage;
        sorter = new Sorter(SortMethod.LATEST);
    }

    /**
     * List reviews according to different types of input.
     *
     * @param input is either to show recommendations list
     *              or the listing method preferred by user. If there is no
     *              preferred listing method, default listing will be used.
     */
    public void listReviews(String input) {
        if (reviewList.size() == 0) {
            ui.printEmptyReviewListMessage();
        } else if (!validSortMethod(input)) {
            ui.printInvalidSortMethodMessage();
        } else {
            if (input == null) {
                sorter.sortReview(reviewList);
                printReviews(reviewList);
            } else {
                try {
                    sorter.sortReview(reviewList, input);
                    printReviews(reviewList);
                } catch (ArrayIndexOutOfBoundsException e) {
                    ui.printInvalidSortMethodMessage();
                }
            }
        }
    }

    private boolean validSortMethod(String sortMethod) {
        ArrayList<String> validSortMethods = new ArrayList<String>();
        validSortMethods.add("rating");
        validSortMethods.add("category");
        validSortMethods.add("title");
        validSortMethods.add("earliest");
        validSortMethods.add("latest");
        validSortMethods.add(null);
        return validSortMethods.contains(sortMethod);
    }

    /**
     * Prints the sorted reviews.
     */
    public void printReviews(ArrayList<Review> reviewList) {
        ui.printReviewListHeading();
        for (int i = 0; i < reviewList.size(); i++) {
            Review currentReview = reviewList.get(i);
            ui.print((i + 1) + ". ");
            if (i < 9) {
                ui.print(" ");
            }
            ui.print(currentReview.getTitle());
            ui.printWhiteSpace(currentReview.getTitle().length());
            ui.print(currentReview.getCategory());
            ui.printWhiteSpace(currentReview.getCategory().length());
            ui.print(currentReview.starRating());
            ui.printWhiteSpace(currentReview.starRating().length());
            ui.println(currentReview.getDateTime());
        }
    }

    /**
     * Sort a review based on input sort type.
     *
     * @param sortType sorting method to be used
     */
    public void sortReview(String sortType) {
        if (sortType == null || sortType.isBlank()) {
            String sortMethod = sorter.getSortMethod();
            ui.println(CURRENT_SORT_METHOD + sortMethod.toUpperCase());
            ui.println(SORT_METHOD_PROMPT);
            return;
        }
        if (sortType.equals("title") || sortType.equals("earliest")
                || sortType.equals("latest") || sortType.equals("rating") || sortType.equals("category")) {
            sorter.changeSortMethod(sortType);
            ui.println(SORT_METHOD_SUCCESS + sortType.toUpperCase());
        } else {
            ui.println(sortType + INVALID_SORT_METHOD);
        }
    }

    /**
     * Add a review.
     *
     * @param input quick or long review
     */
    public void addReview(String input) {
        if (input == null || input.isBlank()) {
            ui.println(QUICK_PROMPT);
            switch (ui.readCommand().toLowerCase()) {
            case "y":
                try {
                    addQuickReview();
                } catch (DuplicateException de) {
                    System.out.println("Please try again with a unique title instead!");
                }
                break;
            case "n":
                try {
                    addLongReview();
                } catch (DuplicateException de) {
                    System.out.println("Please try again with a unique title instead!");
                }
                break;
            default:
                ui.println(INVALID_COMMAND);
            }
        } else {
            switch (input) {
            case "quick":
                try {
                    addQuickReview();
                } catch (DuplicateException de) {
                    System.out.println("Please try again with a unique title instead!");
                }
                break;
            case "long":
                try {
                    addLongReview();
                } catch (DuplicateException de) {
                    System.out.println("Please try again with a unique title instead!");
                }
                break;
            default:
                ui.println(INVALID_COMMAND);
            }
        }
    }

    /**
     * Add a quick review.
     */
    public void addQuickReview() throws DuplicateException {
        boolean isDuplicate;
        String description = "No description entered. ";
        ui.println(TITLE_PROMPT);
        String title = ui.readCommand();
        isDuplicate = checkAndPrintDuplicate(title);
        if (isDuplicate) {
            throw new DuplicateException();
        }
        ui.println(CATEGORY_PROMPT);
        String category = ui.readCommand().toLowerCase();
        ui.println(RATING_PROMPT);
        try {
            int rating = Integer.parseInt(ui.readCommand());
            if (rating < 0 || rating > 5) {
                ui.printInvalidRatingMessage();
                return;
            }
            assert rating >= 0 && rating <= 5 : "rating should be between 0 and 5";
            Review r = new Review(title, category, rating, description);
            reviewList.add(r);
            ui.println(title + ADD_SUCCESS);
        } catch (NumberFormatException e) {
            ui.printInvalidRatingMessage();
        }
    }

    /**
     * Add a long review.
     */
    public void addLongReview() throws DuplicateException {
        boolean isDuplicate;
        ui.println(TITLE_PROMPT);
        String title = ui.readCommand();
        isDuplicate = checkAndPrintDuplicate(title);
        if (isDuplicate) {
            throw new DuplicateException();
        }
        ui.println(CATEGORY_PROMPT);
        String category = ui.readCommand().toLowerCase();
        ui.println(RATING_PROMPT);
        try {
            int rating = Integer.parseInt(ui.readCommand());
            if (rating < 0 || rating > 5) {
                ui.printInvalidRatingMessage();
                return;
            }
            assert rating >= 0 && rating <= 5 : "rating should be between 0 and 5";
            ui.println(DESCRIPTION_PROMPT);
            String description = ui.readCommand();
            Review r = new Review(title, category, rating, description);
            reviewList.add(r);
            ui.println(title + ADD_SUCCESS);
        } catch (NumberFormatException e) {
            ui.printInvalidRatingMessage();
        }
    }

    /**
     * Delete review.
     */
    public void deleteReview(String title) {
        if (title == null || title.isBlank()) {
            ui.println(MISSING_DELETE_TITLE);
            return;
        }
        int reviewIndex = -1;
        for (int i = 0; i < reviewList.size(); i++) {
            if (reviewList.get(i).getTitle().compareTo(title) == 0) {
                reviewIndex = i;
                break;
            }
        }
        if (reviewIndex == -1) {
            ui.println(INVALID_DELETE_TITLE);
        } else {
            reviewList.remove(reviewIndex);
            ui.println(title + DELETE_SUCCESS);
        }
    }

    /**
     * Print text to help user with using the application.
     *
     * @param arguments is the type of help determined by user input.
     */
    public void printHelp(String arguments) {
        if (arguments == null) {
            ui.printGeneralHelpMessage();
        } else if (arguments.equals("sort")) {
            ui.printSortHelpMessage();
        } else if (arguments.equals("list")) {
            ui.printListHelpMessage();
        } else if (arguments.equals("edit")) {
            ui.printEditHelpMessage();
        } else if (arguments.equals("review") || arguments.equals("new")) {
            ui.printReviewHelpMessage();
        } else if (arguments.equals("delete")) {
            ui.printDeleteHelpMessage();
        } else if (arguments.equals("view")) {
            ui.printViewHelpMessage();
        } else if (arguments.equals("exit")) {
            ui.printExitHelpMessage();
        } else {
            ui.printInvalidHelpMessage();
        }
    }

    /**
     * Print invalid command text.
     */
    public void invalidCommand() {
        ui.println(INVALID_COMMAND);
    }

    /**
     * Exits connoisseur.
     */
    public void exit() {
        storage.saveConnoisseurData(reviewList, sorter.getSortMethod());
        storage.saveRecommendationData(recommendationList);
        ui.printExitMessage();
    }

    /**
     * View a selected review.
     *
     * @param title title of the review to be viewed
     */
    public int viewReview(String title) {
        if (title == null || title.isBlank()) {
            ui.println(MISSING_VIEW_TITLE);
            return -1;
        }
        assert title != null : "title should not be empty";
        int reviewIndex = -1;
        for (int i = 0; i < reviewList.size(); i++) {
            if (reviewList.get(i).getTitle().compareTo(title) == 0) {
                reviewIndex = i;
                break;
            }
        }
        if (reviewIndex == -1) {
            ui.println(INVALID_VIEW_TITLE);
        } else {
            ui.println("Found a matching title: ");
            Review currentReview = reviewList.get(reviewIndex);
            ui.printView(currentReview);
        }
        return reviewIndex;
    }

    public boolean checkAndPrintDuplicate(String title) {
        int reviewIndex = -1;
        for (int i = 0; i < reviewList.size(); i++) {
            if ((reviewList.get(i).getTitle().toLowerCase()).compareTo(title.toLowerCase()) == 0) {
                reviewIndex = i;
            }
        }
        if (reviewIndex != -1) {
            System.out.println("There is a review in your list with the same title: ");
            Review currentReview = reviewList.get(reviewIndex);
            ui.print((reviewList.indexOf(currentReview) + 1) + ". ");
            if (reviewList.indexOf(currentReview) < 9) {
                ui.print(" ");
            }
            ui.print(currentReview.getTitle());
            ui.printWhiteSpace(currentReview.getTitle().length());
            ui.print(currentReview.getCategory());
            ui.printWhiteSpace(currentReview.getCategory().length());
            ui.print(currentReview.starRating());
            ui.printWhiteSpace(currentReview.starRating().length());
            ui.println(currentReview.getDateTime());
            return true;
        } else {
            return false;
        }
    }

    public void editReviews(String title) {
        if (title == null || title.isBlank()) {
            ui.println(MISSING_EDIT_TITLE);
        } else {
            int index = viewReview(title);
            if (index == -1) {
                return;
            }
            boolean isDoneEditing = false;
            do {
                ui.println("What would you like to edit (Title / Category / Rating / Description)?");
                Parser.determineEditCommand(index);
                ui.println("Would you like to edit anything else (y/n)?");
                String answer = ui.readCommand();
                switch (answer.toLowerCase()) {
                case "y":
                    break;
                case "n":
                    isDoneEditing = true;
                    break;
                default:
                    ui.println(INVALID_COMMAND);
                    isDoneEditing = true;
                }
            } while (!isDoneEditing);
            ui.println("Would You like to update the date of entry for the changes made(y/n)?");
            String answer = ui.readCommand();
            switch (answer) {
            case "y":
                Review currentReview = reviewList.get(index);
                currentReview.setDateAndTimeOfEntry();
                break;
            case "n":
                break;
            default:
                ui.println(INVALID_COMMAND);
                break;
            }
        }
    }

    public void editReviewTitle(String newTitle, int index) {
        Review currentReview = reviewList.get(index);
        currentReview.setTitle(newTitle);
    }

    public void editReviewRating(String newRating, int index) {
        Review currentReview = reviewList.get(index);
        currentReview.setRating(Integer.parseInt(newRating));
    }

    public void editReviewDescription(String newDescription, int index) {
        Review currentReview = reviewList.get(index);
        currentReview.setDescription(newDescription);
    }

    public void editReviewCategory(String newCategory, int index) {
        Review currentReview = reviewList.get(index);
        currentReview.setCategory(newCategory);
    }

    /**
     * List reviews according to different types of input.
     */
    public void listRecommendations() {
        if (recommendationList.size() == 0) {
            ui.printEmptyRecommendationListMessage();
        } else {
            printRecommendation(recommendationList);
        }
    }

    /**
     * Prints the sorted recommendation.
     */
    public void printRecommendation(ArrayList<Recommendation> recommendationList) {
        ui.printRecommendationListHeading();
        for (int i = 0; i < recommendationList.size(); i++) {
            Recommendation currentRecommendation = recommendationList.get(i);
            ui.print((i + 1) + ". ");
            if (i < 9) {
                ui.print(" ");
            }
            ui.print(currentRecommendation.getTitle());
            ui.printWhiteSpace(currentRecommendation.getTitle().length());
            ui.print(currentRecommendation.getCategory());
            ui.printWhiteSpace(currentRecommendation.getCategory().length());
            ui.println(currentRecommendation.dollarRange());
        }
    }

    public void addRecommendation(String title) throws DuplicateException {
        boolean isDuplicate;

        if (title == null || title.isBlank()) {
            ui.println(MISSING_RECO_TITLE);
            return;
        }
        isDuplicate = checkAndPrintDuplicate(title);
        if (isDuplicate) {
            throw new DuplicateException();
        }
        ui.println(CATEGORY_PROMPT);
        String category = ui.readCommand().toLowerCase();
        ui.println(PRICE_PROMPT);
        try {
            int pricing = Integer.parseInt(ui.readCommand());
            if (pricing < 0 || pricing > 5) {
                ui.printInvalidPricingMessage();
                return;
            }
            assert pricing >= 0 && pricing <= 5 : "rating should be between 0 and 5";
            ui.println(RECOBY_PROMPT);
            String recommendedBy = ui.readCommand();
            Recommendation r = new Recommendation(title, category, pricing, recommendedBy);
            recommendationList.add(r);
            ui.println(title + ADD_SUCCESS);
        } catch (NumberFormatException e) {
            ui.printInvalidRatingMessage();
        }
    }
}
