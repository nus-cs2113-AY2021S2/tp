package seedu.duke.commands;

import org.junit.jupiter.api.Test;
import seedu.duke.TestUtilAndConstants;
import seedu.duke.exception.CommandException;
import seedu.duke.lesson.Lesson;
import seedu.duke.lesson.LessonType;
import seedu.duke.lesson.TeachingStaff;
import seedu.duke.module.Module;
import seedu.duke.module.ModuleList;
import seedu.duke.ui.UI;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EditLessonCommandTest extends LessonCommandTest {

    //@@author ivanchongzhien
    @Test
    void execute_validIndexAndAllFields_lessonFieldsEdited() throws CommandException {
        TestUtilAndConstants.removeFiles();
        ModuleList.loadModuleNames();
        
        ModuleList.addModule(MODULE_CODE);
        ModuleList.setSelectedModule(MODULE_CODE);
        Module module = ModuleList.getSelectedModule();

        TeachingStaff oriTeacher = new TeachingStaff(TEACHER_NAME, TEACHER_EMAIL);
        Lesson oriLesson = new Lesson(LessonType.TUTORIAL, TIME, ONLINE_LINK, oriTeacher);
        module.addLesson(oriLesson);
        
        String lessonIndex = "1" + System.lineSeparator();
        String lessonFields = "1 2 3 4" + System.lineSeparator();
        String newTime = TIME1 + System.lineSeparator();
        String newLink = ONLINE_LINK1 + System.lineSeparator();
        String newTeacherName = TEACHER_NAME1 + System.lineSeparator();
        String newTeacherEmail = TEACHER_EMAIL1 + System.lineSeparator();
        
        String entireInput = lessonIndex + lessonFields + newTime + newLink + newTeacherName + newTeacherEmail;
        ByteArrayInputStream inContent = new ByteArrayInputStream(entireInput.getBytes());
        System.setIn(inContent);
        System.setOut(System.out);

        UI ui = new UI();

        Command command = new EditLessonCommand();
        command.execute(ui);
        
        Lesson actualLessonAfterEdit = ModuleList.getSelectedModule().getLessonList().get(0);
        
        TeachingStaff editedTeacher = new TeachingStaff(TEACHER_NAME1, TEACHER_EMAIL1);
        Lesson editedLesson = new Lesson(LessonType.TUTORIAL, TIME1, ONLINE_LINK1, editedTeacher);
        
        assertEquals(editedLesson.getTime(), actualLessonAfterEdit.getTime());
        assertEquals(editedLesson.getOnlineLink(), actualLessonAfterEdit.getOnlineLink());
        assertEquals(editedLesson.getTeachingStaff().getName(), actualLessonAfterEdit.getTeachingStaff().getName());
        assertEquals(editedLesson.getTeachingStaff().getEmail(), actualLessonAfterEdit.getTeachingStaff().getEmail());
    }
}