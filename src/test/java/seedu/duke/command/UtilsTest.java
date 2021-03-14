package seedu.duke.command;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import seedu.duke.common.ArgumentType;
import seedu.duke.exception.CommandException;
import seedu.duke.parser.ParserHandler;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static seedu.duke.command.AddCommand.COMMAND_ADD;
import static seedu.duke.command.HelpCommand.COMMAND_HELP;
import static seedu.duke.command.Utils.getOptionValue;
import static seedu.duke.command.Utils.isOption;
import static seedu.duke.command.Utils.validateArguments;
import static seedu.duke.command.Utils.validateOptions;
import static seedu.duke.command.ViewCommand.COMMAND_VIEW;
import static seedu.duke.common.Constant.OPTION_AMOUNT;
import static seedu.duke.common.Constant.OPTION_DATE;
import static seedu.duke.common.Constant.OPTION_EXPENSE;
import static seedu.duke.common.Constant.OPTION_LOAN;
import static seedu.duke.common.Constant.OPTION_SAVING;

class UtilsTest {
    private static final ArgumentType[] ARG_TYPE_ORDER_CMD_HELP = { ArgumentType.COMMAND };
    private static final ArgumentType[] ARG_TYPE_ORDER_CMD_VIEW = {
        ArgumentType.COMMAND,
        ArgumentType.OPTION,
        ArgumentType.EMPTY_VALUE
    };
    private static final String[] OR_OPTIONS = {OPTION_EXPENSE, OPTION_LOAN, OPTION_SAVING};
    private static final String[] VALID_OPTIONS_ADD = {OPTION_EXPENSE, OPTION_LOAN, OPTION_SAVING,
            OPTION_AMOUNT, OPTION_DATE};

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

    private void validateArguments_improperCommand_helper(ArrayList<String> arguments,
                                                          ArgumentType[] argumentTypeOrder,
                                                          String expected,
                                                          String command) {
        CommandException e = assertThrows(
            CommandException.class,
            () -> validateArguments(arguments, argumentTypeOrder, command)
        );
        if (!e.getMessage().equals(expected)) {
            fail(arguments.toString() + " - Error: " + e.getMessage());
        }
    }

    @DisplayName("[validateArguments] - help Command - success:")
    @Test
    public void validateArguments_properHelp_success() {
        ArrayList<String> command = ParserHandler.getParseInput("help");
        try {
            validateArguments(command, ARG_TYPE_ORDER_CMD_HELP, COMMAND_HELP);
        } catch (CommandException e) {
            fail(e.getMessage());
        }
    }

    @DisplayName("[validateArguments] - help Command - failure:")
    @Test
    public void validateArguments_improperHelp() {
        String expected1245 = "invalid command order, expected command word.";
        String expected3 = COMMAND_HELP + " Command - too many arguments.";

        ArrayList<String> command1 = ParserHandler.getParseInput("help gerard oi");
        validateArguments_improperCommand_helper(command1, ARG_TYPE_ORDER_CMD_HELP,
                expected1245, COMMAND_HELP);

        ArrayList<String> command2 = ParserHandler.getParseInput("help -z oi");
        validateArguments_improperCommand_helper(command2, ARG_TYPE_ORDER_CMD_HELP,
                expected1245, COMMAND_HELP);

        ArrayList<String> command3 = ParserHandler.getParseInput("help -a");
        validateArguments_improperCommand_helper(command3, ARG_TYPE_ORDER_CMD_HELP,
                expected3, COMMAND_HELP);

        ArrayList<String> command4 = ParserHandler.getParseInput("help me");
        validateArguments_improperCommand_helper(command4, ARG_TYPE_ORDER_CMD_HELP,
                expected1245, COMMAND_HELP);

        ArrayList<String> command5 = ParserHandler.getParseInput("helpz");
        validateArguments_improperCommand_helper(command5, ARG_TYPE_ORDER_CMD_HELP,
                expected1245, COMMAND_HELP);
    }

    @DisplayName("[validateArguments] - view Command - success:")
    @Test
    public void validateArguments_properView_success() {
        // By assumption that options are valid and order is correct.
        ArrayList<String> command1 = ParserHandler.getParseInput("view -e");
        ArrayList<String> command2 = ParserHandler.getParseInput("view -l");
        ArrayList<String> command3 = ParserHandler.getParseInput("view -s");
        try {
            validateArguments(command1, ARG_TYPE_ORDER_CMD_VIEW, COMMAND_VIEW);
            validateArguments(command2, ARG_TYPE_ORDER_CMD_VIEW, COMMAND_VIEW);
            validateArguments(command3, ARG_TYPE_ORDER_CMD_VIEW, COMMAND_VIEW);
        } catch (CommandException e) {
            fail(e.getMessage());
        }
    }

    @DisplayName("[validateArguments] - view Command - failure:")
    @Test
    public void validateArguments_improperView() {
        String expected1 = "view Command - invalid input: ";
        String expected25 = "view Command - not enough arguments.";
        String expected34 = "view Command - too many arguments.";

        ArrayList<String> command1 = ParserHandler.getParseInput("view -l abc");
        validateArguments_improperCommand_helper(command1, ARG_TYPE_ORDER_CMD_VIEW,
                expected1 + "abc", COMMAND_VIEW);

        ArrayList<String> command2 = ParserHandler.getParseInput("view -z -z");
        validateArguments_improperCommand_helper(command2, ARG_TYPE_ORDER_CMD_VIEW,
                expected25, COMMAND_VIEW);

        ArrayList<String> command3 = ParserHandler.getParseInput("view -s -s");
        validateArguments_improperCommand_helper(command3, ARG_TYPE_ORDER_CMD_VIEW,
                expected34, COMMAND_VIEW);

        ArrayList<String> command4 = ParserHandler.getParseInput("view -l -l");
        validateArguments_improperCommand_helper(command4, ARG_TYPE_ORDER_CMD_VIEW,
                expected34, COMMAND_VIEW);

        ArrayList<String> command5 = ParserHandler.getParseInput("view");
        validateArguments_improperCommand_helper(command5, ARG_TYPE_ORDER_CMD_VIEW,
                expected25, COMMAND_VIEW);
    }

    @DisplayName("[validateOptions] - Valid options - success:")
    @Test
    public void validateOptions_validOptions_success() {
        ArrayList<String> command1 = ParserHandler.getParseInput("view -l");
        ArrayList<String> command2 = ParserHandler.getParseInput("add -s savings -a 200.00 -d 20/1/2021");
        ArrayList<String> command3 = ParserHandler.getParseInput("add -a 200.00 -d 20/1/2021 -s savings");

        try {
            validateOptions(command1, COMMAND_VIEW, OR_OPTIONS, OR_OPTIONS);
            validateOptions(command2, COMMAND_ADD, VALID_OPTIONS_ADD, OR_OPTIONS);
            validateOptions(command3, COMMAND_ADD, VALID_OPTIONS_ADD, OR_OPTIONS);
        } catch (CommandException e) {
            fail();
        }
    }

    @DisplayName("[validateOptions] - Invalid options - failure:")
    @Test
    public void validateOptions_invalidOptions() {
        ArrayList<String> command1 = ParserHandler.getParseInput("view -l -z");
        ArrayList<String> command2 = ParserHandler.getParseInput("add -s -a 200.00 -d -d");
        ArrayList<String> command3 = ParserHandler.getParseInput("add -a -s -s -d");
        assertThrows(CommandException.class, () ->
                validateOptions(command1, COMMAND_VIEW, OR_OPTIONS, OR_OPTIONS));
        assertThrows(CommandException.class, () ->
                validateOptions(command2, COMMAND_ADD, VALID_OPTIONS_ADD, OR_OPTIONS));
        assertThrows(CommandException.class, () ->
                validateOptions(command3, COMMAND_ADD, VALID_OPTIONS_ADD, OR_OPTIONS));
    }

    @DisplayName("[getOptionValue] - Option exists - success:")
    @Test
    public void getOptionValue_optionExists_success() {
        ArrayList<String> command1 = ParserHandler.getParseInput("add -s savings -a 200.00 -d 20/1/2021");
        ArrayList<String> command2 = ParserHandler.getParseInput("add -a 200.00 -d 20/1/2021 -s savings");
        try {
            assertEquals("200.00", getOptionValue(command1, COMMAND_ADD, "-a"));
            assertEquals("20/1/2021", getOptionValue(command1, COMMAND_ADD, "-d"));
            assertEquals("savings", getOptionValue(command1, COMMAND_ADD, "-s"));
            assertEquals("200.00", getOptionValue(command2, COMMAND_ADD, "-a"));
            assertEquals("20/1/2021", getOptionValue(command2, COMMAND_ADD, "-d"));
            assertEquals("savings", getOptionValue(command2, COMMAND_ADD, "-s"));
        } catch (CommandException e) {
            fail();
        }
    }

    @DisplayName("[getOptionValue] - Option empty - failure:")
    @Test
    public void getOptionValue_optionEmpty() {
        ArrayList<String> command1 = ParserHandler.getParseInput("add -s -a -d");
        ArrayList<String> command2 = ParserHandler.getParseInput("add -a 200.00 -d -s savings");
        assertThrows(CommandException.class, () ->
                getOptionValue(command1, COMMAND_ADD, "-a"));
        assertThrows(CommandException.class, () ->
                getOptionValue(command1, COMMAND_ADD, "-d"));
        assertThrows(CommandException.class, () ->
                getOptionValue(command1, COMMAND_ADD, "-s"));
        assertThrows(CommandException.class, () ->
                getOptionValue(command2, COMMAND_ADD, "-d"));
    }
}
