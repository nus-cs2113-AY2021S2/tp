package seedu.duke;

import java.util.Scanner;

public class Duke {
    public Ui ui;
    /**
     * Main entry-point for the java.duke.Duke application.
     */
    public Duke() {
        ui = new Ui();
    }

    public void run() {
        Deliveryman.deliveryman = new Deliveryman("Obi Wan", "HIGHGROUND", "YT-1300");
        ui.showWelcomeScreen();
        ui.showLoopingMenuUntilExit();
    }

    public static void main(String[] args) {
        new Duke().run();
    }
}