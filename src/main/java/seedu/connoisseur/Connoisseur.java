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
        CommandList commandList;
        if (storage.retrieveTextFile()) {
            commandList = new CommandList(storage.loadData());
        } else {
            commandList = new CommandList();
        }
        Ui.printGreeting();
        String input;
        Ui ui = new Ui();
        Parser parser = new Parser(commandList);
        boolean isExitCommand = false;
        while (!isExitCommand) {
            input = ui.readCommand();
            isExitCommand = parser.determineCommand(input);
        }
    }
}


