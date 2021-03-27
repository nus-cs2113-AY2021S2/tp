package seedu.duke.commands;

import org.junit.jupiter.api.Test;
import seedu.duke.TestUtilAndConstants;
import seedu.duke.exception.CommandException;
import seedu.duke.lesson.Lesson;
import seedu.duke.lesson.LessonType;
import seedu.duke.module.Module;
import seedu.duke.module.ModuleList;
import seedu.duke.ui.UI;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EditLessonCommandTest extends LessonCommandTest {

    //@@author ivanchongzhien
    @Test
    void execute_validIndexAllFields_lessonFieldsEdited() throws CommandException {
        TestUtilAndConstants.removeFiles();
        ModuleList.loadModuleNames();
        
        ModuleList.addModule(MODULE_CODE);
        ModuleList.setSelectedModule(MODULE_CODE);
        Module module = ModuleList.getSelectedModule();
        
        Lesson oriLesson = initialiseLesson(TEACHER_NAME, TEACHER_EMAIL, 
                LessonType.TUTORIAL, TIME, ONLINE_LINK);
        module.addLesson(oriLesson);
        
        // Prepare user input
        String lessonIndex = "1" + System.lineSeparator();
        String lessonFields = "1 2 3 4" + System.lineSeparator();
        String newTime = TIME1 + System.lineSeparator();
        String newLink = ONLINE_LINK1 + System.lineSeparator();
        String newTeacherName = TEACHER_NAME1 + System.lineSeparator();
        String newTeacherEmail = TEACHER_EMAIL1 + System.lineSeparator();
        
        String entireInput = lessonIndex + lessonFields + newTime + newLink + newTeacherName + newTeacherEmail;
        initialiseUserInput(entireInput);

        // Run command
        UI ui = new UI();
        Command command = new EditLessonCommand();
        command.execute(ui);
        Lesson actualLessonAfterEdit = ModuleList.getSelectedModule().getLessonList().get(0);

        removeOutputStream();
        ModuleList.reset();
        
        // Expected lesson after edit
        Lesson editedLesson = initialiseLesson(TEACHER_NAME1, TEACHER_EMAIL1, 
                LessonType.TUTORIAL, TIME1, ONLINE_LINK1);

        assertEquals(editedLesson.getTime(), actualLessonAfterEdit.getTime());
        assertEquals(editedLesson.getOnlineLink(), actualLessonAfterEdit.getOnlineLink());
        assertEquals(editedLesson.getTeachingStaff().getName(), actualLessonAfterEdit.getTeachingStaff().getName());
        assertEquals(editedLesson.getTeachingStaff().getEmail(), actualLessonAfterEdit.getTeachingStaff().getEmail());
    }

    @Test
    void execute_validAndInvalidIndexPartialFields_lessonFieldsEdited() throws CommandException {
        TestUtilAndConstants.removeFiles();
        ModuleList.loadModuleNames();

        ModuleList.addModule(MODULE_CODE);
        ModuleList.setSelectedModule(MODULE_CODE);
        Module module = ModuleList.getSelectedModule();

        Lesson oriLesson = initialiseLesson(TEACHER_NAME, TEACHER_EMAIL,
                LessonType.TUTORIAL, TIME, ONLINE_LINK);
        module.addLesson(oriLesson);

        // Prepare user input
        String lessonIndex = "1" + System.lineSeparator();
        String lessonFields = "1 10 -1 3 0 abc" + System.lineSeparator(); // 1 and 3 are valid
        String newTime = TIME1 + System.lineSeparator();
        String newTeacherName = TEACHER_NAME1 + System.lineSeparator();

        String entireInput = lessonIndex + lessonFields + newTime + newTeacherName;
        initialiseUserInput(entireInput);

        // Run command
        UI ui = new UI();
        Command command = new EditLessonCommand();
        command.execute(ui);
        Lesson actualLessonAfterEdit = ModuleList.getSelectedModule().getLessonList().get(0);

        removeOutputStream();
        ModuleList.reset();

        // Expected lesson after edit
        Lesson editedLesson = initialiseLesson(TEACHER_NAME1, TEACHER_EMAIL,
                LessonType.TUTORIAL, TIME1, ONLINE_LINK);

        assertEquals(editedLesson.getTime(), actualLessonAfterEdit.getTime());
        assertEquals(editedLesson.getOnlineLink(), actualLessonAfterEdit.getOnlineLink());
        assertEquals(editedLesson.getTeachingStaff().getName(), actualLessonAfterEdit.getTeachingStaff().getName());
        assertEquals(editedLesson.getTeachingStaff().getEmail(), actualLessonAfterEdit.getTeachingStaff().getEmail());
    }
}