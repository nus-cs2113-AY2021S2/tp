package seedu.duke;

import seedu.duke.command.Command;
import seedu.duke.command.CommandHandler;
import seedu.duke.command.ExitCommand;
import seedu.duke.exception.InvalidCommandException;
import seedu.duke.parser.ParserHandler;
import seedu.duke.record.RecordList;
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
        this.ui = new Ui();
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
            //System.out.println("You have entered: " + rawInput);
            ArrayList<String> parsedStringList = ParserHandler.getParseInput(rawInput);
            //System.out.println("You have entered: " + parsedStringList);
            command = parseCommand(parsedStringList);
            if (command == null) {
                continue;
            }
            command.execute(records, ui, storage);
        } while (!ExitCommand.isExit(command));
    }

    private Command parseCommand(ArrayList<String> parsedString) {
        try {
            Command type = CommandHandler.handle(parsedString);
            System.out.println("Command is parsed");
            return type;
        } catch (InvalidCommandException e) {
            System.out.println(e.getMessage());
            //throw new RuntimeException(e);
            return null;
        }
    }
}
