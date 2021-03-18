package seedu.connoisseur.parser;

import seedu.connoisseur.commandlist.CommandList;

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
        case "bye":
            commandList.exit();
            return true;
        default:
            commandList.invalidCommand();
        }
        return false;
    }
}
