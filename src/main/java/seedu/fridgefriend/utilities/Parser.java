package seedu.fridgefriend.utilities;

import static seedu.fridgefriend.food.FoodCategory.convertStringToFoodCategory;
import static seedu.fridgefriend.food.FoodStorageLocation.convertStringToLocation;

import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import seedu.fridgefriend.command.AddCommand;
import seedu.fridgefriend.command.ByeCommand;
import seedu.fridgefriend.command.ClearCommand;
import seedu.fridgefriend.command.Command;
import seedu.fridgefriend.command.ExpiringCommand;
import seedu.fridgefriend.command.HelpCommand;
import seedu.fridgefriend.command.HistoryCommand;
import seedu.fridgefriend.command.ListCommand;
import seedu.fridgefriend.command.RemoveCommand;
import seedu.fridgefriend.command.RunningLowCommand;
import seedu.fridgefriend.command.SearchCommand;
import seedu.fridgefriend.command.SetLimitCommand;
import seedu.fridgefriend.exception.EmptyDescriptionException;
import seedu.fridgefriend.exception.InvalidDateException;
import seedu.fridgefriend.exception.InvalidFoodCategoryException;
import seedu.fridgefriend.exception.InvalidFoodLocationException;
import seedu.fridgefriend.exception.InvalidInputException;
import seedu.fridgefriend.exception.InvalidQuantityException;
import seedu.fridgefriend.exception.InvalidSetLimitQuantityException;
import seedu.fridgefriend.food.FoodCategory;

/**
 * Represents an object that deals with making sense of the user command.
 */
public class Parser {

    private static final int COMMAND_WORD_INDEX = 0;
    private static final int NUMBER_OF_PHRASES = 2;
    private static final int MAX_ALLOWABLE_QUANTITY = 1000000;

    //@@author Vinci-Hu
    /**
     * Define arguments format for add food command.
     * A Pattern object which defines how the input string for food item
     * that should look like. [^/]+ implies 1 or more characters except for '/'
     */
    private static final Pattern FOOD_DATA_ARGS_FORMAT =
            Pattern.compile("(?<name>[^/]+)"
                    + " /cat (?<category>[^/]+)"
                    + " /exp (?<expiryDate>[^/]+)"
                    + " /loc (?<storageLocation>[^/]+)"
                    + " /qty (?<quantity>[^/]+)");

    /**
     * Define arguments format for remove food command with quantity.
     */
    private static final Pattern REMOVE_ARGS_FORMAT =
            Pattern.compile("(?<name>[^/]+)"
                    + " /qty (?<quantity>[^/]+)");
    //@@author

    /**
     * Define arguments format for remove food command with quantity.
     */
    private static final Pattern SET_LIMIT_ARGS_FORMAT =
            Pattern.compile("(?<foodCategory>[^/]+)"
                    + " /qty (?<quantity>[^/]+)");
    public static final int GREATER = 1;
    public static final int EQUAL_TO = 0;

    //@@author SimJJ96
    /**
     * Returns a Command object based on the user's raw input.
     *
     * @param input user's raw input
     * @return Command object
     * @throws EmptyDescriptionException if the required description field is empty
     * @throws InvalidInputException if the command is not recognised
     * @throws InvalidDateException if the date input cannot be parsed
     * @throws InvalidQuantityException if the quantity input cannot be parsed
     * @throws InvalidSetLimitQuantityException if the set limit quantity input cannot be parsed
     * @throws InvalidFoodCategoryException if the category input cannot be parsed
     * @throws InvalidFoodLocationException if the location input cannot be parsed
     */
    public static Command getCommand(String input)
            throws EmptyDescriptionException, InvalidInputException, InvalidDateException,
            InvalidQuantityException, InvalidSetLimitQuantityException,
            InvalidFoodCategoryException, InvalidFoodLocationException {
        String[] parsedInput = parseInput(input);
        Command command = parseCommand(parsedInput);
        return command;
    }

    /**
     * Parses input into command and description.
     *
     * @param input user input string
     * @return String array of command and description
     * @throws InvalidInputException if the input is empty
     */
    public static String[] parseInput(String input) throws InvalidInputException {
        if (input.isEmpty()) {
            throw new InvalidInputException();
        }
        //remove trailing whitespaces and parse input into two separated by a whitespace
        String[] words = input.trim().split("\\s+", Parser.NUMBER_OF_PHRASES);
        if (words.length == Parser.NUMBER_OF_PHRASES) {
            return words;
        } else {
            //return an array of command and empty description
            return new String[] {words[COMMAND_WORD_INDEX], ""};
        }
    }

    /**
     * Returns the appropriate Command object based on command and description.
     *
     * @param parsedInput string array containing command and description
     * @return Command object
     * @throws EmptyDescriptionException if the required description field is empty
     * @throws InvalidInputException if the command is not recognised
     * @throws InvalidDateException if the date input cannot be parsed
     * @throws InvalidQuantityException if the quantity input cannot be parsed
     * @throws InvalidSetLimitQuantityException if set limit quantity input cannot be parsed
     * @throws InvalidFoodCategoryException if the category input cannot be parsed
     * @throws InvalidFoodLocationException if the location input cannot be parsed
     */
    public static Command parseCommand(String[] parsedInput)
            throws EmptyDescriptionException, InvalidInputException, InvalidDateException,
            InvalidQuantityException, InvalidSetLimitQuantityException,
            InvalidFoodCategoryException, InvalidFoodLocationException {
        String commandString = parsedInput[COMMAND_WORD_INDEX];
        String description = parsedInput[1];
        Command command;

        switch (commandString.toLowerCase()) {
        case "add":
            command = Parser.getAddCommand(description);
            break;
        case "list":
            command = Parser.getListCommand(description);
            break;
        case "remove":
            command = Parser.getRemoveCommand(description);
            break;
        case "search":
            command = Parser.getSearchCommand(description);
            break;
        case "expiring":
            command = Parser.getExpiringCommand();
            break;
        case "runninglow":
            command = Parser.getRunningLowCommand();
            break;
        case "setlimit":
            command = Parser.getSetLimitCommand(description);
            break;
        case "help":
            command = Parser.getHelpCommand();
            break;
        case "clear":
            command = Parser.getClearCommand();
            break;
        case "history":
            command = Parser.getHistoryCommand(description);
            break;
        case "bye":
            command = Parser.getByeCommand();
            break;
        default:
            throw new InvalidInputException();
        }
        assert command != null : "Command should not be null";
        return command;
    }

    /**
     * Returns an AddCommand object based on description.
     *
     * @param description description for command
     * @return AddCommand object
     * @throws EmptyDescriptionException if the description is empty
     * @throws InvalidInputException if the description cannot parse
     * @throws InvalidDateException if the date input cannot be parsed
     * @throws InvalidQuantityException if the quantity input cannot be parsed
     * @throws InvalidFoodCategoryException if the category input cannot be parsed
     * @throws InvalidFoodLocationException if the location input cannot be parsed
     */
    private static Command getAddCommand(String description)
            throws EmptyDescriptionException, InvalidInputException,
            InvalidDateException, InvalidQuantityException,
            InvalidFoodCategoryException, InvalidFoodLocationException {
        Command addCommand = parseAddDescription(description);
        return addCommand;
    }
    //@@author

    //@@author Vinci-Hu
    /**
     * Parses description into name, foodCategory, expiryDate and storageLocation and quanity.
     * Matcher objects will try to parse a string according to the Pattern we define
     * like above FOOD_DATA_ARGS_FORMAT. For other future parsers can copy the usage here.
     *
     * @param foodDescription the string in the required format of food description
     * @return a new AddCommand for Food
     * @throws EmptyDescriptionException if the description is empty
     * @throws InvalidInputException if the description cannot parsed
     * @throws InvalidDateException if the date input cannot be parsed
     * @throws InvalidQuantityException if the quantity input cannot be parsed
     * @throws InvalidFoodCategoryException if the category input cannot be parsed
     * @throws InvalidFoodLocationException if the location input cannot be parsed
     */
    private static Command parseAddDescription(String foodDescription)
            throws EmptyDescriptionException, InvalidInputException,
            InvalidDateException, InvalidQuantityException,
            InvalidFoodCategoryException, InvalidFoodLocationException {
        if (foodDescription.isEmpty()) {
            throw new EmptyDescriptionException();
        }
        Matcher matcherQuantity = FOOD_DATA_ARGS_FORMAT.matcher(foodDescription.trim());

        // Validate foodDescription string format
        if (matcherQuantity.matches()) {
            int quantity = parseIntegerQuantity(matcherQuantity.group("quantity"));
            return new AddCommand(matcherQuantity.group("name"),
                    convertStringToFoodCategory(matcherQuantity.group("category")),
                    matcherQuantity.group("expiryDate"),
                    convertStringToLocation(matcherQuantity.group("storageLocation")),
                    quantity);
        } else {
            throw new InvalidInputException();
        }
    }
    //@@author

    /**
     * Returns a ListCommand object based on description.
     *
     * @param description description for command
     * @return ListCommand object
     */
    private static Command getListCommand(String description) {
        Command listCommand = new ListCommand(description);
        return listCommand;
    }

    /**
     * Returns a RemoveCommand object based on description.
     *
     * @param description description for command
     * @return RemoveCommand object
     * @throws EmptyDescriptionException if the description is empty
     * @throws InvalidInputException if the description cannot parsed
     * @throws InvalidQuantityException if the quantity input cannot be parsed
     */
    private static Command getRemoveCommand(String description)
            throws EmptyDescriptionException, InvalidQuantityException,
            InvalidInputException {
        Command removeCommand = parseRemoveDescription(description);
        return removeCommand;
    }

    //@@author Vinci-Hu
    /**
     * Parses description into name and quantity.
     * Matcher objects will try to parse a string according to the Pattern we define
     * like above FOOD_DATA_ARGS_FORMAT. For other future parsers can copy the usage here.
     *
     * @param removeDescription the string in the required format of food description
     * @return a new RemoveCommand for Food
     * @throws EmptyDescriptionException if the description is empty
     * @throws InvalidInputException if the description cannot parsed
     * @throws InvalidQuantityException if the quantity input cannot be parsed
     */
    private static Command parseRemoveDescription(String removeDescription)
            throws EmptyDescriptionException, InvalidQuantityException, InvalidInputException {
        if (removeDescription.isEmpty()) {
            throw new EmptyDescriptionException();
        }
        Matcher matcherRemove = REMOVE_ARGS_FORMAT.matcher(removeDescription.trim());
        if (matcherRemove.matches()) {
            String name = matcherRemove.group("name");
            int quantity = parseIntegerQuantity(matcherRemove.group("quantity"));
            return new RemoveCommand(name, quantity);
        } else {
            throw new InvalidInputException();
        }
    }
    //@@author

    //@@author SimJJ96
    /**
     * Returns a SearchCommand object based on description.
     *
     * @param description description for command
     * @return SearchCommand object
     * @throws EmptyDescriptionException if the description is empty
     */
    private static Command getSearchCommand(String description) throws EmptyDescriptionException {
        Command searchCommand = new SearchCommand(description);
        return searchCommand;
    }
    //@@author

    //@@author kwokyto
    /**
     * Returns an ExpiringCommand object.
     */
    private static Command getExpiringCommand() {
        Command expiringCommand = new ExpiringCommand();
        return expiringCommand;
    }

    //@@author kwokyto
    /**
     * Returns a RunningLowCommand object.
     */
    private static Command getRunningLowCommand() {
        Command runningLowCommand = new RunningLowCommand();
        return runningLowCommand;
    }

    //@@author kwokyto
    /**
     * Returns a SetLimitCommand object.
     *
     * @throws EmptyDescriptionException if the description is empty
     * @throws InvalidFoodCategoryException if the category input cannot be parsed
     * @throws InvalidInputException if the description cannot parsed
     * @throws InvalidSetLimitQuantityException if the set limit quantity input cannot be parsed
     */
    private static Command getSetLimitCommand(String description) throws EmptyDescriptionException,
            InvalidSetLimitQuantityException, InvalidInputException, InvalidFoodCategoryException {
        Command setLimitCommand = parseSetLimitDescription(description);
        return setLimitCommand;
    }

    //@@author kwokyto
    private static Command parseSetLimitDescription(String description) throws EmptyDescriptionException,
            InvalidSetLimitQuantityException, InvalidInputException, InvalidFoodCategoryException {
        if (description.isEmpty()) {
            throw new EmptyDescriptionException();
        }
        Matcher matcherRemove = SET_LIMIT_ARGS_FORMAT.matcher(description.trim());
        if (!matcherRemove.matches()) {
            throw new InvalidInputException();
        }
        String foodCategoryString = matcherRemove.group("foodCategory");
        if (!FoodCategory.isValidCategory(foodCategoryString)) {
            throw new InvalidFoodCategoryException(foodCategoryString);
        }
        FoodCategory foodCategory = FoodCategory.convertStringToFoodCategory(foodCategoryString);
        int quantity = parseSetLimitIntegerQuantity(matcherRemove.group("quantity"));
        return new SetLimitCommand(foodCategory, quantity);
    }

    //@@author kwokyto
    /**
     * Returns a HelpCommand object.
     *
     * @return HelpCommand object
     */

    private static Command getHelpCommand() {
        Command helpCommand = new HelpCommand();
        return helpCommand;
    }

    /**
     * Returns a ClearCommand object.
     *
     * @return ClearCommand object
     */
    private static Command getClearCommand() {
        Command clearCommand = new ClearCommand();
        return clearCommand;
    }

    //@@author leeyp
    /**
     * Returns a HistoryCommand object.
     *
     * @return HistoryCommand object
     */
    private static Command getHistoryCommand(String description) {
        Command historyCommand = new HistoryCommand(description);
        return historyCommand;
    }

    /**
     * Returns a ByeCommand object.
     *
     * @return ByeCommand object
     */
    private static Command getByeCommand() {
        Command byeCommand = new ByeCommand();
        return byeCommand;
    }

    //@@author SimJJ96
    /**
     * Parses the description of quantity to integer.
     *
     * @param description quantity description
     * @return integer quantity
     * @throws EmptyDescriptionException if the description is empty
     * @throws InvalidQuantityException if the description is not a positive integer or exceed max quantity
     */
    public static int parseIntegerQuantity(String description)
            throws EmptyDescriptionException, InvalidQuantityException {
        if (description.isEmpty()) {
            throw new EmptyDescriptionException();
        }
        try {
            BigInteger bigIntegerQuantity = new BigInteger(description);
            BigInteger maxQuantity = BigInteger.valueOf(MAX_ALLOWABLE_QUANTITY);
            BigInteger zero = BigInteger.valueOf(0);
            if (bigIntegerQuantity.compareTo(maxQuantity) == GREATER) {
                throw new InvalidQuantityException("Sorry my friend, "
                        + "the quantity you have entered "
                        + "has exceed the maximum allowable quantity.");
            } else if (bigIntegerQuantity.compareTo(zero) < GREATER) {
                throw new InvalidQuantityException();
            }
            int quantityInteger = bigIntegerQuantity.intValue();
            return quantityInteger;
        } catch (NumberFormatException numberFormatException) {
            throw new InvalidQuantityException();
        }
    }

    /**
     * Parses the description of quantity to set limit integer.
     *
     * @param description set limit quantity description
     * @return set limit integer quantity
     * @throws EmptyDescriptionException if the description is empty
     * @throws InvalidSetLimitQuantityException if the description exceed the max quantity or less than 0
     */
    public static int parseSetLimitIntegerQuantity(String description)
            throws EmptyDescriptionException, InvalidSetLimitQuantityException {
        if (description.isEmpty()) {
            throw new EmptyDescriptionException();
        }
        try {
            BigInteger bigIntegerQuantity = new BigInteger(description);
            BigInteger maxQuantity = BigInteger.valueOf(MAX_ALLOWABLE_QUANTITY);
            BigInteger zero = BigInteger.valueOf(0);
            if (bigIntegerQuantity.compareTo(maxQuantity) == GREATER) {
                throw new InvalidSetLimitQuantityException("Sorry my friend, "
                        + "the quantity you have entered "
                        + "has exceed the maximum allowable quantity.");
            } else if (bigIntegerQuantity.compareTo(zero) < EQUAL_TO) {
                throw new InvalidSetLimitQuantityException();
            }
            int quantityInteger = bigIntegerQuantity.intValue();
            return quantityInteger;
        } catch (NumberFormatException numberFormatException) {
            throw new InvalidSetLimitQuantityException();
        }
    }
    //@author

}
