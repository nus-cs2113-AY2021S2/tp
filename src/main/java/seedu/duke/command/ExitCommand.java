package seedu.duke.command;

import seedu.duke.record.RecordHandler;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

public class ExitCommand extends Command {
    public static final String EXIT_MESSAGE = "Bye for now, remember to save more!";

    @Override
    public void execute(RecordHandler records, Ui ui, Storage storage) {
        setExit(true);
        System.out.println(EXIT_MESSAGE);
    }
}
