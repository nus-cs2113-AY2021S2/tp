package seedu.fridgefriend;

import java.util.ArrayList;
import java.util.Scanner;

import seedu.fridgefriend.command.Command;
import seedu.fridgefriend.food.Food;
import seedu.fridgefriend.utilities.Parser;

public class FridgeFriend {

    public static final ArrayList<Food> fridge = new ArrayList<>();
    private static boolean isExit = false;

    public static void main(String[] args) {
        printWelcomeMessage();
        Scanner in = new Scanner(System.in);
        run(in);
        printByeMessage();
    }

    private static void run(Scanner in) {
        while (!isExit) {
            try {
                String input = getUserInput(in);
                Command command = Parser.getCommand(input);
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
}