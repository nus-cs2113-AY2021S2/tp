package seedu.model.inventory;

import seedu.exceptions.inventory.InvalidQuantityException;
import seedu.ui.InventoryUI;
import java.util.ArrayList;
import static seedu.ui.UI.prettyPrint;

public class InventoryList {
    private InventoryUI ui;
    public static ArrayList<Inventory> list = new ArrayList<>();

    public InventoryList() {
    }

    /**
     * Constructor for Inventory List.
     *
     * @param load Inventory List
     */
    public InventoryList(ArrayList<Inventory> load) {
        this.list = load;
    }

    /**
     * Adds a Inventory object to or increases quantity of Inventory object in the InventoryList.
     *
     * @param argArr array of inputs for Inventory object.
     */
    public void addDrugs(String[] argArr) {
        for (int i = 0; i < list.size(); i++) {
            Inventory inventoryTemp = list.get(i);
            String tempName = inventoryTemp.getDrugName();
            Double tempPrice = inventoryTemp.getDoublePrice();
            if (tempName.equals(argArr[0]) && tempPrice.equals(Double.parseDouble(argArr[1]))) {
                inventoryTemp.addQuantity(Integer.parseInt(argArr[2]));
                return;
            }
        }
        Inventory newInventory = new Inventory(argArr[0], Double.parseDouble(argArr[1]), Integer.parseInt(argArr[2]));
        list.add(newInventory);
    }

    /**
     * Deletes a Quantity of an Inventory object.
     *
     * @param argArr array of inputs for Inventory object.
     * @throws InvalidQuantityException when Quantity input is invalid.
     */
    public void deleteDrugs(String[] argArr) throws InvalidQuantityException {
        for (int i = 0; i < list.size(); i++) {
            String name = argArr[1];
            String quantityDelete = argArr[2];
            Inventory inventoryTemp = list.get(i);
            String tempName = inventoryTemp.getDrugName();
            int tempQuantity = inventoryTemp.getQuantity();
            if (tempName.equals(name) && tempQuantity >= Integer.parseInt(quantityDelete)) {
                inventoryTemp.removeQuantity(Integer.parseInt(quantityDelete));
                return;
            } else if (tempName.equals(name) && tempQuantity < Integer.parseInt(quantityDelete)) {
                throw new InvalidQuantityException();
            }
        }
    }

    /**
     * Displays information of all relevant Inventory objects.
     */
    public void listDrugs() {
        int numberOfDrugs = list.size();
        if (numberOfDrugs != 0) {
            System.out.print(System.lineSeparator());
            ui.inventoryListHeader();
            for (int i = 0; i < 60; i++) {
                System.out.print("-");
            }
            System.out.print(System.lineSeparator());
            for (Inventory inventory : list) {
                display(inventory);
            }
        } else {
            ui.emptyInventoryListMessage();
        }
    }

    /**
     * Checks if Inventory object is list.
     *
     * @param inputString Inventory object name.
     * @return true or false.
     */
    public boolean isDrugStored(String inputString) {
        for (Inventory inventory : list) {
            String drugName = inventory.getDrugName();
            if (drugName.equals(inputString)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Displays the format for the Inventory List.
     *
     * @param inventory Inventory object.
     */
    public static void display(Inventory inventory) {
        System.out.println(
                prettyPrint(inventory.getDrugName(), 15) + " | "
                        + prettyPrint(inventory.getStringPrice(), 10) + " | "
                        + prettyPrint(Integer.toString(inventory.getQuantity()), 5));
    }

    /**
     * Returns size of Inventory List.
     *
     * @return size of Inventory List.
     */
    public int getSize() {
        return list.size();
    }

    /**
     * Returns the format the list has to be saved in Inventory text file.
     *
     * @param i index of Inventory object.
     * @return the format the list has to be saved in Inventory text file.
     */
    public String toSaveFile(int i) {
        return list.get(i).toSaveFormat();
    }

}




