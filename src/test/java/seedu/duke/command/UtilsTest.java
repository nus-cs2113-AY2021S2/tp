package seedu.duke.command;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import seedu.duke.common.ArgumentType;
import seedu.duke.exception.CommandException;
import seedu.duke.parser.ParserHandler;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static seedu.duke.command.HelpCommand.COMMAND_HELP;
import static seedu.duke.command.Utils.isOption;
import static seedu.duke.command.Utils.validateArguments;

class UtilsTest {
    @DisplayName("[isOption] - Valid Options - success:")
    @Test
    public void isOption_optionMatch_success() {
        assertAll(
            () -> assertTrue(isOption("-e")),
            () -> assertTrue(isOption("-l")),
            () -> assertTrue(isOption("-s")),
            () -> assertTrue(isOption("-d")),
            () -> assertTrue(isOption("-a")),
            () -> assertTrue(isOption("-i")),
            () -> assertTrue(isOption("-E")),
            () -> assertTrue(isOption("-L")),
            () -> assertTrue(isOption("-S")),
            () -> assertTrue(isOption("-D")),
            () -> assertTrue(isOption("-A")),
            () -> assertTrue(isOption("-I")),
            () -> assertTrue(isOption("-p"))
        );
    }

    @DisplayName("[isOption] - Invalid Options - failure:")
    @Test
    public void isOption_invalidOptions() {
        assertAll(
            () -> assertFalse(isOption("--")),
            () -> assertFalse(isOption("-[")),
            () -> assertFalse(isOption("- ")),
            () -> assertFalse(isOption("-1")),
            () -> assertFalse(isOption("-9")),
            () -> assertFalse(isOption("-hello"))
        );
    }

    @DisplayName("[validateArguments] - help Command - failure:")
    @Test
    public void validateArguments_improperHelp() {
        String expected_1_2_4_5 = "invalid command order, expected command word.";
        String expected_3 = COMMAND_HELP + " Command - too many arguments.";

        ArrayList<String> command1 = ParserHandler.getParseInput("help gerard oi");
        validateArguments_improperHelp_helper(command1, expected_1_2_4_5);

        ArrayList<String> command2 = ParserHandler.getParseInput("help -z oi");
        validateArguments_improperHelp_helper(command2, expected_1_2_4_5);

        ArrayList<String> command3 = ParserHandler.getParseInput("help -a");
        validateArguments_improperHelp_helper(command3, expected_3);

        ArrayList<String> command4 = ParserHandler.getParseInput("help me");
        validateArguments_improperHelp_helper(command4, expected_1_2_4_5);

        ArrayList<String> command5 = ParserHandler.getParseInput("helpz");
        validateArguments_improperHelp_helper(command5, expected_1_2_4_5);
    }

    private void validateArguments_improperHelp_helper(ArrayList<String> arguments, String expected) {
        ArgumentType[] commandHelpArgType = { ArgumentType.COMMAND };
        CommandException e = assertThrows(
            CommandException.class,
            () -> validateArguments(arguments, commandHelpArgType, COMMAND_HELP)
        );
        if (!e.getMessage().equals(expected)) {
            fail(arguments.toString() + e.getMessage());
        }
    }
}
