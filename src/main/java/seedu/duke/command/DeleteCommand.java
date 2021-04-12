package seedu.duke.command;


import seedu.duke.account.FitCenter;


import java.util.HashMap;
import java.util.Locale;

/**
 * Represents a command of deleting a record from current record list.
 */
public class DeleteCommand extends Command {
    private static final String FEEDBACK_FORMAT = "You have successfully deleted the %s record of "
            + "index %s!\nRecord summary: %s\nDisplaying current %s records:";
    private final CommandRecordType recordType;
    private final int indexToDelete;

    public DeleteCommand(CommandRecordType recordType, HashMap<String, String> params) throws NumberFormatException {
        this.recordType = recordType;
        indexToDelete = Integer.parseInt(params.get("index")) - 1;
    }

    /**
     * Deletes a record from current record list.
     *
     * @param fitCenter the fitCenter interface for current user.
     * @return the feedback message of execution.
     */
    @Override
    public CommandResult execute(FitCenter fitCenter) {
        try {
            String recordSummary = fitCenter.removeRecordFromList(recordType, indexToDelete);
            feedback = String.format(FEEDBACK_FORMAT, recordType, (indexToDelete + 1), recordSummary, recordType);
            feedback += "\n" + fitCenter.getRecordListString(recordType);
            return new CommandResult(feedback);
        } catch (IndexOutOfBoundsException e) {
            return new CommandResult("The index you entered is out of bound.\n"
                    + "Here are the records of type " + recordType.toString().toLowerCase(Locale.ROOT) + ":\n"
                    + fitCenter.getRecordListString(recordType));
        }
    }
}
