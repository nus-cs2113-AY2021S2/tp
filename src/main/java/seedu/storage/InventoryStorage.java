package seedu.storage;

import seedu.exceptions.HealthVaultException;
import seedu.logger.HealthVaultLogger;
import seedu.model.inventory.InventoryList;
import seedu.logic.errorchecker.InventoryChecker;
import seedu.model.inventory.Inventory;
import seedu.ui.InventoryUI;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * InventoryStorage handles the necessary file I/O operations.
 */
public class InventoryStorage {

    protected File saveFile;
    protected String filePath;
    protected ArrayList<Inventory> inventories = new ArrayList<>();
    protected InventoryUI ui;
    protected InventoryChecker checker;
    public Logger logger = HealthVaultLogger.getLogger();

    /**
     * Constructor for InventoryStorage.
     *
     * @param filePath filepath to create and update file.
     */
    public InventoryStorage(String filePath) {
        this.filePath = filePath;
        saveFile = new File(filePath);
    }

    /**
     * Creates a directory if it does not exist.
     * Creates a file if it does not exist.
     *
     * @throws IOException If unable to create file/directory.
     */
    public void fileInit() {
        try {
            //makes file directory if it doesnt exist in the system.
            if (!(saveFile.exists())) {
                saveFile.getParentFile().mkdirs();
                saveFile.createNewFile();
            }
        } catch (IOException e) {
            System.out.println("OOPS! I can't create the directory or file!");
            logger.log(Level.WARNING, "Unable to create file");
        }
    }

    /**
     * Loads data from text file into InventoryList.
     *
     * @return Inventory List
     * @throws HealthVaultException If any corrupted file/data detected.
     */
    public ArrayList<Inventory> loadInventory() throws HealthVaultException {
        fileInit();
        Scanner fileScanner = null;
        try {
            // initializing file scanner to scan the file
            fileScanner = new Scanner(saveFile);

            while (fileScanner.hasNext()) {
                String currentScan = fileScanner.nextLine();
                //splits the string into sections for storing in the ArrayList
                String[] taskSave = currentScan.trim().split("\\|");
                int numberOfTokens = taskSave.length;
                if (taskSave.length != 3) {
                    throw new HealthVaultException("loadFile");
                }
                checker = new InventoryChecker(inventories, taskSave, numberOfTokens);
                checker.checkStorage();
                Inventory tempInventory = new Inventory(taskSave[0], Double.parseDouble(taskSave[1]),
                        Integer.parseInt(taskSave[2]));
                inventories.add(tempInventory);
            }
        } catch (FileNotFoundException e) {
            throw new HealthVaultException("loadFile");
        }
        fileScanner.close();
        return inventories;
    }

    /**
     * Stores data from InventoryList into a specified text file.
     * @param saveInput InventoryList object where Inventory object's data are received.
     */
    public void storeInventory(InventoryList saveInput) {
        fileInit();
        try {
            //creates a new file writer to write to text file
            FileWriter fileWriter = new FileWriter(filePath);
            for (int i = 0; i < saveInput.getSize(); i++) {
                fileWriter.write(saveInput.toSaveFile(i) + "\n");
            }
            fileWriter.close();
        } catch (java.io.IOException e) {
            System.out.println("☹ OOPS!!! The file can't be saved :-(");
        }
    }
}


