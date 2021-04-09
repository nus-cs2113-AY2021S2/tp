package seedu.connoisseur.commands;

import seedu.connoisseur.storage.ConnoisseurData;
import seedu.connoisseur.storage.Storage;
import seedu.connoisseur.ui.Ui;


import static seedu.connoisseur.messages.Messages.INVALID_COMMAND;
import static seedu.connoisseur.messages.Messages.HELP_MESSAGE;
import static seedu.connoisseur.messages.Messages.SORT_HELP_MESSAGE;
import static seedu.connoisseur.messages.Messages.LIST_HELP_MESSAGE;
import static seedu.connoisseur.messages.Messages.EDIT_HELP_MESSAGE;
import static seedu.connoisseur.messages.Messages.NEW_HELP_MESSAGE;
import static seedu.connoisseur.messages.Messages.DELETE_HELP_MESSAGE;
import static seedu.connoisseur.messages.Messages.VIEW_HELP_MESSAGE;
import static seedu.connoisseur.messages.Messages.DISPLAY_HELP_MESSAGE;
import static seedu.connoisseur.messages.Messages.REVIEW_MODE_MESSAGE;
import static seedu.connoisseur.messages.Messages.RECO_MODE_MESSAGE;
import static seedu.connoisseur.messages.Messages.RECODONE_HELP_MESSAGE;
import static seedu.connoisseur.messages.Messages.EXIT_HELP_MESSAGE;
import static seedu.connoisseur.messages.Messages.INVALID_HELP_MESSAGE;
import static seedu.connoisseur.messages.Messages.MISSING_DISPLAY_TYPE;
import static seedu.connoisseur.messages.Messages.EXIT_MESSAGE;


/**
 * Class with methods for different commands.
 */
public class Commands {

    private final Ui ui;
    private final Storage storage;
    private boolean isReviewMode = true;
    private final ReviewList reviewList;
    private final RecommendationList recommendationList;

    /**
     * Creates Commands based on stored data.
     *
     * @param connoisseurData locally stored data
     * @param ui              ui instance
     * @param storage         storage instance
     */
    public Commands(ConnoisseurData connoisseurData, Ui ui, Storage storage) {
        this.ui = ui;
        this.storage = storage;
        reviewList = new ReviewList(connoisseurData, ui);
        recommendationList = new RecommendationList(connoisseurData, ui, reviewList);
    }

    /**
     * Creates new tasks if no existing data in files.
     */
    public Commands(Ui ui, Storage storage) {
        this.ui = ui;
        this.storage = storage;
        reviewList = new ReviewList(ui);
        recommendationList = new RecommendationList(ui, reviewList);
    }

    /**
     * Goes into review mode.
     */
    public void reviewMode() {
        isReviewMode = true;
        ui.println("You are now in review mode");
    }

    /**
     * Goes into recommendation mode.
     */
    public void recommendationMode() {
        isReviewMode = false;
        ui.println("You are now in recommendation mode");
    }

    /**
     * Changes display to stars or asterisks.
     *
     * @param displayType stars or asterisks
     */
    public void display(String displayType) {
        if (displayType == null || displayType.isBlank()) {
            ui.println(MISSING_DISPLAY_TYPE);
            return;
        }
        if (isReviewMode) {
            reviewList.changeDisplay(displayType);
        } else {
            ui.printCommandDoesNotExistInRecommendationMode();
        }
    }

    /**
     * Print text to help user with using the application.
     *
     * @param arguments is the type of help determined by user input.
     */
    public void printHelp(String arguments) {
        if (arguments == null || arguments.equals("")) {
            ui.println(HELP_MESSAGE);
        } else if (arguments.equals("sort")) {
            ui.println(SORT_HELP_MESSAGE);
        } else if (arguments.equals("list")) {
            ui.println(LIST_HELP_MESSAGE);
        } else if (arguments.equals("edit")) {
            ui.println(EDIT_HELP_MESSAGE);
        } else if (arguments.equals("new") || arguments.equals("add")) {
            ui.println(NEW_HELP_MESSAGE);
        } else if (arguments.equals("delete")) {
            ui.println(DELETE_HELP_MESSAGE);
        } else if (arguments.equals("view")) {
            ui.println(VIEW_HELP_MESSAGE);
        } else if (arguments.equals("display")) {
            ui.println(DISPLAY_HELP_MESSAGE);
        } else if (arguments.equals("review")) {
            ui.println(REVIEW_MODE_MESSAGE);
        } else if (arguments.equals("reco")) {
            ui.println(RECO_MODE_MESSAGE);
        } else if (arguments.equals("done")) {
            ui.println(RECODONE_HELP_MESSAGE);
        } else if (arguments.equals("exit") || arguments.equals("bye")) {
            ui.println(EXIT_HELP_MESSAGE);
        } else {
            ui.println(INVALID_HELP_MESSAGE);
        }
    }

    /**
     * Print invalid command text.
     */
    public void invalidCommand() {
        ui.println(INVALID_COMMAND);
    }

    /**
     * Print invalid parameters text.
     */
    public void invalidParameters() {
        ui.println("Invalid command. Please do not enter extra parameters or less parameters than required.");
    }

    /**
     * Exits connoisseur.
     */
    public void exit() {
        storage.saveConnoisseurData(reviewList.sorter.getSortMethod(), reviewList.getDisplayStars(),
                reviewList.reviews, recommendationList.recommendations);
        ui.println(EXIT_MESSAGE);
    }

    /**
     * List reviews or recommendations depending on the mode.
     *
     * @param input is the sorting preference used to list, only applicable in review mode.
     */
    public void list(String input) {
        if (isReviewMode) {
            reviewList.listReviews(input);
        } else {
            recommendationList.listRecommendations();
        }
    }

    /**
     * Sort reviews depending on the mode.
     *
     * @param sortType is the sorting preference, only applicable in review mode.
     */
    public void sort(String sortType) {
        if (isReviewMode) {
            reviewList.sortReviews(sortType);
        } else {
            ui.printCommandDoesNotExistInRecommendationMode();
        }
    }

    /**
     * Delete reviews or recommendations depending on the mode.
     *
     * @param title is the title of review or recommendation to be deleted.
     */
    public void delete(String title) {
        if (isReviewMode) {
            reviewList.deleteReview(title);
        } else {
            recommendationList.deleteRecommendation(title);
        }
    }


    /**
     * View a selected review.
     *
     * @param title title of the review to be viewed.
     */
    public void view(String title) {
        title = title.toLowerCase();
        if (isReviewMode) {
            reviewList.viewReview(title);
        } else {
            ui.printCommandDoesNotExistInRecommendationMode();
        }
    }

    /**
     * Removes selected recommended from list and converts it to a review.
     *
     * @param title title of the review to be viewed.
     */
    public void done(String title) {
        if (isReviewMode) {
            ui.printCommandDoesNotExistInReviewMode();
        } else {
            recommendationList.convertRecommendation(title);
        }
    }


    /**
     * Add a selected review or recommendation.
     *
     * @param input will be quick or long in review mode.
     *              will be the recommendation title in the recommendation mode.
     */
    public void add(String input) {
        if (isReviewMode) {
            reviewList.addReview(input);
        } else {
            if (input == null || input.isBlank()) {
                invalidParameters();
            } else {
                recommendationList.addRecommendation();
            }
        }
    }

    /**
     * Edits a review.
     *
     * @param title title of review
     */
    public void edit(String title) {
        if (isReviewMode) {
            reviewList.editReview(title);
        } else {
            recommendationList.editRecommendation(title);
        }
    }
}