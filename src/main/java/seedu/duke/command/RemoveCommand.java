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
import static seedu.duke.command.Utils.validateOptions;
import static seedu.duke.common.Constant.OPTION_EXPENSE;
import static seedu.duke.common.Constant.OPTION_INDEX;
import static seedu.duke.common.Constant.OPTION_LOAN;
import static seedu.duke.common.Constant.OPTION_SAVING;
import static seedu.duke.common.Validators.validateIndex;

/**
 * Handles all operations related to the remove command.
 */
public class RemoveCommand extends Command {
    private static final String[] VALID_OPTIONS = {OPTION_INDEX};
    private static final ArgumentType[] ARGUMENT_TYPE_ORDER = {
        ArgumentType.COMMAND,
        ArgumentType.OPTION,
        ArgumentType.VALUE
    };
    protected static final String COMMAND_REMOVE = "remove";

    private String recordNumberStr;
    private int recordNumberInt;

    public RemoveCommand(ArrayList<String> arguments, RecordList records) throws CommandException {
        validateOptions(arguments, COMMAND_REMOVE, VALID_OPTIONS, VALID_OPTIONS);
        recordNumberStr = getIndexInString(arguments);
        recordNumberInt = getIndexInInteger(arguments, records);
        validateArguments(arguments, ARGUMENT_TYPE_ORDER, COMMAND_REMOVE);
    }

    private String getIndexInString(ArrayList<String> arguments) throws CommandException {
        if (hasOption(arguments, OPTION_INDEX)) {
            return getOptionValue(arguments, COMMAND_REMOVE, OPTION_INDEX);
        } else {
            throw new CommandException("missing option: -i", COMMAND_REMOVE);
        }
    }

    private int getIndexInInteger(ArrayList<String> arguments, RecordList records) throws CommandException {
        try {
            return validateIndex(getOptionValue(arguments, COMMAND_REMOVE, OPTION_INDEX), records);
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
