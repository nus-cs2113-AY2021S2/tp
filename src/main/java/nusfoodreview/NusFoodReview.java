package nusfoodreview;

import admin.AdminVerification;
import canteens.Canteen;
import command.Command;
import command.DisplayStoresCommand;
import exceptions.DukeExceptions;
import parser.Parser;
import storage.Storage;
import ui.Ui;
import checkuser.CheckUser;

import java.util.ArrayList;

public class NusFoodReview {
    private ArrayList<Canteen> canteens; // todo: add a canteen manager
    private Ui ui;
    private Storage storage;
    private Parser parser;
    private boolean isExit = false;
    private boolean isPublicUser;
    private Command displayStore = new DisplayStoresCommand();

    public NusFoodReview(String filePath) {
        ui = new Ui();
        parser = new Parser();
        storage = new Storage(filePath);
        canteens = storage.load();
    }

    /**
     * Main entry-point for the java.duke.Duke application.
     */
    public static void main(String[] args) throws DukeExceptions {
        new NusFoodReview("data/storage.txt").run();
    }

    public void run() throws DukeExceptions {
        ui.showLogo();
        ui.showLoginPage();
        isPublicUser = CheckUser.checkUserType(isPublicUser);
        if (isPublicUser) {
            runPublicUser();
        } else {
            runAdmin();
        }
        System.exit(0);
    }

    public void runPublicUser() throws DukeExceptions {
        ui.userShowWelcome();
        displayStore.execute(canteens, ui);
        // Have not yet added ability to add stores, for now: end application if storage is empty.
        if (canteens.size() == 0) {
            return;
        }
        assert true;


        //take in the store the user wants to see first
        String index = ui.readCommand();
        ui.showStoreOptions(canteens.get(0).getCanteenName(),
                canteens.get(0).getStore(Integer.parseInt(index) - 1).getStoreName());
        boolean isExit = false;

        while (!isExit) {

            try {
                String line = ui.readCommand();
                Command c = parser.parse(line,index,canteens.get(0).getNumStores());
                c.execute(canteens, ui);
                ui.showStoreOptions(canteens.get(0).getCanteenName(),
                        canteens.get(0).getStore(Integer.parseInt(index) - 1).getStoreName());
                isExit = c.isExit();
            } catch (DukeExceptions e) {
                ui.showError(e.getMessage());
            }

        }
    }

    public void runAdmin() {
        ui.adminShowWelcome();
        AdminVerification.verifyInputPassword();
        ui.showAdminVerified();

        while (!isExit) {
            ui.showAdminOptions();
            try {
                String line = ui.readCommand();
                Command c = parser.parseAdminCommand(line,canteens.get(0).getNumStores());
                c.execute(canteens, ui);
                isExit = c.isExit();
            } catch (DukeExceptions e) {
                ui.showError(e.getMessage());
            }
        }
    }
}
