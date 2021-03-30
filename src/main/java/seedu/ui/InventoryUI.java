package seedu.ui;

public class InventoryUI extends UI{
    public static void printDrugHelpList() {
        System.out.println("Here is a list of drug commands: ");
        System.out.println("\"add/[Drug name]/[Price]/[Quantity]\" adds a new drug to the drug inventory!");
        System.out.println("\"list\" brings up the list of all current inventories in the inventory!");
        System.out.println("\"delete/[Drug name]\" deletes the drug from the list!");
        System.out.println("\"help\" brings up this list of commands!");
        System.out.println("\"return\" returns you to the Start Menu!");
    }

    public static void drugAddedMessage(String name) {
        System.out.println(name + " is added into Inventory!");
    }

    public static void emptyInventoryListMessage() {
        System.out.println("You do not have any Drugs in your inventory:(");
    }

    public static void notEmptyInventoryListMessage() {
        System.out.println("Here are the inventories currently in the inventory!");
    }

    public static void deleteDrugMessage(String deletedDrug) {
        System.out.println("Noted. I've removed this drug: " + deletedDrug);
    }

    public static void DrugCommandWelcome() {
        System.out.println("Welcome to the Inventory!");
        System.out.println("Type \"help\" to see the list of Inventory commands");
    }

    public void showLoadingError() {
    }
}
