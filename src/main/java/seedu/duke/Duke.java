package seedu.duke;

import java.util.Scanner;

public class Duke {
    public Ui ui;
    public DataManager dataManager;
    public Deliveryman deliveryman;
    /**
     * Main entry-point for the java.duke.Duke application.
     */
    public Duke() {
        ui = new Ui();
        dataManager = new DataManager();
    }

    public void run() {
        deliveryman = dataManager.loadProfile();
        ui.showWelcomeScreen();
        ui.showLoopingMenuUntilExit(deliveryman, dataManager);
    }

    public static void main(String[] args) {
        new Duke().run();
    }
}