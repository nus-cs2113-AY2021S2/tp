package seedu.duke;

import admin.AdminVerification;
import canteens.Canteen;
import command.Command;
import exceptions.DukeExceptions;
import parser.Parser;
import storage.Storage;
import ui.Ui;

import java.util.ArrayList;

public class Duke {
    private ArrayList<Canteen> canteens; // todo: add a canteen manager
    private Ui ui;
    private Storage storage;
    private Parser parser;
    private boolean isPublicUser = false;
    private boolean isAdmin = false;
    private boolean isVerified = false;
    private boolean isExit = false;

    public Duke(String filePath) {
        ui = new Ui();
        parser = new Parser();
        storage = new Storage(filePath);
        canteens = storage.load();
    }

    /**
     * Main entry-point for the java.duke.Duke application.
     */
    public static void main(String[] args) {
        new Duke("data/storage.txt").run();
    }

    public void run() {
        ui.showLoginPage();
        checkUser();
        if (isPublicUser) {
            runPublicUser();
        } else {
            runAdmin();
        }
        System.exit(0);
    }

    public void checkUser() {
        while (!(isPublicUser | isAdmin)) {
            try {
                String input = Ui.readCommand();
                if (!(input.equals("1") | input.equals("2") | input.equals("exit"))) {
                    throw new DukeExceptions("Wrong input, enter either 1 or 2.");
                }
                if (input.equals("1")) {
                    isPublicUser = true;
                } else if (input.equals("2")) {
                    isAdmin = true;
                } else {
                    ui.showGoodbye();
                    System.exit(0);
                }
            } catch (DukeExceptions e) {
                ui.showError(e.getMessage());
            }
        }
    }

    public void runPublicUser() {
        ui.userShowWelcome();
        boolean isExit = false;
        // Have not yet added ability to add stores, for now: end application if storage is empty.
        if (canteens.size() == 0) {
            return;
        }
        assert false;
        while (!isExit) {
            try {
                String line = ui.readCommand();
                Command c = parser.parse(line, canteens.get(0).getNumStores());
                c.execute(canteens, ui);
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
