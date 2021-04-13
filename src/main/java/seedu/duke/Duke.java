package seedu.duke;

import controller.AppController;

import java.io.IOException;

import ui.Ui;

public class Duke {
    /**
     * Main entry-point for the our application.
     */
    public static void main(String[] args) throws IOException {
        Ui.printWelcomeMessage();
        Ui.printHelpMessage();
        AppController controller = new AppController();
        controller.run();
        Ui.printExitMessage();
    }
}
