package seedu.duke;

import controller.AppController;

import java.io.IOException;
import ui.ui;

public class Duke {
    /**
     * Main entry-point for the java.duke.Duke application.
     */

    public static void main(String[] args) throws IOException {
        ui.printWelcomeMessage();
        ui.printHelpMessage();
        AppController controller = new AppController();
        controller.run();
        ui.printExitMessage();
    }
}

