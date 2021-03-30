package seedu.logic.instance;

import seedu.exceptions.HealthVaultException;
import seedu.logic.command.InventoryActions;
import seedu.logic.parser.InventoryParser;
import seedu.storage.InventoryStorage;
import seedu.logic.command.Command;
import seedu.ui.InventoryUI;
import seedu.ui.UI;

public class InventoryInstance {

    /**
     * Main entry-point for the java.duke.DrugInstance application.
     */
    private InventoryUI ui;
    private InventoryActions drugs;
    private InventoryStorage inventoryStorage;
    private InventoryParser parser;

    //protected ArrayList<Inventory> inventories;

    public InventoryInstance(String filePath) {
        ui = new InventoryUI();
        inventoryStorage = new InventoryStorage(filePath);
        parser = new InventoryParser();
        try {
            //inventories = inventoryStorage.uploadDrugs();
            drugs = new InventoryActions(inventoryStorage.loadInventory());
        } catch (HealthVaultException e) {
            ui.showLoadingError();
            drugs = new InventoryActions();
            //inventories = inventoryStorage.createNewFile();
        }
    }

    public void run() {
        InventoryUI.DrugCommandWelcome();
        boolean isReturnToStartMenu = false;
        while (!isReturnToStartMenu) {
            try {
                UI.showLine(); // show the divider line ("_______")
                String fullCommand = ui.getInput("Inventory");
                Command c = parser.inventoryParse(fullCommand, drugs);
                c.execute(drugs, ui);
                inventoryStorage.storeInventory(drugs);
                isReturnToStartMenu = c.isExit();
                if (isReturnToStartMenu) {
                    UI.returningToStartMenuMessage();
                }
                UI.showLine();
            } catch (NullPointerException e) {
                //Command C can return as null if an error is triggered in parser
                //Null Pointer Exception may hence occur, the catch statement is to ensure it does not exit the loop.
            }
        }
        //InventoryParser InventoryParser = new InventoryParser(inventories);
        //InventoryParser.parseMethod();
        //inventoryStorage.exitProgram();
    }

}
