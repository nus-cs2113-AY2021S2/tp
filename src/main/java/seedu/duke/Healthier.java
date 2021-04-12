package seedu.duke;

import seedu.duke.account.FitCenter;
import seedu.duke.account.User;
import seedu.duke.command.Command;
import seedu.duke.command.CommandResult;
import seedu.duke.command.ExitCommand;
import seedu.duke.commandparser.CommandParser;
import seedu.duke.exception.ExceedTimeInOneDayException;
import seedu.duke.goal.timemanager.TimeController;
import seedu.duke.exception.TypeException;
import seedu.duke.storage.Storage;
import seedu.duke.ui.UI;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;

public class Healthier {
    private UI ui;
    private Storage storage;
    private final User currentUser = new User();
    private final FitCenter currentFitCenter = currentUser.getFitCenter();

    private void start() {
        ui = new UI();
        TimeController timeController = new TimeController();
        timeController.checkForTime(currentFitCenter);
        String recordFilePath = "data" + File.separator + "records.txt";
        String goalFilePath = "data" + File.separator + "goals.txt";
        try {
            storage = new Storage(recordFilePath, goalFilePath);
            storage.readRecords(currentUser);
            storage.readGoals(currentUser);
        } catch (IOException e) {
            ui.showFileErrorMessage();
            e.printStackTrace();
            System.exit(0);
        } catch (ParseException | NumberFormatException | TypeException | ExceedTimeInOneDayException e) {
            e.printStackTrace();
            ui.showFileParserErrorMessage();
            System.exit(0);
        }
        ui.printGreetings();
        currentFitCenter.showGoalProgress();
    }

    private void loopCommand() throws IOException {
        CommandParser commandParser = new CommandParser();
        Command command;
        do {
            String userInput = ui.getUserInput();
            command = commandParser.parseCommand(userInput);
            CommandResult result = command.execute(currentFitCenter);
            ui.printCommandResult(result);
            storage.store(currentUser);
            commandParser.clearParserParams();
        } while (!ExitCommand.isExitCommand(command));
    }

    private void exit() {
        ui.printExitMessage();
        System.exit(0);
    }

    /**
     * Executes the application.
     */
    public void run() {
        try {
            start();
            loopCommand();
            exit();
        } catch (IOException e) {
            ui.showFileErrorMessage();
        }
    }

    /**
     * The main method of this application.
     *
     * @param args commandLine arguments.
     */
    public static void main(String[] args) {
        new Healthier().run();
    }
}
