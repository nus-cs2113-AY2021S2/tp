package seedu.duke.command;

import java.util.HashMap;

public class DeleteCommand extends Command {
    private CommandRecordType recordType;
    private int indexToDelete;

    public DeleteCommand(CommandRecordType recordType, HashMap<String, String> params) throws NumberFormatException {
        this.recordType = recordType;
        indexToDelete = Integer.parseInt(params.get("index"));
    }

    @Override
    public CommandResult execute() {
        return new CommandResult(feedback);
    }
}
