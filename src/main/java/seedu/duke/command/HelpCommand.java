package seedu.duke.command;

import seedu.duke.common.ArgumentType;
import seedu.duke.exception.CommandException;
import seedu.duke.record.RecordList;
import seedu.duke.storage.Storage;
import seedu.duke.ui.HelpPage;
import seedu.duke.ui.Ui;

import java.util.ArrayList;

import static seedu.duke.command.Utils.validateArguments;

public class HelpCommand extends Command {
    private static final ArgumentType[] ARGUMENT_TYPE_ORDER = { ArgumentType.COMMAND };
    protected static final String COMMAND_HELP = "help";

    public HelpCommand(ArrayList<String> arguments) throws CommandException {
        validateArguments(arguments, ARGUMENT_TYPE_ORDER, COMMAND_HELP);
    }

    @Override
    public void execute(RecordList records, Ui ui, Storage storage) {
        HelpPage.printHelp(COMMAND_HELP);
    }
}
