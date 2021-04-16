package seedu.easylog.commands.itemscommands;

import org.junit.jupiter.api.Test;
import seedu.easylog.model.Item;
import seedu.easylog.model.ItemManager;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemsAddFromFileCommandTest {

    @Test
    public void executeItemsAddFromFileTest() {
        BigDecimal testItemPrice = new BigDecimal("599.00");
        int testItemStock = 10;
        int testItemSales = 10;
        String testItemName = "PS5";
        Item testItem = new Item(testItemName, testItemPrice, testItemStock);
        testItem.setItemSales(testItemSales);

        String inputFromFile = "599.00 10 10 PS5";
        ItemManager itemManager = new ItemManager();
        ItemsAddFromFileCommand itemsAddFromFileCommand = new ItemsAddFromFileCommand();
        itemsAddFromFileCommand.execute(inputFromFile, itemManager);
        Item itemAdded = itemManager.getLatestItemAdded();

        assertEquals(testItem.getItemPrice(), itemAdded.getItemPrice());
        assertEquals(testItem.getItemStock(), itemAdded.getItemStock());
        assertEquals(testItem.getItemSales(), itemAdded.getItemSales());
        assertEquals(testItem.getItemName(), itemAdded.getItemName());
    }
}
