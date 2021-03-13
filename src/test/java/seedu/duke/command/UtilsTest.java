package seedu.duke.command;

import org.junit.jupiter.api.Test;
import seedu.duke.common.ArgumentType;
import seedu.duke.exception.CommandException;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static seedu.duke.command.HelpCommand.COMMAND_HELP;
import static seedu.duke.command.Utils.isOption;
import static seedu.duke.command.Utils.validateArguments;

class UtilsTest {
    private static final String SF_FAIL_MESSAGE = "%s wrong Exception message!";

    @Test
    public void isOption_optionMatch_success() {
        // Mix of option matches, top "row" are real ones,
        // bottom "row" are fake ones but valid options.
        String[] optionMatches = {
            "-e", "-l", "-s", "-d", "-a", "-i",
            "-E", "-L", "-S", "-D", "-A", "-I", "-p"
        };
        for (String opt : optionMatches) {
            assertTrue(isOption(opt));
        }
    }

    @Test
    public void isOption_invalidOptions() {
        // Neither of the options will match.
        String[] invalidOptions = {
            "--", "-[", "-hello", "- ", "-1", "-9"
        };
        for (String opt : invalidOptions) {
            assertFalse(isOption(opt));
        }
    }

    @Test
    public void validateArgument_improperCommandLine() {
        String[] commandLineHelp = { "help", "-a" };
        String expected1 = COMMAND_HELP + " Command - too many arguments.";
        ArgumentType[] commandHelpArgType = { ArgumentType.COMMAND };
        CommandException e1 = assertThrows(CommandException.class, () ->
            validateArguments(new ArrayList<>(Arrays.asList(commandLineHelp)),
                              commandHelpArgType,
                              COMMAND_HELP)
        );
        if (!e1.getMessage().equals(expected1)) {
            fail(String.format(SF_FAIL_MESSAGE, "e1"));
        }
    }
}
