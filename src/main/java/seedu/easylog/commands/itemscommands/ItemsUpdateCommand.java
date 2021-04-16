package seedu.easylog.commands.itemscommands;

import seedu.easylog.common.Constants;
import seedu.easylog.exceptions.EmptyItemIndexException;
import seedu.easylog.exceptions.EmptyItemPriceException;
import seedu.easylog.exceptions.EmptyItemStockException;
import seedu.easylog.exceptions.InvalidItemIndexException;
import seedu.easylog.exceptions.InvalidItemPriceException;
import seedu.easylog.exceptions.InvalidItemStockException;
import seedu.easylog.exceptions.NonNumericOrIntegerItemStockException;
import seedu.easylog.exceptions.NonNumericItemPriceException;
import seedu.easylog.exceptions.NullItemPriceException;
import seedu.easylog.exceptions.NullItemStockException;
import seedu.easylog.exceptions.WrongItemFieldException;
import seedu.easylog.exceptions.WrongUpdateCommandException;
import seedu.easylog.exceptions.EmptyItemFieldException;
import seedu.easylog.exceptions.InvalidItemFieldException;
import seedu.easylog.exceptions.EmptyItemListException;
import seedu.easylog.exceptions.NullItemIndexException;
import seedu.easylog.exceptions.NullItemFieldException;
import seedu.easylog.model.ItemManager;


public class ItemsUpdateCommand extends ItemsCommand {

    /**
     * Updates a particular field of an item of interest in the system.
     *
     * @param extraDescription Any extra input from the user, this field should be empty
     *                         in order to execute an update command successfully
     * @param itemManager      item manager object which modifies items when necessary
     */
    public void execute(String extraDescription, ItemManager itemManager) throws WrongUpdateCommandException,
            WrongItemFieldException, EmptyItemIndexException, InvalidItemIndexException, EmptyItemPriceException,
            InvalidItemPriceException, NullItemPriceException, NullItemStockException, EmptyItemStockException,
            InvalidItemStockException, NonNumericOrIntegerItemStockException, NonNumericItemPriceException,
            EmptyItemFieldException, InvalidItemFieldException, EmptyItemListException {
        int itemListSize = itemManager.getSize();
        if (itemListSize == 0) {
            throw new EmptyItemListException();
        }
        if (!extraDescription.isEmpty()) {
            throw new WrongUpdateCommandException();
        }
        boolean stopAskingForItemIndex = false;
        String itemIndexInString = " ";
        while (!stopAskingForItemIndex) {
            ui.askForItemIndex();
            ItemsListCommand itemsListCommand = new ItemsListCommand();
            itemsListCommand.execute(itemManager); // Show item list to allow user to see the item index to update

            itemIndexInString = ui.askForUserInput();
            try {
                if (itemIndexInString == null) {
                    throw new NullItemIndexException();
                }
                if (itemIndexInString.equals("")) {
                    throw new EmptyItemIndexException();
                }
                int size = itemManager.getSize();
                double itemIndexInDouble = Double.parseDouble(itemIndexInString) - Constants.ARRAY_OFFSET;
                if (itemIndexInDouble < 0 || itemIndexInDouble >= size) {
                    throw new InvalidItemIndexException();
                }
                stopAskingForItemIndex = true;
            } catch (EmptyItemIndexException e) {
                ui.showEmptyItemIndexInput();
            } catch (InvalidItemIndexException | NumberFormatException e) {
                ui.showInvalidItemIndexInput();
            } catch (NullItemIndexException e) {
                ui.showNullItemIndex();
            }
        }
        String itemField;
        do {
            ui.askForItemFieldToBeUpdated();
            itemField = ui.askForUserInput();
            try {
                if (itemField == null) {
                    throw new NullItemFieldException();
                }
                if (itemField.equals("")) {
                    throw new EmptyItemFieldException();
                }
                if (!(itemField.equals("p") || itemField.equals("s"))) {
                    throw new InvalidItemFieldException();
                }
            } catch (EmptyItemFieldException e) {
                ui.showEmptyItemType();
            } catch (InvalidItemFieldException e) {
                ui.showInvalidItemType();
            } catch (NullItemFieldException e) {
                ui.showNullItemField();
            }
        } while (!(itemField.equals("p") || itemField.equals("s")));
        int itemIndex = Integer.parseInt(itemIndexInString) - Constants.ARRAY_OFFSET;
        itemsParser.processUpdateAttributeInput(itemField, itemIndex, itemManager);
    }
}
