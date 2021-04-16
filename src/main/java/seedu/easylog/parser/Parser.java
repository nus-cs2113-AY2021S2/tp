package seedu.easylog.parser;

import seedu.easylog.commands.ExitCommand;
import seedu.easylog.commands.HelpCommand;
import seedu.easylog.commands.itemscommands.ItemsAddFromFileCommand;
import seedu.easylog.commands.orderscommands.OrdersAddFromFileCommand;
import seedu.easylog.common.Constants;
import seedu.easylog.exceptions.InvalidFileInputException;
import seedu.easylog.exceptions.NoItemsStatisticsCanBeGivenException;
import seedu.easylog.model.ItemManager;
import seedu.easylog.model.OrderManager;
import seedu.easylog.storage.Logging;
import seedu.easylog.storage.Receipt;
import seedu.easylog.ui.Ui;

import java.io.IOException;

/**
 * Process raw user input.
 */
public class Parser {

    public static Receipt receipt = new Receipt();
    public static Ui ui = new Ui();
    public static Logging logging = new Logging();

    /**
     * Splits the input to process the command, word and arguments.
     *
     * @param rawUserInput the input from user
     * @return the splitted command, word and arguments
     */
    public static String[] splitCommandWordAndArgs(String rawUserInput) {
        logging.writeInfoLevelLog("Splitting user input to command type and arguments.");
        String[] splitCommand = rawUserInput.split(" ", 2);
        return splitCommand.length == 2 ? splitCommand : new String[]{splitCommand[0], ""};
    }

    /**
     * Processes the user input.
     *
     * @param rawUserInput the input from user
     * @param itemManager  item manager
     * @param orderManager order manager
     * @throws IOException Exception when there is invalid input
     */
    public void processUserInput(String rawUserInput, ItemManager itemManager, OrderManager orderManager)
            throws IOException {
        logging.writeInfoLevelLog("Beginning to process user input.");
        String[] commandTypeAndParams = splitCommandWordAndArgs(rawUserInput);
        String commandType = commandTypeAndParams[0];
        String commandArgs = commandTypeAndParams[1];
        switch (commandType) {
        case (Constants.COMMAND_HELP):
            logging.writeInfoLevelLog("Help command inputted by user to be executed.");
            new HelpCommand().execute();
            logging.writeInfoLevelLog("Help command has been successfully executed.");
            break;
        case (Constants.COMMAND_EXIT):
            logging.writeInfoLevelLog("Exit command inputted by user to be executed.");
            new ExitCommand().execute(itemManager, orderManager);
            break;
        case (Constants.COMMAND_ITEMS):
            logging.writeInfoLevelLog("Processing items-related command inputted by user.");
            ItemsParser.processItemsInput(commandArgs, itemManager);
            break;
        case (Constants.COMMAND_ORDERS):
            logging.writeInfoLevelLog("Processing orders-related command inputted by user.");
            OrdersParser.processOrdersInput(commandArgs, itemManager, orderManager);
            break;
        default:
            logging.writeWarningLevelLog("Invalid command has been inputted by user.");
            ui.showInvalidCommand();
        }
    }

    /**
     * Processes the input to file.
     *
     * @param commandType  the type of command
     * @param commandArgs  the argument of command
     * @param itemManager  item manager
     * @param orderManager order manager
     * @throws InvalidFileInputException Exception when there is invalid file input
     */
    public void processFileInput(String commandType, String commandArgs, ItemManager itemManager,
                                 OrderManager orderManager) throws InvalidFileInputException {
        switch (commandType) {
        case (Constants.COMMAND_ITEMS):
            new ItemsAddFromFileCommand().execute(commandArgs, itemManager);
            break;
        case (Constants.COMMAND_ORDERS):
            new OrdersAddFromFileCommand().execute(commandArgs, itemManager, orderManager);
            break;
        case (Constants.COMMAND_RECEIPT_COUNTER):
            receipt.setReceiptCounter(Integer.parseInt(commandArgs));
            break;
        default:
            throw new InvalidFileInputException();
        }
    }
}
