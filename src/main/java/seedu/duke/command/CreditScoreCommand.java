package seedu.duke.command;

import seedu.duke.common.ArgumentType;
import seedu.duke.exception.CommandException;
import seedu.duke.record.RecordList;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

import java.util.ArrayList;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static seedu.duke.command.Utils.validateArguments;

/**
 * Handles all operations related to the credit score command.
 */
public class CreditScoreCommand extends Command {

    protected static final String COMMAND_CREDIT_SCORE = "creditscore";
    private static final ArgumentType[] ARGUMENT_TYPE_ORDER = {
            ArgumentType.COMMAND,
            ArgumentType.VALUE
    };

    /**
     * Constructor to validate the format for credit score command.
     *
     * @param arguments parsed input containing arguments.
     * @throws CommandException contains the error messages when a incorrect format is detected.
     */
    public CreditScoreCommand(ArrayList<String> arguments) throws CommandException {
        validateArguments(arguments, ARGUMENT_TYPE_ORDER, COMMAND_CREDIT_SCORE);
    }

    private long getDayDifference(LocalDate issueDate, LocalDate returnDate) {
        LocalDate from = issueDate;
        LocalDate to;
        if(returnDate == null) {
            to = LocalDate.now();
        } else {
            assert returnDate != null : "returnDate should not be empty";
            to = returnDate;
        }
        long dayDifference = ChronoUnit.DAYS.between(from, to);
        return dayDifference;
    }

    private int getCreditScore(int days, int score) {
        return 0;
    }

    @Override
    public void execute(RecordList recordList, Ui ui, Storage storage) {

    }
}
