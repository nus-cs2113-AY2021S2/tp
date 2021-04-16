package seedu.easylog.parser;

import seedu.easylog.commands.itemscommands.ItemsAddCommand;
import seedu.easylog.commands.itemscommands.ItemsClearCommand;
import seedu.easylog.commands.itemscommands.ItemsDeleteCommand;
import seedu.easylog.commands.itemscommands.ItemsFindCommand;
import seedu.easylog.commands.itemscommands.ItemsListCommand;
import seedu.easylog.commands.itemscommands.ItemsPromptPriceCommand;
import seedu.easylog.commands.itemscommands.ItemsPromptStockCommand;
import seedu.easylog.commands.itemscommands.ItemsStatisticsCommand;
import seedu.easylog.commands.itemscommands.ItemsUpdateCommand;
import seedu.easylog.commands.itemscommands.ItemsHelpCommand;
import seedu.easylog.common.Constants;
import seedu.easylog.exceptions.EmptyItemFieldException;
import seedu.easylog.exceptions.EmptyItemIndexException;
import seedu.easylog.exceptions.EmptyItemListException;
import seedu.easylog.exceptions.EmptyItemNameException;
import seedu.easylog.exceptions.EmptyItemPriceAndStockInputException;
import seedu.easylog.exceptions.EmptyItemPriceException;
import seedu.easylog.exceptions.EmptyItemStockException;
import seedu.easylog.exceptions.EmptyNumberException;
import seedu.easylog.exceptions.IncorrectNumberOfItemPriceAndStockInputException;
import seedu.easylog.exceptions.InvalidItemFieldException;
import seedu.easylog.exceptions.InvalidItemIndexException;
import seedu.easylog.exceptions.InvalidItemPriceException;
import seedu.easylog.exceptions.InvalidItemStockException;
import seedu.easylog.exceptions.InvalidNumberException;
import seedu.easylog.exceptions.InvalidTotalItemStockException;
import seedu.easylog.exceptions.ItemListAlreadyClearedException;
import seedu.easylog.exceptions.ItemNotFoundException;
import seedu.easylog.exceptions.NoItemsStatisticsCanBeGivenException;
import seedu.easylog.exceptions.NonNumericOrIntegerItemStockException;
import seedu.easylog.exceptions.NonNumericItemPriceException;
import seedu.easylog.exceptions.NullItemNameException;
import seedu.easylog.exceptions.NullItemPriceAndStockInputException;
import seedu.easylog.exceptions.NullItemPriceException;
import seedu.easylog.exceptions.NullItemStockException;
import seedu.easylog.exceptions.WrongItemFieldException;
import seedu.easylog.exceptions.WrongItemsClearCommandException;
import seedu.easylog.exceptions.WrongItemsStatsCommandException;
import seedu.easylog.exceptions.WrongUpdateCommandException;
import seedu.easylog.exceptions.ItemNameTooLongException;
import seedu.easylog.model.Item;
import seedu.easylog.model.ItemManager;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Process items related input.
 */
public class ItemsParser extends Parser {

    /**
     * Process items-related input from user and executes the relevant items-related commands.
     *
     * @param itemsInput raw input related to items.
     * @param itemManager manipulates inventory.
     */
    public static void processItemsInput(String itemsInput, ItemManager itemManager) {
        String[] splitItemsArg = splitCommandWordAndArgs(itemsInput);
        String itemsType = splitItemsArg[0];
        String itemsArg = splitItemsArg[1];

        switch (itemsType) {
        case (Constants.COMMAND_ADD):
            try {
                new ItemsAddCommand().execute(itemsArg, itemManager);
            } catch (EmptyItemNameException e) {
                ui.showItemEmptyName();
            } catch (ItemNameTooLongException e) {
                ui.showItemNameTooLong();
            } catch (NonNumericOrIntegerItemStockException e) {
                ui.showNonNumericOrIntegerItemStock();
            } catch (NonNumericItemPriceException e) {
                ui.showNonNumericItemPrice();
            } catch (InvalidTotalItemStockException e) {
                ui.showInvalidTotalItemStock();
            } catch (NullItemNameException e) {
                ui.showNullItemName();
            } catch (NullItemStockException e) {
                ui.showNullItemStock();
            } catch (EmptyItemStockException e) {
                ui.showEmptyItemStock();
            } catch (InvalidItemStockException e) {
                ui.showInvalidItemStock();
            }
            break;
        case (Constants.COMMAND_DELETE):
            try {
                new ItemsDeleteCommand().execute(itemsArg, itemManager);
            } catch (EmptyNumberException e) {
                ui.showItemEmptyNumber();
            } catch (InvalidNumberException e) {
                ui.showInvalidItemNumber();
            } catch (NumberFormatException e) {
                ui.showNonIntegerItemNumber();
            }
            break;
        case (Constants.COMMAND_LIST):
            new ItemsListCommand().execute(itemManager);
            break;
        case (Constants.COMMAND_CLEAR):
            try {
                new ItemsClearCommand().execute(itemsArg, itemManager);
            } catch (ItemListAlreadyClearedException e) {
                ui.showAlreadyClearedItemList();
            } catch (WrongItemsClearCommandException e) {
                ui.showWrongItemsClearCommand();
            }
            break;
        case (Constants.COMMAND_UPDATE):
            try {
                new ItemsUpdateCommand().execute(itemsArg, itemManager);
            } catch (WrongUpdateCommandException e) {
                ui.showWrongUpdateCommand();
            } catch (EmptyItemListException e) {
                ui.showEmptyItemList();
            } catch (WrongItemFieldException e) {
                ui.showWrongItemField();
            } catch (InvalidItemIndexException e) {
                ui.showInvalidItemIndex();
            } catch (EmptyItemIndexException e) {
                ui.showEmptyItemIndex();
            } catch (EmptyItemPriceException e) {
                ui.showEmptyItemPrice();
            } catch (NullItemPriceException e) {
                ui.showNullItemPrice();
            } catch (NumberFormatException e) {
                ui.showNonNumericInputForUpdate();
            } catch (InvalidItemPriceException e) {
                ui.showInvalidRevisedItemPrice();
            } catch (InvalidItemStockException e) {
                ui.showInvalidRevisedItemStock();
            } catch (EmptyItemStockException e) {
                ui.showEmptyRevisedItemStock();
            } catch (NullItemStockException e) {
                ui.showNullItemStock();
            } catch (NonNumericItemPriceException e) {
                ui.showNonNumericItemPrice();
            } catch (NonNumericOrIntegerItemStockException e) {
                ui.showNonNumericItemStockInput();
            } catch (EmptyItemFieldException e) {
                ui.showEmptyItemType();
            } catch (InvalidItemFieldException e) {
                ui.showInvalidItemType();
            }
            break;
        case (Constants.COMMAND_FIND):
            try {
                new ItemsFindCommand().execute(itemsArg, itemManager);
            } catch (EmptyItemNameException e) {
                ui.showItemEmptyName();
            } catch (ItemNotFoundException e) {
                ui.showItemNotFound();
            }
            break;
        case (Constants.COMMAND_STATISTICS):
            try {
                new ItemsStatisticsCommand().execute(itemsArg, itemManager);
            } catch (NoItemsStatisticsCanBeGivenException e) {
                ui.showNoItemsTipsCanBeGiven();
            } catch (WrongItemsStatsCommandException e) {
                ui.showWrongItemsStatsCommand();
            }
            break;
        default:
            logging.writeWarningLevelLog("User inputted invalid items-related command.");
            new ItemsHelpCommand().execute();
            logging.writeInfoLevelLog("Items-related command shown and printed on the console.");
        }

    }

    /**
     * Process the amount of stock input in string.
     *
     * @param stockInString the amount of stocks in string
     * @return the amount of stocks in integer
     */
    public int processStockInput(String stockInString) {
        int endIndex = stockInString.indexOf(" ");
        if (endIndex != -1) {
            stockInString = stockInString.substring(0, endIndex);
        }
        return Integer.parseInt(stockInString); // returns stock input in integer
    }

    /**
     * Process the updates of an item.
     *
     * @param updateInput the type of update
     * @param itemIndex   the index of item to be updated
     * @param itemManager item manager
     */
    public void processUpdateAttributeInput(String updateInput, int itemIndex, ItemManager itemManager) {
        if (updateInput.equals("p")) {
            boolean stopAskingPrice = false;
            BigDecimal revisedItemPrice = new BigDecimal(Constants.INVALID_ITEM_PRICE);
            while (!stopAskingPrice) {
                ui.askForRevisedItemPrice();
                try {
                    ItemsPromptPriceCommand itemsPromptPriceCommand = new ItemsPromptPriceCommand();
                    revisedItemPrice = itemsPromptPriceCommand.execute();
                    stopAskingPrice = true;
                } catch (NullItemPriceException e) {
                    ui.showNullItemPrice();
                } catch (EmptyItemPriceException e) {
                    ui.showEmptyItemPrice();
                } catch (InvalidItemPriceException e) {
                    ui.showInvalidRevisedItemPrice();
                } catch (NonNumericItemPriceException e) {
                    ui.showNonNumericItemPrice();
                }
            }
            itemManager.setRevisedItemPrice(itemIndex, revisedItemPrice);
            ui.showUpdateItemPrice(itemManager.getItem(itemIndex));
        } else if (updateInput.equals("s")) {
            boolean stopAskingStock = false;
            int revisedStock = Constants.INVALID_ITEM_STOCK;
            while (!stopAskingStock) {
                ui.askForRevisedItemStock();
                try {
                    ItemsPromptStockCommand itemsPromptStockCommand = new ItemsPromptStockCommand();
                    revisedStock = itemsPromptStockCommand.execute();
                    stopAskingStock = true;
                } catch (NullItemStockException e) {
                    ui.showNullItemStock();
                } catch (EmptyItemStockException e) {
                    ui.showEmptyRevisedItemStock();
                } catch (InvalidItemStockException e) {
                    ui.showInvalidRevisedItemStock();
                } catch (NonNumericOrIntegerItemStockException e) {
                    ui.showNonNumericOrIntegerItemStock();
                }
            }
            itemManager.setRevisedItemStock(itemIndex, revisedStock);
            ui.showUpdateItemStock(itemManager.getItem(itemIndex));
        }
    }

    /**
     * Prompts the user for the item price and stock for the item that they want to enter into the inventory.
     * Processes the input price and stock that the user has inputted.
     * Then creates the item object for the item that they want to enter into the inventory.
     *
     * @param itemDescription name of the item to be inputted into the inventory.
     * @return Item object with the relevant attributes/details that the user has inputted.
     */
    public Item promptAndProcessItemPriceAndStock(String itemDescription) {
        BigDecimal itemPrice = null;
        int itemStock = 0;
        boolean stopAskingUserForItemPriceAndStockInput = false;

        while (!stopAskingUserForItemPriceAndStockInput) {
            ui.askForItemPriceAndStock();
            String itemPriceAndStockInput = ui.askForUserInput();

            try {
                if (itemPriceAndStockInput == null) {
                    throw new NullItemPriceAndStockInputException();
                }

                if (itemPriceAndStockInput.equals("")) {
                    throw new EmptyItemPriceAndStockInputException();
                }

                String[] splitInput = itemPriceAndStockInput.split(" ");

                if (splitInput.length != Constants.NUMBER_OF_ITEM_FIELDS) {
                    throw new IncorrectNumberOfItemPriceAndStockInputException();
                }

                String itemPriceInString = splitInput[0];
                String itemStockInString = splitInput[1];

                itemPrice = itemPriceInStringToBigDecimalFormat(itemPriceInString);
                itemPrice = itemPrice.setScale(Constants.PRICING_SCALE, RoundingMode.HALF_EVEN);
                itemStock = itemStockInStringToIntegerFormat(itemStockInString);
                stopAskingUserForItemPriceAndStockInput = true;
            } catch (NullItemPriceException e) {
                ui.showNullItemPrice();
            } catch (EmptyItemPriceException e) {
                ui.showEmptyItemPrice();
            } catch (NonNumericItemPriceException e) {
                ui.showNonNumericItemPrice();
            } catch (InvalidItemPriceException e) {
                ui.showInvalidItemPrice();
            } catch (NullItemStockException e) {
                ui.showNullItemStock();
            } catch (EmptyItemStockException e) {
                ui.showEmptyItemStock();
            } catch (NonNumericOrIntegerItemStockException e) {
                ui.showNonNumericOrIntegerItemStock();
            } catch (InvalidItemStockException e) {
                ui.showInvalidItemStock();
            } catch (IncorrectNumberOfItemPriceAndStockInputException e) {
                ui.showIncorrectNumberOfItemPriceAndStockInput();
            } catch (EmptyItemPriceAndStockInputException e) {
                ui.showEmptyItemPriceAndStockInput();
            } catch (NullItemPriceAndStockInputException e) {
                ui.showNullItemPriceAndStockInput();
            }
        }

        return new Item(itemDescription, itemPrice, itemStock);
    }

    /**
     * Convert the item price in string inputted by user to BigDecimal type.
     *
     * @param itemPriceInString item price in string inputted by user
     * @return item price inputted by user in BigDecimal type.
     * @throws NullItemPriceException user inputted null.
     * @throws EmptyItemPriceException user did not input any item price.
     * @throws NonNumericItemPriceException user did not input valid price for the item e.g., not integer or double.
     * @throws InvalidItemPriceException user inputted negative price or more than the limit.
     */
    public BigDecimal itemPriceInStringToBigDecimalFormat(String itemPriceInString) throws NullItemPriceException,
            EmptyItemPriceException, NonNumericItemPriceException, InvalidItemPriceException {
        if (itemPriceInString == null) {
            throw new NullItemPriceException();
        }

        if (itemPriceInString.equals("")) {
            throw new EmptyItemPriceException();
        }

        try {
            double itemPriceInDouble = Double.parseDouble(itemPriceInString);
            if (itemPriceInDouble < Constants.MINIMUM_ITEM_PRICE || itemPriceInDouble > Constants.MAXIMUM_ITEM_PRICE) {
                throw new InvalidItemPriceException();
            }
        } catch (NumberFormatException e) {
            throw new InvalidItemPriceException();
        }

        return new BigDecimal(itemPriceInString);
    }

    /**
     * Convert the item stock in string to int type.
     *
     * @param itemStockInString item stock in string inputted by the user.
     * @return item stock inputted by user in int type.
     * @throws NullItemStockException user entered null for item stock.
     * @throws EmptyItemStockException user did not enter any item stock.
     * @throws NonNumericOrIntegerItemStockException user entered non integer as item stock.
     * @throws InvalidItemStockException user inputted negative stock or more than the limit.
     */
    public int itemStockInStringToIntegerFormat(String itemStockInString) throws NullItemStockException,
            EmptyItemStockException, NonNumericOrIntegerItemStockException, InvalidItemStockException {
        if (itemStockInString == null) {
            throw new NullItemStockException();
        }

        if (itemStockInString.equals("")) {
            throw new EmptyItemStockException();
        }

        try {
            double itemStockInDouble = Double.parseDouble(itemStockInString);
            if (itemStockInDouble < Constants.MINIMUM_ITEM_STOCK
                    || itemStockInDouble > Constants.MAXIMUM_ITEM_STOCK) {
                throw new InvalidItemStockException();
            }
            Integer.parseInt(itemStockInString);
        } catch (NumberFormatException e) {
            throw new InvalidItemStockException();
        }

        return Integer.parseInt(itemStockInString);
    }
}
