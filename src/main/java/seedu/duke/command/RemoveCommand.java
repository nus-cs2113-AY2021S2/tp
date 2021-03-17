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

    /**
     * Constructor to validate the format for remove command.
     * @param arguments parsed input containing options and arguments.
     * @param recordList is the recordList.
     * @throws CommandException contains the error messages when a incorrect format is detected.
     */
    public RemoveCommand(ArrayList<String> arguments, RecordList recordList) throws CommandException {
        validateOptions(arguments, COMMAND_REMOVE, VALID_OPTIONS, VALID_OPTIONS);
        recordNumberStr = getIndexInString(arguments);
        recordNumberInt = getIndexInInteger(arguments, recordList);
        validateArguments(arguments, ARGUMENT_TYPE_ORDER, COMMAND_REMOVE);
    }

    /**
     * Get the index field in String.
     * @param arguments parsed input containing options and arguments.
     * @return a String containing the index of the record.
     * @throws CommandException contains the error messages when a incorrect format is detected.
     */
    private String getIndexInString(ArrayList<String> arguments) throws CommandException {
        if (hasOption(arguments, OPTION_INDEX)) {
            return getOptionValue(arguments, COMMAND_REMOVE, OPTION_INDEX);
        } else {
            throw new CommandException("missing option: -i", COMMAND_REMOVE);
        }
    }

    /**
     * Get the index field in Integer.
     * @param arguments parsed input containing options and arguments.
     * @param recordList is the recordList.
     * @return a Integer containing the index of the record.
     * @throws CommandException contains the error messages when a incorrect format is detected.
     */
    private int getIndexInInteger(ArrayList<String> arguments, RecordList recordList) throws CommandException {
        try {
            return validateIndex(getOptionValue(arguments, COMMAND_REMOVE, OPTION_INDEX), recordList);
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
     * @param recordList is the recordList.
     * @param ui      is the Ui object that interacts with the user.
     * @param storage is the Storage object that reads and writes to the save file.
     */
    @Override
    public void execute(RecordList recordList, Ui ui, Storage storage) {
        Record currentRecord = recordList.getRecordAt(recordNumberInt);
        ui.printMessage("This record will be removed: " + currentRecord);
        recordList.deleteRecordAt(recordNumberInt);
        storage.saveRecordListData(recordList);
    }
}
