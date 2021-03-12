package seedu.duke;

import seedu.duke.command.Command;
import seedu.duke.command.CommandHandler;
import seedu.duke.command.ExitCommand;
import seedu.duke.exception.FileLoadingException;
import seedu.duke.exception.InvalidFileInputException;
import seedu.duke.parser.ParserHandler;
import seedu.duke.record.RecordList;

import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

import java.util.ArrayList;

public class Duke {
    private Ui ui;
    private RecordList records;
    private Storage storage;

    public Duke() {
        ui = new Ui();
        storage = new Storage();
        records = new RecordList();
    }

    /**
     * Main entry-point for the java.duke.Duke application.
     */
    public static void main(String[] args) {
        new Duke().run();
    }

    /**
     * Runner for the FINUX Application.
     */
    private void run() {
        start();
        commandLooper();
        end();
    }

    private void end() {
        ui.printGoodByeMessage();
        System.exit(0);
    }

    // @@ author jonahtwl-reused
    // No recovery should be expected from a corrupted file.
    // Reused from: https://github.com/se-edu/addressbook-level2/blob/master/src/seedu/addressbook/Main.java

    private void start() {
        try {
            ui = new Ui();
            storage = new Storage();
            records = new RecordList(storage.loadFile());
            ui.printWelcomeMessage();
        } catch (FileLoadingException e) {
            Ui.printInitError();
            throw new RuntimeException(e.getMessage());
        }
    }

    private void commandLooper() {
        Command command;
        String rawInput;
        do {
            rawInput = ui.getUserInput();
            ArrayList<String> parsedStringList = ParserHandler.getParseInput(rawInput);
            command = CommandHandler.parseCommand(parsedStringList, records);
            if (command != null) {
                command.execute(records, ui, storage);
            }
        } while (!ExitCommand.isExit(command));
    }

}
