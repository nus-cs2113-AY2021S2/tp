package seedu.easylog.commands.itemscommands;

import seedu.easylog.common.Constants;
import seedu.easylog.exceptions.EmptyItemPriceException;
import seedu.easylog.exceptions.InvalidItemPriceException;
import seedu.easylog.exceptions.NonNumericItemPriceException;
import seedu.easylog.exceptions.NullItemPriceException;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ItemsPromptPriceCommand extends ItemsCommand {

    /**
     * Prompts the user for the item price.
     *
     * @return item price
     */
    public BigDecimal execute() throws NullItemPriceException, EmptyItemPriceException, NonNumericItemPriceException,
            InvalidItemPriceException {
        ui.promptItemPrice();

        String itemPriceInString = ui.askForUserInput();

        BigDecimal itemPrice = itemsParser.itemPriceInStringToBigDecimalFormat(itemPriceInString);
        itemPrice = itemPrice.setScale(Constants.PRICING_SCALE, RoundingMode.HALF_EVEN);

        return itemPrice;
    }
}