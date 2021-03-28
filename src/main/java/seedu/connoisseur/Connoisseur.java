package seedu.connoisseur;

import seedu.connoisseur.commandlist.CommandList;
import seedu.connoisseur.exceptions.DuplicateException;
import seedu.connoisseur.parser.Parser;
import seedu.connoisseur.storage.Storage;
import seedu.connoisseur.ui.Ui;

import java.util.ArrayList;

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
        if (storage.retrieveConnoisseurTextFile() & storage.retrieveRecommendationTextFile()) {
            commandList = new CommandList(storage.loadConnoisseurData(), storage.loadRecommendationData(), ui, storage);
        } else if (storage.retrieveConnoisseurTextFile() & !storage.retrieveRecommendationTextFile()) {
            commandList = new CommandList(storage.loadConnoisseurData(), new ArrayList<>(), ui, storage);
        } else if (!storage.retrieveConnoisseurTextFile() & storage.retrieveRecommendationTextFile()) {
            commandList = new CommandList(new ArrayList<>(), storage.loadRecommendationData(), ui, storage);
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


