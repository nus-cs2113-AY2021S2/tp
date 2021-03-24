package seedu.duke;

import seedu.duke.command.BorrowersCreditScoreForReturnedLoans;
import seedu.duke.command.Command;
import seedu.duke.command.CommandHandler;
import seedu.duke.command.ExitCommand;
import seedu.duke.exception.FileLoadingException;
import seedu.duke.parser.ParserHandler;
import seedu.duke.record.RecordList;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

import java.util.ArrayList;

public class Duke {
    private Ui ui;
    private RecordList records;
    private Storage storage;
    private CommandHandler commandHandler;
    private ParserHandler parserHandler;
    private BorrowersCreditScoreForReturnedLoans borrowersCreditScoreForReturnedLoans;

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

    /**
     * Exits the application.
     */
    private void end() {
        ui.printGoodByeMessage();
        System.exit(0);
    }

    /**
     * Starts the main application.
     */
    private void start() {
        try {
            ui = new Ui();
            storage = new Storage();
            records = new RecordList();
            parserHandler = new ParserHandler();
            commandHandler = new CommandHandler();
            storage.loadFile();
            records = new RecordList(storage.getRecordListData());
            borrowersCreditScoreForReturnedLoans = new BorrowersCreditScoreForReturnedLoans(
                    storage.getBorrowersCreditScoreForReturnedLoansMapData());
            ui.printWelcomeMessage();
        } catch (FileLoadingException e) {
            Ui.printInitError();
            System.exit(-1);
        }
    }

    /**
     * Loops the application until an EXIT command is parsed.
     */
    private void commandLooper() {
        Command command;
        String rawInput;
        do {
            rawInput = ui.getUserInput();
            ArrayList<String> parsedStringList = parserHandler.getParseInput(rawInput);
            assert parsedStringList.size() != 0 : "Empty Parser Error";
            command = commandHandler.parseCommand(parsedStringList, records);
            if (command != null) {
                command.execute(records, ui, storage, borrowersCreditScoreForReturnedLoans);
            }
        } while (!ExitCommand.isExit(command));
    }
}
