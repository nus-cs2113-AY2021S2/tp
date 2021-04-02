package seedu.logic.errorchecker;


import seedu.exceptions.CorruptedFileException;
import seedu.exceptions.HealthVaultException;
import seedu.exceptions.InvalidIntegerException;
import seedu.exceptions.NoInputException;
import seedu.exceptions.inventory.DuplicateDrugException;
import seedu.exceptions.inventory.InvalidPriceException;
import seedu.exceptions.patient.IllegalCharacterException;
import seedu.logic.command.InventoryActions;
import seedu.model.Inventory;

import java.util.ArrayList;

public class InventoryChecker extends MainChecker {
    private InventoryActions inventory;
    private ArrayList<Inventory> inventoryArrayList;
    private String[] stringTokens;
    private String command;
    private int numberOfTokens;

    public InventoryChecker(InventoryActions inventory, String[] stringTokens, String command, int numberOfTokens) {
        this.inventory = inventory;
        this.stringTokens = stringTokens;
        this.command = command;
        this.numberOfTokens = numberOfTokens;
    }

    public InventoryChecker(ArrayList<Inventory> inventory, String[] stringTokens, int numberOfTokens) {
        inventoryArrayList = inventory;
        this.stringTokens = stringTokens;
        this.numberOfTokens = numberOfTokens;
    }


    public void checkStorage() throws HealthVaultException {
        emptySpaceCheck();
        checkStorageLength();
        illegalCharacterChecker(stringTokens[0], "name");
        illegalCharacterChecker(stringTokens[2], "quantity");
    }
    public void checkAdd() {
        try {
            illegalCharacterChecker(stringTokens[1], "name");
            illegalCharacterChecker(stringTokens[3], "quantity");
        } catch (IllegalCharacterException e) {
            System.out.println(e.getMessage());
        }
    }
    public void checkStorageLength() throws HealthVaultException {
        if (numberOfTokens != 3) {
            throw new CorruptedFileException("Inventory");
        }
    }
    public void emptySpaceCheck() throws NoInputException {
        for (int i = 0; i < numberOfTokens; i++) {
            if (stringTokens[i].trim().equals("")) {
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
    public static void isValidQuantity(String number) throws InvalidIntegerException {
        try {
            Integer.parseInt(number);     // Check age is numeric
        } catch (NumberFormatException e) {
            throw new InvalidIntegerException();
        }
        if (Integer.parseInt(number) < 0) {
            throw new InvalidIntegerException();
        }
    }

    public static boolean isValidPrice(String price) throws InvalidPriceException {
        try {
            Double.parseDouble(price);
        } catch (NumberFormatException e) { //check if price is a double
            throw new InvalidPriceException();
        }
        return false;
    }
}

