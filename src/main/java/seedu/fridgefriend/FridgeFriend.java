package seedu.fridgefriend;

import seedu.fridgefriend.command.AddCommand;
import seedu.fridgefriend.command.Command;
import seedu.fridgefriend.command.ListCommand;
import seedu.fridgefriend.command.RemoveCommand;
import seedu.fridgefriend.command.SearchCommand;
import seedu.fridgefriend.exception.EmptyDescriptionException;
import seedu.fridgefriend.exception.InvalidInputException;
import seedu.fridgefriend.food.Food;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        if (exception instanceof IndexOutOfBoundsException) {
            System.out.println(exception.getMessage());
        } else if (exception instanceof NumberFormatException) {
            System.out.println(exception.getMessage());
        } else if (exception instanceof InvalidInputException) {
            System.out.println(exception.getMessage());
        } else if (exception instanceof EmptyDescriptionException) {
            System.out.println(exception.getMessage());
        }
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
     * Parses description into food category and name.
     *
     * @param foodDescription the string in the required format of food description
     * @return String array consist of food category and name
     * @throws EmptyDescriptionException if the description is empty
     */
    public static String[] parseFoodDescription(String foodDescription) throws EmptyDescriptionException {
        if (foodDescription.isEmpty()) {
            throw new EmptyDescriptionException();
        }
        //remove trailing whitespaces and parse food description into two separated by category tag
        return foodDescription.trim().split("/c",LIMIT);
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
            throws EmptyDescriptionException, InvalidInputException {
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

    private static void proceedToAdd(String description) throws EmptyDescriptionException {
        Command add = new AddCommand(parseFoodDescription(description));
        add.execute(fridge);
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