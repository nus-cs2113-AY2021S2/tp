package seedu.connoisseur.parser;

import seedu.connoisseur.commands.Commands;

/**
 * Handles Connoisseur's commands.
 */
public class Parser {
    private static Commands commands;

    /**
     * Constructor for parser class.
     */
    public Parser(Commands commands) {
        Parser.commands = commands;
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
        case "review":
            if (arguments == null || arguments.isBlank()) {
                commands.reviewMode();
            } else {
                commands.invalidParameters();
            }
            break;
        case "reco":
            if (arguments == null || arguments.isBlank()) {
                commands.recommendationMode();
            } else {
                commands.invalidParameters();
            }
            break;
        case "list":
            if (arguments == null || arguments.isBlank()) {
                commands.list(arguments);
            } else {
                commands.invalidParameters();
            }
            break;
        case "edit":
            commands.edit(arguments);
            break;
        case "sort":
            commands.sort(arguments);
            break;
        case "new":
        case "add":
            commands.add(arguments);
            break;
        case "delete":
            commands.delete(arguments);
            break;
        case "done":
            commands.done(arguments);
            break;
        case "view":
            commands.view(arguments);
            break;
        case "display":
            commands.display(arguments);
            break;
        case "help":
            commands.printHelp(arguments);
            break;
        case "exit":
        case "bye":
            if (arguments == null || arguments.isBlank()) {
                commands.exit();
                return true;
            } else {
                commands.invalidParameters();
                break;
            }
        default:
            commands.invalidCommand();
        }
        return false;
    }
}
