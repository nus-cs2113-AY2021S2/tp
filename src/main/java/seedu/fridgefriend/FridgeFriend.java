package seedu.fridgefriend;

import static seedu.fridgefriend.food.FoodCategory.convertStringToFoodCategory;
import static seedu.fridgefriend.food.FoodStorageLocation.convertStringToLocation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import seedu.fridgefriend.command.AddCommand;
import seedu.fridgefriend.command.Command;
import seedu.fridgefriend.command.ListCommand;
import seedu.fridgefriend.command.RemoveCommand;
import seedu.fridgefriend.command.SearchCommand;
import seedu.fridgefriend.exception.EmptyDescriptionException;
import seedu.fridgefriend.exception.InvalidDateException;
import seedu.fridgefriend.exception.InvalidInputException;
import seedu.fridgefriend.food.Food;
import seedu.fridgefriend.food.FoodCategory;
import seedu.fridgefriend.food.FoodStorageLocation;

public class FridgeFriend {

    private static final List<Food> fridge = new ArrayList<>();

    private static final int COMMAND_WORD = 0;
    private static final int LIMIT = 2;

    private static boolean isBye = false;

    public static void main(String[] args) {

        printWelcomeMessage();

        String input;
        Scanner in = new Scanner(System.in);

        while (!isBye) {
            try {
                input = getUserInput(in);
                processCommand(parseCommand(input));
            } catch (Exception exception) {
                printExceptionMessage(exception);
            }
        }
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
        String genericErrorMessage = "There was an error!";
        System.out.println(genericErrorMessage);
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
            throws EmptyDescriptionException, InvalidInputException, InvalidDateException {
        if (foodDescription.isEmpty()) {
            throw new EmptyDescriptionException();
        }
        final Matcher matcher = FOOD_DATA_ARGS_FORMAT.matcher(foodDescription.trim());
        // Validate foodDescription string format
        if (!matcher.matches()) {
            throw new InvalidInputException();
        }

        // Get Objects
        String foodName = matcher.group("name");
        FoodCategory foodCategory = convertStringToFoodCategory(matcher.group("category"));
        String expiryString = matcher.group("expiryDate");
        FoodStorageLocation foodStorageLocation = convertStringToLocation(matcher.group("storageLocation"));
        return new AddCommand(foodName, foodCategory, expiryString, foodStorageLocation);
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

    private static void processCommand(String[] parsedInput)
            throws EmptyDescriptionException, InvalidInputException, InvalidDateException {
        String command = parsedInput[COMMAND_WORD];
        String description = parsedInput[1];

        switch (command.toLowerCase()) {
        case "add":
            proceedToAdd(description);
            break;
        case "list":
            proceedToList(description);
            break;
        case "remove":
            proceedToRemove(description);
            break;
        case "search":
            proceedToSearch(description);
            break;
        case "bye":
            proceedToExit();
            break;
        default:
            throw new InvalidInputException();
        }
    }

    private static void proceedToAdd(String description)
            throws EmptyDescriptionException, InvalidInputException, InvalidDateException {
        Command addCommand = parseFoodDescription(description);
        addCommand.execute(fridge);
    }

    private static void proceedToList(String description) {
        Command list = new ListCommand(description);
        list.execute(fridge);
    }

    private static void proceedToRemove(String description) throws EmptyDescriptionException {
        try {
            Command remove = new RemoveCommand(parseIntegerDescription(description), fridge);
            remove.execute(fridge);
        } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw new IndexOutOfBoundsException("Please enter a valid index to remove food.\n");
        }
    }

    private static void proceedToSearch(String description) throws EmptyDescriptionException {
        Command search = new SearchCommand(description);
        search.execute(fridge);
    }

    private static void proceedToExit() {
        isBye = true;
        printByeMessage();
    }
}