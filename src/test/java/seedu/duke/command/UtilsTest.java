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
import static seedu.duke.command.CreditScoreCommand.COMMAND_CREDIT_SCORE;
import static seedu.duke.command.HelpCommand.COMMAND_HELP;
import static seedu.duke.command.Utils.getOptionValue;
import static seedu.duke.command.Utils.getValue;
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
    private static final ArgumentType[] ARG_TYPE_ORDER_CMD_HELP = {
        ArgumentType.COMMAND,
        ArgumentType.VALUE
    };
    private static final ArgumentType[] ARG_TYPE_ORDER_CMD_VIEW = {
        ArgumentType.COMMAND,
        ArgumentType.OPTION,
        ArgumentType.EMPTY_VALUE
    };
    private static final String[] OR_OPTIONS = {OPTION_EXPENSE, OPTION_LOAN, OPTION_SAVING};
    private static final String[] VALID_OPTIONS_ADD = {
        OPTION_EXPENSE, OPTION_LOAN, OPTION_SAVING, OPTION_AMOUNT, OPTION_DATE
    };

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
            () -> assertTrue(isOption("-p")),
            () -> assertTrue(isOption("-E"))
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
        ParserHandler parserHandler = new ParserHandler();
        ArrayList<String> command = parserHandler.getParseInput("help");
        try {
            validateArguments(command, ARG_TYPE_ORDER_CMD_HELP, COMMAND_HELP);
        } catch (CommandException e) {
            fail(e.getMessage());
        }
    }

    @DisplayName("[validateArguments] - help Command - failure:")
    @Test
    public void validateArguments_improperHelp() {
        ArrayList<String> command = new ArrayList<>();
        command.add("help");
        String expected1 = COMMAND_HELP + " Command - not enough arguments.";
        validateArguments_improperCommand_helper(command, ARG_TYPE_ORDER_CMD_HELP,
                expected1, COMMAND_HELP);

        command.add("me");
        command.add("oi");
        String expected2 = COMMAND_HELP + " Command - too many arguments.";
        validateArguments_improperCommand_helper(command, ARG_TYPE_ORDER_CMD_HELP,
                expected2, COMMAND_HELP);

        command.clear();
        command.add("help");
        command.add(null);
        String expected3 = COMMAND_HELP + " Command - missing argument value.";
        validateArguments_improperCommand_helper(command, ARG_TYPE_ORDER_CMD_HELP,
                expected3, COMMAND_HELP);

        command.remove(1);
        command.add("");
        validateArguments_improperCommand_helper(command, ARG_TYPE_ORDER_CMD_HELP,
                expected3, COMMAND_HELP);
    }

    @DisplayName("[validateArguments] - view Command - success:")
    @Test
    public void validateArguments_properView_success() {
        ParserHandler parserHandler = new ParserHandler();
        // By assumption that options are valid and order is correct.
        ArrayList<String> command1 = parserHandler.getParseInput("view -e");
        ArrayList<String> command2 = parserHandler.getParseInput("view -l");
        ArrayList<String> command3 = parserHandler.getParseInput("view -s");
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

        ParserHandler parserHandler = new ParserHandler();
        ArrayList<String> command1 = parserHandler.getParseInput("view -l abc");
        validateArguments_improperCommand_helper(command1, ARG_TYPE_ORDER_CMD_VIEW,
                expected1 + "abc", COMMAND_VIEW);

        ArrayList<String> command2 = parserHandler.getParseInput("view -z -z");
        validateArguments_improperCommand_helper(command2, ARG_TYPE_ORDER_CMD_VIEW,
                expected25, COMMAND_VIEW);

        ArrayList<String> command3 = parserHandler.getParseInput("view -s -s");
        validateArguments_improperCommand_helper(command3, ARG_TYPE_ORDER_CMD_VIEW,
                expected34, COMMAND_VIEW);

        ArrayList<String> command4 = parserHandler.getParseInput("view -l -l");
        validateArguments_improperCommand_helper(command4, ARG_TYPE_ORDER_CMD_VIEW,
                expected34, COMMAND_VIEW);

        ArrayList<String> command5 = parserHandler.getParseInput("view");
        validateArguments_improperCommand_helper(command5, ARG_TYPE_ORDER_CMD_VIEW,
                expected25, COMMAND_VIEW);
    }

    @DisplayName("[validateOptions] - Valid options - success:")
    @Test
    public void validateOptions_validOptions_success() {
        ParserHandler parserHandler = new ParserHandler();
        ArrayList<String> command1 = parserHandler.getParseInput("view -l");
        ArrayList<String> command2 = parserHandler.getParseInput("add -s savings -a 200.00 -d 20/1/2021");
        ArrayList<String> command3 = parserHandler.getParseInput("add -a 200.00 -d 20/1/2021 -s savings");

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
        ParserHandler parserHandler = new ParserHandler();

        ArrayList<String> command1 = parserHandler.getParseInput("view -l -z");
        assertThrows(CommandException.class, () ->
                validateOptions(command1, COMMAND_VIEW, OR_OPTIONS, OR_OPTIONS));

        ArrayList<String> command2 = parserHandler.getParseInput("add -s -a 200.00 -d -d");
        assertThrows(CommandException.class, () ->
                validateOptions(command2, COMMAND_ADD, VALID_OPTIONS_ADD, OR_OPTIONS));
        
        ArrayList<String> command3 = parserHandler.getParseInput("add -a -s -s -d");
        assertThrows(CommandException.class, () ->
                validateOptions(command3, COMMAND_ADD, VALID_OPTIONS_ADD, OR_OPTIONS));

        ArrayList<String> command4 = parserHandler.getParseInput("add -a 200.00 -d 20/1/2021 -s -l savings");
        assertThrows(CommandException.class, () ->
                validateOptions(command4, COMMAND_ADD, VALID_OPTIONS_ADD, OR_OPTIONS));
    }

    @DisplayName("[getValue] - Value exists - success:")
    @Test
    public void getValue_valueExists_success() {
        ArrayList<String> command1 = new ArrayList<>();
        String verify1 = "abc";
        command1.add("help");
        command1.add(verify1);
        ArrayList<String> command2 = new ArrayList<>();
        String verify2 = "mark";
        command2.add("creditscore");
        command2.add(verify2);
        try {
            assertEquals(verify1, getValue(command1, COMMAND_CREDIT_SCORE));
            assertEquals(verify2, getValue(command2, COMMAND_CREDIT_SCORE));
        } catch (CommandException e) {
            fail(e.getMessage());
        }
    }

    @DisplayName("[getValue] - Value missing - failure:")
    @Test
    public void getValue_valueMissing() {
        ArrayList<String> command1 = new ArrayList<>();
        command1.add("help");
        assertThrows(CommandException.class, () -> getValue(command1, COMMAND_HELP));
        command1.add("");
        assertThrows(CommandException.class, () -> getValue(command1, COMMAND_HELP));
    }

    @DisplayName("[getOptionValue] - Option exists - success:")
    @Test
    public void getOptionValue_optionExists_success() {
        ParserHandler parserHandler = new ParserHandler();
        ArrayList<String> command1 = parserHandler.getParseInput("add -s savings -a 200.00 -d 20/1/2021");
        ArrayList<String> command2 = parserHandler.getParseInput("add -a 200.00 -d 20/1/2021 -s savings");
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
        ParserHandler parserHandler = new ParserHandler();
        ArrayList<String> command1 = parserHandler.getParseInput("add -s -a -d");
        assertThrows(CommandException.class, () ->
                getOptionValue(command1, COMMAND_ADD, "-a"));
        assertThrows(CommandException.class, () ->
                getOptionValue(command1, COMMAND_ADD, "-d"));
        assertThrows(CommandException.class, () ->
                getOptionValue(command1, COMMAND_ADD, "-s"));
        assertThrows(CommandException.class, () ->
                getOptionValue(command1, COMMAND_ADD, "-p"));

        ArrayList<String> command2 = parserHandler.getParseInput("add -a 200.00 -d -s savings");
        assertThrows(CommandException.class, () ->
                getOptionValue(command2, COMMAND_ADD, "-d"));
    }
}
