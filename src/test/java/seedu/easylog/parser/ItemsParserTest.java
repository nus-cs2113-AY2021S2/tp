package seedu.easylog.parser;

import org.junit.jupiter.api.Test;
import seedu.easylog.exceptions.EmptyItemPriceException;
import seedu.easylog.exceptions.EmptyItemStockException;
import seedu.easylog.exceptions.InvalidItemPriceException;
import seedu.easylog.exceptions.InvalidItemStockException;
import seedu.easylog.exceptions.NullItemPriceException;
import seedu.easylog.exceptions.NullItemStockException;
import seedu.easylog.exceptions.NonNumericItemPriceException;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ItemsParserTest {

    ItemsParser itemsParser = new ItemsParser();

    @Test
    public void processPriceInputTest() throws NonNumericItemPriceException, EmptyItemPriceException,
            InvalidItemPriceException, NullItemPriceException {
        String testInput = "599.00";
        assertEquals(new BigDecimal(testInput), itemsParser.itemPriceInStringToBigDecimalFormat(testInput));
    }

    @Test
    public void processStockInputTest() {
        String testInput = "10";
        assertEquals(10, itemsParser.processStockInput(testInput));
    }

    @Test
    public void itemStockInStringToIntegerFormat_nullInput_failure() {
        assertThrows(NullItemStockException.class, () -> {
            itemsParser.itemStockInStringToIntegerFormat(null);
        });
    }

    @Test
    public void itemStockInStringToIntegerFormat_emptyInput_failure() {
        assertThrows(EmptyItemStockException.class, () -> {
            itemsParser.itemStockInStringToIntegerFormat("");
        });
    }

    @Test
    public void itemStockInStringToIntegerFormat_outOfRangeInput_failure() {
        assertThrows(InvalidItemStockException.class, () -> {
            itemsParser.itemStockInStringToIntegerFormat("-1");
        });

        assertThrows(InvalidItemStockException.class, () -> {
            itemsParser.itemStockInStringToIntegerFormat("1.11");
        });

        assertThrows(InvalidItemStockException.class, () -> {
            itemsParser.itemStockInStringToIntegerFormat("999999999999999999999999");
        });
    }

    @Test
    public void itemStockInStringToIntegerFormat_nonNumericalInput_failure() {
        assertThrows(InvalidItemStockException.class, () -> {
            itemsParser.itemStockInStringToIntegerFormat("abc");
        });
    }

    @Test
    public void itemPriceInStringToBigDecimalFormat_nullInput_failure() {
        assertThrows(NullItemPriceException.class, () -> {
            itemsParser.itemPriceInStringToBigDecimalFormat(null);
        });
    }

    @Test
    public void itemPriceInStringToBigDecimalFormat_emptyInput_failure() {
        assertThrows(EmptyItemPriceException.class, () -> {
            itemsParser.itemPriceInStringToBigDecimalFormat("");
        });
    }

    @Test
    public void itemPriceInStringToBigDecimalFormat_outOfRangeInput_failure() {
        assertThrows(InvalidItemPriceException.class, () -> {
            itemsParser.itemPriceInStringToBigDecimalFormat("-1");
        });

        assertThrows(InvalidItemPriceException.class, () -> {
            itemsParser.itemPriceInStringToBigDecimalFormat("99999999999999999999999999999999999999999999999999");
        });

    }

    @Test
    public void itemPriceInStringToBigDecimalFormat_nonNumericInput_failure() {
        assertThrows(InvalidItemPriceException.class, () -> {
            itemsParser.itemPriceInStringToBigDecimalFormat("abc");
        });
    }
}
