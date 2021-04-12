package seedu.duke.command;

import seedu.duke.common.ArgumentType;
import seedu.duke.exception.CommandException;
import seedu.duke.record.RecordList;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

import java.util.ArrayList;

import static seedu.duke.command.Utils.validateArguments;

/**
 * Handles all operations related to the exit command.
 */
public class ExitCommand extends Command {
    private static final ArgumentType[] ARGUMENT_TYPE_ORDER = { ArgumentType.COMMAND };
    protected static final String COMMAND_EXIT = "exit";
    private static final String MESSAGE_EXITING = "You are exiting FINUX now...";

    /**
     * Constructor to validate the format for exit command.
     * @param arguments parsed input containing options and arguments.
     * @throws CommandException contains the error messages when a incorrect format is detected.
     */
    public ExitCommand(ArrayList<String> arguments) throws CommandException {
        validateArguments(arguments, ARGUMENT_TYPE_ORDER, COMMAND_EXIT);
    }

    /**
     * Executes the exit function.
     *
     * @param recordList is the RecordList component of Finux.
     * @param ui      is the Ui object that interacts with the user.
     * @param storage is the Storage object that reads and writes to the save file.
     * @param creditScoreReturnedLoansMap is the CreditScoreReturnedLoansMap component of Finux.
     */
    @Override
    public void execute(RecordList recordList, Ui ui, Storage storage, CreditScoreReturnedLoansMap
            creditScoreReturnedLoansMap) {
        System.out.println(MESSAGE_EXITING);
    }
}
