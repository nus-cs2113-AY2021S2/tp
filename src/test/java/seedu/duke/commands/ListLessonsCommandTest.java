package seedu.duke.commands;

import org.junit.jupiter.api.Test;
import seedu.duke.lesson.Lesson;
import seedu.duke.lesson.LessonType;
import seedu.duke.lesson.TeachingStaff;
import seedu.duke.module.Module;
import seedu.duke.module.ModuleList;
import seedu.duke.ui.UI;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ListLessonsCommandTest extends LessonCommandTest {

    public static final String EXPECTED_OUTPUT = "1. tutorial - " + TIME + "\n \t" + ONLINE_LINK + "\n \t"
            + TEACHER_NAME + "\n \t" + TEACHER_EMAIL + System.lineSeparator() + "2. lab - " + TIME1 + "\n \t"
            + ONLINE_LINK1 + "\n \t" + TEACHER_NAME1 + "\n \t" + TEACHER_EMAIL1 + System.lineSeparator();

    @Test
    void printLessonsFromList() {
        ModuleList moduleList = new ModuleList();
        UI ui = new UI();

        OutputStream os = getOutputStream();
        Module module = new Module(MODULE_CODE);
        String moduleCode = module.getModuleCode();
        boolean isModuleSelected = ModuleList.setSelectedModule(module);
        addLessonsToList(moduleList, ui);
        removeOutputStream();

        os = getOutputStream();
        ListLessonsCommand.printLessonsFromList(module.getLessonList());
        assertEquals(EXPECTED_OUTPUT, os.toString());
        removeOutputStream();
    }
}