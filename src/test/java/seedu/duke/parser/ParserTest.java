package seedu.duke.parser;

import seedu.duke.TestUtilAndConstants;
import seedu.duke.commands.AddModuleCommand;
import seedu.duke.commands.Command;
import seedu.duke.commands.DeleteModuleCommand;
import seedu.duke.commands.EditCheatSheetCommand;
import seedu.duke.commands.EnterModuleCommand;
import seedu.duke.commands.ListLessonsCommand;
import seedu.duke.commands.ListTasksCommand;
import seedu.duke.commands.ModuleInfoCommand;
import seedu.duke.commands.OpenLessonLinkCommand;
import seedu.duke.commands.PrintHelpCommand;
import seedu.duke.exception.CommandException;
import seedu.duke.exception.ParserException;
import seedu.duke.module.ModuleList;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.duke.common.ModuleCommands.EDIT_CHEAT_SHEET;
import static seedu.duke.common.ModuleCommands.INFO;
import static seedu.duke.common.ModuleCommands.LESSONS;
import static seedu.duke.common.ModuleCommands.LINK;
import static seedu.duke.common.ModuleCommands.TASKS;

import org.junit.jupiter.api.Test;

class ParserTest {

    public static final String MODULE_CODE = "CS1234";
    public static final String ADD_MODULE = "add CS2113T";
    public static final String HELP = "help";
    public static final String OPEN_MODULE = "open cs1234";
    public static final String DELETE_MODULE = "del";
    public static final String ARBITRARY_STRING = "AakjhdLKLlkjlLJAAasldkj 12801 =123-=-';";
    public static final String INCORRECT_DASHBOARD1 = "help me!!";
    public static final String INCORRECT_DASHBOARD2 = "modules abc 123";
    public static final String INCORRECT_DASHBOARD3 = "del something";

        
    //@@author ivanchongzhien
    
    @Test
    // DASHBOARD COMMANDS
    void parse_dashboardCommands_correctCommandObject() throws CommandException,
            ParserException {
        ModuleList.reset();

        Parser parser = new Parser();

        Command command1 = parser.parse(ADD_MODULE);
        assertTrue(command1 instanceof AddModuleCommand);

        Command command2 = parser.parse(HELP);
        assertTrue(command2 instanceof PrintHelpCommand);

        Command command3 = parser.parse(OPEN_MODULE);
        assertTrue(command3 instanceof EnterModuleCommand);

        Command command4 = parser.parse(DELETE_MODULE);
        assertTrue(command4 instanceof DeleteModuleCommand);
    }

    @Test
    // IN MODULE COMMAND
    void parse_inModuleCommands_correctCommandObject() throws CommandException, ParserException {
        ModuleList.addModule(MODULE_CODE);
        ModuleList.setSelectedModule(MODULE_CODE);

        Parser parser = new Parser();

        Command actualCommand = parser.parse(TASKS.getWord());
        assertTrue(actualCommand instanceof ListTasksCommand);

        actualCommand = parser.parse(LINK.getWord());
        assertTrue(actualCommand instanceof OpenLessonLinkCommand);

        actualCommand = parser.parse(LESSONS.getWord());
        assertTrue(actualCommand instanceof ListLessonsCommand);

        actualCommand = parser.parse(INFO.getWord());
        assertTrue(actualCommand instanceof ModuleInfoCommand);

        actualCommand = parser.parse(EDIT_CHEAT_SHEET.getWord());
        assertTrue(actualCommand instanceof EditCheatSheetCommand);

        // Invalid command case - not so happy case
        boolean isThrown = false;
        try {
            parser.parse(ARBITRARY_STRING);
        } catch (ParserException e) {
            isThrown = true;
        }
        assertTrue(isThrown);

        ModuleList.reset();
        TestUtilAndConstants.emptyModuleList();
    }

    @Test
    // IN MODULE COMMAND
    void parse_invalidCommands_exceptionIsThrown() throws CommandException, ParserException {
        Parser parser = new Parser();
        boolean isThrown = false;
        
        // Dashboard
        try {
            parser.parse(ARBITRARY_STRING);
        } catch (ParserException e) {
            isThrown = true;
        }
        assertTrue(isThrown);
        isThrown = false;

        // Command with unnecessary arguments
        try {
            parser.parse(INCORRECT_DASHBOARD1);
        } catch (ParserException e) {
            isThrown = true;
        }
        assertTrue(isThrown);
        isThrown = false;

        try {
            parser.parse(INCORRECT_DASHBOARD2);
        } catch (ParserException e) {
            isThrown = true;
        }
        assertTrue(isThrown);
        isThrown = false;

        try {
            parser.parse(INCORRECT_DASHBOARD3);
        } catch (ParserException e) {
            isThrown = true;
        }
        assertTrue(isThrown);
        isThrown = false;
        
        // In module
        ModuleList.addModule(MODULE_CODE);
        ModuleList.setSelectedModule(MODULE_CODE);

        try {
            parser.parse(ARBITRARY_STRING);
        } catch (ParserException e) {
            isThrown = true;
        }
        assertTrue(isThrown);

        ModuleList.reset();
        TestUtilAndConstants.emptyModuleList();
    }
}