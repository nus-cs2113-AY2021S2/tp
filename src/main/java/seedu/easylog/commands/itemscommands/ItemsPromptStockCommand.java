package seedu.easylog.commands.itemscommands;

import seedu.easylog.exceptions.EmptyItemStockException;
import seedu.easylog.exceptions.InvalidItemStockException;
import seedu.easylog.exceptions.NonNumericOrIntegerItemStockException;
import seedu.easylog.exceptions.NullItemStockException;

public class ItemsPromptStockCommand extends ItemsCommand {

    /**
     * Prompts the user for the item stock.
     *
     * @return item stock
     */
    public int execute() throws NullItemStockException, EmptyItemStockException, InvalidItemStockException,
            NonNumericOrIntegerItemStockException {
        ui.promptItemStock();

        String itemStockInString = ui.askForUserInput();

        int itemStock = itemsParser.itemStockInStringToIntegerFormat(itemStockInString);

        return itemStock;
    }
}