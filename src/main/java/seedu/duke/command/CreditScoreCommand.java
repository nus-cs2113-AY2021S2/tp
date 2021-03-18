package seedu.duke.command;

import seedu.duke.exception.CommandException;
import seedu.duke.record.RecordList;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

import java.util.ArrayList;
import java.time.LocalDate;

public class CreditScoreCommand extends Command{

    protected static final String COMMAND_CREDIT_SCORE = "creditscore";

    public CreditScoreCommand(ArrayList<String> arguments) throws CommandException {
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
