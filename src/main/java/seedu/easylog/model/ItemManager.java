package seedu.easylog.model;

import seedu.easylog.common.Constants;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Manage item list manipulation commands.
 */
public class ItemManager {

    protected ArrayList<Item> itemList;
    protected ArrayList<Item> foundItemList = new ArrayList<>();

    public ItemManager() {
        this.itemList = new ArrayList<>();
    }

    /**
     * Adds item to the item list.
     *
     * @param item item to be added to the item list
     */
    public void addItem(Item item) {
        itemList.add(item);
    }

    /**
     * Gets the item list.
     *
     * @return The list of items in the system
     */
    public ArrayList<Item> getItemList() {
        return itemList;
    }

    /**
     * Gets the list of items in String format to be printed as output to the user.
     *
     * @return String format for the list of items to be printed
     */
    public String getItemListPrintFormat(ArrayList<Item> itemListToBePrint) {
        String itemsListOutput = "";

        for (int itemIndex = 0; itemIndex < itemListToBePrint.size(); itemIndex++) {
            itemsListOutput += (itemIndex + 1) + ". " + itemListToBePrint.get(itemIndex).getItemName()
                    + Constants.ITEM_NAME_AND_PRICE_SEPARATOR
                    + itemListToBePrint.get(itemIndex).getItemPrice() + Constants.ITEM_PRICE_AND_STOCK_SEPARATOR
                    + itemListToBePrint.get(itemIndex).getItemStock() + "\n";
        }
        return itemsListOutput;
    }

    /**
     * Removes a specific item from the system.
     */
    public void deleteItem(int index) {
        itemList.remove(index);
    }

    /**
     * Finds items by keyword.
     *
     * @param keyword keyword to be searched
     */
    public void findItem(String keyword) {
        for (int i = 0; i < getSize(); i++) {
            if (getItem(i).itemName.contains(keyword)) {
                foundItemList.add(getItem(i));
            }
        }
    }

    /**
     * get index of the item name in the inventory.
     *
     * @param itemName name of the item to get it's index.
     * @return index of the corresponding item name in the inventory.
     */
    public int getItemIndex(String itemName) {
        int itemIndex = 0;
        for (int i = 0; i < getSize(); ++i) {
            if (getItem(i).itemName.contains(itemName)) {
                itemIndex = i;
                break;
            }
        }
        return itemIndex;
    }

    /**
     * Gets the found items.
     *
     * @return list of found item(s) from itemList
     */
    public ArrayList<Item> getFoundItemList() {
        return foundItemList;
    }

    /**
     * Gets the number of relevant items after search.
     *
     * @return the size of foundItemList
     */
    public int getFoundSize() {
        return foundItemList.size();
    }

    /**
     * Gets the description of a specific item based on the given index.
     *
     * @return the description of the specific item
     */
    public Item getItem(int index) {
        return itemList.get(index);
    }

    /**
     * Gets the number of items in the system.
     *
     * @return the size of item list
     */
    public int getSize() {
        return itemList.size();
    }

    /**
     * Clears all items in the system.
     */
    public void clearItemList() {
        itemList.clear();
    }

    /**
     * Clears all found items in Found List.
     */
    public void clearFoundList() {
        foundItemList.clear();
    }

    /**
     * Gets the latest item added to the itemList.
     *
     * @return Latest item added to itemList
     */
    public Item getLatestItemAdded() {
        int index = getSize() - Constants.ARRAY_OFFSET;
        return getItem(index);
    }

    /**
     * Sets the price of an item specified by its index to
     * be the revised one.
     */
    public void setRevisedItemPrice(int itemIndex, BigDecimal revisedItemPrice) {
        Item itemToBeUpdated = getItem(itemIndex);
        itemToBeUpdated.setItemPrice(revisedItemPrice);
    }

    /**
     * Sets the stock of an item specified by its index to
     * be the revised one.
     */
    public void setRevisedItemStock(int itemIndex, int revisedItemStock) {
        Item itemToBeUpdated = getItem(itemIndex);
        itemToBeUpdated.setItemStock(revisedItemStock);
    }

    /**
     * Increments the item sales after an item is added to an order.
     */
    public void incrementItemSales(Item item, int newItemSales) {
        int currentItemSales = item.getItemSales();
        int updatedItemSales = currentItemSales + newItemSales;

        item.setItemSales(updatedItemSales);
    }

    /**
     * Gets the sales of the most popular item(s).
     *
     * @return sales of most popular item(s).
     */
    public int countSalesOfMostPopularItems() {
        int largestSales = 0;

        for (Item item : itemList) {
            if (item.getItemSales() > largestSales) {
                largestSales = item.getItemSales();
            }
        }

        return largestSales;
    }

    /**
     * Counts the number of most popular item(s).
     *
     * @return number of most popular item(s).
     */
    public int countNumberOfMostPopularItems() {
        int numberOfMostPopularItems = 0;
        int largestSales = countSalesOfMostPopularItems();

        if (largestSales == 0) {
            return numberOfMostPopularItems;
        }

        for (Item item : itemList) {
            if (item.getItemSales() == largestSales) {
                numberOfMostPopularItems++;
            }
        }

        return numberOfMostPopularItems;
    }

    /**
     * Gets the description of most popular item(s).
     *
     * @return description of most popular item(s).
     */
    public String getMostPopularItemDescriptions() {
        String mostPopularItemDescriptions = "";
        int numberOfMostPopularItems = countNumberOfMostPopularItems();
        int largestSales = countSalesOfMostPopularItems();
        int count = 0;

        if (numberOfMostPopularItems == 1) {
            for (Item item : itemList) {
                if (item.getItemSales() == largestSales) {
                    mostPopularItemDescriptions += item.itemName;
                }
            }
        }

        if (numberOfMostPopularItems > 1) {
            for (Item item : itemList) {
                if (item.getItemSales() == largestSales) {
                    if (count == 0) {
                        mostPopularItemDescriptions += item.itemName;
                    } else {
                        mostPopularItemDescriptions = mostPopularItemDescriptions + ", " + item.itemName;
                    }
                    count++;
                }
            }
        }

        return mostPopularItemDescriptions;
    }
}

