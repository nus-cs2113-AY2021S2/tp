package seedu.ui;

import static seedu.duke.Constants.*;

public class InventoryUI extends UI{

    public static void drugAddedMessage(String name) {
        System.out.println(name + " is added into Inventory!");
    }

    public static void emptyInventoryListMessage() {
        System.out.println("You do not have any Drugs in your inventory:(");
    }
    public static void inventoryListHeader() {
        System.out.println(
                UI.prettyPrint("DrugName", 15) + " | " + UI.prettyPrint("Price", 10) + " | "
                        + UI.prettyPrint("Quantity", 5)) ;
    }
    public static void printInventoryHelpMessage() {

        UI.printEmptyLine();
        System.out.println("Here is a list of Inventory commands: ");

        UI.printEmptyLine();
        int[] lengthPara = {10,60,50};
        printer(new String[]{HELP_HEADER_COMMAND, HELP_HEADER_DESCRIPTION, HELP_HEADER_FORMAT}, lengthPara);
        UI.showLongLine();
        printer(new String[]{HELP_COMMAND, INVENTORY_HELP_DESCRIPTION, MARK_BLANK}, lengthPara);
        printer(new String[]{ADD_COMMAND, INVENTORY_ADD_DESCRIPTION, INVENTORY_ADD_FORMAT}, lengthPara);
        printer(new String[]{LIST_COMMAND, INVENTORY_LIST_DESCRIPTION, INVENTORY_LIST_FORMAT}, lengthPara);
        printer(new String[]{DELETE_COMMAND, INVENTORY_DELETE_DESCRIPTION, INVENTORY_DELETE_FORMAT}, lengthPara);
        printer(new String[]{RETURN_COMMAND, RETURN_DESCRIPTION, MARK_BLANK}, lengthPara);
        UI.printEmptyLine();

    }
    public static void notEmptyInventoryListMessage() {
        System.out.println("Here are the inventories currently in the inventory!");
    }

    public static void deleteDrugMessage(String deletedDrug) {
        System.out.println("Noted. I've removed this drug: " + deletedDrug);
    }

    public static void inventoryMenuHeader() {
        System.out.print("Welcome to Inventory Menu!\nType \"help\" for Inventory menu commands\n\n");
    }

    public void showLoadingError() {
    }
}
