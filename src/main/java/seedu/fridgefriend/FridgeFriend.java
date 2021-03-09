package seedu.fridgefriend;

import seedu.fridgefriend.command.AddCommand;
import seedu.fridgefriend.command.Command;
import seedu.fridgefriend.command.ListCommand;
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
                printExceptionMessage(exception.getMessage());
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

    private static void printExceptionMessage(String exceptionMessage) {
        System.out.println(exceptionMessage);
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

        String[] words = input.trim().split("\\s+", LIMIT);
        if (words.length == LIMIT) {
            return words;
        } else {
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

        return foodDescription.trim().split("/c",LIMIT);
    }

    private static void processCommand(String[] parsedInput)
            throws EmptyDescriptionException, InvalidInputException {
        String command = parsedInput[COMMAND_WORD];
        String description = parsedInput[1];

        switch (command.toLowerCase()) {
        case "add":
            Command add = new AddCommand(parseFoodDescription(description));
            add.execute(fridge);
            break;
        case "list":
            Command list = new ListCommand(description);
            list.execute(fridge);
            break;
        case "bye":
            isBye = true;
            printByeMessage();
            break;
        default:
            throw new InvalidInputException();
        }
    }
}