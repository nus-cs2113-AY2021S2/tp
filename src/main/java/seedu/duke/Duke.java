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
        System.exit(0);
    }

    private void start() {
        ui = new Ui();
        storage = new Storage();
        records = new RecordList(storage.loadFile());
        ui.printWelcomeMessage();
    }

    private void commandLooper() {
        Command command;
        String rawInput;
        do {
            rawInput = ui.getUserInput();
            ArrayList<String> parsedStringList = ParserHandler.getParseInput(rawInput);
            command = parseCommand(parsedStringList);
            if (command != null) {
                command.execute(records, ui, storage);
            }
        } while (!ExitCommand.isExit(command));
    }

    //Shift to ParserHandler class
    private Command parseCommand(ArrayList<String> parsedString) {
        try {
            //System.out.println("Command is parsed");
            return CommandHandler.createCommand(parsedString, records);
            //Command type = CommandHandler.createCommand(parsedString, records);
            //System.out.println("Command is parsed");
            //return type;
        } catch (CommandException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
