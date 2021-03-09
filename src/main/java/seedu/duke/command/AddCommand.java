package seedu.duke.command;

import seedu.duke.record.RecordList;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

import java.util.ArrayList;

public class AddCommand extends Command{
    public static final String KEY_ADD = "add";

    private ArrayList<String> parsedArguments;

    public AddCommand(ArrayList<String> parsedArguments) {
        this.parsedArguments = parsedArguments;
    }

    @Override
    public void execute(RecordList records, Ui ui, Storage storage) {
        addItem(records, ui, storage);
    }

    private void addItem(RecordList records, Ui ui, Storage storage) {

    }
}
