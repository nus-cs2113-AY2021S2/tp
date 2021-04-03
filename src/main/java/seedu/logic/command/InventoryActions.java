package seedu.logic.command;

import seedu.model.Inventory;
import seedu.ui.InventoryUI;
import java.util.ArrayList;
import static seedu.ui.UI.prettyPrint;

public class InventoryActions {
    private InventoryUI ui;
    public static ArrayList<Inventory> list = new ArrayList<>();

    public InventoryActions() {
    }
    public InventoryActions(ArrayList<Inventory> load) {
     this.list = load;
    }

    public void addDrugs(String[] argArr) {
        Inventory newInventory = new Inventory(argArr[0], Double.parseDouble(argArr[1]), Integer.parseInt(argArr[2]));
        list.add(newInventory);
    }

    public void deleteDrugs(String inputName) {
        String drugName = null;
        for (int i = 0; i< list.size(); i++) {
            Inventory inventoryTemp = list.get(i);
            String tempName = inventoryTemp.getDrugName();
            if (tempName.equals(inputName)) {
                list.remove(inventoryTemp);
                drugName = tempName;
                InventoryUI.deleteDrugMessage(drugName);
            }
        }
    }

    public void listDrugs() {
        int numberOfDrugs = list.size();
        if (numberOfDrugs != 0) {
            //ui.notEmptyInventoryListMessage();
            System.out.print(System.lineSeparator());
            ui.inventoryListHeader();
            for (int i = 0; i < 60; i++) {
                System.out.print("-");
            }
            System.out.println("\n");
            /*String newString = "-";
            System.out.println(newString.repeat(60));
            */
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
                prettyPrint(inventory.getDrugName(), 15) + " | " + prettyPrint(inventory.getPrice(), 10) + " | "
                        + prettyPrint(Integer.toString(inventory.getQuantity()), 5));
    }

    public int getSize() {
        return list.size();
    }

    public String toSaveFile(int i) {
        return list.get(i).toSaveFormat();
    }

}




