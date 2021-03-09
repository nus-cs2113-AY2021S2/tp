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
    private static final String filePath = "data/storage.txt";

    /**
     * Main entry-point for the java.duke.Duke application.
     */
    public static void main(String[] args) {
//        System.out.println(args[0]);
//        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        ui = new Ui();
        ui.showWelcome();
//        storage = new Storage(filePath);
        if (args != null & args.length > 0) {
            storage = new Storage(args[0]);
        } else {
            storage = new Storage(filePath);
        }
//        storage = new Storage(args[0]);
        canteens = storage.load();
        echo();
    }

    public static void echo() {
        boolean isExit = false;
        while (!isExit) {
            String userCommand = ui.readCommand();
            String[] parsedCommand = userCommand.split(" ");
            if (parsedCommand[0].equals("list")) {
                displayStores();
            } else if (parsedCommand[0].equals("exit")) {
                isExit = true;
            } else {
                ui.showError();
            }
        }
        ui.showGoodbye();
        System.exit(0);
    }

    public static void displayStores() {
        ui.showGetCanteen(canteens);
        String userCommand = ui.readCommand();
        int canteenIndex = Integer.parseInt(userCommand) - 1;
        ArrayList<Store> stores = canteens.get(canteenIndex).getStores();
        for (Store store: stores) {
            store.displayStore();
        }
    }

}
