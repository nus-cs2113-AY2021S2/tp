package seedu.connoisseur;

import seedu.connoisseur.commandlist.CommandList;
import seedu.connoisseur.parser.Parser;
import seedu.connoisseur.storage.Storage;
import seedu.connoisseur.ui.Ui;


public class Connoisseur {

    /**
     * Main entry-point for the java.connoisseur.Connoisseur application.
     */
    public static void main(String[] args) {
        new Connoisseur();
    }

    /**
     * Sets up required files for Duke to start.
     */
    public Connoisseur() {
        Storage.createFolder();
        Storage storage = new Storage();
        if (storage.retrieveTextFile()) {
            new CommandList(storage.loadData());
        }
        Ui.printGreeting();
        String input;
        Ui ui = new Ui();
        boolean isExitCommand = false;
        while (!isExitCommand) {
            input = ui.readCommand();
            Parser parser = new Parser();
            isExitCommand = parser.determineCommand(input);
        }
    }
}


