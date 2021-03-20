package seedu.duke.command;

import seedu.duke.common.ArgumentType;
import seedu.duke.exception.CommandException;
import seedu.duke.record.Loan;
import seedu.duke.record.Record;
import seedu.duke.record.RecordList;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

import java.util.ArrayList;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static seedu.duke.command.Utils.getValue;
import static seedu.duke.command.Utils.validateArguments;

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

    private long getDayDifference(LocalDate issueDate, LocalDate returnDate) {
        LocalDate from = issueDate;
        LocalDate to;
        if (returnDate == null) {
            to = LocalDate.now();
        } else {
            assert returnDate != null : "returnDate should not be empty";
            to = returnDate;
        }
        long dayDifference = ChronoUnit.DAYS.between(from, to);
        return dayDifference;
    }


    private int computeCreditScore(long daysDifference, int currentCreditScore) {
        long loanPeriod = 10; //need to get this as input from user, save in loan object.
        long computedCreditScore = currentCreditScore;

        if (daysDifference > loanPeriod) {
            computedCreditScore -= (daysDifference - loanPeriod);
            if (computedCreditScore < 0) {
                computedCreditScore = 0;
            }
        }
        return (int) computedCreditScore;
    }

    @Override
    public void execute(RecordList recordList, Ui ui, Storage storage) {
        int creditScore = 10; //score in the range of [0,10]

        for (int i = 0; i < recordList.getRecordCount(); i++) {
            Record currentRecord = recordList.getRecordAt(i);
            if (currentRecord instanceof Loan) {
                Loan currentLoan = (Loan) currentRecord;
                if (currentLoan.getBorrowerName().equalsIgnoreCase(borrowerName)) {
                    long daysDifference = getDayDifference(currentLoan.getIssueDate(), currentLoan.getReturnDate());
                    creditScore = computeCreditScore(daysDifference, creditScore);
                }
            }
        }

        ui.printMessage("Credit score for " + borrowerName + " is: " + creditScore);
    }
}
