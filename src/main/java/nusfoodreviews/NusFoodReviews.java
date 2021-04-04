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

import java.io.IOException;
import java.util.ArrayList;


public class NusFoodReviews {
    private ArrayList<Canteen> canteens; // todo: add a canteen manager
    private Ui ui;
    private Storage storage;
    private Parser parser;
    private boolean isExit = false;
    private static int userIndex = -1;   // userIndex=0 for Public, userIndex=1 for admin
    private static int canteenIndex = -1;
    private static int storeIndex = -1;

    public NusFoodReviews(String filePath) {
        ui = new Ui();
        parser = new Parser(this, ui);
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
        while (true) {
            if (userIndex == -1) {
                assert (canteenIndex == -1);
                assert (storeIndex == -1);
                userIndex = chooseUser();
            } else if (userIndex == 1) {
                runAdmin();
            } else if (userIndex == 0) {
                runPublicUser();
            } else {
                System.exit(1);
            }
        }
    }

    public int chooseUser() {
        ui.showLoginPage();
        boolean isPublicUser = CheckUser.checkUserType(ui);
        if (isPublicUser) {
            ui.userShowWelcome();
            return 0;
        } else {
            ui.adminShowWelcome();
            AdminVerification.verifyInputPassword();
            ui.showAdminVerified();
            return 1;
        }
    }

    public void runPublicUser() {
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
                Command c = parser.parse(line, store, canteen);
                c.execute(canteens, ui);
            }
        } catch (DukeExceptions | IOException e) {
            ui.showError(e.getMessage());
        }
    }

    public void runAdmin() {
        ui.showAdminOptions();
        try {
            String line = ui.readCommand();
            Command c = parser.parseAdminCommand(line);
            c.execute(canteens, ui);
        } catch (DukeExceptions | IOException e) {
            ui.showError(e.getMessage());
        }
    }

    public static void resetAllIndex() {
        userIndex = -1;
        canteenIndex = -1;
        storeIndex = -1;
    }

    public static void resetCanteenStoreIndex() {
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
        ui.showDisplaySelectCanteens(canteens, "view");
        String line = ui.readCommand();
        if (line.equals("exit")) {
            ui.showGoodbye();
            System.exit(0);
        } else if (line.equals("cancel")) {
            canteenIndex = -1;
            return;
        }
        canteenIndex = parser.parseInt(line, 1, canteens.size()) - 1;
    }

    public int getStoreIndex() {
        return storeIndex;
    }

    public void setStoreIndex() throws DukeExceptions {
        Canteen canteen = canteens.get(canteenIndex);
        ui.showDisplaySelectStores(canteen);
        if (canteen.getNumStores() < 1) {
            resetCanteenStoreIndex();
            return;
        }
        String line = ui.readCommand();
        if (line.equals("exit")) {
            ui.showGoodbye();
            System.exit(0);
        } else if (line.equals("cancel")) {
            storeIndex = -1;
            return;
        }
        storeIndex = parser.parseInt(line, 1, canteen.getNumStores()) - 1;
    }

    public ArrayList<Canteen> getCanteens() {
        return canteens;
    }

}
