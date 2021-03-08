package seedu.duke;

import seedu.duke.exception.EmptyFoodDescriptionException;
import seedu.duke.exception.EmptyInputException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Duke {

    private static final List<String> foodList = new ArrayList<>();

    private static final int COMMAND_WORD = 0;

    private static boolean isBye = false;

    public static void main(String[] args) {

        printWelcomeMessage();

        String input;
        Scanner in = new Scanner(System.in);

        while (!isBye) {
            try {
                input = getUserInput(in);
                parseInput(input);
            } catch (Exception exception) {
                printErrorMessage(exception);
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

    private static void addFoodIntoList(String foodDescription) {
        foodList.add(foodDescription);
    }

    private static void checkFoodDescription(String foodDescription) throws EmptyFoodDescriptionException {
        if (foodDescription.isEmpty()) {
            throw new EmptyFoodDescriptionException();
        }
    }

    private static void printAddFoodMessage(String foodDescription) {
        System.out.println("Great! I have added [" + foodDescription + "] into your fridge.\n");
    }

    private static void printErrorMessage(Exception exception) {
        if (exception instanceof EmptyInputException) {
            System.out.println("Sorry my friend, please give a valid input.\n");
        } else if (exception instanceof EmptyFoodDescriptionException) {
            System.out.println("Sorry my friend, the description cannot be empty.\n");
        }
    }

    //@@author SimJJ96-reused
    /*Reused from https://github.com/SimJJ96/ip/blob/master/src/
            main/java/duke/Parser.java with minor modification*/
    /**
     * Parses input into command and description and execute.
     *
     * @param input user input string
     * @throws EmptyInputException if the initial input is empty
     * @throws EmptyFoodDescriptionException if the description of food is empty
     */
    public static void parseInput(String input) throws EmptyInputException,
            EmptyFoodDescriptionException {

        if (input.isEmpty()) {
            throw new EmptyInputException();
        }

        String[] words = input.trim().split("\\s+", 2);
        String command = words[COMMAND_WORD];
        String foodDescription = input.replaceFirst(command,"").trim();

        switch (command.toLowerCase()) {
        case "add":
            checkFoodDescription(foodDescription);
            addFoodIntoList(foodDescription);
            printAddFoodMessage(foodDescription);
            break;
        case "bye":
            isBye = true;
            printByeMessage();
            break;
        default:
            System.out.println(command + " " + foodDescription + "\n");
            break;
        }
    }
    //@author
}