package seedu.easylog.commands.itemscommands;

import seedu.easylog.common.Constants;
import seedu.easylog.exceptions.EmptyItemNameException;
import seedu.easylog.exceptions.EmptyItemStockException;
import seedu.easylog.exceptions.InvalidItemStockException;
import seedu.easylog.exceptions.InvalidTotalItemStockException;
import seedu.easylog.exceptions.NonNumericOrIntegerItemStockException;
import seedu.easylog.exceptions.NonNumericItemPriceException;
import seedu.easylog.exceptions.NullItemNameException;
import seedu.easylog.exceptions.NullItemStockException;
import seedu.easylog.exceptions.ItemNameTooLongException;
import seedu.easylog.model.Item;
import seedu.easylog.model.ItemManager;

public class ItemsAddCommand extends ItemsCommand {
    /**
     * Adds an item to the item list.
     *
     * @param itemDescription description of an item
     * @param itemManager     item manager
     */
    public void execute(String itemDescription, ItemManager itemManager)
            throws EmptyItemNameException, NonNumericOrIntegerItemStockException, NonNumericItemPriceException,
            InvalidTotalItemStockException, NullItemNameException, NullItemStockException, EmptyItemStockException,
            InvalidItemStockException, ItemNameTooLongException {
        if (itemDescription == null) {
            throw new NullItemNameException();
        }

        if (itemDescription.equals("")) {
            throw new EmptyItemNameException();
        }

        if (itemDescription.length() > Constants.ITEM_NAME_LENGTH_LIMIT) {
            throw new ItemNameTooLongException();
        }

        Item item = itemsParser.promptAndProcessItemPriceAndStock(itemDescription);
        assert itemManager != null;
        itemManager.addItem(item);

        assert item != null;
        assert itemManager.getLatestItemAdded().equals(item);
        ui.showAddItem(item);
    }
}
