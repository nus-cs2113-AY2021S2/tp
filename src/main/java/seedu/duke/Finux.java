package seedu.duke;

import seedu.duke.command.CreditScoreReturnedLoansMap;
import seedu.duke.command.Command;
import seedu.duke.command.CommandHandler;
import seedu.duke.exception.FileLoadingException;
import seedu.duke.parser.ParserHandler;
import seedu.duke.record.RecordList;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

import java.util.ArrayList;

import static seedu.duke.common.Constant.FINUX_LOGGER;

public class Finux {
    private Ui ui;
    private Storage storage;
    private ParserHandler parserHandler;
    private CommandHandler commandHandler;
    private RecordList recordList;
    private CreditScoreReturnedLoansMap creditScoreReturnedLoansMap;

    /**
     * Main entry-point for Finux application.
     */
    public static void main(String[] args) {
        new Finux().run();
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
     * Starts the main application.
     */
    private void start() {
        try {
            ui = new Ui();
            storage = new Storage();
            parserHandler = new ParserHandler();
            commandHandler = new CommandHandler();
            storage.loadFile();
            recordList = new RecordList(storage.getRecordListData());
            creditScoreReturnedLoansMap = new CreditScoreReturnedLoansMap(storage.getMapData());
            ui.printWelcomeMessage();
        } catch (FileLoadingException e) {
            ui.printInitError();
            FINUX_LOGGER.logWarning("Unable to load finux.txt!");
            System.exit(-1);
        }
    }

    /**
     * Loops the application until an EXIT command is parsed.
     */
    private void commandLooper() {
        while (!commandHandler.isExit()) {
            String rawInput = ui.getUserInput();
            ArrayList<String> parsedStringList = parserHandler.getParseInput(rawInput);
            assert parsedStringList.size() != 0 : "Empty Parser Error";
            Command command = commandHandler.parseCommand(parsedStringList, recordList);
            if (command == null) {
                continue;
            }
            command.execute(recordList, ui, storage, creditScoreReturnedLoansMap);
        }
    }

    /**
     * Exits the application.
     */
    private void end() {
        ui.printGoodByeMessage();
        System.exit(0);
    }
}
