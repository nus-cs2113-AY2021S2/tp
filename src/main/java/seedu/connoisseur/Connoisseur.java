package seedu.connoisseur;

import seedu.connoisseur.parser.Parser;
import seedu.connoisseur.ui.Ui;

public class Connoisseur {
    private Ui ui;
    private Parser parser;

    /**
     * Main entry-point for the java.connoisseur.Connoisseur application.
     */
    public static void main(String[] args) {
        new Connoisseur().run();
    }

    public void run() {
        ui = new Ui();
        parser = new Parser();

        Ui.printGreeting();
        String input;
        boolean isExit = false;

        while (!isExit) {
            input = ui.readCommand();
            isExit = parser.determineCommand(input);
        }

        Ui.printExitMessage();

    }
}


