package seedu.duke.logic.parser;

import seedu.duke.logic.commands.CheckInCommand;
import seedu.duke.logic.commands.CheckoutCommand;
import seedu.duke.logic.commands.ClearCommand;
import seedu.duke.logic.commands.Command;
import seedu.duke.logic.commands.EditMaxCommand;
import seedu.duke.logic.commands.ExitCommand;
import seedu.duke.logic.commands.FindCommand;
import seedu.duke.logic.commands.HelpCommand;
import seedu.duke.logic.commands.ListCheckedInCommand;
import seedu.duke.logic.commands.ListCommand;
import seedu.duke.logic.commands.MoveStorageCommand;
import seedu.duke.common.Messages;
import seedu.duke.exceptions.InvalidCommandException;
import seedu.duke.exceptions.InvalidIdException;
import seedu.duke.exceptions.InvalidIntegerException;
import seedu.duke.exceptions.InvalidMaxCapacityException;
import seedu.duke.exceptions.InvalidNameFormatException;
import seedu.duke.exceptions.InvalidPhoneNumberException;
import seedu.duke.exceptions.NoArgumentPassedException;
import seedu.duke.exceptions.PersonNotFoundException;
import seedu.duke.exceptions.StorageOperationException;
import seedu.duke.exceptions.WrongFlagException;


/**
 * Parses user input arguments and returns a new Command object.
 */
public class Parser {
    public static final String MAX_REGEX = "[0-9]+";

    /**
     * Method that splits user input into 2 sections.
     * First section contains desired command
     * Second section contains the description of the task
     *
     * @param text This is the user input. It is a string
     * @return String[] This returns an array, containing 2 fields
     */
    public String[] splitTextIntoTwoFields(String text) {
        String[] textArray = text.split(" ", 2);
        textArray[0] = textArray[0].toLowerCase();
        return textArray;
    }

    /**
     * Methodthat parses the user command and returns a Command object, depending on user input.
     * @param userInput This is the user input.
     * @return Command. This returns a Command object, depending on the user input.
     * @throws InvalidCommandException if the user enters a single word command that is not part of functionality
     * @throws NoArgumentPassedException if no argument is entered by user.
     * @throws WrongFlagException if user enters the wrong flag header
     * @throws InvalidIdException if the ID does not consist of 3 integers followed by an uppercase letter
     * @throws InvalidNameFormatException if the name does not consist of strings
     * @throws InvalidPhoneNumberException if the phone number does not consist of 8 integers
     * @throws StorageOperationException if there were errors reading the file
     * @throws InvalidIntegerException if the argument does not consist of integers only
     * @throws PersonNotFoundException if the person cannot be located in the storage
     * @throws InvalidMaxCapacityException if the argument is not a valid integer that represents maximum capacity
     */
    public Command parseCommand(String userInput) throws

            InvalidCommandException, NoArgumentPassedException,
            WrongFlagException, InvalidIdException,
            InvalidNameFormatException, InvalidPhoneNumberException,
            StorageOperationException, InvalidIntegerException, PersonNotFoundException, InvalidMaxCapacityException {

        String[] inputArray;
        String argument = null;
        assert userInput != null : "User input cannot be null";
        userInput = userInput.trim();
        inputArray = splitTextIntoTwoFields(userInput);   //inputArray may be of size 1 or size 2
        String command;
        command = inputArray[0];
        if (inputArray.length != 1) {
            argument = inputArray[1].trim();
        } else if (!command.equals("listcheckedin")
                && !command.equals("exit")
                && !command.equals("listall")
                && !command.equals("clear")
                && !command.equals("help")
                && !command.equals("editmax")) {
            throw new InvalidCommandException(Messages.INVALID_COMMAND);
        }
        switch (command) {
        case CheckInCommand.COMMAND:
            return CheckInParser.parseCheckIn(argument);
        case CheckoutCommand.COMMAND:
            return CheckoutParser.parseCheckOut(argument);
        case FindCommand.COMMAND:
            return FindParser.parseFind(argument);
        case ListCommand.COMMAND:
            return ListAllParser.parseList();
        case ListCheckedInCommand.COMMAND:
            return ListCheckedInParser.parseCheckedInList();
        case ExitCommand.COMMAND:
            return ExitParser.parseExit();
        case ClearCommand.COMMAND:
            return ClearParser.parseClear();
        case HelpCommand.COMMAND:
            return HelpParser.parseHelp();
        case EditMaxCommand.COMMAND:
            return EditMaxParser.parseEditMax(argument);

        case MoveStorageCommand.COMMAND:
            return MoveStorageParser.parseMoveStorage(argument);

        default:
            throw new InvalidCommandException(Messages.INVALID_COMMAND);
        }
    }

    static boolean isValidInteger(String argument) {
        return (argument.matches(MAX_REGEX));
    }

    public static int idFlagChecker(String argument) {
        return argument.indexOf("i/");
    }
    
    protected static int nameFlagChecker(String argument) {
        return argument.indexOf("n/");
    }
    
    protected static int phoneFlagChecker(String argument) {
        return argument.indexOf("p/");
    }

    protected static int flagChecker(String argument) {
        return argument.indexOf('/');
    }

}
