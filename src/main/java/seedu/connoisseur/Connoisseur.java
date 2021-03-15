package seedu.connoisseur;

import seedu.connoisseur.commandlist.CommandList;
import seedu.connoisseur.parser.Parser;
import seedu.connoisseur.review.Review;
import seedu.connoisseur.storage.Storage;
import seedu.connoisseur.ui.Ui;


public class Connoisseur {

    /**
     * Task list created for user.
     */
    private CommandList reviewList = new CommandList();

    /**
     * Main entry-point for the java.connoisseur.Connoisseur application.
     */
    public static void main(String[] args) {
        new Connoisseur().run();
    }

    /**
     * Sets up required files for Duke to start.
     */
    public Connoisseur() {

        Storage.createFolder();

        Storage storage = new Storage();
        if (storage.retrieveTextFile()) {
            reviewList = new CommandList(storage.loadData());
        }

    }

    public void run() {
        Ui ui = new Ui();
        Parser parser = new Parser();


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


