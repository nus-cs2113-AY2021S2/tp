package seedu.duke.command;

import seedu.duke.common.ArgumentType;
import seedu.duke.common.RecordType;
import seedu.duke.exception.CommandException;
import seedu.duke.record.RecordList;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

import java.util.ArrayList;

import static seedu.duke.command.Utils.checkInvalidOptions;
import static seedu.duke.command.Utils.checkOptionConflict;
import static seedu.duke.command.Utils.getOptionValue;
import static seedu.duke.command.Utils.hasOption;
import static seedu.duke.command.Utils.validateArguments;
import static seedu.duke.common.Constant.OPTION_EXPENSE;
import static seedu.duke.common.Constant.OPTION_LOAN;
import static seedu.duke.common.Constant.OPTION_SAVING;

public class RemoveCommand extends Command {
    private static final ArgumentType[] argumentTypeOrder = {
        ArgumentType.COMMAND,
        ArgumentType.OPTION,
        ArgumentType.VALUE
    };
    protected static final String COMMAND_REMOVE = "remove";

    private RecordType recordType;
    private String recordNumber;

    public RemoveCommand(ArrayList<String> arguments) throws CommandException {
        checkInvalidOptions(arguments, COMMAND_REMOVE, OPTION_EXPENSE, OPTION_LOAN, OPTION_SAVING);
        checkOptionConflict(arguments, COMMAND_REMOVE, OPTION_EXPENSE, OPTION_LOAN, OPTION_SAVING);
        validateArguments(arguments, argumentTypeOrder, COMMAND_REMOVE);

        if (hasOption(arguments, OPTION_EXPENSE)) {
            recordType = RecordType.EXPENSE;
            recordNumber = getOptionValue(arguments, COMMAND_REMOVE, OPTION_EXPENSE);
        } else if (hasOption(arguments, OPTION_LOAN)) {
            recordType = RecordType.LOAN;
            recordNumber = getOptionValue(arguments, COMMAND_REMOVE, OPTION_LOAN);
        } else if (hasOption(arguments, OPTION_SAVING)) {
            recordType = RecordType.SAVING;
            recordNumber = getOptionValue(arguments, COMMAND_REMOVE, OPTION_SAVING);
        } else {
            throw new CommandException("missing option: [-e | -l | -s]", COMMAND_REMOVE);
        }
    }

    @Override
    public void execute(RecordList records, Ui ui, Storage storage) {

    }
}
