package seedu.duke.parser;

import seedu.duke.commands.AddLessonCommand;
import seedu.duke.commands.AddModuleCommand;
import seedu.duke.commands.Command;
import seedu.duke.commands.ListTasksCommand;
import seedu.duke.exception.UnknownCommandException;
import seedu.duke.module.Module;
import seedu.duke.lesson.Lesson;
import seedu.duke.lesson.LessonType;
import seedu.duke.lesson.TeachingStaff;
import seedu.duke.module.ModuleList;
import seedu.duke.task.Task;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {
    @Test
        // DASHBOARD COMMAND
    void parse_dashboardCommandAddModule_addCommandObject() throws UnknownCommandException {
        ModuleList.selectedModule = null;
        
        Parser parser = new Parser();
        String input = "add CS2113T";

        // Command expectedCommand = new AddModuleCommand("CS2113T");
        Command actualCommand = parser.parse(input);
        assertTrue(actualCommand instanceof AddModuleCommand);
    }

    @Test
        // IN MODULE COMMAND
        // add lesson command
    void parse_inModuleCommandListTask_ListTask() throws UnknownCommandException {
        
        Module dummyMod = new Module("CS1234");
        ModuleList.selectedModule = dummyMod;
        
        Parser parser = new Parser();
        String input = "tasks";
        
        Command actualCommand = parser.parse(input);
        assertTrue(actualCommand instanceof ListTasksCommand);
    }

    @Test
        // add lesson command - all detail fields included
    void parse_inModuleCommandAddLessonFullDetails_addLessonObject() throws UnknownCommandException {
        Module dummyMod = new Module("CS1234");
        ModuleList.selectedModule = dummyMod;
        
        Parser parser = new Parser();
        String input = "add lesson tutorial ;; Wednesday 9am-10am ;; www.zoom.com/1234 ;; Xianhao Cheng ;; xh123@nus.edu.sg";

        Command actualCommand = parser.parse(input);
        assertTrue(actualCommand instanceof AddLessonCommand);
    }



}