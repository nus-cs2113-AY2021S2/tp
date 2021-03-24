package seedu.duke.ui;

public class DrugUI {
    public static void printDrugHelpList() {
        System.out.println("Here is a list of drug commands: ");
        System.out.println("\"add\" adds a new drug to the drug inventory!");
        System.out.println("\"list\" brings up the list of all current drugs in the inventory!");
        System.out.println("\"delete\" deletes the drug from the list!");
        System.out.println("\"help\" brings up this list of commands!");
        System.out.println("\"return\" returns you to the Start Menu!");
    }

    public static void drugAddedMessage(String name) {
        System.out.println(name + " is added into Drug Inventory!");
    }

    public static void emptyDrugListMessage() {
        System.out.println("You do not have any Drugs in your inventory:(");
    }

    public static void drugNotFoundMessage() {
        System.out.println("OOPS! Drug not found in the inventory");
    }

    public static void drugListMessage() {
        System.out.println("Here are the drugs currently in the inventory!");
    }

    public static void deleteDrugMessage(String deletedDrug) {
        System.out.println("Noted. I've removed this drug: " + deletedDrug);
    }
    public static void invalidCommandMessage() {
        System.out.println("There is no such action! Please only enter the following: ");
        printDrugHelpList();
    }

    public static void drugMenuPrompt() {
        System.out.print("Drug --> ");
    }

    public static void drugNamePrompt() {
        System.out.print("Name: ");
    }
    public static void drugPricePrompt() {
        System.out.print("Price: ");
    }
    public static void drugQuantityPrompt() {
        System.out.print("Quantity: ");
    }
    public static void DrugCommandWelcome() {
        System.out.println("Welcome to the Drug Inventory!");
        printDrugHelpList();
    }
}
