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

class AddLessonCommandTest {

    public static final String EXPECTED_OUTPUT = "Added tutorial." + System.lineSeparator();
    public static final String MODULE_CODE = "CS3235";
    public static final String TEACHER_NAME = "Ivan Chong Zhi En";
    public static final String TEACHER_EMAIL = "ivanchong@zhi.en";
    public static final String TIME = "Wednesday 9 am - 10am";
    public static final String ONLINE_LINK = "https://youtu.be/dQw4w9WgXcQ";

    @Test
    void execute() {
        ModuleList moduleList = new ModuleList();
        UI ui = new UI();
        Lesson newLesson = initialiseLesson();
        Command command = new AddLessonCommand(newLesson);
        OutputStream os = getOutputStream();
        command.execute(moduleList, ui);
        assertEquals(EXPECTED_OUTPUT, os.toString());
        removeOutputStream();
    }

    private Lesson initialiseLesson() {
        Module module = new Module(MODULE_CODE);
        String moduleCode = module.getModuleCode();
        boolean isModuleSelected = ModuleList.setSelectedModule(module);
        TeachingStaff teachingStaff = new TeachingStaff();
        teachingStaff.setName(TEACHER_NAME);
        teachingStaff.setEmail(TEACHER_EMAIL);
        Lesson newLesson = new Lesson(LessonType.TUTORIAL);
        newLesson.setTime(TIME);
        newLesson.setTeachingStaff(teachingStaff);
        newLesson.setOnlineLink(ONLINE_LINK);
        return newLesson;
    }

    private void removeOutputStream() {
        PrintStream originalOut = System.out;
        System.setOut(originalOut);
    }

    private OutputStream getOutputStream() {
        OutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        System.setOut(ps);
        return os;
    }

}