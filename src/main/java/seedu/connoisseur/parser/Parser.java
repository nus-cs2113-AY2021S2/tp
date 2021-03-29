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

    /**
     * Processes user input and executes the relevant commands.
     *
     * @return true if exit command, false otherwise
     */
    public boolean determineCommand(String input) throws DuplicateException {
        Ui ui = new Ui();
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
            commandList.list(arguments, isReviewMode);
            break;
        case "edit":
            commandList.edit(arguments, isReviewMode);
            break;
        case "sort":
            commandList.sort(arguments, isReviewMode);
            break;
        case "new":
        case "add":
            commandList.add(arguments, isReviewMode);
            break;
        case "delete":
            commandList.delete(arguments, isReviewMode);
            break;
        case "done":
            commandList.done(arguments, isReviewMode);
        case "view":
            commandList.view(arguments, isReviewMode);
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
