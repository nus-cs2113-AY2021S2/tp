package seedu.connoisseur.commandlist;

import seedu.connoisseur.recommendation.Recommendation;
import seedu.connoisseur.review.Review;
import seedu.connoisseur.storage.ConnoisseurData;
import seedu.connoisseur.storage.Storage;
import seedu.connoisseur.ui.Ui;
import seedu.connoisseur.sorter.SortMethod;
import seedu.connoisseur.sorter.Sorter;

import java.util.ArrayList;


import static seedu.connoisseur.messages.Messages.INVALID_COMMAND;

/**
 * Class with methods for different commands.
 */
public class CommandList {

    public ArrayList<Review> reviewList = new ArrayList<>();
    public ArrayList<Recommendation> recommendationList = new ArrayList<>();
    private final Sorter sorter;
    private final Ui ui;
    private final Storage storage;
    private ReviewCommandList reviewCommandList;
    private RecommendationsCommandList recommendationsCommandList;

    /**
     * Creates CommandList based on stored data.
     *
     * @param connoisseurData locally stored data
     * @param ui              ui instance
     * @param storage         storage instance
     */
    public CommandList(ConnoisseurData connoisseurData, Ui ui, Storage storage) {
        this.ui = ui;
        this.storage = storage;
        sorter = new Sorter(SortMethod.LATEST);
        this.reviewList = connoisseurData.getReviewList();
        this.recommendationList = connoisseurData.getRecoList();
        reviewCommandList = new ReviewCommandList(connoisseurData, ui, storage);
        recommendationsCommandList = new RecommendationsCommandList(connoisseurData, ui, storage);
    }

    /**
     * Creates new tasks if no existing data in files.
     */
    public CommandList(Ui ui, Storage storage) {
        this.ui = ui;
        this.storage = storage;
        sorter = new Sorter(SortMethod.LATEST);
        reviewCommandList = new ReviewCommandList(ui, storage);
        recommendationsCommandList = new RecommendationsCommandList(ui, storage);
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
        } else if (arguments.equals("reco")) {
            ui.printRecommendationHelpMessage();
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
        storage.saveConnoisseurData(reviewList, recommendationList, sorter.getSortMethod());
        ui.printExitMessage();
    }

    /**
     * List reviews or recommendations depending on the mode.
     *
     * @param input        is the sorting preference used to list, only applicable in review mode.
     * @param isReviewMode to check if user is in review or recommendation mode
     */
    public void list(String input, Boolean isReviewMode) {
        if (isReviewMode) {
            reviewCommandList.listReviews(input, reviewList);
        } else {
            recommendationsCommandList.listRecommendations(recommendationList);
        }
    }

    /**
     * Sort reviews depending on the mode.
     *
     * @param sortType     is the sorting preference, only applicable in review mode.
     * @param isReviewMode to check if user is in review or recommendation mode
     */
    public void sort(String sortType, Boolean isReviewMode) {
        if (isReviewMode) {
            reviewCommandList.sortReview(sortType);
        } else {
            ui.printCommandDoesNotExistInRecommendationMode();
        }
    }

    /**
     * Delete reviews or recommendations depending on the mode.
     *
     * @param title        is the title of review or recommendation to be deleted.
     * @param isReviewMode to check if user is in review or recommendation mode.
     */
    public void delete(String title, Boolean isReviewMode) {
        if (isReviewMode) {
            reviewCommandList.deleteReview(title);
        } else {
            ui.printCommandDoesNotExistInRecommendationMode();
        }
    }

    /**
     * View a selected review.
     *
     * @param title title of the review to be viewed.
     */
    public int viewReview(String title) {
        return reviewCommandList.viewReviewCommand(title);
    }

    /**
     * Add a selected review or recommendation.
     *
     * @param input        will be quick or long in review mode.
     *                     will be the recommendation title in the recommendation mode.
     * @param isReviewMode to check if user is in review or recommendation mode.
     */
    public void add(String input, Boolean isReviewMode) {
        if (isReviewMode) {
            reviewCommandList.addReview(input);
        } else {
            recommendationsCommandList.addRecommendation(input);
        }
    }

    /**
     * Edits a review.
     *
     * @param title        title of review
     * @param isReviewMode to check if user is in review or recommendation mode.
     */
    public void edit(String title, Boolean isReviewMode) {
        if (isReviewMode) {
            reviewCommandList.editReview(title, reviewList);
        } else {
            ui.printCommandDoesNotExistInRecommendationMode();
        }
    }

}
