package seedu.duke;

import seedu.duke.commands.Command;
import seedu.duke.exception.DukeException;
import seedu.duke.exception.UnknownCommandException;
import seedu.duke.parser.Parser;
import seedu.duke.storage.Storage;
import seedu.duke.ui.UI;

import java.util.Scanner;

public class Duke {

    private static final UI ui = new UI();
    private static final Storage storage = new Storage();
    private static final Parser parser = new Parser();

    public static void main(String[] args) {

        //start and load
        start();

        //receive user input
        run();

        //exit
        exit();
    }

    private static void start() {
        //print welcome
        ui.printWelcome();

        //load data from file
        storage.loadData();
    }

    private static void run() {
        Boolean isExit = false;
        Scanner in = new Scanner(System.in);

        //loop
        while (!isExit) {
            //scan
            String input = in.nextLine();
            //parse
            Command command = null;
            try {
                command = parser.parse(input);
            } catch (DukeException e) {
                // TODO - pass to ui to print warning
                System.out.println("Unknown Command");
            }

            //execute
            isExit = command.execute();
        }

    }

    private static void exit() {
        //print exit message
        ui.printBye();
    }
}
