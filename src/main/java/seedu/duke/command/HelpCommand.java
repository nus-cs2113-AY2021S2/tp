package seedu.duke.command;

import seedu.duke.common.ArgumentType;
import seedu.duke.exception.CommandException;
import seedu.duke.record.RecordList;
import seedu.duke.storage.Storage;
import seedu.duke.ui.HelpPage;
import seedu.duke.ui.Ui;

import java.util.ArrayList;

import static seedu.duke.command.Utils.validateArguments;
import static seedu.duke.command.Utils.validateHelpType;
import static seedu.duke.command.Utils.validateNoOptions;

/**
 * Handles all operations related to the help command.
 */
public class HelpCommand extends Command {
    private static final ArgumentType[] ARGUMENT_TYPE_ORDER = {
        ArgumentType.COMMAND,
        ArgumentType.VALUE
    };

    protected static final String COMMAND_HELP = "help";
    private final String helpType;

    /**
     * Constructor to validate the format for help command.
     * @param arguments parsed input containing options and arguments.
     * @throws CommandException contains the error messages when a incorrect format is detected.
     */
    public HelpCommand(ArrayList<String> arguments) throws CommandException {
        validateNoOptions(arguments, COMMAND_HELP);
        validateArguments(arguments, ARGUMENT_TYPE_ORDER, COMMAND_HELP);
        helpType = validateHelpType(arguments, COMMAND_HELP);
    }

    /**
     * Executes the help function.
     *
     * @param recordList is the RecordList component of Finux.
     * @param ui      is the Ui object that interacts with the user.
     * @param storage is the Storage object that reads and writes to the save file.
     * @param creditScoreReturnedLoansMap is the CreditScoreReturnedLoansMap component of Finux.
     */
    @Override
    public void execute(RecordList recordList, Ui ui, Storage storage, CreditScoreReturnedLoansMap
            creditScoreReturnedLoansMap) {
        HelpPage.printHelp(helpType);
    }
}
