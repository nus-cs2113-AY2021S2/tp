package seedu.connoisseur;

import seedu.connoisseur.exceptions.DuplicateException;
import seedu.connoisseur.parser.Parser;
import seedu.connoisseur.storage.Storage;
import seedu.connoisseur.ui.Ui;

import static seedu.connoisseur.messages.Messages.COMMAND_PROMPT;

import seedu.connoisseur.commands.Commands;

public class Connoisseur {

    /**
     * Main entry-point for the java.connoisseur.Connoisseur application.
     */
    public static void main(String[] args) throws DuplicateException {
        new Connoisseur();
    }

    /**
     * Sets up required files for Connoisseur to start.
     */
    public Connoisseur() throws DuplicateException {
        Ui ui = new Ui();
        Storage storage = new Storage(ui);
        Commands commands;
        if (storage.retrieveDataFile()) {
            commands = new Commands(storage.loadConnoisseurData(), ui, storage);
        } else {
            commands = new Commands(ui, storage);
        }
        ui.printGreeting();
        Parser parser = new Parser(commands);
        boolean isExitCommand = false;

        while (!isExitCommand) {
            ui.println(COMMAND_PROMPT);
            String input;
            input = ui.readCommand();
            isExitCommand = parser.determineCommand(input);
        }
    }
}


