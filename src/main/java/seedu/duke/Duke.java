package seedu.duke;

import seedu.duke.command.Command;
import seedu.duke.command.CommandHandler;
import seedu.duke.exception.CommandException;
import seedu.duke.parser.ParserHandler;
import seedu.duke.record.RecordHandler;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

import java.util.ArrayList;

public class Duke {
    private RecordHandler records;
    private Ui ui;
    private Storage storage;

    /**
     * Main entry-point for the java.duke.Duke application.
     */
    public static void main(String[] args) {
        /*
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("What is your name?");

        Scanner in = new Scanner(System.in);
        System.out.println("Hello " + in.nextLine());
         */
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
        records = new RecordHandler();
        storage = new Storage();
        ui.printWelcomeMessage();
    }

    private void end() {
        ui.printGoodByeMessage();
    }

    private void commandLooper() {
        boolean isExit = false;
        while (!isExit) {
            try {
                String rawInput = ui.getUserInput();
                ArrayList<String> parsedInput = ParserHandler.getParseInput(rawInput);
                Command c = CommandHandler.createCommand(parsedInput);
                c.execute(records, ui, storage);
                isExit = c.isExit();
            } catch (CommandException e) {
                ui.printMessage(e.getMessage());
            }
        }
    }
}
