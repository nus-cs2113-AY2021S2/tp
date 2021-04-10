package seedu.connoisseur.ui;

import java.io.PrintStream;
import java.util.Scanner;

import static seedu.connoisseur.messages.Messages.WELCOME_MESSAGE;
import static seedu.connoisseur.messages.Messages.ERROR_MESSAGE;
import static seedu.connoisseur.messages.Messages.INPUT_TOO_LONG_MESSAGE_20CHAR;
import static seedu.connoisseur.messages.Messages.INPUT_TOO_LONG_MESSAGE_15CHAR;


public class Ui {
    private static final PrintStream out = System.out;
    private static final int MAX_WHITE_SPACE = 16;
    private static final int MAX_WHITE_SPACE_TITLE = 26;
    private static final int MAX_WHITE_SPACE_VIEW = 67;
    private static final int MAX_WHITE_SPACE_DATE = 23;
    private static final int MAX_WHITE_SPACE_PRICE = 18;
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
        println("+-------------------------------+-----------------+-----------------+------------------------+");
        println("|   Title                       | Category        | Rating          | Date                   |");
        println("+-------------------------------+-----------------+-----------------+------------------------+");
    }

    /**
     * Prints border of end of table for list command.
     */
    public void printTableEndBorderForReview() {
        println("+-------------------------------+-----------------+-----------------+------------------------+");
    }

    /**
     * Prints header for recommendation list command.
     */
    public void printRecommendationListHeading() {
        println("Here are your recommendations: ");
        println("+-------------------------------+-----------------+"
                + "-------------------+-----------------+-----------------+");
        println("|   Title                       | Category        |"
                + " Price range       | Location        | Recommended By  |");
        println("+-------------------------------+-----------------+"
                + "-------------------+-----------------+-----------------+");
    }

    /**
     * Prints border of end of table for list command.
     */
    public void printTableEndBorderForReco() {
        println("+-------------------------------+-----------------+"
                + "-------------------+-----------------+-----------------+");
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
     * Prints whitespace to align title to header.
     *
     * @param wordLength length of word to subtract
     */
    public void printWhiteSpaceTitle(int wordLength) {
        int numOfSpaces = MAX_WHITE_SPACE_TITLE - wordLength;
        while (numOfSpaces > 0) {
            out.print(" ");
            numOfSpaces--;
        }
    }

    /**
     * Prints whitespace to align price to its header.
     *
     * @param wordLength length of word to subtract
     */
    public void printWhiteSpacePrice(int wordLength) {
        int numOfSpaces = MAX_WHITE_SPACE_PRICE - wordLength;
        while (numOfSpaces > 0) {
            out.print(" ");
            numOfSpaces--;
        }
    }

    /**
     * Prints whitespace to align border in view command.
     *
     * @param wordLength length of word to subtract
     */
    public void printWhiteSpaceView(int wordLength) {
        int numOfSpaces = MAX_WHITE_SPACE_VIEW - wordLength;
        while (numOfSpaces > 0) {
            out.print(" ");
            numOfSpaces--;
        }
    }

    /**
     * Prints whitespace to align border for date field.
     *
     * @param wordLength length of word to subtract
     */
    public void printWhiteSpaceDate(int wordLength) {
        int numOfSpaces = MAX_WHITE_SPACE_DATE - wordLength;
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
     * Prints error message.
     *
     * @param e error encountered
     */
    public void printErrorMessage(Exception e) {
        println(ERROR_MESSAGE);
        e.printStackTrace();
    }

    /**
     * Prints invalid rating message.
     */
    public void printInvalidRatingMessage() {
        println("Invalid number. Please add in a valid rating!");
    }

    /**
     * Prints invalid pricing message.
     */
    public void printInvalidPricingMessage() {
        println("Invalid price range! Please enter numbers up to 2 decimal places "
                + "between 0.00 and 9999.99, separated by -");
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

    public void printCommandDoesNotExistInReviewMode() {
        println("This command does not exist in review mode");
    }

    public void printCommandDoesNotExistInRecommendationMode() {
        println("This command does not exist in recommendation mode");
    }

    public void printEmptyInputMessage() {
        println("This field should not be empty!");
    }

    public void printNoUniqueTitleMessage() {
        println("Please try again with a unique title!");
    }

    public void printInputTooLongMessage_20Char() {
        println(INPUT_TOO_LONG_MESSAGE_20CHAR);
    }

    public void printInputTooLongMessage_15Char() {
        println(INPUT_TOO_LONG_MESSAGE_15CHAR);
    }

}
