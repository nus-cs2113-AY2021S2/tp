package seedu.duke.command;

import seedu.duke.common.ArgumentType;
import seedu.duke.exception.CommandException;
import seedu.duke.record.Loan;
import seedu.duke.record.Record;
import seedu.duke.record.RecordList;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

import java.util.ArrayList;

import static seedu.duke.command.Utils.getValue;
import static seedu.duke.command.Utils.validateArguments;
import static seedu.duke.command.Utils.getDaysDifference;
import static seedu.duke.command.Utils.computeCreditScore;

/**
 * Handles all operations related to the credit score command.
 */
public class CreditScoreCommand extends Command {
    private static final ArgumentType[] ARGUMENT_TYPE_ORDER = {
        ArgumentType.COMMAND,
        ArgumentType.VALUE
    };
    protected static final String COMMAND_CREDIT_SCORE = "creditscore";
    private final String borrowerName;

    /**
     * Constructor to validate the format for credit score command.
     *
     * @param arguments parsed input containing arguments.
     * @throws CommandException contains the error messages when a incorrect format is detected.
     */
    public CreditScoreCommand(ArrayList<String> arguments) throws CommandException {
        borrowerName = getValue(arguments, COMMAND_CREDIT_SCORE);
        validateArguments(arguments, ARGUMENT_TYPE_ORDER, COMMAND_CREDIT_SCORE);
    }

    @Override
    public void execute(RecordList recordList, Ui ui, Storage storage, BorrowersCreditScoreForReturnedLoans
            borrowersCreditScoreForReturnedLoans) {
        int creditScore = borrowersCreditScoreForReturnedLoans.getCurrentBorrowerCreditScoreForReturnedLoans(
                borrowerName.toLowerCase());

        for (int i = 0; i < recordList.getRecordCount(); i++) {
            Record currentRecord = recordList.getRecordAt(i);
            if (currentRecord instanceof Loan) {
                Loan currentLoan = (Loan) currentRecord;
                boolean isLoanedToCurrentBorrower = currentLoan.getBorrowerName().equalsIgnoreCase(borrowerName);
                boolean isNotReturned = !currentLoan.isReturn();
                boolean isLoanedToCurrentBorrowerAndNotReturned = isLoanedToCurrentBorrower && isNotReturned;
                if (isLoanedToCurrentBorrowerAndNotReturned) {
                    long daysDifference = getDaysDifference(currentLoan.getIssueDate(), currentLoan.getReturnDate());
                    creditScore = computeCreditScore(daysDifference, creditScore, currentLoan.isReturn());
                }
            }
        }

        ui.printMessage("Credit score for " + borrowerName + " is: " + creditScore);
    }
}
