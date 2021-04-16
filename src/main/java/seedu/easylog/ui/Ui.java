package seedu.easylog.ui;

import seedu.easylog.common.Messages;
import seedu.easylog.model.Item;
import seedu.easylog.model.Order;

import java.util.Scanner;

/**
 * Handles ui related methods.
 */
public class Ui {

    public static final Scanner SCANNER = new Scanner(System.in);

    public String askForUserInput() {
        return SCANNER.nextLine().trim();
    }

    public void showGreeting() {
        System.out.print(Messages.MESSAGE_GREETING);
    }

    public void showExit() {
        System.out.print(Messages.MESSAGE_GOODBYE);
    }

    public void showHelp() {
        System.out.print(Messages.MESSAGE_SHOW_ALL_COMMANDS);
    }

    /**
     * Prints all commands related to items and brief descriptions of these commands.
     */
    public void showItemsHelp() {
        System.out.print(Messages.MESSAGE_SHOW_ITEMS_COMMANDS);
    }

    public void showInvalidCommand() {
        System.out.print(Messages.MESSAGE_INVALID_COMMAND);
    }

    /**
     * Show message for when item has been added into the inventory.
     * @param item item that was added into the inventory.
     */
    public void showAddItem(Item item) {
        System.out.print(Messages.MESSAGE_LINE);
        System.out.println(item.getAddItemMessage());
        System.out.print(Messages.MESSAGE_LINE);
    }

    /**
     * Prints a message to notify the user that there is no input item name.
     * This means that the user should complete the item name.
     */
    public void showItemEmptyName() {
        System.out.print(Messages.MESSAGE_EMPTY_ITEM_NAME);
    }

    /**
     * Prints a message to notify the user that there is no input customer name for this order.
     * This means that the user should complete the customer name.
     */
    public void showOrderEmptyCustomerName() {
        System.out.print(Messages.MESSAGE_EMPTY_ORDER_CUSTOMER_NAME);
    }

    /**
     * Prints a message to notify the user that there is no input order index.
     * This means the user should complete the order index of this order.
     */
    public void showOrderEmptyIndex() {
        System.out.print(Messages.MESSAGE_EMPTY_ORDER_INDEX);
    }


    /**
     * Prints a message to notify the user that there is no input order number.
     * This means the user should complete the order number.
     */
    public void showOrderEmptyNumber() {
        System.out.print(Messages.MESSAGE_EMPTY_ORDER_NUMBER);
    }

    /**
     * Prints a message to notify the user that the item has been successfully deleted.
     *
     * @param item an object to store item's information
     */
    public void showDeletedItem(Item item) {
        System.out.println(item.getDeleteItemMessage());
        System.out.print(Messages.MESSAGE_LINE);
    }

    /**
     * Prints a message to notify the user that there is no input item number.
     * This means the user should complete the index of the item.
     */
    public void showItemEmptyNumber() {
        System.out.print(Messages.MESSAGE_EMPTY_ITEM_NUMBER);
    }

    /**
     * Prints a message to notify the user that the input item number is not an integer.
     * This means the user should input an integer type item number.
     */
    public void showNonIntegerItemNumber() {
        System.out.print(Messages.MESSAGE_NON_INTEGER_ITEM_NUMBER);
    }

    /**
     * Prints a message to notify the user that the input item type is not valid.
     * This means the user should choose a valid type p or s.
     */
    public void showInvalidItemType() {
        System.out.print(Messages.MESSAGE_INVALID_UPDATE_ITEM_FIELD);
    }

    /**
     * Prints a message to notify the user that the input item type is not valid.
     * This means the user should choose a valid type p or s.
     */
    public void showEmptyItemType() {
        System.out.print(Messages.MESSAGE_EMPTY_UPDATE_ITEM_FIELD);
    }

    /**
     * Prints a message to notify the user that the input item number is either not a number or not an integer.
     * This means the user should check the item index and input again.
     */
    public void showNonIntegerOrNonNumericItemIndexForUpdate() {
        System.out.print(Messages.MESSAGE_NON_NUMERIC_OR_NON_INTEGER_ITEM_NUMBER_FOR_UPDATE);
    }

    /**
     * Prints the list of all items in the system.
     *
     * @param rawItemListOutput List of items in String format
     */
    public void showItemList(String rawItemListOutput) {
        if (rawItemListOutput.equals("")) {
            System.out.print(Messages.MESSAGE_EMPTY_ITEM_LIST);
        } else {
            System.out.print(Messages.MESSAGE_LIST_ITEMS);
            System.out.print(rawItemListOutput);
            System.out.print(Messages.MESSAGE_LINE);
        }
    }

    /**
     * Prints a message to notify the user that the item list is empty.
     */
    public void showEmptyItemList() {
        System.out.print(Messages.MESSAGE_EMPTY_ITEM_LIST);
    }


    /**
     * Prints the list of all orders in the system.
     * This includes each customer's name
     * followed by his or her items in the record.
     *
     * @param rawOrderListOutput List of orders in String format
     */
    public void showOrderList(String rawOrderListOutput) {
        if (rawOrderListOutput.equals("")) {
            System.out.print(Messages.MESSAGE_EMPTY_ORDER_LIST);
        } else {
            System.out.print(Messages.MESSAGE_LIST_ORDERS);
            System.out.print(rawOrderListOutput);
        }
    }

    /**
     * Prints all commands related to orders and brief descriptions of these commands.
     */
    public void showOrdersHelp() {
        System.out.print(Messages.MESSAGE_SHOW_ORDERS_RELATED_COMMANDS);
    }

    /**
     * Show message to tell user to input item index and item quantity to be added into the specific order.
     */
    public void showAddItemsToOrder() {
        System.out.print(Messages.MESSAGE_ADD_ITEMS_TO_ORDER);
    }

    /**
     * Prints a message to notify the user that the order has been successfully added.
     *
     * @param order an object to store order's information
     */
    public void showOrderAdded(Order order) {
        System.out.print(Messages.MESSAGE_LINE);
        System.out.println(order.getAddOrderMessage());
        System.out.print(Messages.MESSAGE_LINE);
    }

    /**
     * Prints a message to notify the user that the order has been successfully deleted.
     *
     * @param order an object to store order's information
     */
    public void showOrderDeleted(Order order) {
        System.out.print(Messages.MESSAGE_LINE);
        System.out.println(order.getDeleteOrderMessage());
        System.out.print(Messages.MESSAGE_LINE);
    }

    /**
     * Prints a message to notify the user that the input order number is out of range.
     * This means the user should input another order number.
     */
    public void showInvalidItemNumber() {
        System.out.print(Messages.MESSAGE_INVALID_ITEM_NUMBER);
    }

    /**
     * Prints a message to notify the user that the input order number is out of range.
     * This means the user should input another order number.
     */
    public void showInvalidItemIndexInput() {
        System.out.print(Messages.MESSAGE_INVALID_UPDATE_ITEM_INDEX);
    }

    /**
     * Prints a message to notify the user that the input order index is either not a number or not an integer.
     * This means the user should check and input order index again.
     */
    public void showNonIntegerOrNonNumericOrderIndex() {
        System.out.print(Messages.MESSAGE_NON_INTEGER_OR_NON_NUMERIC_ORDER_INDEX);
    }

    /**
     * Prints a message to notify the user that the input order number is out of range.
     * This means the user should input another order number.
     */
    public void showInvalidOrderNumber() {
        System.out.print(Messages.MESSAGE_INVALID_ORDER_NUMBER);
    }

    /**
     * Prints a message to notify the user that there is no single item in the system.
     * This means the user should not attempt to clear items.
     */
    public void showAlreadyClearedItemList() {
        System.out.print(Messages.MESSAGE_ALREADY_CLEARED_ITEM_LIST);
    }

    /**
     * Prints a message to notify the user that there is no single order in the system.
     * This means the user should not attempt to clear orders.
     */
    public void showAlreadyClearedOrderList() {
        System.out.print(Messages.MESSAGE_ALREADY_CLEARED_ORDER_LIST);
    }

    /**
     * Prints a message to notify the user that all the items are cleared successfully.
     */
    public void showClearedItemList() {
        System.out.print(Messages.MESSAGE_CLEAR_ITEM_LIST);
    }

    /**
     * Prints a message to notify the user that all the orders are cleared successfully.
     */
    public void showClearedOrderList() {
        System.out.print(Messages.MESSAGE_CLEAR_ORDER_LIST);
    }

    /**
     * Show message when user tried to input item not found in inventory into the order.
     *
     * @param itemIndexNotOffsetted item index that the user tried to enter into the order.
     */
    public void showItemNotFoundWhenAddingToOrder(String itemIndexNotOffsetted) {
        System.out.print(Messages.MESSAGE_LINE);
        System.out.println(itemIndexNotOffsetted + " does not exist. "
                + "Please try another valid item number until at least one item is added to the order.");
        System.out.print(Messages.MESSAGE_LINE);
    }

    /**
     * Prints a message to ask the user about the price of the item entered earlier.
     */
    public void promptItemPrice() {
        System.out.print(Messages.MESSAGE_PROMPT_ITEM_PRICE);
    }

    /**
     * Prints a message to notify the user that the input item price is invalid.
     * This means the user should input either 0 or a positive number
     * smaller than or equal to 1000000000
     */
    public void showInvalidItemPrice() {
        System.out.print(Messages.MESSAGE_SHOW_INVALID_ITEM_PRICE);
    }

    public void showInvalidRevisedItemPrice() {
        System.out.print(Messages.MESSAGE_SHOW_INVALID_REVISED_ITEM_PRICE);
    }


    public void showNonNumericInputForUpdate() {
        System.out.print(Messages.MESSAGE_NON_NUMERIC_INPUT_INDEX_FOR_UPDATE);
    }

    /**
     * Prints a message to notify the user that the input item index is null.
     * This means the user should input a non-null and valid item index.
     */
    public void showNullItemIndex() {
        System.out.print(Messages.MESSAGE_NULL_ITEM_INDEX);
    }

    /**
     * Prints a message to notify the user that the input item field is null.
     * This means the user should input a non-null and valid item field.
     */
    public void showNullItemField() {
        System.out.print(Messages.MESSAGE_NULL_ITEM_FIELD);
    }


    /**
     * Prints a message to notify the user that the input item price is null.
     * This means the user should input a non-null and valid item price.
     */
    public void showNullItemPrice() {
        System.out.print(Messages.MESSAGE_NULL_ITEM_PRICE);
    }

    /**
     * Prints a message to notify the user that the input item price is empty.
     * This means the user should input a non-empty and valid item price.
     */
    public void showEmptyItemPrice() {
        System.out.print(Messages.MESSAGE_EMPTY_ITEM_PRICE);
    }

    /**
     * Prints a message to notify the user that the input revised item stock is empty.
     * This means the user should input a non-empty and valid item stock.
     */
    public void showEmptyRevisedItemStock() {
        System.out.print(Messages.MESSAGE_EMPTY_REVISED_ITEM_STOCK);
    }

    /**
     * Prints a message to ask the user about the stock of the item entered earlier.
     */
    public void promptItemStock() {
        System.out.print(Messages.MESSAGE_PROMPT_ITEM_STOCK);
    }

    /**
     * Prints a message to notify the user that the input item stock is invalid.
     * This means the user should input either 0 or a positive integer number
     * smaller than or equal to 100000000.
     */
    public void showInvalidItemStock() {
        System.out.print(Messages.MESSAGE_SHOW_INVALID_ITEM_STOCK);
    }

    /**
     * Prints a message to notify the user that the input revised item stock is invalid.
     * This means the user should input either 0 or a positive integer number
     * smaller than or equal to 100000000.
     */
    public void showInvalidRevisedItemStock() {
        System.out.print(Messages.MESSAGE_SHOW_INVALID_REVISED_ITEM_STOCK);
    }

    /**
     * Prints a message to notify the user that the total item stock is more than 1000000000.
     * This means the user should input another valid number such that
     * total item stock is a positive integer smaller than or equal to 100000000.
     */
    public void showInvalidTotalItemStock() {
        System.out.print(Messages.MESSAGE_SHOW_INVALID_TOTAL_ITEM_STOCK);
    }

    /**
     * Prints a message to notify the user that the input item stock is null.
     * This means the user should input a non-null and valid item stock.
     */
    public void showNullItemStock() {
        System.out.print(Messages.MESSAGE_NULL_ITEM_STOCK);
    }

    /**
     * Prints a message to notify the user that the input item stock is empty.
     * This means the user should input a non-empty and valid item stock.
     */
    public void showEmptyItemStock() {
        System.out.print(Messages.MESSAGE_EMPTY_ITEM_STOCK);
    }

    /**
     * Prints a message to notify the user that the items clear command is entered wrongly.
     * This means the user should input "items clear" exactly if he / she
     * really wants to execute a clear command for all items.
     */
    public void showWrongItemsClearCommand() {
        System.out.print(Messages.MESSAGE_WRONG_ITEMS_CLEAR_COMMAND);
    }

    /**
     * Prints a message to notify the user that the items stats command is entered wrongly.
     * This means the user should input "items stats" exactly if he / she
     * really wants to use this feature to see the most popular item(s).
     */
    public void showWrongItemsStatsCommand() {
        System.out.print(Messages.MESSAGE_WRONG_ITEMS_STATS_COMMAND);
    }

    /**
     * Prints a message to notify the user that the items update command is entered wrongly.
     * This means the user should input "items update" exactly if he / she
     * really wants to execute an update command for any item of interest.
     */
    public void showWrongUpdateCommand() {
        System.out.print(Messages.MESSAGE_WRONG_UPDATE_COMMAND);
    }

    /**
     * Prints a message to notify the user that the orders clear command is entered wrongly.
     * This means the user should input "orders clear" exactly if he / she
     * really wants to execute a clear command for all orders.
     */
    public void showWrongOrdersClearCommand() {
        System.out.print(Messages.MESSAGE_WRONG_ORDERS_CLEAR_COMMAND);
    }

    /**
     * Prints a message to ask the user for the index of the item
     * in order for a field of the item to be updated later.
     */
    public void askForItemIndex() {
        System.out.print(Messages.MESSAGE_ASK_FOR_ITEM_INDEX);
    }

    /**
     * Prints a message to ask the user for the field of the item to be updated.
     */
    public void askForItemFieldToBeUpdated() {
        System.out.print(Messages.MESSAGE_ASK_FOR_ITEM_FIELD_TO_BE_UPDATED);
    }

    /**
     * Prints a message to ask the user about the revised item price.
     */
    public void askForRevisedItemPrice() {
        System.out.print(Messages.MESSAGE_ASK_FOR_REVISED_ITEM_PRICE);
    }

    /**
     * Prints a message to notify the user the item field is updated successfully.
     */
    public void showUpdateItemPrice(Item item) {
        System.out.print(Messages.MESSAGE_LINE);
        System.out.print(item.getUpdatedPriceMessage());
        System.out.print(Messages.MESSAGE_LINE);
    }

    /**
     * Prints a message to notify the user that the item field entered is wrong.
     * This means the user should input either "p" for (item) price
     * or s for (item) stock.
     */
    public void showWrongItemField() {
        System.out.print(Messages.MESSAGE_WRONG_ITEM_FIELD_COMMAND);
    }

    /**
     * Prints a message to notify the user that the input item index is invalid.
     * This means the user should input a valid number corresponding to the index
     * in the item list.
     */
    public void showInvalidItemIndex() {
        System.out.print(Messages.MESSAGE_INVALID_ITEM_INDEX);
    }

    /**
     * Prints a message to notify the user that the input item index is empty.
     * This means the user should input a non-empty and
     * valid number corresponding to the index in the item list.
     */
    public void showEmptyItemIndex() {
        System.out.print(Messages.MESSAGE_EMPTY_ITEM_INDEX);
    }

    /**
     * Prints a message to inform the users about the total price of their order.
     */
    public void showOrderTotalPrice(Order order) {
        System.out.print(Messages.MESSAGE_LINE);
        System.out.println(order.getOrderTotalPriceMessage(order));
        System.out.print(Messages.MESSAGE_LINE);
    }

    /**
     * Prints a message to inform the users about the shipping status of their order.
     */
    public void showOrderStatus(Order order) {
        System.out.print(Messages.MESSAGE_LINE);
        System.out.println(order.getOrderStatusMessage());
    }

    /**
     * Prints a message to ask the user about the revised item stock.
     */
    public void askForRevisedItemStock() {
        System.out.print(Messages.MESSAGE_ASK_FOR_REVISED_ITEM_STOCK);
    }

    /**
     * Prints a message to notify the user the item field is updated successfully.
     */
    public void showUpdateItemStock(Item item) {
        System.out.print(Messages.MESSAGE_LINE);
        System.out.print(item.getUpdatedStockMessage());
        System.out.print(Messages.MESSAGE_LINE);
    }

    public void showNotEnoughStock() {
        System.out.print(Messages.MESSAGE_NOT_ENOUGH_STOCK);
    }

    public void showItemAndStockAddedToOrder(String itemName, int stockAdded) {
        System.out.print(Messages.MESSAGE_LINE);
        System.out.print(itemName + " and stock of " + stockAdded + " added to the order.\n" + Messages.MESSAGE_LINE);
    }

    /**
     * Show message to tell user that wrong format is inputted while trying to add item details into the order.
     */
    public void showInvalidWhileAddingItemToOrder() {
        System.out.print(Messages.MESSAGE_INVALID_WHILE_ADDING_ITEM_TO_ORDER);
    }

    public void showItemNotFound() {
        System.out.print(Messages.MESSAGE_ITEM_NOT_FOUND);
    }

    public void showFoundList(String rawItemListOutput) {
        if (rawItemListOutput.equals("")) {
            System.out.print(Messages.MESSAGE_EMPTY_ITEM_LIST);
        } else {
            System.out.print(Messages.MESSAGE_FOUNDLIST_ITEMS);
            System.out.print(rawItemListOutput);
            System.out.print(Messages.MESSAGE_LINE);
        }
    }

    public void showFoundOrderList(String rawOrderListOutput) {
        if (rawOrderListOutput.equals("")) {
            System.out.print(Messages.MESSAGE_EMPTY_ORDER_LIST);
        } else {
            System.out.print(Messages.MESSAGE_FOUND_LIST_ORDERS);
            System.out.print(rawOrderListOutput);
        }
    }

    /**
     * Prints a message to notify the user that the input customer name is not found.
     * This means this order does not exist in the order list.
     */
    public void showOrderNotFound() {
        System.out.print(Messages.MESSAGE_ORDER_NOT_FOUND);
    }

    public void showSaveDataLoading() {
        System.out.print(Messages.MESSAGE_SAVE_DATA_LOADING);
    }

    public void showLookingForSaveData() {
        System.out.print(Messages.MESSAGE_LOOKING_FOR_SAVE_DATA);
    }

    public void showSaveDataLoaded() {
        System.out.print(Messages.MESSAGE_SAVE_DATA_LOADED);
    }

    public void showSaveDataCreated() {
        System.out.print(Messages.MESSAGE_SAVE_DATA_CREATED);
    }

    public void showSaveDataSaved() {
        System.out.print(Messages.MESSAGE_SAVE_DATA_SAVED);
    }

    public void showNoSaveDataFound() {
        System.out.print(Messages.MESSAGE_SAVE_DATA_NOT_FOUND);
    }

    /**
     * Shows which line in the file causes and error when trying to process it.
     *
     * @param fileLine Line of the file with the format error.
     */
    public void showInvalidFileInputLine(int fileLine) {
        System.out.println(Messages.MESSAGE_INVALID_FILE_INPUT_LINE + fileLine);
    }

    public void showErrorWhileSaving() {
        System.out.print(Messages.MESSAGE_ERROR_WHILE_SAVING);
    }

    public void showGeneratingReceipt(String customerName) {
        System.out.println("Generating receipt for customer: " + customerName);
    }

    public void showReceiptGenerated(String customerName) {
        System.out.println("Receipt generated for customer: " + customerName);
        System.out.println("Do note that the receipt file can only be accessed when you exit the app.");
        System.out.print(Messages.MESSAGE_LINE);
    }

    public void showErrorGeneratingReceipt(String customerName) {
        System.out.println("Error while generating receipt for customer: " + customerName);
    }

    /**
     * Prints a message to show the most popular item
     * and suggests the user to stock up if not enough.
     *
     * @param itemDescription description of the most popular item
     */
    public void showStatisticsForMostPopularItem(String itemDescription) {
        System.out.print(Messages.MESSAGE_SHOW_MOST_POPULAR_ITEM + itemDescription
                + Messages.SHOW_CONSIDER_STOCK_UP_IF_MOST_POPULAR_ITEM_IS_NOT_ENOUGH);
    }

    /**
     * Prints a message to show the most popular items
     * and suggests the user to stock up if not enough.
     *
     * @param itemDescriptions descriptions of the most popular items
     */
    public void showStatisticsForMostPopularItems(String itemDescriptions) {
        System.out.print(Messages.MESSAGE_SHOW_MOST_POPULAR_ITEMS + itemDescriptions
                + Messages.SHOW_CONSIDER_STOCK_UP_IF_MOST_POPULAR_ITEMS_ARE_NOT_ENOUGH);
    }

    /**
     * Prints a message to show that no tips regarding items can be given.
     * This means the user has not sold any single item yet.
     */
    public void showNoItemsTipsCanBeGiven() {
        System.out.print(Messages.MESSAGE_SHOW_NO_ITEMS_TIPS_CAN_BE_GIVEN);
    }

    public String showReceiptHeader() {
        return (Messages.MESSAGE_RECEIPT_HEADER + "\n");
    }

    /**
     * Prints a message to notify the user that the input item name is null.
     * This means the user should check the input again and retry.
     */
    public void showNullItemName() {
        System.out.print(Messages.MESSAGE_NULL_ITEM_NAME);
    }

    /**
     * Prints a message to notify the user that the format
     * while adding item price and stock is incorrect.
     * This means the user should check the input again and retry.
     */
    public void showIncorrectNumberOfItemPriceAndStockInput() {
        System.out.print(Messages.MESSAGE_INCORRECT_ITEM_PRICE_AND_STOCK_FORMAT);
    }

    /**
     * Prints a message to ask the item price and stock from the user
     * and show the correct input format to the user.
     * This means the user should follow the instruction and input the item price and stock.
     */
    public void askForItemPriceAndStock() {
        System.out.print(Messages.MESSAGE_ASK_FOR_ITEM_PRICE_AND_STOCK);
    }

    /**
     * Prints a message to notify the user that there is no item index.
     * This means the user should complete the item information.
     */
    public void showEmptyItemIndexInput() {
        System.out.print(Messages.MESSAGE_EMPTY_UPDATE_ITEM_INDEX);
    }

    /**
     * Prints a message to notify the user that there are no input item price and stock.
     * This means the user should complete the item information.
     */
    public void showEmptyItemPriceAndStockInput() {
        System.out.print(Messages.MESSAGE_EMPTY_ITEM_PRICE_AND_STOCK);
    }

    /**
     * Prints a message to notify the user that the input item price and stock are null.
     * This means the user should check the input again and retry.
     */
    public void showNullItemPriceAndStockInput() {
        System.out.print(Messages.MESSAGE_NULL_ITEM_PRICE_AND_STOCK);
    }

    /**
     * Prints a message to notify the user that the input item price is non-numeric.
     * This means the user should check the input price again and retry.
     */
    public void showNonNumericItemPrice() {
        System.out.print(Messages.MESSAGE_NON_NUMERIC_ITEM_PRICE);
    }

    /**
     * Prints a message to notify the user that the input item stock is either not a number or not an integer.
     * This means the user should check the input stock again.
     */
    public void showNonNumericOrIntegerItemStock() {
        System.out.print(Messages.MESSAGE_NON_NUMERIC_OR_INTEGER_ITEM_STOCK);
    }

    /**
     * Prints a message to notify the user that the input item stock is non-numeric.
     * This means the user should check the input stock again and retry.
     */
    public void showNonNumericItemStockInput() {
        System.out.println(Messages.MESSAGE_NON_NUMERIC_OR_INTEGER_ITEM_STOCK);
    }

    /**
     * Prints a message to notify the user that the input item name is too long.
     * This means the user should input an alternative item name within 30 characters including spaces.
     */
    public void showItemNameTooLong() {
        System.out.print(Messages.MESSAGE_ITEM_NAME_TOO_LONG);
    }

    /**
     * Prints a message to notify the user that the order list is empty.
     */
    public void showEmptyOrderList() {
        System.out.print(Messages.MESSAGE_EMPTY_ORDER_LIST_TO_DELETE);
    }

    /**
     * Prints a message to notify the user that the input customer name is too long.
     * This means the user should input an alternative customer name within 30 characters including spaces.
     */
    public void showCustomerNameTooLong() {
        System.out.print(Messages.MESSAGE_CUSTOMER_NAME_TOO_LONG);
    }

    public void showInvalidInventory() {
        System.out.print(Messages.MESSAGE_INVALID_INVENTORY);
    }

    public void showUnknownErrorOccurred() {
        System.out.print(Messages.MESSAGE_UNKNOWN_ERROR_OCCURRED);
    }
}
