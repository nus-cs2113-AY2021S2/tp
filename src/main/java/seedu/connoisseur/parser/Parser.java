package seedu.connoisseur.parser;

import seedu.connoisseur.commandlist.CommandList;

/**
 * Handles Connoisseur's commands.
 */
public class Parser {
    public CommandList commandList;

    public Parser() {
        commandList = new CommandList();
    }

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
            /*Ui.printDivider();
            Ui.printHelpCommandList();
            Ui.printDivider();*/
        } else if (command.equals("bye")) {
            return true;
        }
        /*else {
            throw new InvalidTaskCommandException();
        }*/

        return false;
    }
}
