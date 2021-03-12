package seedu.duke.command;

import seedu.duke.common.ArgumentType;
import seedu.duke.exception.CommandException;
import seedu.duke.record.Record;
import seedu.duke.record.RecordList;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

import java.util.ArrayList;

import static seedu.duke.command.Utils.checkInvalidOptions;
import static seedu.duke.command.Utils.checkOptionConflict;
import static seedu.duke.command.Utils.getOptionValue;
import static seedu.duke.command.Utils.hasOption;
import static seedu.duke.command.Utils.validateArguments;
import static seedu.duke.common.Constant.OPTION_INDEX;
import static seedu.duke.common.Validators.validateIndex;

public class RemoveCommand extends Command {
    private static final ArgumentType[] argumentTypeOrder = {
        ArgumentType.COMMAND,
        ArgumentType.OPTION,
        ArgumentType.VALUE
    };
    protected static final String COMMAND_REMOVE = "remove";

    private String recordNumberStr;
    private int recordNumberInt;

    public RemoveCommand(ArrayList<String> arguments, RecordList records) throws CommandException {
        checkInvalidOptions(arguments, COMMAND_REMOVE, OPTION_INDEX);
        checkOptionConflict(arguments, COMMAND_REMOVE, OPTION_INDEX);
        validateArguments(arguments, argumentTypeOrder, COMMAND_REMOVE);

        if (hasOption(arguments, OPTION_INDEX)) {
            recordNumberStr = getOptionValue(arguments, COMMAND_REMOVE, OPTION_INDEX);
        } else {
            throw new CommandException("missing option: -i", COMMAND_REMOVE);
        }

        try {
            recordNumberInt = validateIndex(getOptionValue(arguments, COMMAND_REMOVE, OPTION_INDEX), records);
        } catch (NumberFormatException e) {
            throw new CommandException("Index \"" + recordNumberStr + "\" is not an integer!", COMMAND_REMOVE);
        } catch (IndexOutOfBoundsException e) {
            throw new CommandException("Index \"" + recordNumberStr + "\" is out of bounds!", COMMAND_REMOVE);
        }
    }

    /**
     * Executes the delete function.
     * Prints a message containing the record that will be removed.
     * Removes the record at the specified index.
     *
     * @param records is the recordList.
     * @param ui      is the Ui object that interacts with the user.
     * @param storage is the Storage object that reads and writes to the save file.
     */
    @Override
    public void execute(RecordList records, Ui ui, Storage storage) {
        Record currentRecord = records.getRecordAt(recordNumberInt);
        ui.printMessage("This record will be removed: " + currentRecord);
        records.deleteRecordAt(recordNumberInt);
        storage.saveRecordListData(records);
    }
}
