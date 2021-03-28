package seedu.connoisseur.parser;

import seedu.connoisseur.commandlist.CommandList;
import seedu.connoisseur.exceptions.DuplicateException;
import seedu.connoisseur.ui.Ui;

/**
 * Handles Connoisseur's commands.
 */
public class Parser {
    private static CommandList commandList;
    private boolean isReviewMode = true;

    /**
     * Constructor for parser class.
     */
    public Parser(CommandList commandList) {
        Parser.commandList = commandList;
    }

    public static void determineEditCommand(int index) {
        Ui ui = new Ui();
        String input = ui.readCommand();
        try {
            input = input.trim().toLowerCase();
        } catch (ArrayIndexOutOfBoundsException e) {
            input = null;
        }
        switch (input) {
        case "title":
            System.out.println("What would you like to change the title to?");
            String newTitle = ui.readCommand();
            commandList.editReviewTitle(newTitle, index);
            break;
        case "rating":
            System.out.println("What would you like to change the rating to out of 5 stars?");
            String newRating = ui.readCommand();
            try {
                if (Integer.parseInt(newRating) <= 5 && Integer.parseInt(newRating) >= 0) {
                    commandList.editReviewRating(newRating, index);
                } else {
                    System.out.println("Invalid rating, failed to edit rating ");
                }
            } catch (NumberFormatException ne) {
                System.out.println("Invalid rating, failed to edit rating ");
            }
            break;
        case "description":
            System.out.println("Enter your new description of the review: ");
            String newDescription = ui.readCommand();
            commandList.editReviewDescription(newDescription, index);
            break;
        case "category":
            System.out.println("What would you like to change the category to?");
            String newCategory = ui.readCommand();
            commandList.editReviewCategory(newCategory, index);
            break;
        default:
            commandList.invalidCommand();
            break;
        }
    }

    /**
     * Processes user input and executes the relevant commands.
     *
     * @return true if exit command, false otherwise
     */
    public boolean determineCommand(String input) throws DuplicateException {
        String command = input.split(" ", 2)[0].toLowerCase().trim();
        String arguments;
        try {
            arguments = input.split(" ", 2)[1].trim();
        } catch (ArrayIndexOutOfBoundsException e) {
            arguments = null;
        }

        switch (command) {
        case "review":
            isReviewMode = true;
            System.out.println("You are now in review mode");
            break;
        case "reco":
            isReviewMode = false;
            System.out.println("You are now in recommendation mode");
            break;
        case "list":
            if(isReviewMode) {
                commandList.listReviews(arguments);
            }else {
                commandList.listRecommendations();
            }
            break;
        case "edit":
            if(isReviewMode) {
                commandList.editReviews(arguments);
            }
            break;
        case "sort":
            if(isReviewMode) {
                commandList.sortReview(arguments);
            }
            break;
        case "new":
            if (isReviewMode) {
                commandList.addReview(arguments);
            }
            break;
        case "delete":
            if(isReviewMode) {
                commandList.deleteReview(arguments);
            }
            break;
        case "view":
            if(isReviewMode) {
                commandList.viewReview(arguments);
            }
            break;
        case "add":
            if(isReviewMode) {
                commandList.addRecommendation(arguments);
            }
            break;
        case "help":
            commandList.printHelp(arguments);
            break;
        case "exit":
        case "bye":
            commandList.exit();
            return true;
        default:
            commandList.invalidCommand();
        }
        return false;
    }
}
