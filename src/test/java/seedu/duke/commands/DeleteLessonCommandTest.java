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
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DeleteLessonCommandTest {

    public static final String EXPECTED_OUTPUT = "Removed tutorial." + System.lineSeparator() + "Removed lab."
            + System.lineSeparator();
    public static final String MODULE_CODE = "CS3235";
    public static final String TEACHER_NAME = "Ivan Chong Zhi En";
    public static final String TEACHER_EMAIL = "ivanchong@zhi.en";
    public static final String TIME = "Wednesday 9 am - 10am";
    public static final String ONLINE_LINK = "https://youtu.be/dQw4w9WgXcQ";
    public static final String TEACHER_NAME1 = "Isa Bin Haron";
    public static final String TEACHER_EMAIL1 = "isa@bin.haron";
    public static final String TIME1 = "Wednesday 9 pm - 10 pm";
    public static final String ONLINE_LINK1 = "https://youtu.be/YnopHCL1Jk8";

    @Test
    void deleteLessonsFromList() {

        ModuleList moduleList = new ModuleList();
        UI ui = new UI();

        Module module = new Module(MODULE_CODE);
        String moduleCode = module.getModuleCode();
        boolean isModuleSelected = ModuleList.setSelectedModule(module);

        OutputStream os = getOutputStream();
        addLessonsToList(moduleList, ui);
        ArrayList<Integer> indexes = new ArrayList<>();
        initialisedIndexes(indexes);
        removeOutputStream();

        os = getOutputStream();
        DeleteLessonCommand.deleteLessonsFromList(module, module.getLessonList(), indexes);
        assertEquals(EXPECTED_OUTPUT, os.toString());
        removeOutputStream();
    }

    private void initialisedIndexes(ArrayList<Integer> indexes) {
        indexes.add(1);
        indexes.add(2);
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