package seedu.easylog.common;

public class Messages {

    public static final String MESSAGE_LINE = "____________________________________________________________\n";
    public static final String MESSAGE_LIST_ITEMS = MESSAGE_LINE
            + "Here is the list of items.\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_FOUNDLIST_ITEMS = MESSAGE_LINE
            + "Here is the list of relevant items found.\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_LIST_ORDERS = MESSAGE_LINE
            + "Here is the list of orders.\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_FOUND_LIST_ORDERS = MESSAGE_LINE
            + "Here is the list of relevant orders found.\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_ADD_ITEMS_TO_ORDER = "Input the item to be added to this order.\n"
            + "Input format: <item_index> <item_quantity>\n"
            + "Type <stop> to stop adding items to order,"
            + " else continue entering items in the same format.\n"
            + "Do note that you need at least 1 item in the order for <stop> to work.\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_SHOW_ALL_COMMANDS = MESSAGE_LINE
            + "General Options:\n"
            + "  1. items                          Show items-related commands\n"
            + "  2. items add <item_name>          Add an item\n"
            + "  3. items list                     List all items\n"
            + "  4. items delete <item_index>      Delete an item\n"
            + "  5. items clear                    Empty all items\n"
            + "  6. items find <item_name>         Find an item\n"
            + "  7. items update                   Update the detail of an item\n"
            + "  8. items stats                    Discover the most popular item(s)\n"
            + "  9. orders                         Show orders-related commands\n"
            + "  10. orders add <order_name>       Add an order\n"
            + "  11. orders list                   List all orders\n"
            + "  12. orders delete <order_index>   Delete an order\n"
            + "  13. orders clear                  Empty all orders\n"
            + "  14. orders price <order_index>    Check the total price of an order\n"
            + "  15. orders done <order_index>     Update the status of an order\n"
            + "  16. orders find <order_name>      Find an order\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_GREETING = MESSAGE_LINE
            + "Hello! I'm easyLog!\n"
            + "What can I do for you? Enter help to view commands.\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_GOODBYE = MESSAGE_LINE
            + "Bye. Thanks for using easyLog!\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_INVALID_COMMAND = MESSAGE_LINE
            + "OOPS!!! I'm sorry! I don't know what that means.\n"
            + "Please input again! :)\n"
            + "Type <help> to see the available command and their format.\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_EMPTY_ITEM_NAME = MESSAGE_LINE
            + "OOPS!!! The item name is missing!\n"
            + "Please complete the item information! :)\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_NULL_ITEM_NAME = MESSAGE_LINE
            + "OOPS!!! The item name is null!\n"
            + "Please retry adding the item name! :)\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_ASK_FOR_ITEM_PRICE_AND_STOCK = MESSAGE_LINE
            + "Please input item price and stock.\n"
            + "Input format: <item_price> <item_quantity>.\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_INCORRECT_ITEM_PRICE_AND_STOCK_FORMAT = MESSAGE_LINE
            + "Invalid input format while adding the item price and stock.\n"
            + "Please enter only two parameters separated by exactly one empty space.\n";
    public static final String MESSAGE_EMPTY_ITEM_PRICE_AND_STOCK = MESSAGE_LINE
            + "Empty item price and stock.\n";
    public static final String MESSAGE_NULL_ITEM_PRICE_AND_STOCK = MESSAGE_LINE
            + "Null item price and stock.\n";
    public static final String MESSAGE_NON_NUMERIC_OR_INTEGER_ITEM_PRICE = MESSAGE_LINE
            + "Item price entered is either non-numeric or exceed double range in Java.\n";
    public static final String MESSAGE_NON_NUMERIC_ITEM_PRICE = MESSAGE_LINE
            + "Non-numeric item price.\n";
    public static final String MESSAGE_NON_NUMERIC_OR_INTEGER_ITEM_STOCK = MESSAGE_LINE
            + "The item stock is either not a number or out of the int value range in Java.\n";
    public static final String MESSAGE_EMPTY_ORDER_CUSTOMER_NAME = MESSAGE_LINE
            + "The customer name is missing.\n"
            + "Please complete the order information then try orders add command again.\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_EMPTY_ORDER_NUMBER = MESSAGE_LINE
            + "OOPS!!! The order number is missing!\n"
            + "Please complete the order information! :)\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_INVALID_ITEM_NUMBER = MESSAGE_LINE
            + "OOPS!!! The item number is invalid!\n"
            + "Please input the item information again! :)\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_INVALID_UPDATE_ITEM_INDEX = MESSAGE_LINE
            + "Invalid index number.\n";
    public static final String MESSAGE_INVALID_ORDER_NUMBER = MESSAGE_LINE
            + "OOPS!!! The order index is out of range!\n"
            + "Please input the order index again! :)\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_EMPTY_ITEM_NUMBER = MESSAGE_LINE
            + "OOPS!!! The item number is missing!\n"
            + "Please complete the item information! :)\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_SHOW_ORDERS_RELATED_COMMANDS = MESSAGE_LINE
            + "Orders-Related Options:\n"
            + "  1. orders add <order_name>        Add an order\n"
            + "  2. orders list                    List all orders\n"
            + "  3. orders delete <order_index>    Delete an order\n"
            + "  4. orders clear                   Empty all orders\n"
            + "  5. orders price <order_index>     Check the total price of an order\n"
            + "  6. orders done <order_index>      Update the status of an order\n"
            + "  7. orders find <order_name>       Find an order\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_SHOW_ITEMS_COMMANDS = MESSAGE_LINE
            + "Items-Related Options:\n"
            + "  1. items add <item_name>          Add an item\n"
            + "  2. items list                     List all items\n"
            + "  3. items delete <item_index>      Delete an item\n"
            + "  4. items clear                    Empty all items\n"
            + "  5. items find <item_name>         Find an item\n"
            + "  6. items update                   Update the detail of an item\n"
            + "  7. items stats                    Discover the most popular item(s)\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_ALREADY_CLEARED_ITEM_LIST = MESSAGE_LINE
            + "OOPS!!! There is no single item which can be cleared right now!\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_ALREADY_CLEARED_ORDER_LIST = MESSAGE_LINE
            + "OOPS!!! There is no single order which can be cleared right now!\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_CLEAR_ITEM_LIST = MESSAGE_LINE
            + "Done! I just cleared all items for you.\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_CLEAR_ORDER_LIST = MESSAGE_LINE
            + "Done! I just cleared all orders for you.\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_EMPTY_ITEM_LIST = MESSAGE_LINE
            + "There is no item in the system at the moment.\n"
            + "Please add at least one item to the system first.\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_EMPTY_ORDER_LIST = MESSAGE_LINE
            + "There is no order at the moment.\n"
            + "Please add at least one order to the system first.\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_EMPTY_ORDER_INDEX = MESSAGE_LINE
            + "OOPS!!! The order index is missing!\n"
            + "Please complete the order index! :)\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_INDENTATION = "    ";
    public static final String MESSAGE_NON_INTEGER_OR_NON_NUMERIC_ORDER_INDEX = MESSAGE_LINE
            + "OOPS!!! The input order index "
            + "is either not a number or out of int value range in Java.\n"
            + "Please input the order index again! :)\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_NON_INTEGER_ITEM_NUMBER = MESSAGE_LINE
            + "OOPS!!! The input item information "
            + "is not an integer number!\n"
            + "Please input the item information again! :)\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_EMPTY_UPDATE_ITEM_FIELD = MESSAGE_LINE
            + "Empty item field.\n ";
    public static final String MESSAGE_INVALID_UPDATE_ITEM_FIELD = MESSAGE_LINE
            + "Invalid input item field.\n";
    public static final String MESSAGE_NON_NUMERIC_OR_NON_INTEGER_ITEM_NUMBER_FOR_UPDATE = MESSAGE_LINE
            + "The item index is either not a number or out of int value range in Java.\n";
    public static final String MESSAGE_PROMPT_ITEM_PRICE = MESSAGE_LINE
            + "Please enter the price of the item.\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_SHOW_INVALID_ITEM_PRICE = MESSAGE_LINE
            + "The item price is invalid!\n"
            + "Note: The price to be entered should be either 0 or a positive number "
            + "smaller than or equal to S$1000000000.\n"
            + "Also, The system supports a maximum scale of 2 (number of digits right after the decimal).\n"
            + "If you enter any number having a scale greater than 2, it will be automatically rounded up "
            + "to a number having an exact scale of 2.\n";
    public static final String MESSAGE_SHOW_INVALID_REVISED_ITEM_PRICE = MESSAGE_LINE
            + "Invalid item price.\n";
    public static final String MESSAGE_NULL_ITEM_PRICE = MESSAGE_LINE
            + "OOPS!!! The input item price is null!\n"
            + "Please input again and complete the item price! :)\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_NULL_ITEM_INDEX = MESSAGE_LINE
            + "OOPS!!! The input item index is null!\n"
            + "Please input again and complete the item index! :)\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_NULL_ITEM_FIELD = MESSAGE_LINE
            + "OOPS!!! The input item field is null!\n"
            + "Please input again and complete the item field! :)\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_EMPTY_ITEM_PRICE = MESSAGE_LINE
            + "Empty item price.\n";
    public static final String MESSAGE_EMPTY_REVISED_ITEM_STOCK = MESSAGE_LINE
            + "Empty item stock.\n";
    public static final String MESSAGE_NON_NUMERIC_INPUT_INDEX_FOR_UPDATE = MESSAGE_LINE
            + "Non-numeric item index.\n";
    public static final String MESSAGE_PROMPT_ITEM_STOCK = MESSAGE_LINE
            + "Please enter the stock of the item.\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_SHOW_INVALID_ITEM_STOCK = MESSAGE_LINE
            + "The item stock is invalid!\n"
            + "Note: The stock to be entered should be a positive integer number "
            + "smaller than or equal to 100000000\n"
            + "(The warehouse cannot store more than one hundred million items.)\n";
    public static final String MESSAGE_SHOW_INVALID_REVISED_ITEM_STOCK = MESSAGE_LINE
            + "Invalid item stock.\n";
    public static final String MESSAGE_SHOW_INVALID_TOTAL_ITEM_STOCK = MESSAGE_LINE
            + "OOPS!!! The total item stock is more than 1000000000!\n"
            + "Please input again and give a valid item stock! :)\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_NULL_ITEM_STOCK = MESSAGE_LINE
            + "OOPS!!! The input item stock is null!\n"
            + "Please input again and give a valid item stock! :)\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_EMPTY_ITEM_STOCK = MESSAGE_LINE
            + "OOPS!!! The input item stock is empty!\n"
            + "Please input again and complete the item stock! :)\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_WRONG_ITEMS_CLEAR_COMMAND = MESSAGE_LINE
            + "OOPS!!! I'm sorry! I don't know what that means.\n"
            + "Do you mean \"items clear\"?\n"
            + "Alternatively, see \"items\" or \" help\" for more information.\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_WRONG_ITEMS_STATS_COMMAND = MESSAGE_LINE
            + "OOPS!!! I'm sorry! I don't know what that means.\n"
            + "Do you mean \"items stats\"?\n"
            + "Alternatively, see \"items\" or \" help\" for more information.\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_WRONG_UPDATE_COMMAND = MESSAGE_LINE
            + "OOPS!!! I'm sorry! I don't know what that means.\n"
            + "Do you mean \"items update\"?\n"
            + "Alternatively, see \"items\" or \" help\" for more information.\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_WRONG_ORDERS_CLEAR_COMMAND = MESSAGE_LINE
            + "OOPS!!! I'm sorry! I don't know what that means.\n"
            + "Do you mean \"orders clear\"?\n"
            + "Alternatively, see \"orders\" or \" help\" for more information.\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_ASK_FOR_ITEM_INDEX = MESSAGE_LINE
            + "Below is the exhaustive list for all items.\n"
            + "May I know which item should be updated?\n"
            + "Please input the index of the item of interest only.\n";
    public static final String MESSAGE_ASK_FOR_ITEM_FIELD_TO_BE_UPDATED = MESSAGE_LINE
            + "What would you like to update, price or stock? (p/s)\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_ASK_FOR_REVISED_ITEM_PRICE = MESSAGE_LINE
            + "What is the revised item price?\n"
            + "Enter the same price if you no longer want to update the item price.\n";
    public static final String MESSAGE_WRONG_ITEM_FIELD_COMMAND = MESSAGE_LINE
            + "OOPS!!! I'm sorry! I don't know what that means.\n"
            + "Please input either \"p\" for (item) price or s for (item) stock.\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_INVALID_ITEM_INDEX = MESSAGE_LINE
            + "OOPS!!! The item index is invalid!\n"
            + "Please input again and give a valid item index! :)\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_EMPTY_ITEM_INDEX = MESSAGE_LINE
            + "OOPS!!! The item index is empty!\n"
            + "Please input again and complete the item index! :)\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_EMPTY_UPDATE_ITEM_INDEX = MESSAGE_LINE
            + "Empty item index.\n";
    public static final String MESSAGE_ASK_FOR_REVISED_ITEM_STOCK = MESSAGE_LINE
            + "What is the revised item stock? Enter the same stock if you no longer want to update the item stock.\n";
    public static final String MESSAGE_NOT_ENOUGH_STOCK = MESSAGE_LINE
            + "Not enough stock to be added into the order.\n"
            + "Please retry and type valid stock number.\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_INVALID_WHILE_ADDING_ITEM_TO_ORDER = MESSAGE_LINE
            + "Invalid input format while adding items to order.\n"
            + "Note that <item_index> and <item_quantity> needs to be whole numbers or integers.\n"
            + "Please retry adding items to the order.\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_ITEM_NOT_FOUND = MESSAGE_LINE
            + "Sorry! No relevant item is found in the warehouse.\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_ORDER_NOT_FOUND = MESSAGE_LINE
            + "Sorry! No relevant order is found.\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_SAVE_DATA_LOADING = "Loading save data.\n";
    public static final String MESSAGE_LOOKING_FOR_SAVE_DATA = "Looking for save data.\n";
    public static final String MESSAGE_SAVE_DATA_LOADED = "Save data loaded.\n" + MESSAGE_LINE;
    public static final String MESSAGE_SAVE_DATA_CREATED = MESSAGE_LINE
            + "Save data created as there is no existing save data\n";
    public static final String MESSAGE_SAVE_DATA_SAVED = MESSAGE_LINE + "Save data saved.\n";
    public static final String MESSAGE_SAVE_DATA_NOT_FOUND = "Save data not found.\n" + MESSAGE_LINE;
    public static final String MESSAGE_INVALID_FILE_INPUT_LINE = "Invalid line from save file at line : ";
    public static final String MESSAGE_ERROR_WHILE_SAVING = "Error while saving. Save file may or may not be "
            + "saved correctly\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_SHOW_MOST_POPULAR_ITEM = MESSAGE_LINE + "The most popular item is ";
    public static final String MESSAGE_SHOW_MOST_POPULAR_ITEMS = MESSAGE_LINE + "The most popular items are ";
    public static final String SHOW_CONSIDER_STOCK_UP_IF_MOST_POPULAR_ITEM_IS_NOT_ENOUGH = ".\nPlease consider stocking"
            + " it up if it is not enough :)\n"
            + MESSAGE_LINE;
    public static final String SHOW_CONSIDER_STOCK_UP_IF_MOST_POPULAR_ITEMS_ARE_NOT_ENOUGH = ".\nPlease consider "
            + "stocking them up if they are not enough :)\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_SHOW_NO_ITEMS_TIPS_CAN_BE_GIVEN = MESSAGE_LINE
            + "No item-related tips can be given.\n"
            + "As you have not sold any single item yet.\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_RECEIPT_HEADER = MESSAGE_LINE + "Order details as shown below\n";
    public static final String MESSAGE_ITEM_NAME_TOO_LONG = MESSAGE_LINE
            + "Item name inputted is too lengthy.\n"
            + "Note that the item name length limit is 30 characters including spaces.\n"
            + "Please try items add <item_name> again if you wish to add an item.\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_EMPTY_ORDER_LIST_TO_DELETE = MESSAGE_LINE
            + "There is no order at the moment.\n"
            + "Please add at least one order to the system first.\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_CUSTOMER_NAME_TOO_LONG = MESSAGE_LINE
            + "Customer name inputted is too lengthy.\n"
            + "Note that the customer name length limit is 30 characters including spaces.\n"
            + "Please try orders add <customer_name> again if you wish to add an order.\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_INVALID_INVENTORY = MESSAGE_LINE
            + "All items in inventory have stock 0.\n"
            + "Use <items update> feature first to update the stocks of the item\n"
            + "in the inventory before continuing to add an order.\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_UNKNOWN_ERROR_OCCURRED = MESSAGE_LINE
            + "Unknown error has occurred while using easyLog.\n"
            + "Kindly follow command format using <help> to prevent such errors.\n"
            + "Please restart command from the beginning to try again.\n"
            + MESSAGE_LINE;
}

