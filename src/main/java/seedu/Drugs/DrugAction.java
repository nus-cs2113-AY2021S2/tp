package seedu.duke;

import java.util.ArrayList;

public class DrugAction {
    public ArrayList<drugInstance> drugInstances = new ArrayList<>();

    public void addDrugs(String description) {
        try {
            description = description.substring(4);
            String[] elements = description.split(" ");
            drugInstances.add(new drugInstance(elements[0], elements[1], elements[2]));
            System.out.println("Added " + elements[elements.length - 1] + " " + elements[0] + " to inventory!");
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("The description of 'add' cannot be empty");
            return;
        }
    }

    public void deleteDrugs(String description) {
        try {
            description = description.substring(7);
            for (int i = 0; i< drugInstances.size(); ++i) {
                if (drugInstances.get(i).getName().contains(description)) {
                    System.out.println("Deleted " + drugInstances.get(i).getName() + " from inventory!");
                    drugInstances.remove(drugInstances.get(i));
                    break;
                }
            }
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("The description of 'delete' cannot be empty");
            return;
        }
    }

    public void printList() {
        if (drugInstances.size() != 0) {
            System.out.println("Current Inventory: ");
            for (int i = 1; i <= drugInstances.size(); ++i) {
                System.out.println(i + ". " + drugInstances.get(i-1).getName() + " " + drugInstances.get(i-1).getPrice() + " " + drugInstances.get(i-1).getQuantity());
            }
        } else {
            System.out.println("\tYou do not have any drugInstances in your inventory:(");
        }
    }

}




