package seedu.duke;

public class Duke {
    public Ui ui;
    public Deliveryman deliveryman;
    /**
     * Main entry-point for the java.duke.Duke application.
     */
    public Duke() {
        ui = new Ui();
    }


    public void run() {
        deliveryman = DataManager.loadProfile();
        Route.loadRoutes();
        ui.showWelcomeScreen();
        ui.showLoopingMenuUntilExit(deliveryman);
    }

    public static void main(String[] args) {
        new Duke().run();
    }
}