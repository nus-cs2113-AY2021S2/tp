package seedu.logic.errorchecker;

import seedu.exceptions.inventory.DuplicateDrugException;
import seedu.exceptions.inventory.InvalidPriceException;
import seedu.logic.command.InventoryActions;
import seedu.model.Inventory;

public class InventoryChecker extends MainChecker {
    public InventoryChecker() {
        super();
    }

    public static void duplicateChecker(String inputString) throws DuplicateDrugException {
        for (Inventory inventory : InventoryActions.inventories) {
            String drugName = inventory.getDrugName();
            if (drugName.equals(inputString)) {
                throw new DuplicateDrugException();
            }
        }
    }
    public static void isValidPrice(String price) throws InvalidPriceException {
        try {
            Double.parseDouble(price);
        } catch (NumberFormatException e) { //check if price is a double
            throw new InvalidPriceException();
        }
    }
}

