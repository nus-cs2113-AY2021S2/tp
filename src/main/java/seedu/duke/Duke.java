package seedu.duke;

import seedu.duke.command.Command;
import seedu.duke.command.CommandHandler;
import seedu.duke.command.ExitCommand;
import seedu.duke.parser.ParserHandler;
import seedu.duke.record.RecordList;
import seedu.duke.exception.CommandException;

import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

import java.util.ArrayList;

public class Duke {
    private Ui ui;
    private RecordList records;
    private Storage storage;

    /*
    public Duke() {
        ui = new Ui();
        storage = new Storage();
        records = new RecordList();
    }
     */

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

    private void start() {
        ui = new Ui();
        storage = new Storage();
        records = new RecordList(storage.loadFile());
        ui.printWelcomeMessage();
    }

    private void end() {
        //ui.printGoodByeMessage();
        System.out.println("PROGRAM TERMINATES HERE!");
    }

    private void commandLooper() {
        Command command;
        String rawInput;
        do {
            rawInput = ui.getUserInput();
            ArrayList<String> parsedStringList = ParserHandler.getParseInput(rawInput);
            command = parseCommand(parsedStringList);
            if (command == null) {
                continue;
            }
            command.execute(records, ui, storage);
        } while (!ExitCommand.isExit(command));
    }

    private Command parseCommand(ArrayList<String> parsedString) {
        try {
            //System.out.println("Command is parsed");
            return CommandHandler.createCommand(parsedString);
        } catch (CommandException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
