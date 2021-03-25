package seedu.connoisseur.parser;

import seedu.connoisseur.commandlist.CommandList;
import seedu.connoisseur.ui.Ui;

/**
 * Handles Connoisseur's commands.
 */
public class Parser {
    private static CommandList commandList;

    /**
     * Constructor for parser class.
     */
    public Parser(CommandList commandList) {
        Parser.commandList = commandList;
    }

    public static void determineEditCommand(int Index) {
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
            commandList.editReviewTitle(newTitle, Index);
            break;
        case "rating":
            System.out.println("What would you like to change the rating to out of 5 stars?");
            String newRating = ui.readCommand();
            try {
                if (Integer.parseInt(newRating) <= 5 && Integer.parseInt(newRating) >= 0) {
                    commandList.editReviewRating(newRating, Index);
                } else {
                    System.out.println("Invalid rating, failed to edit rating ");
                    ;
                }
            } catch (NumberFormatException ne) {
                System.out.println("Invalid rating, failed to edit rating ");
                ;
            }
            break;
        case "description":
            System.out.println("Enter your new description of the review: ");
            String newDescription = ui.readCommand();
            commandList.editReviewDescription(newDescription, Index);
            break;
        case "category":
            System.out.println("What would you like to change the category to?");
            String newCategory = ui.readCommand();
            commandList.editReviewCategory(newCategory, Index);
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
    public boolean determineCommand(String input) {
        String command = input.split(" ", 2)[0].toLowerCase().trim();
        String arguments;
        try {
            arguments = input.split(" ", 2)[1].trim();
        } catch (ArrayIndexOutOfBoundsException e) {
            arguments = null;
        }

        switch (command) {
        case "list":
            commandList.listReviews(arguments);
            break;
        case "edit":
            commandList.editReviews(arguments);
            break;
        case "sort":
            commandList.sortReview(arguments);
            break;
        case "new":
            commandList.addReview(arguments);
            break;
        case "delete":
            commandList.deleteReview(arguments);
            break;
        case "view":
            commandList.viewReview(arguments);
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
