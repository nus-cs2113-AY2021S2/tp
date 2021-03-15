package seedu.fridgefriend;

import seedu.fridgefriend.command.Command;
import seedu.fridgefriend.exception.InvalidInputException;
import seedu.fridgefriend.food.Fridge;
import seedu.fridgefriend.utilities.Parser;
import seedu.fridgefriend.utilities.Ui;

public class FridgeFriend {

    private static boolean isExit = false;

    public FridgeFriend() {
        new Ui();
        new Fridge();
    }

    public static void main(String[] args) {
        Ui.printWelcomeMessage();
        run();
        Ui.printByeMessage();
    }

    private static void run() {
        while (!isExit) {
            try {
                String input = Ui.getNextLine();
                Command command = Parser.getCommand(input);
                executeCommand(command);
                isExit = command.isExit();
            } catch (Exception exception) {
                Ui.printExceptionMessage(exception);
            }
        }
    }

    private static void executeCommand(Command command) throws InvalidInputException {
        command.execute();
    }
}