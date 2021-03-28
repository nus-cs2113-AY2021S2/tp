package seedu.connoisseur;

import seedu.connoisseur.commandlist.CommandList;
import seedu.connoisseur.exceptions.DuplicateException;
import seedu.connoisseur.parser.Parser;
import seedu.connoisseur.storage.Storage;
import seedu.connoisseur.ui.Ui;

import static seedu.connoisseur.messages.Messages.COMMAND_PROMPT;

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
        CommandList commandList;
        if (storage.retrieveDataFile()) {
            commandList = new CommandList(storage.loadConnoisseurData(), ui, storage);
        } else {
            commandList = new CommandList(ui, storage);
        }
        ui.printGreeting();
        String input;
        Parser parser = new Parser(commandList);
        boolean isExitCommand = false;

        while (!isExitCommand) {
            ui.println(COMMAND_PROMPT);
            input = ui.readCommand();
            isExitCommand = parser.determineCommand(input);
        }
    }
}


