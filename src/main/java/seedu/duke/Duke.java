package seedu.duke;

import seedu.duke.module.ModuleList;
import seedu.duke.parser.Parser;
import seedu.duke.storage.Loader;
import seedu.duke.storage.Writer;
import seedu.duke.ui.UI;

public class Duke {

    private static final UI ui = new UI();
    private static final Parser parser = new Parser();
    private static final Loader loader = new Loader();
    private static final Writer writer = new Writer();

    public static void main(String[] args) {

        //Start and load
        start();

        //Receive user input
        run();

        //Exit
        exit();
    }

    private static void start() {
        //Print welcome
        ui.printWelcome();

        //Load module names
        ModuleList.loadModuleNames(loader);
    }

    private static void run() {
        Boolean isExit = false;

        //Loop
        while (!isExit) {
            //Scan


            //Parse
            //Command command = parser.parse(input);

            //Execute
            //isExit = command.execute();
        }

    }

    private static void exit() {
        //Print exit message
        ui.printBye();
    }
}
