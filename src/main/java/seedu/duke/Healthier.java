package seedu.duke;

import seedu.duke.commandparser.CommandParser;
import seedu.duke.ui.UI;

public class Healthier {
    private UI ui;

    private void start() {
        ui = new UI();
        ui.printGreetings();
    }

    private void loopCommand() {
        CommandParser commandParser = new CommandParser();
        ui.printHelpPrompt();
        String userInput = ui.getUserInput();
        while (!userInput.equals("exit")) {
            //Command command = commandParser.parseCommand(userInput);
            commandParser.parseCommand(userInput);
            ui.printHelpPrompt();
            //command = ui.getUserInput();
            commandParser.clearParserParams();
            userInput = ui.getUserInput();
        }
        ui.printExitMessage();
    }

    public void run() {
        start();
        loopCommand();
    }


    public static void main(String[] args) {
        new Healthier().run();
    }
    /*
    private static void exit() {
        ui.printExitMessage();
        System.exit(0);
    }

     */
}
