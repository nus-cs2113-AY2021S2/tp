package seedu.duke.commands;

import org.junit.jupiter.api.Test;
import seedu.duke.exceptions.CommandException;
import seedu.duke.lesson.Lesson;
import seedu.duke.lesson.LessonType;
import seedu.duke.module.Module;
import seedu.duke.module.ModuleList;
import seedu.duke.ui.UI;

import java.io.OutputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddLessonCommandTest extends LessonCommandTest {

    public static final String EXPECTED_OUTPUT = "Added tutorial." + System.lineSeparator();

    @Test
    void execute() {
        ModuleList moduleList = new ModuleList();
        UI ui = new UI();
        Module module = new Module(MODULE_CODE);
        String moduleCode = module.getModuleCode();
        moduleList.selectedModule = module;
        Lesson newLesson = initialiseLesson(TEACHER_NAME, TEACHER_EMAIL, LessonType.TUTORIAL, TIME, ONLINE_LINK);
        Command command = new AddLessonCommand(newLesson);
        OutputStream os = getOutputStream();

        try {
            command.execute(moduleList, ui);
        } catch (CommandException e) {
            printFailedToExecuteCommand();
        }
        assertEquals(EXPECTED_OUTPUT, os.toString());
        removeOutputStream();
    }
}