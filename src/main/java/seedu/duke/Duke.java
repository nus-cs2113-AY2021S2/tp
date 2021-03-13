package seedu.duke;

import canteens.Canteen;
import command.Command;
import exceptions.DukeExceptions;
import parser.Parser;
import storage.Storage;
import stores.Store;
import ui.Ui;

import java.util.ArrayList;

public class Duke {
    private ArrayList<Canteen> canteens; // todo: add a canteen manager
    private Ui ui;
    private Storage storage;
    private Parser parser;

    public Duke(String filePath) {
        ui = new Ui();
        parser = new Parser();
        storage = new Storage(filePath);
        canteens = storage.load();
    }

    /**
     * Main entry-point for the java.duke.Duke application.
     */
    public static void main(String[] args) {
        new Duke("data/storage.txt").run();
    }

    public void run() {
        echo();
        System.exit(0);
    }

    public void echo() {
        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String line = ui.readCommand();
                Command c = parser.parse(line, canteens.get(0).getNumStores());
                c.execute(canteens, ui);
                isExit = c.isExit();
            } catch (DukeExceptions e) {
                ui.showError(e.getMessage());
            }
        }
    }
}
