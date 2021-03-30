package seedu.duke.command;

import seedu.duke.account.FitCenter;
import seedu.duke.common.Messages;

import java.util.HashMap;

public class CancelCommand extends Command {
    private final CommandRecordType recordType;
    private final int indexToDelete;

    public CancelCommand(CommandRecordType recordType, HashMap<String, String> params) {
        this.recordType = recordType;
        this.indexToDelete = Integer.parseInt(params.get("index")) - 1;
    }

    @Override
    public CommandResult execute(FitCenter fitCenter) {
        String goalTypeString = recordType.toString().toLowerCase().replace("_", " ");
        try {
            String feedbackFormat = "You have successfully canceled a goal for %s!\n"
                    + "Goal canceled:\n%s\nDisplaying current %s goals available:\n";
            String cancelSummary = fitCenter.cancelGoalFromList(recordType, indexToDelete);
            feedback = String.format(feedbackFormat, recordType.toString().toLowerCase(),
                    cancelSummary, goalTypeString)
                    + fitCenter.getGoalListString(recordType, null);
        } catch (IndexOutOfBoundsException e) {
            feedback = Messages.MESSAGE_INDEX_OUT_OF_RANGE_EXCEPTION
                    + String.format("\nDisplaying current %s goals available:\n",
                    goalTypeString)
                    + fitCenter.getGoalListString(recordType, null);
        }
        return new CommandResult(feedback);
    }
}
