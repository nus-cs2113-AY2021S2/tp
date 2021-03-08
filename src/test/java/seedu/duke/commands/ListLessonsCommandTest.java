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

class ListLessonsCommandTest {

    public static final String MODULE_CODE = "CS3235";
    public static final String TEACHER_NAME = "Ivan Chong Zhi En";
    public static final String TEACHER_EMAIL = "ivanchong@zhi.en";
    public static final String TIME = "Wednesday 9 am - 10am";
    public static final String ONLINE_LINK = "https://youtu.be/dQw4w9WgXcQ";
    public static final String TEACHER_NAME1 = "Isa Bin Haron";
    public static final String TEACHER_EMAIL1 = "isa@bin.haron";
    public static final String TIME1 = "Wednesday 9 pm - 10 pm";
    public static final String ONLINE_LINK1 = "https://youtu.be/YnopHCL1Jk8";
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

    private void addLessonsToList(ModuleList moduleList, UI ui) {
        Lesson newLesson = initialiseLesson(TEACHER_NAME, TEACHER_EMAIL, LessonType.TUTORIAL, TIME, ONLINE_LINK);
        Command command = new AddLessonCommand(newLesson);
        command.execute(moduleList, ui);

        newLesson = initialiseLesson(TEACHER_NAME1, TEACHER_EMAIL1, LessonType.LAB, TIME1, ONLINE_LINK1);
        command = new AddLessonCommand(newLesson);
        command.execute(moduleList, ui);
    }

    private Lesson initialiseLesson(String teacherName, String teacherEmail, LessonType lessonType, String time,
                                    String OnlineLink) {
        TeachingStaff teachingStaff = new TeachingStaff();
        teachingStaff.setName(teacherName);
        teachingStaff.setEmail(teacherEmail);
        Lesson newLesson = new Lesson(lessonType);
        newLesson.setTime(time);
        newLesson.setTeachingStaff(teachingStaff);
        newLesson.setOnlineLink(OnlineLink);
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