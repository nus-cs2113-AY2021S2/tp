package seedu.connoisseur.ui;

import seedu.connoisseur.review.Review;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

import static seedu.connoisseur.messages.Messages.WELCOME_MESSAGE;
import static seedu.connoisseur.messages.Messages.HELP_MESSAGE;
import static seedu.connoisseur.messages.Messages.SORT_HELP_MESSAGE;
import static seedu.connoisseur.messages.Messages.LIST_HELP_MESSAGE;
import static seedu.connoisseur.messages.Messages.EXIT_MESSAGE;
import static seedu.connoisseur.messages.Messages.ERROR_MESSAGE;
import static seedu.connoisseur.messages.Messages.EXIT_HELP_MESSAGE;
import static seedu.connoisseur.messages.Messages.VIEW_HELP_MESSAGE;
import static seedu.connoisseur.messages.Messages.DELETE_HELP_MESSAGE;
import static seedu.connoisseur.messages.Messages.REVIEW_HELP_MESSAGE;
import static seedu.connoisseur.messages.Messages.EDIT_HELP_MESSAGE;

public class Ui {
    private static final PrintStream out = System.out;
    private static final int MAX_WHITE_SPACE = 15;
    private final Scanner in;

    /**
     * Constructor for Ui class.
     */
    public Ui() {
        this.in = new Scanner(System.in);
    }

    /**
     * Reads user input.
     *
     * @return the input line as a string
     */
    public String readCommand() {
        return in.nextLine();
    }

    /**
     * Prints the welcome message to the printstream.
     */
    public void printGreeting() {
        println(WELCOME_MESSAGE);
    }

    /**
     * Prints header for review list command.
     */
    public void printReviewListHeading() {
        println("Here are your reviews: ");
        println("    Title          Category       Rating         Date");
    }

    /**
     * Prints header for recommendation list command.
     */
    public void printRecommendationListHeading() {
        println("Here are your recommendations: ");
        println("    Title          Category       Rating");
    }

    /**
     * Prints view command output.
     *
     * @param currentReview review to be viewed
     */
    public void printView(Review currentReview) {
        println("Title               : " + currentReview.getTitle());
        println("Category            : " + currentReview.getCategory());
        println("Date & Time of Entry: " + currentReview.getDateTime());
        println("Rating              : " + currentReview.starRating());
        println("Description         : " + currentReview.getDescription());
    }

    /**
     * Prints whitespace to align items to header.
     *
     * @param wordLength length of word to subtract
     */
    public void printWhiteSpace(int wordLength) {
        int numOfSpaces = MAX_WHITE_SPACE - wordLength;
        while (numOfSpaces > 0) {
            out.print(" ");
            numOfSpaces--;
        }
    }

    /**
     * Prints an array of Strings to the output stream.
     *
     * @param message array of strings to be printed
     */
    public void println(String... message) {
        for (String m : message) {
            out.println(m);
        }
    }

    /**
     * Prints a message to the output stream without a newline ending.
     *
     * @param message string to be printed
     */
    public void print(String message) {
        out.print(message);
    }

    /**
     * Prints general help message.
     */
    public void printGeneralHelpMessage() {
        println(HELP_MESSAGE);
    }

    /**
     * Prints sort help message.
     */
    public void printSortHelpMessage() {
        println(SORT_HELP_MESSAGE);
    }

    /**
     * Prints sort help message.
     */
    public void printExitHelpMessage() {
        println(EXIT_HELP_MESSAGE);
    }

    /**
     * Prints list help message.
     */
    public void printListHelpMessage() {
        println(LIST_HELP_MESSAGE);
    }

    public void printEditHelpMessage() {
        println(EDIT_HELP_MESSAGE);
    }

    /**
     * Prints delete help message.
     */
    public void printDeleteHelpMessage() {
        println(DELETE_HELP_MESSAGE);
    }

    /**
     * Prints view help message.
     */
    public void printViewHelpMessage() {
        println(VIEW_HELP_MESSAGE);
    }

    /**
     * Prints view help message.
     */
    public void printReviewHelpMessage() {
        println(REVIEW_HELP_MESSAGE);
    }

    /**
     * Prints exit message.
     */
    public void printExitMessage() {
        println(EXIT_MESSAGE);
    }

    /**
     * Prints error message.
     *
     * @param e error encountered
     */
    public void printErrorMessage(IOException e) {
        println(ERROR_MESSAGE);
        e.printStackTrace();
    }

    /**
     * Prints invalid rating message.
     */
    public void printInvalidRatingMessage() {
        println("Invalid number please add in a valid rating!");
    }

    /**
     * Prints invalid rating message.
     */
    public void printInvalidPricingMessage() {
        println("Invalid number please add in a valid pricing!");
    }

    /**
     * Prints invalid sort method message.
     */
    public void printInvalidSortMethodMessage() {
        println("Invalid sort type!");
    }

    /**
     * Prints invalid help command message.
     */
    public void printInvalidHelpMessage() {
        println("Invalid help command!");
    }

    /**
     * Prints empty review list message.
     */
    public void printEmptyReviewListMessage() {
        println("You have no reviews, type 'new' to start!");
    }

    /**
     * Prints empty recommendation list message.
     */
    public void printEmptyRecommendationListMessage() {
        println("You have no recommendations, type 'add' followed by a title to start!");
    }

}
