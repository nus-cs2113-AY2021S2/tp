package seedu.logic.instance;

import seedu.exceptions.HealthVaultException;
import seedu.exceptions.InsufficientInputException;
import seedu.exceptions.ExcessInputException;
import seedu.exceptions.NoInputException;
import seedu.exceptions.inventory.DuplicateDrugException;
import seedu.exceptions.inventory.WrongNumberException;
import seedu.exceptions.patient.IllegalCharacterException;
import seedu.logic.command.InventoryActions;
import seedu.logic.parser.InventoryParser;
import seedu.model.Inventory;
import seedu.storage.InventoryStorage;
import seedu.logic.command.Command;
import seedu.ui.InventoryUI;
import seedu.ui.UI;
import java.util.ArrayList;

public class InventoryInstance {

    /**
     * Main entry-point for the java.duke.DrugInstance application.
     */
    private InventoryUI ui;
    private InventoryActions inventory;
    private InventoryStorage inventoryStorage;
    private InventoryParser parser;

    public InventoryInstance(String filePath) {
        ui = new InventoryUI();
        inventoryStorage = new InventoryStorage(filePath);
        parser = new InventoryParser();
    }

    public void run() {
        try {
            ArrayList<Inventory> list = inventoryStorage.loadInventory();
            inventory = new InventoryActions(list);
        } catch (HealthVaultException e) {
            ui.corruptedFileErrorMessage();
            inventory = new InventoryActions();
            return;
        }
        InventoryUI.inventoryMenuHeader();
        boolean isReturnToStartMenu = false;
        while (!isReturnToStartMenu) {
            try {
                UI.showLine(); // show the divider line ("_______")
                String fullCommand = ui.getInput("Inventory");
                Command c = parser.inventoryParse(fullCommand, inventory);
                c.execute(inventory, ui);
                inventoryStorage.storeInventory(inventory);
                isReturnToStartMenu = c.isExit();
                if (isReturnToStartMenu) {
                    UI.returningToStartMenuMessage();
                }
            } catch (NullPointerException e) {
                //Command C can return as null if an error is triggered in parser
                //Null Pointer Exception may hence occur, the catch statement is to ensure it does not exit the loop.
            } catch (WrongNumberException e) {
                e.getError();
            } catch (DuplicateDrugException e) {
                e.getError("DrugStored");
            } catch (IllegalCharacterException | InsufficientInputException |
                    ExcessInputException | NoInputException e) {
                System.out.println(e.getMessage());
            } catch (HealthVaultException e) {
                e.getError("");
            }
        }
    }
}
