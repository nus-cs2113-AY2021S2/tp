package seedu.connoisseur.parser;

import seedu.connoisseur.commandlist.CommandList;
import seedu.connoisseur.exceptions.ConnoisseurException;
import seedu.connoisseur.exceptions.InvalidReviewCommandException;
import seedu.connoisseur.exceptions.InvalidReviewDescriptionException;

import java.net.ConnectException;

/**
 * Handles Connoisseur's commands.
 */
public class Parser {
    public CommandList commandList;

    /**
     * Constructor for parser class.
     */
    public Parser(CommandList commandList) {
        this.commandList = commandList;
    }

    /**
     * Processes user input and executes the relevant commands.
     *
     * @param input user input
     * @return true if exit command, false otherwise
     */
    public boolean determineCommand(String input) throws ConnoisseurException {
        String command = input.split(" ", 2)[0].toLowerCase().trim();
        String description;
        try {
            description = input.split(" ", 2)[1].trim();
        } catch (ArrayIndexOutOfBoundsException e) {
            description = "";
        }

        if (command.equals("list")) {
            commandList.listReviews(description);
        } else if (command.equals("sort")) {
            commandList.sortReview(description);
        } else if (command.equals("new")) {
            String reviewType = commandList.determineReviewType(description);   //catch the errors here
            if (reviewType.equals("quick")) {
                commandList.addQuickReview();
            } else {
                commandList.addLongReview();
            }
        } else if (command.equals("delete")) {
            commandList.deleteReview(description);
        } else if (command.equals("help")) {
            CommandList.printHelp();
        } else if (command.equals("bye")) {
            commandList.exit();
            return true;
        } else {
            throw new InvalidReviewCommandException();
        }
        return false;
    }
}
