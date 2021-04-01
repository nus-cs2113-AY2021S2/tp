package seedu.duke.command;

import seedu.duke.account.FitCenter;
import seedu.duke.common.Messages;
import seedu.duke.goal.PeriodType;

import java.util.HashMap;

/**
 * Represent a command of checking current progress for all goals of a specified type or
 * specified type and period type.
 */
public class CheckCommand extends Command {
    private final CommandRecordType recordType;
    private final PeriodType optionalPeriodType;

    public CheckCommand(CommandRecordType recordType, HashMap<String, String> params) {
        this.recordType = recordType;
        this.optionalPeriodType = params.get("periodType") == null
                ? null : PeriodType.valueOf(params.get("periodType"));
    }

    /**
     * Checking the progress of all goals for the specified type or the specified type and
     * the period type.
     *
     * @param fitCenter the fitCenter interface for current user.
     * @return the feedback message of execution.
     */
    @Override
    public CommandResult execute(FitCenter fitCenter) {
        feedback = fitCenter.getGoalListString(recordType, optionalPeriodType);
        addTitleToFeedback();
        return new CommandResult(feedback);
    }

    private void addTitleToFeedback() {
        String recordString = recordType.toString().toLowerCase().replace("_", " ");
        String feedbackHeading = String.format(Messages.MESSAGE_CHECK_TITLE, recordString);
        feedback = feedbackHeading + feedback;
    }
}
