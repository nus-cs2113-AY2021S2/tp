package seedu.duke.command;

import seedu.duke.common.ArgumentType;
import seedu.duke.exception.CommandException;
import seedu.duke.record.RecordList;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

import java.util.ArrayList;
import java.time.LocalDate;

import static seedu.duke.command.Utils.getValue;
import static seedu.duke.command.Utils.validateArguments;

public class CreditScoreCommand extends Command {
    private static final ArgumentType[] ARGUMENT_TYPE_ORDER = {
        ArgumentType.COMMAND,
        ArgumentType.VALUE
    };
    protected static final String COMMAND_CREDIT_SCORE = "creditscore";
    private final String borrower;

    public CreditScoreCommand(ArrayList<String> arguments) throws CommandException {
        borrower = getValue(arguments, COMMAND_CREDIT_SCORE);
        validateArguments(arguments, ARGUMENT_TYPE_ORDER, COMMAND_CREDIT_SCORE);
    }

    private int getDayDifference(LocalDate issueDate, LocalDate returnDate) {
        return 0;
    }

    private int getCreditScore(int days, int score) {
        return 0;
    }

    @Override
    public void execute(RecordList recordList, Ui ui, Storage storage) {

    }
}
