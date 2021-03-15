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
    public Parser() {
        commandList = new CommandList();
    }

    /**
     * Processes user input and executes the relevant commands. 
     * @param input user input
     * @return true if exit command, false otherwise
     */
    public boolean determineCommand(String input) {
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
            commandList.addReview(description);
        } else if (command.equals("delete")) {
            commandList.deleteReview(description);
        } else if (command.equals("help")) {
            CommandList.printHelp();
        } else if (command.equals("bye")) {
            commandList.exit();
            return true;
        } else {
            CommandList.invalidCommand();
        }
        return false;
    }
}
