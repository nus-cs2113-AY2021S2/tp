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
            arguments = "";
        }

        if (command.equals("list")) {
            commandList.listReviews(arguments);
        } else if (command.equals("sort")) {
            commandList.sortReview(arguments);
        } else if (command.equals("new")) {
            commandList.addReview(arguments);
        } else if (command.equals("delete")) {
            commandList.deleteReview(arguments);
        } else if (command.equals("help")) {
            commandList.printHelp(arguments);
        } else if (command.equals("bye")) {
            commandList.exit();
            return true;
        } else {
            commandList.invalidCommand();
        }
        return false;
    }
}
