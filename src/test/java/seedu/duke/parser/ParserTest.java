package seedu.duke.parser;

import seedu.duke.commands.AddLessonCommand;
import seedu.duke.commands.AddModuleCommand;
import seedu.duke.commands.Command;
import seedu.duke.exception.UnknownCommandException;
import seedu.duke.lesson.Lesson;
import seedu.duke.lesson.LessonType;
import seedu.duke.lesson.TeachingStaff;
import seedu.duke.module.ModuleList;
import seedu.duke.task.Task;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ParserTest {
    @Test
    // happy case
    // dashboard command
    void parse_dashboardCommandAddModule_addCommandObject() throws UnknownCommandException {
        Parser parser = new Parser();
        String input = "add CS2113T";
        
        Command expectedCommand = new AddModuleCommand("CS2113T");
        Command actualCommand = parser.parse(input);
        assertEquals(expectedCommand, actualCommand);
    }

    @Test
    // happy case
    // in module command
    void parse_inModuleCommandAddLessonFullDetails_addLessonObject() throws UnknownCommandException {
        Parser parser = new Parser();
        String input = "add lesson tutorial ;; Wednesday 9am-10am ;; www.zoom.com/1234 ;; Xianhao Cheng ;; xh123@nus.edu.sg";

        TeachingStaff expectedTeacher = new TeachingStaff("Xianhao Cheng", "xh123@nus.edu.sg");
        Lesson expectedLesson = new Lesson(LessonType.TUTORIAL, "Wednesday 9am-10am", 
                "www.zoom.com/1234", expectedTeacher);
        
        Command expectedCommand = new AddLessonCommand(expectedLesson);
        Command actualCommand = parser.parse(input);
        assertEquals(expectedCommand, actualCommand);
    }

}