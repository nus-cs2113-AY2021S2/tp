package seedu.duke;

import seedu.duke.account.FitCenter;
import seedu.duke.account.User;
import seedu.duke.command.Command;
import seedu.duke.command.CommandResult;
import seedu.duke.command.ExitCommand;
import seedu.duke.commandparser.CommandParser;
import seedu.duke.ui.UI;

public class Healthier {
    private UI ui;
    private User currentUser = new User();
    private FitCenter currentFitCenter = currentUser.getFitCenter();

    private void start() {
        ui = new UI();
        ui.printGreetings();
    }

    private void loopCommand() {
        CommandParser commandParser = new CommandParser(currentFitCenter);
        Command command;
        do {
            String userInput = ui.getUserInput();
            command = commandParser.parseCommand(userInput);
            command.setFitCenter(currentFitCenter);
            CommandResult result = command.execute();
            UI.printMessage(result.getFeedback());
            commandParser.clearParserParams();
        } while (!ExitCommand.isExitCommand(command));
    }

    private void exit() {
        ui.printExitMessage();
        System.exit(0);
    }

    public void run() {
        start();
        loopCommand();
        exit();
    }

    public static void main(String[] args) {
        new Healthier().run();
    }
}
