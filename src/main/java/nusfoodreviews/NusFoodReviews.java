package nusfoodreviews;

import admin.AdminVerification;
import canteens.Canteen;
import command.Command;
import command.DisplayStoresCommand;
import exceptions.DukeExceptions;
import parser.Parser;
import storage.Storage;
import stores.Store;
import ui.Ui;
import checkuser.CheckUser;

import java.util.ArrayList;

public class NusFoodReviews {
    private ArrayList<Canteen> canteens; // todo: add a canteen manager
    private Ui ui;
    private Storage storage;
    private Parser parser;
    private boolean isExit = false;
    private boolean isPublicUser;
    private static int canteenIndex = -1;
    private static int storeIndex = -1;

    public NusFoodReviews(String filePath) {
        ui = new Ui();
        parser = new Parser();
        storage = new Storage(filePath);
        canteens = storage.load();
    }

    /**
     * Main entry-point for the java.duke.Duke application.
     */
    public static void main(String[] args) throws DukeExceptions {
        new NusFoodReviews("data/storage.txt").run();
    }

    public void run() throws DukeExceptions {
        ui.showLogo();
        ui.showLoginPage();
        isPublicUser = CheckUser.checkUserType(isPublicUser);
        if (isPublicUser) {
            ui.userShowWelcome();
            runPublicUser();
        } else {
            runAdmin();
        }
        System.exit(0);
    }

    public void runPublicUser() throws DukeExceptions {
        boolean isExit = false;

        while (!isExit) {
            try {
                if (canteenIndex < 0) {
                    ui.showDisplayCanteens(canteens);
                    String line = ui.readCommand();
                    canteenIndex = parser.parseInt(line, 1, canteens.size()) - 1;
                } else if (storeIndex < 0) {
                    Canteen canteen = canteens.get(canteenIndex);
                    ui.showDisplayStores(canteen);
                    String line = ui.readCommand();
                    storeIndex = parser.parseInt(line, 1, canteen.getNumStores()) - 1;
                } else {
                    Canteen canteen = canteens.get(canteenIndex);
                    Store store = canteen.getStore(storeIndex);
                    ui.showStoreOptions(canteen.getCanteenName(),
                            store.getStoreName());
                    String line = ui.readCommand();
                    Command c = parser.parse(line, store, canteens.get(canteenIndex).getNumStores());
                    c.execute(canteens, ui);
                }
            } catch (DukeExceptions e) {
                ui.showError(e.getMessage());
            }
        }
    }

    public void runAdmin() {
        ui.adminShowWelcome();
        AdminVerification.verifyInputPassword();
        ui.showAdminVerified();

        while (true) {
            ui.showAdminOptions();
            try {
                String line = ui.readCommand();
                Command c = parser.parseAdminCommand(line,canteens.get(0).getNumStores());
                c.execute(canteens, ui);
            } catch (DukeExceptions e) {
                ui.showError(e.getMessage());
            }
        }
    }

    public static void resetIndexes() {
        canteenIndex = -1;
        storeIndex = -1;
    }

}
