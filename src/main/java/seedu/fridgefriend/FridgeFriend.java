package seedu.fridgefriend;

import java.util.ArrayList;

import seedu.fridgefriend.command.Command;
import seedu.fridgefriend.exception.InvalidInputException;
import seedu.fridgefriend.food.Food;
import seedu.fridgefriend.utilities.Parser;
import seedu.fridgefriend.utilities.Ui;

public class FridgeFriend {

    public static final ArrayList<Food> fridge = new ArrayList<>();
    private static boolean isExit = false;

    public static void main(String[] args) {
        Ui.printWelcomeMessage();
        run();
        Ui.printByeMessage();
    }

    private static void run() {
        new Ui();
        while (!isExit) {
            try {
                String input = Ui.getUserInput();
                Command command = Parser.getCommand(input);
                executeCommand(command);
                isExit = command.isExit();
            } catch (Exception exception) {
                Ui.printExceptionMessage(exception);
            }
        }
    }

    private static void executeCommand(Command command) throws InvalidInputException {
        command.execute(fridge);
    }
}