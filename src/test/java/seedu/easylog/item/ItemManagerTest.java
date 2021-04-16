package seedu.easylog.item;

import org.junit.jupiter.api.Test;
import seedu.easylog.model.Item;
import seedu.easylog.model.ItemManager;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemManagerTest {

    @Test
    public void testGetItemListPrintFormat() {

        BigDecimal priceOne = new BigDecimal("100.00");
        BigDecimal priceTwo = new BigDecimal("36.00");
        Item itemOne = new Item("PS5",priceOne,5);
        Item itemTwo = new Item("MP3", priceTwo,5);
        ItemManager itemManager = new ItemManager();
        itemManager.addItem(itemOne);
        itemManager.addItem(itemTwo);

        assertEquals("1. PS5, S$100.00, 5\n" + "2. MP3, S$36.00, 5\n",
                itemManager.getItemListPrintFormat(itemManager.getItemList()));
    }

}
