package seedu.duke.command;

import seedu.duke.common.ArgumentType;
import seedu.duke.exception.CommandException;
import seedu.duke.record.Loan;
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

/**
 * Handles all operations related to the return command.
 */
public class ReturnCommand extends Command {
    private static final ArgumentType[] argumentTypeOrder = {
        ArgumentType.COMMAND,
        ArgumentType.OPTION,
        ArgumentType.VALUE
    };
    protected static final String COMMAND_RETURN = "return";

    private String recordNumberStr;
    private int recordNumberInt;

    public ReturnCommand(ArrayList<String> arguments, RecordList records) throws CommandException {
        checkInvalidOptions(arguments, COMMAND_RETURN, OPTION_INDEX);
        checkOptionConflict(arguments, COMMAND_RETURN, OPTION_INDEX);
        validateArguments(arguments, argumentTypeOrder, COMMAND_RETURN);

        if (hasOption(arguments, OPTION_INDEX)) {
            recordNumberStr = getOptionValue(arguments, COMMAND_RETURN, OPTION_INDEX);
        } else {
            throw new CommandException("missing option: -i", COMMAND_RETURN);
        }

        try {
            recordNumberInt = validateIndex(getOptionValue(arguments, COMMAND_RETURN, OPTION_INDEX), records);
        } catch (NumberFormatException e) {
            throw new CommandException("Index \"" + recordNumberStr + "\" is not an integer!", COMMAND_RETURN);
        } catch (IndexOutOfBoundsException e) {
            throw new CommandException("Index \"" + recordNumberStr + "\" is out of bounds!", COMMAND_RETURN);
        }
    }

    /**
     * Executes the return function.
     * Prints a message containing the loan that will be marked as returned.
     *
     * @param records is the recordList.
     * @param ui      is the Ui object that interacts with the user.
     * @param storage is the Storage object that reads and writes to the save file.
     */
    @Override
    public void execute(RecordList records, Ui ui, Storage storage) {

        Record currentRecord = records.getRecordAt(recordNumberInt);
        if (currentRecord instanceof Loan) {
            Loan currentLoan = (Loan) currentRecord;
            currentLoan.markAsReturned();
            ui.printMessage("Loan marked as returned: " + currentLoan);
            storage.saveRecordListData(records);
        } else {
            ui.printMessage("Specified record number is not a loan!");
        }
    }
}
