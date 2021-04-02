package seedu.logic.instance;

import seedu.exceptions.HealthVaultException;
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

    //protected ArrayList<Inventory> inventories;

    public InventoryInstance(String filePath) {
        ui = new InventoryUI();
        inventoryStorage = new InventoryStorage(filePath);
        parser = new InventoryParser();
    }

    public void run() {
        try {
            //inventories = inventoryStorage.uploadDrugs();
            ArrayList<Inventory> list = inventoryStorage.loadInventory();
            inventory = new InventoryActions(list);
        } catch (HealthVaultException e) {
            ui.showLoadingError();
            inventory = new InventoryActions();
            //inventories = inventoryStorage.createNewFile();
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
                //UI.showLine();
                UI.printEmptyLine();
            } catch (NullPointerException e) {
                //Command C can return as null if an error is triggered in parser
                //Null Pointer Exception may hence occur, the catch statement is to ensure it does not exit the loop.
            } catch (Exception e) {
                System.out.println("Something went wrong");
            }
        }

    }

}
