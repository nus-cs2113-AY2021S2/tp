package seedu.duke.command;

import seedu.duke.common.ArgumentType;
import seedu.duke.common.RecordType;
import seedu.duke.exception.CommandException;
import seedu.duke.record.Expense;
import seedu.duke.record.Loan;
import seedu.duke.record.Record;
import seedu.duke.record.RecordList;
import seedu.duke.record.Saving;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

import java.util.ArrayList;

import static seedu.duke.command.Utils.checkInvalidOptions;
import static seedu.duke.command.Utils.checkOptionConflict;
import static seedu.duke.command.Utils.hasOption;
import static seedu.duke.command.Utils.validateArguments;
import static seedu.duke.common.Constant.OPTION_EXPENSE;
import static seedu.duke.common.Constant.OPTION_LOAN;
import static seedu.duke.common.Constant.OPTION_SAVING;

public class ViewCommand extends Command {
    private static final ArgumentType[] argumentTypeOrder = {
        ArgumentType.COMMAND,
        ArgumentType.OPTION,
        ArgumentType.EMPTY_VALUE
    };
    protected static final String COMMAND_VIEW = "view";

    private RecordType recordType;

    public ViewCommand(ArrayList<String> arguments) throws CommandException {
        checkInvalidOptions(arguments, COMMAND_VIEW, OPTION_EXPENSE, OPTION_LOAN, OPTION_SAVING);
        checkOptionConflict(arguments, COMMAND_VIEW, OPTION_EXPENSE, OPTION_LOAN, OPTION_SAVING);

        if (hasOption(arguments, OPTION_EXPENSE)) {
            recordType = RecordType.EXPENSE;
        } else if (hasOption(arguments, OPTION_LOAN)) {
            recordType = RecordType.LOAN;
        } else if (hasOption(arguments, OPTION_SAVING)) {
            recordType = RecordType.SAVING;
        } else {
            throw new CommandException("missing option: [-e | -l | -s]", COMMAND_VIEW);
        }
        validateArguments(arguments, argumentTypeOrder, COMMAND_VIEW);
    }

    @Override
    public void execute(RecordList recordList, Ui ui, Storage storage) {
        switch (recordType) {
        case EXPENSE:
            // records.viewExpenses(ui);
            viewTotalAmountExpense(recordList);
            break;
        case LOAN:
            // records.viewLoans(ui);
            viewTotalAmountLoan(recordList);
            break;
        case SAVING:
            // Fallthrough
        default:
            // records.viewSavings(ui);
            viewTotalAmountSaving(recordList);
        }
    }

    public void viewTotalAmountExpense (RecordList recordList) {
        double totalAmount = 0;
        for (int i = 0; i < recordList.getRecordCount(); i++) {
            Record currentRecord = recordList.getRecordAt(i);
            if (currentRecord instanceof Expense) {
                totalAmount = totalAmount + currentRecord.getAmount();
            }
        }
        System.out.println("The total amount for expense is " + totalAmount);
    }

    public void viewTotalAmountLoan (RecordList recordList) {
        double totalAmount = 0;
        for (int i = 0; i < recordList.getRecordCount(); i++) {
            Record currentRecord = recordList.getRecordAt(i);
            if (currentRecord instanceof Loan) {
                totalAmount = totalAmount + currentRecord.getAmount();
            }
        }
        System.out.println("The total amount for loan is " + totalAmount);
    }

    public void viewTotalAmountSaving (RecordList recordList) {
        double totalAmount = 0;
        for (int i = 0; i < recordList.getRecordCount(); i++) {
            Record currentRecord = recordList.getRecordAt(i);
            if (currentRecord instanceof Saving) {
                totalAmount = totalAmount + currentRecord.getAmount();
            }
        }
        System.out.println("The total amount for saving is " + totalAmount);
    }
}
