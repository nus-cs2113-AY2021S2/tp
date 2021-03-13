package seedu.duke;

import canteens.Canteen;
import command.Command;
import exceptions.DukeExceptions;
import parser.Parser;
import storage.Storage;
import ui.Ui;

import java.util.ArrayList;

public class Duke {
    private static ArrayList<Canteen> canteens; // todo: add a canteen manager
    private static Ui ui;
    private static Storage storage;
    private static final String filePath = "data/storage.txt";

    /**
     * Main entry-point for the java.duke.Duke application.
     */
    public static void main(String[] args) {
        ui = new Ui();
        storage = new Storage(filePath);
        canteens = storage.load();

        echo();
        System.exit(0);
    }

    public static void echo() {
        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String line = ui.readCommand();
                Command c = Parser.parse(line);
                c.execute(canteens, ui);
                isExit = c.isExit();
            } catch (DukeExceptions e) {
                ui.showError();
            }
        }
    }
}
