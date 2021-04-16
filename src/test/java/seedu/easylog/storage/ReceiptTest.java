package seedu.easylog.storage;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReceiptTest {

    @Test
    public void setReceiptCounterTest() {
        Receipt receipt = new Receipt();
        int testReceiptCount = 5;

        receipt.setReceiptCounter(testReceiptCount);

        assertEquals(testReceiptCount, Receipt.receiptCounter);
    }
}
