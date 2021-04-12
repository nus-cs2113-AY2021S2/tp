package seedu.duke.command;

import seedu.duke.common.ArgumentType;
import seedu.duke.common.RecordType;
import seedu.duke.exception.CommandException;
import seedu.duke.record.RecordList;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

import java.util.ArrayList;

import static seedu.duke.command.Utils.hasOption;
import static seedu.duke.command.Utils.validateArguments;
import static seedu.duke.command.Utils.validateOptions;
import static seedu.duke.common.Constant.OPTION_EXPENSE;
import static seedu.duke.common.Constant.OPTION_LOAN;
import static seedu.duke.common.Constant.OPTION_SAVING;
import static seedu.duke.common.Constant.OPTION_ALL;
import static seedu.duke.common.Messages.ERROR_MISSING_RECORD_OPTIONS_2;

/**
 * Handles all operations related to the view command.
 */
public class ViewCommand extends Command {
    private static final String[] VALID_OPTIONS = {OPTION_EXPENSE, OPTION_LOAN, OPTION_SAVING, OPTION_ALL};
    private static final ArgumentType[] ARGUMENT_TYPE_ORDER = {
        ArgumentType.COMMAND,
        ArgumentType.OPTION,
        ArgumentType.EMPTY_VALUE
    };
    protected static final String COMMAND_VIEW = "view";

    private RecordType recordType;

    /**
     * Constructor to validate the format for view command.
     * @param arguments parsed input containing options and arguments.
     * @throws CommandException contains the error messages when a incorrect format is detected.
     */
    public ViewCommand(ArrayList<String> arguments) throws CommandException {
        validateOptions(arguments, COMMAND_VIEW, VALID_OPTIONS, VALID_OPTIONS);
        checkRecordType(arguments);
        validateArguments(arguments, ARGUMENT_TYPE_ORDER, COMMAND_VIEW);
    }

    /**
     * Check if the input contains the correct record type and options.
     * @param arguments parsed input containing the options and arguments.
     * @throws CommandException contains the error messages when a incorrect format is detected.
     */
    private void checkRecordType(ArrayList<String> arguments) throws CommandException {
        if (hasOption(arguments, OPTION_EXPENSE)) {
            recordType = RecordType.EXPENSE;
        } else if (hasOption(arguments, OPTION_LOAN)) {
            recordType = RecordType.LOAN;
        } else if (hasOption(arguments, OPTION_SAVING)) {
            recordType = RecordType.SAVING;
        } else if (hasOption(arguments, OPTION_ALL)) {
            recordType = RecordType.ALL;
        } else {
            throw new CommandException(ERROR_MISSING_RECORD_OPTIONS_2, COMMAND_VIEW);
        }
    }

    /**
     * Executes the view function.
     *
     * @param recordList is the RecordList component of Finux.
     * @param ui      is the Ui object that interacts with the user.
     * @param storage is the Storage object that reads and writes to the save file.
     * @param creditScoreReturnedLoansMap is the CreditScoreReturnedLoansMap component of Finux.
     */
    @Override
    public void execute(RecordList recordList, Ui ui, Storage storage, CreditScoreReturnedLoansMap
            creditScoreReturnedLoansMap) {
        switch (recordType) {
        case EXPENSE:
            ui.printTotalAmountExpense(recordList);
            break;
        case LOAN:
            ui.printTotalAmountLoan(recordList);
            break;
        case SAVING:
            ui.printTotalAmountSaving(recordList);
            break;
        case ALL:
            // Fallthrough
        default:
            ui.printTotalAmountAllType(recordList);
        }
    }
}
