package seedu.duke;

import canteens.Canteen;
import storage.Storage;
import stores.Store;
import ui.Ui;

import java.util.ArrayList;

public class Duke {
    private static ArrayList<Canteen> canteens; // todo: add a canteen manager
    private static Ui ui;
    private static Storage storage;
    private final static String filePath = "./src/main/java/data/storage.txt";

    /**
     * Main entry-point for the java.duke.Duke application.
     */
    public static void main(String[] args) {
        storage = new Storage(filePath);
        ui = new Ui();
        canteens = storage.load();
        echo();
    }

    public static void echo() {
        boolean isExit = false;
        while(!isExit) {
            String userCommand = ui.readCommand();
            String[] parsedCommand = userCommand.split(" ");
            if(parsedCommand[0].equals("list")) {
                displayStores();
            } else if(parsedCommand[0].equals("exit")) {
                isExit = true;
            }
        }
        ui.showGoodbye();
    }

    public static void displayStores() {
        ui.showGetCanteen(canteens);
        String userCommand = ui.readCommand();
        int canteenIndex = Integer.parseInt(userCommand) - 1;
        ArrayList<Store> stores = canteens.get(canteenIndex).getStores();
        for(Store store: stores) {
            store.displayStore();
        }
    }

}
