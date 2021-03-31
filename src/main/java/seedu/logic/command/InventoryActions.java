package seedu.logic.command;

import seedu.model.Inventory;
//import seedu.exceptions.inventory.WrongInputException;
import seedu.ui.InventoryUI;

import java.util.ArrayList;

public class InventoryActions {
    public static ArrayList<Inventory> inventories = new ArrayList<>();

    public InventoryActions() {
    }

    public InventoryActions(ArrayList<Inventory> load) {
     this.inventories = load;
    }

    public void addDrugs(String[] argArr) {
        Inventory newInventory = new Inventory(argArr[0], Double.parseDouble(argArr[1]), Integer.parseInt(argArr[2]));
        inventories.add(newInventory);
        /*try {
            double priceDouble = Double.parseDouble(price); //check if price is a double
            if (name.isEmpty() || quantity.isEmpty()) {
                throw new WrongInputException("empty");
            }
            Drugs.add(new Inventory(name, priceDouble, quantity));
            InventoryUI.drugAddedMessage(name);
        } catch (NumberFormatException e) {
            throw new WrongInputException("price");
        }*/
    }

    public void deleteDrugs(String inputName) {
        String drugName = null;
        for (int i = 0; i< inventories.size(); i++) {
            Inventory inventoryTemp = inventories.get(i);
            String tempName = inventoryTemp.getDrugName();
            if (tempName.equals(inputName)) {
                inventories.remove(inventoryTemp);
                drugName = tempName;
                InventoryUI.deleteDrugMessage(drugName);
            }
        }
        /*try {
            boolean isContaining = false;
            for (int i = 0; i < Drugs.size(); ++i) {
                if (Drugs.get(i).getName().equals(name)) {
                    String drugName = Drugs.get(i).getName();
                    InventoryUI.deleteDrugMessage(drugName);
                    Drugs.remove(Drugs.get(i));
                    isContaining = true;
                    break;
                }
            }
            if(!isContaining) {
                throw new WrongInputException("doesNotExist");
            }
        } catch (StringIndexOutOfBoundsException e) {
            throw new WrongInputException("empty");
        }*/
    }
    public void listDrugs() {
        int numberOfDrugs = inventories.size();
        if (numberOfDrugs != 0) {
            InventoryUI.notEmptyInventoryListMessage();
            for (int i = 1; i <= numberOfDrugs; ++i) {
                System.out.println(i + ".\n" + inventories.get(i - 1).getDrugDetails());
            }
        } else {
            InventoryUI.emptyInventoryListMessage();
        }
    }

    public boolean isDrugStored(String inputString) {
        for (Inventory inventory : inventories) {
            String drugName = inventory.getDrugName();
            if (drugName.equals(inputString)) {
                return true;
            }
        }
        return false;
    }

    public int getSize() {
        return inventories.size();
    }

    /*public void checkDrugsSize() throws WrongInputException {
        if (inventories.size() == 0) {
            throw new WrongInputException("emptyList");
        }
    }*/
    public String toSaveFile(int i) {
        return inventories.get(i).toSaveFormat();
    }

}




