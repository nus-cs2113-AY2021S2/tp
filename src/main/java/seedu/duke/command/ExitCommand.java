package seedu.duke.command;

import seedu.duke.ui.Ui;

public class ExitCommand extends Command {
    public static final String EXIT_MESSAGE = "Bye for now, remember to save more!";

    @Override
    public void execute(Ui ui) {
        setExit(true);
        System.out.println(EXIT_MESSAGE);
    }
}
