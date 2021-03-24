package nusfoodreviews;

import admin.AdminVerification;
import canteens.Canteen;
import command.Command;
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
        parser = new Parser(this);
        storage = new Storage(filePath);
        canteens = storage.load();
    }

    /**
     * Main entry-point for the java.nusfoodreviews.NusFoodReviews application.
     */
    public static void main(String[] args) throws DukeExceptions {
        new NusFoodReviews("data/storage.txt").run();

    }

    public void run() throws DukeExceptions {
        ui.showLogo();
        ui.showLoginPage();
        assert (!isPublicUser);
        isPublicUser = CheckUser.checkUserType(ui);
        if (isPublicUser) {
            runPublicUser();
        } else {
            runAdmin();
        }
        System.exit(0);
    }

    public void runPublicUser() throws DukeExceptions {
        ui.userShowWelcome();

        while (true) {
            try {
                if (canteenIndex < 0) {
                    setCanteenIndex();
                } else if (storeIndex < 0) {
                    setStoreIndex();
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
                Command c = parser.parseAdminCommand(line);
                c.execute(canteens, ui);
            } catch (DukeExceptions e) {
                ui.showError(e.getMessage());
            }
        }
    }

    public static void resetAllIndexes() {
        canteenIndex = -1;
        storeIndex = -1;
    }

    public static void resetStoreIndex() {
        storeIndex = -1;
    }

    public int getCanteenIndex() {
        return canteenIndex;
    }

    public void setCanteenIndex() throws DukeExceptions {
        ui.showDisplaySelectCanteens(canteens);
        String line = ui.readCommand();
        if (line.equals("exit")) {
            ui.showGoodbye();
            System.exit(0);
        }
        canteenIndex = parser.parseInt(line, 1, canteens.size()) - 1;
    }

    public int getStoreIndex() {
        return storeIndex;
    }

    public void setStoreIndex() throws DukeExceptions {
        Canteen canteen = canteens.get(canteenIndex);
        ui.showDisplaySelectStores(canteen);
        String line = ui.readCommand();
        if (line.equals("exit")) {
            ui.showGoodbye();
            System.exit(0);
        }
        storeIndex = parser.parseInt(line, 1, canteen.getNumStores()) - 1;
    }

    public ArrayList<Canteen> getCanteens() {
        return canteens;
    }

}
