package seedu.duke.parser;

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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.duke.common.ModuleCommands.EDIT_CHEAT_SHEET;
import static seedu.duke.common.ModuleCommands.INFO;
import static seedu.duke.common.ModuleCommands.LESSONS;
import static seedu.duke.common.ModuleCommands.LINK;
import static seedu.duke.common.ModuleCommands.TASKS;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class ParserTest {

    public static final String MODULE_CODE = "CS1234";
    public static final String ADD_MODULE = "add CS2113T";
    public static final String HELP = "help";
    public static final String OPEN_MODULE = "open cs1234";
    public static final String DELETE_MODULE = "delete";
    public static final String ARBITRARY_STRING = "AakjhdLKLlkjlLJAAasldkj 12801 =123-=-';";
    
    
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
    }


    @Test
    // Test check indices method - providing various valid and invalid inputs
    // Invalid inputs : out of bounds, duplicate index, non-integer inputs
    void checkIndices_variousInputs_processedArrayList() {
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);
        
        int max = 5;
        String input1 = "1 2 3"; // happy
        assertEquals(expected, Parser.checkIndices(input1, max));
        
        String input2 = "1 1 2 3 3 3 2 2 1 2"; // duplicates
        assertEquals(expected, Parser.checkIndices(input2, max));
        
        String input3 = "10 1 99 2 10909 3 99 99 100 10"; // out of bounds and duplicates
        assertEquals(expected, Parser.checkIndices(input3, max));
        
        String input4 = "10 1 -1 -99 -2 10918 2 3 -99 990 990 10 0 10"; // out of bounds and duplicates and negative
        assertEquals(expected, Parser.checkIndices(input4, max));
        
        String input5 = "10 1 -1 -99 -2 10918 2 3 abc"; // out of bounds and duplicates and negative and non-integer
        assertEquals(expected, Parser.checkIndices(input5, max));
    }
}