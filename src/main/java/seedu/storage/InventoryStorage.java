package seedu.storage;

import seedu.exceptions.DukeException;
import seedu.logic.command.InventoryActions;
import seedu.model.Inventory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class InventoryStorage {

    protected File saveFile;
    protected String filePath;
    protected ArrayList<Inventory> inventories = new ArrayList<>();

    public InventoryStorage(String filePath) {
        this.filePath = filePath;
        saveFile = new File(filePath);
    }
    public void fileInit() {
        try {
            //makes file directory if it doesnt exist in the system.
            if (!(saveFile.exists())) {
                saveFile.getParentFile().mkdirs();
                saveFile.createNewFile();
            }
        } catch (IOException e) {
            System.out.println("OOPS! I can't create the directory or file!");
        }
    }

   /* public ArrayList<Inventory> createNewFile() {
        File drugsFile = new File(getFilepath());
        try {
            if (drugsFile.createNewFile()) {
                System.out.println("\tTo save your task locally,\n" +
                        "\tA new file has been created at:\n\t" +
                        drugsFile.getAbsolutePath() + "\n");
            }
        } catch (IOException e) {
            System.out.println("\tThere was an I/O error:\nBye!\n");
            e.printStackTrace();
        }
        return inventories;
    }

    public String getFilepath() {
        return this.filepath;
    }*/
    public ArrayList<Inventory> loadInventory() throws DukeException {
        fileInit();
        try {
            // initializing file scanner to scan the file
            Scanner fileScanner = new Scanner(saveFile);

            while (fileScanner.hasNext()) {
                String currentScan = fileScanner.nextLine();
                //splits the string into sections for storing in the ArrayList
                String[] taskSave = currentScan.trim().split(" \\| ");
                if (taskSave.length != 3) {
                    throw new DukeException("loadFile");
                }
                Inventory tempInventory = new Inventory(taskSave[0], Double.parseDouble(taskSave[1]), Integer.parseInt(taskSave[2]));
                inventories.add(tempInventory);
            }
        } catch (FileNotFoundException e) {
            throw new DukeException("OOPS! I can't read the save file!");
        } catch (DukeException e) {
            e.getError("loadFile");
        }
        return inventories;
    }
    public void storeInventory(InventoryActions saveInput) {
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
   /* public ArrayList<Inventory> uploadDrugs() throws FileNotFoundException {
        File f = new File(getFilepath());
        Scanner s = new Scanner(f);
        while (s.hasNext()) {
            String[] part = s.nextLine().split(" | ");
            Drugs.add(new Inventory(part[0], Double.parseDouble(part[1]), part[2]));
        }
        return Drugs;
    }*/

   /* public void saveDrugs() throws IOException {
        FileWriter fw = new FileWriter(getFilepath());
        for (Inventory Inventory : inventories) {
            fw.write(Inventory.stringToSave());
            fw.write(System.lineSeparator());
        }
        fw.close();
    }*/

    /*public void exitProgram() {
        System.out.println("Returning to start menu!");
        try {
            saveDrugs();
        } catch (IOException e) {
            System.out.println("No file was saved due to an I/O error.\n");
        }
    }*/

}


