package seedu.fridgefriend;

import seedu.fridgefriend.command.Command;
import seedu.fridgefriend.exception.FoodNameNotFoundException;
import seedu.fridgefriend.exception.InvalidIndexException;
import seedu.fridgefriend.exception.InvalidInputException;
import seedu.fridgefriend.exception.InvalidQuantityException;
import seedu.fridgefriend.exception.RepetitiveFoodIdentifierException;
import seedu.fridgefriend.food.Fridge;
import seedu.fridgefriend.utilities.LoggingHandler;
import seedu.fridgefriend.utilities.Parser;
import seedu.fridgefriend.utilities.Storage;
import seedu.fridgefriend.utilities.Ui;

/**
 * FridgeFriend is an app for managing food in the fridge, optimised for use via a Command Line Interface (CLI).
 * If you can type fast, `FridgeFriend` can track your cold or frozen groceries faster and easier than any other apps.
 * It is written in Java, and has more than 1.5kLoC.
 * 
 * @author Hu Wen Qi
 * @author Kim Joohwan
 * @author Lee Yang Peng
 * @author Ryan Kwok
 * @author Sing Jing Jie
 * @version 1.0
 */
public class FridgeFriend {

    private static boolean isExit = false;
    public static Fridge fridge = new Fridge();

    public FridgeFriend() {
        new Ui();
        new LoggingHandler();
        LoggingHandler.logInfo("FridgeFriend application initialised.");
        new Storage();
    }

    public static void main(String[] args) {
        Ui.printWelcomeMessage();
        Storage.load(fridge);
        run();
        Storage.save(fridge);
        Ui.printByeMessage();
    }

    private static void run() {
        LoggingHandler.logInfo("Main programme loop started.");
        while (!isExit) {
            try {
                String input = Ui.getNextLine();
                Command command = Parser.getCommand(input);
                executeCommand(command);
                isExit = command.isExit();
            } catch (Exception exception) {
                Ui.printExceptionMessage(exception);
                LoggingHandler.logInfo("Error found.", exception);
            }
        }
        LoggingHandler.logInfo("Main programme loop exited.");
    }

    private static void executeCommand(Command command) throws InvalidInputException,
            InvalidIndexException, RepetitiveFoodIdentifierException,
            InvalidQuantityException, FoodNameNotFoundException {
        command.setData(fridge);
        command.execute();
    }
}