package seedu.duke;

import seedu.duke.commands.Command;
import seedu.duke.exception.DukeException;
import seedu.duke.exception.UnknownCommandException;
import seedu.duke.exception.CommandException;
import seedu.duke.module.ModuleList;
import seedu.duke.parser.Parser;
import seedu.duke.ui.UI;

import java.util.Scanner;

import static seedu.duke.common.Messages.MESSAGE_WELCOME;
import static seedu.duke.common.Messages.TAG_GULIO;

public class Duke {

    private static final UI ui = new UI();

    public static void main(String[] args) {
        start();
        run();
    }

    private static void start() {
        ui.printMessage(TAG_GULIO + MESSAGE_WELCOME);
        ModuleList.loadModuleNames();
    }

    private static void run() {
        boolean isExit = false;
        Parser parser = new Parser();

        while (!isExit) {
            ui.printModuleIndicator();
            String input = ui.readCommand();
            try {
                Command command = parser.parse(input);
                command.execute(ui);
                isExit = command.isExit();
            } catch (DukeException e) {
                ui.printError(e);
            }

        }
    }

}
