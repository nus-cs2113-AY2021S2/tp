package seedu.duke;

import seedu.duke.commandparser.CommandParser;
import seedu.duke.ui.UI;

public class Duke {
    private UI ui;

    private void start() {
        ui = new UI();
        ui.printGreetings();
    }

    private void loopCommand() {
        CommandParser commandParser = new CommandParser();
        ui.printHelpPrompt();
        String command = ui.getUserInput();
        while (!command.equals("exit")) {
            commandParser.parseCommand(command);
            ui.printHelpPrompt();
            command = ui.getUserInput();
        }
        ui.printExitMessage();
    }

    public void run() {
        start();
        loopCommand();
    }


    public static void main(String[] args) {
        new Duke().run();
    }
    /*
    private static void exit() {
        ui.printExitMessage();
        System.exit(0);
    }

     */
}
