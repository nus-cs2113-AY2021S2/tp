package seedu.fridgefriend;

import seedu.fridgefriend.command.Command;
import seedu.fridgefriend.exception.FoodNameNotFoundException;
import seedu.fridgefriend.exception.InvalidFoodCategoryException;
import seedu.fridgefriend.exception.InvalidFoodLocationException;
import seedu.fridgefriend.exception.InvalidInputException;
import seedu.fridgefriend.exception.InvalidQuantityException;
import seedu.fridgefriend.exception.RepetitiveFoodIdentifierException;
import seedu.fridgefriend.food.Fridge;
import seedu.fridgefriend.utilities.LoggingHandler;
import seedu.fridgefriend.utilities.Parser;
import seedu.fridgefriend.utilities.Storage;
import seedu.fridgefriend.utilities.Ui;

/**
 * `FridgeFriend` is an app for managing food in the fridge that is optimised for use via a 
 * Command Line Interface (CLI) and is targeted at new homeowners who cook. If you can type fast, 
 * `FridgeFriend` can track your cold or frozen groceries faster and easier than any other apps.
 * It is written in Java, and has more than 6000 lines of code.
 * 
 * @author Hu Wen Qi
 * @author Kim Joohwan
 * @author Lee Yang Peng
 * @author Ryan Kwok
 * @author Sing Jing Jie
 * @version 2.1
 */
public class FridgeFriend {

    private static boolean isExit = false;
    public static Fridge fridge = new Fridge();

    //@@author kwokyto
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
            } catch (RuntimeException runtimeException) {
                safeExit();
            } catch (Exception exception) {
                Ui.printExceptionMessage(exception);
                LoggingHandler.logInfo("Error found.", exception);
            }
            Storage.save(fridge);
        }
        LoggingHandler.logInfo("Main programme loop exited.");
    }

    private static void executeCommand(Command command) throws InvalidInputException,
            RepetitiveFoodIdentifierException, InvalidQuantityException,
            FoodNameNotFoundException, InvalidFoodCategoryException, InvalidFoodLocationException {
        command.setData(fridge);
        command.execute();
    }

    //@@author SimJJ96
    private static void safeExit() {
        String interruptMessage = "Application has been interrupted.\n"
                + "Exiting application...";
        Ui.printMessage(interruptMessage);
        System.exit(0);
    }

}