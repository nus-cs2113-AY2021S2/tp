package seedu.duke.command;

import seedu.duke.account.FitCenter;
import seedu.duke.record.RecordType;


import java.util.HashMap;

public class DeleteCommand extends Command {
    private static final String FEEDBACK_FORMAT = "You have successfully deleted the %s record of "
            + "index %s!\nRecord summary: %s\nDisplaying current exercise records:";
    private CommandRecordType recordType;
    private RecordType type;
    private int indexToDelete;

    public DeleteCommand(CommandRecordType recordType, HashMap<String, String> params) throws NumberFormatException {
        this.recordType = recordType;
        indexToDelete = Integer.parseInt(params.get("index"));
    }

    @Override
    public CommandResult execute(FitCenter fitCenter) {
        try {
            String recordSummary = fitCenter.removeRecordFromList(recordType, indexToDelete);
            feedback = String.format(FEEDBACK_FORMAT, type, indexToDelete, recordSummary);
            return new CommandResult(feedback);
        } catch (IndexOutOfBoundsException e) {
            return new CommandResult("The index you entered is out of bound.\n"
                    + "Here are the tasks of type " + type + ":\n");
        }
    }
}
