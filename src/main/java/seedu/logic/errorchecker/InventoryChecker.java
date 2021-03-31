package seedu.logic.errorchecker;

import seedu.exceptions.CorruptedFileException;
import seedu.exceptions.HealthVaultException;
import seedu.exceptions.NoInputException;
import seedu.exceptions.inventory.DuplicateDrugException;
import seedu.exceptions.inventory.InvalidPriceException;
import seedu.logic.command.InventoryActions;
import seedu.model.Inventory;

import java.util.ArrayList;

public class InventoryChecker extends MainChecker {
    private InventoryActions inventory;
    private ArrayList<Inventory> inventoryArrayList;
    private ArrayList<String> stringTokens;
    private String command;
    private int numberOfTokens;

    public InventoryChecker(InventoryActions inventory, ArrayList<String> stringTokens, String command, int numberOfTokens) {
        this.inventory = inventory;
        this.stringTokens = stringTokens;
        this.command = command;
        this.numberOfTokens = numberOfTokens;
    }

    public InventoryChecker(ArrayList<Inventory> inventory, ArrayList<String> stringTokens, int numberOfTokens) {
        inventoryArrayList = inventory;
        this.stringTokens = stringTokens;
        this.numberOfTokens = numberOfTokens;
    }

    public void checkStorage() throws HealthVaultException {
        emptySpaceCheck();
        checkStorageLength();
        illegalCharacterChecker(stringTokens.get(0), "name");
        illegalCharacterChecker(stringTokens.get(1), "price");
        illegalCharacterChecker(stringTokens.get(2), "quantity");
    }
    public void checkAdd() throws HealthVaultException, NumberFormatException {
        emptySpaceCheck();
        isValidPrice(stringTokens.get(2));
        duplicateChecker(stringTokens.get(1));
        checkNumericInput(stringTokens.get(3));
        illegalCharacterChecker(stringTokens.get(1), "name");
        illegalCharacterChecker(stringTokens.get(2), "price");
        illegalCharacterChecker(stringTokens.get(3), "quantity");
    }
    public void checkStorageLength() throws HealthVaultException {
        if (numberOfTokens != 3) {
            throw new CorruptedFileException("Inventory");
        }
    }
    public void emptySpaceCheck() throws NoInputException {
        for (int i = 0; i < numberOfTokens; i++) {
            if (stringTokens.get(i).trim().equals("")) {
                throw new NoInputException();
            }
        }
    }
    public static void duplicateChecker(String inputString) throws DuplicateDrugException {
        for (Inventory inventory : InventoryActions.list) {
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

