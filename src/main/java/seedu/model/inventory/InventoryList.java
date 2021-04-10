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

    public InventoryList(ArrayList<Inventory> load) {
        this.list = load;
    }

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
                //inventoryTemp.removeQuantity(tempQuantity);
                throw new InvalidQuantityException();
            }
        }
    }

    public void listDrugs() {
        int numberOfDrugs = list.size();
        if (numberOfDrugs != 0) {
            System.out.print(System.lineSeparator());
            ui.inventoryListHeader();
            for (int i = 0; i < 60; i++) {
                System.out.print("-");
            }
            System.out.println("\n");

            for (Inventory inventory : list) {
                display(inventory);
            }
        } else {
            ui.emptyInventoryListMessage();
        }
    }

    public boolean isDrugStored(String inputString) {
        for (Inventory inventory : list) {
            String drugName = inventory.getDrugName();
            if (drugName.equals(inputString)) {
                return true;
            }
        }
        return false;
    }

    public static void display(Inventory inventory) {
        System.out.println(
                prettyPrint(inventory.getDrugName(), 15) + " | "
                        + prettyPrint(inventory.getStringPrice(), 10) + " | "
                        + prettyPrint(Integer.toString(inventory.getQuantity()), 5));
    }

    public int getSize() {
        return list.size();
    }

    public String toSaveFile(int i) {
        return list.get(i).toSaveFormat();
    }

}




