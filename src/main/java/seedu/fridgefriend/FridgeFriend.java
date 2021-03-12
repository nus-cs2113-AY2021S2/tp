package seedu.fridgefriend;

import static seedu.fridgefriend.food.FoodCategory.convertStringToFoodCategory;
import static seedu.fridgefriend.food.FoodStorageLocation.convertStringToLocation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import seedu.fridgefriend.command.AddCommand;
import seedu.fridgefriend.command.ByeCommand;
import seedu.fridgefriend.command.Command;
import seedu.fridgefriend.command.ListCommand;
import seedu.fridgefriend.command.RemoveCommand;
import seedu.fridgefriend.command.SearchCommand;
import seedu.fridgefriend.exception.EmptyDescriptionException;
import seedu.fridgefriend.exception.InvalidIndexException;
import seedu.fridgefriend.exception.InvalidInputException;
import seedu.fridgefriend.food.Food;

public class FridgeFriend {

    private static final List<Food> fridge = new ArrayList<>();

    private static final int COMMAND_WORD = 0;
    private static final int LIMIT = 2;

    private static boolean isExit = false;

    public static void main(String[] args) {

        printWelcomeMessage();

        String input;
        Scanner in = new Scanner(System.in);

        run(in);

        printByeMessage();
    }

    private static void run(Scanner in) {
        String input;
        while (!isExit) {
            try {
                input = getUserInput(in);
                String[] parsedInput = parseCommand(input);
                Command command = getCommand(parsedInput);
                executeCommand(command);
                isExit = command.isExit();
            } catch (Exception exception) {
                printExceptionMessage(exception);
            }
        }
    }

    private static void executeCommand(Command command) {
        command.execute(fridge);
    }

    private static String getUserInput(Scanner in) {
        return in.nextLine();
    }

    private static void printByeMessage() {
        System.out.println("Bye. Hope to see you again soon!\n");
    }

    private static void printWelcomeMessage() {
        System.out.println("Hello! I'm FridgeFriend!");
        System.out.println("What can I do for you?\n");
    }

    private static void printExceptionMessage(Exception exception) {
        System.out.println(exception.getMessage());
    }

    /**
     * Parses input into command and description.
     *
     * @param input user input string
     * @return String array of command and description
     * @throws InvalidInputException if the input is empty
     */
    public static String[] parseCommand(String input) throws InvalidInputException {
        if (input.isEmpty()) {
            throw new InvalidInputException();
        }
        //remove trailing whitespaces and parse input into two separated by a whitespace
        String[] words = input.trim().split("\\s+", LIMIT);
        if (words.length == LIMIT) {
            return words;
        } else {
            //return an array of command and empty description
            return new String[] {words[COMMAND_WORD], ""};
        }
    }

    /**
     * Define arguments format for add food command.
     * A Pattern object which defines how the input string for food item
     * that should look like. [^/]+ implies 1 or more characters except for '/'
     */
    public static final Pattern FOOD_DATA_ARGS_FORMAT =
            Pattern.compile("(?<name>[^/]+)"
                    + " /c (?<category>[^/]+)"
                    + " /exp (?<expiryDate>[^/]+)"
                    + " /loc (?<storageLocation>[^/]+)");

    /**
     * Parses description into name, foodCategory, expiryDate and storageLocation.
     * Matcher objects will try to parse a string according to the Pattern we define
     * like above FOOD_DATA_ARGS_FORMAT. For other future parsers can copy the usage here.
     *
     * @param foodDescription the string in the required format of food description
     * @return a new AddCommand for Food
     * @throws EmptyDescriptionException if the description is empty
     * @throws InvalidInputException if the description cannot parse
     */
    public static Command parseFoodDescription(String foodDescription)
            throws EmptyDescriptionException, InvalidInputException {
        if (foodDescription.isEmpty()) {
            throw new EmptyDescriptionException();
        }
        final Matcher matcher = FOOD_DATA_ARGS_FORMAT.matcher(foodDescription.trim());
        // Validate foodDescription string format
        if (!matcher.matches()) {
            throw new InvalidInputException();
        }
        return new AddCommand(
            matcher.group("name"),
            convertStringToFoodCategory(matcher.group("category")),
            matcher.group("expiryDate"),
            convertStringToLocation(matcher.group("storageLocation"))
        );
    }

    public static int parseIntegerDescription(String description) throws EmptyDescriptionException {
        if (description.isEmpty()) {
            throw new EmptyDescriptionException();
        }

        try {
            int index = Integer.parseInt(description);
            return index;
        } catch (NumberFormatException numberFormatException) {
            throw new NumberFormatException("Please enter a valid index to remove food.\n");
        }
    }

    private static Command getCommand(String[] parsedInput)
            throws EmptyDescriptionException, InvalidInputException, InvalidIndexException {
        String commandString = parsedInput[COMMAND_WORD];
        String description = parsedInput[1];
        Command command;

        switch (commandString.toLowerCase()) {
        case "add":
            command = getAddCommand(description);
            break;
        case "list":
            command = getListCommand(description);
            break;
        case "remove":
            command = getRemoveCommand(description);
            break;
        case "search":
            command = getSearchCommand(description);
            break;
        case "bye":
            command = getByeCommand();
            break;
        default:
            throw new InvalidInputException();
        }
        return command;
    }

    private static Command getAddCommand(String description) 
            throws EmptyDescriptionException, InvalidInputException {
        Command addCommand = parseFoodDescription(description);
        return addCommand;
    }

    private static Command getListCommand(String description) {
        Command listCommand = new ListCommand(description);
        return listCommand;
    }

    private static Command getRemoveCommand(String description)
            throws EmptyDescriptionException, InvalidIndexException {
        try {
            Command removeCommand = new RemoveCommand(parseIntegerDescription(description), fridge);
            return removeCommand;
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidIndexException(e);
        }
    }

    private static Command getSearchCommand(String description) throws EmptyDescriptionException {
        Command searchCommand = new SearchCommand(description);
        return searchCommand;
    }

    private static Command getByeCommand() {
        Command byeCommand = new ByeCommand();
        return byeCommand;
    }
}