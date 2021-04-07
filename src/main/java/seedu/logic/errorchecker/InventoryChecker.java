package seedu.logic.errorchecker;

import seedu.exceptions.CorruptedFileException;
import seedu.exceptions.HealthVaultException;
import seedu.exceptions.NoInputException;
import seedu.exceptions.inventory.DuplicateDrugException;
import seedu.exceptions.inventory.NonExistentDrugException;
import seedu.exceptions.inventory.WrongNumberException;
import seedu.exceptions.patient.IllegalCharacterException;
import seedu.logic.command.InventoryActions;
import seedu.model.Inventory;
import java.util.ArrayList;

public class InventoryChecker extends MainChecker {
    private InventoryActions inventory;
    private ArrayList<Inventory> inventoryArrayList;
    private String[] stringTokens;
    private int numberOfTokens;

    public InventoryChecker(InventoryActions inventory, String[] stringTokens, int numberOfTokens) {
        this.inventory = inventory;
        this.stringTokens = stringTokens;
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
        checkPrice(stringTokens[1]);
        checkQuantity(stringTokens[2]);
        checkDuplicate(stringTokens[0], Double.parseDouble(stringTokens[1]));
    }

    public void checkAdd() throws DuplicateDrugException, WrongNumberException, IllegalCharacterException, seedu.exceptions.patient.IllegalCharacterException {
        illegalCharacterChecker(stringTokens[1], "name");
        illegalCharacterChecker(stringTokens[3], "quantity");
        checkPrice(stringTokens[2]);
        checkQuantity(stringTokens[3]);
        checkDuplicate(stringTokens[1], Double.parseDouble(stringTokens[2]));
    }

    public void checkDelete() throws IllegalCharacterException, NonExistentDrugException {
        illegalCharacterChecker(stringTokens[1], "name");
        isNameExist(stringTokens[1], inventory);
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

    public static void checkDuplicate(String inputString, Double price) throws DuplicateDrugException {
        for (Inventory inventory : InventoryActions.list) {
            String drugName = inventory.getDrugName();
            Double drugPrice = inventory.getDoublePrice();
            if (drugName.equals(inputString) && !drugPrice.equals(price)) {
                throw new DuplicateDrugException();
            }
        }
    }

    public static void checkQuantity(String number) throws WrongNumberException {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new WrongNumberException("quantity");
        }
        if (Integer.parseInt(number) < 0) {
            throw new WrongNumberException("quantity");
        }
    }

    public static boolean checkPrice(String price) throws WrongNumberException {
        try {
            Double.parseDouble(price);
        } catch (NumberFormatException e) { //check if price is a double
            throw new WrongNumberException("price");
        }
        if (Double.parseDouble(price) < 0) {
            throw new WrongNumberException("price");
        }
        return false;
    }

    public void isNameExist(String userInput, InventoryActions drugs) throws NonExistentDrugException{
       if (!drugs.isDrugStored(userInput)) {
           throw new NonExistentDrugException("NameDoesNotExist");
       }
    }

}

