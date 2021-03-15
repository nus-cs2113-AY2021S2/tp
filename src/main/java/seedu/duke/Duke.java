package seedu.duke;

import seedu.duke.command.Command;

/**
 * Main class of the application, where the entry point is.
 */
public class Duke {
    private Data data;
    private Ui ui;
    private Parser parser;

    /**
     * This initializes all resources for the program.
     */
    private Duke() {
        ui = new Ui();
        data = new Data();
        parser = new Parser(ui, data);
    }

    /**
     * This is the actual program logic for the application.
     */
    private void run() {
        ui.printWelcome();

        while (true) {
            String fullCommand = ui.readInput();
            if (fullCommand == null) {
                // Reached EOF but no exit command is executed - we still exit
                break;
            }

            try {
                Command cmd = parser.parse(fullCommand);
                cmd.execute();
                if (cmd.isExit()) {
                    break;
                }
            } catch (Exception e) {
                ui.printException(e);
            }
        }
        // Program Exits, do some cleaning
        ui.closeScanner();
    }

    /**
     * Main entry-point for the java.duke.Duke application.
     */
    public static void main(String[] args) {
        Duke duke = new Duke();
        duke.run();
    }
}
