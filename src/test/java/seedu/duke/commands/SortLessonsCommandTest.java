package seedu.duke.commands;

import org.junit.jupiter.api.Test;
import seedu.duke.TestUtilAndConstants;
import seedu.duke.exception.CommandException;
import seedu.duke.lesson.Lesson;
import seedu.duke.lesson.LessonType;
import seedu.duke.module.ModuleList;
import seedu.duke.ui.UI;

import java.io.OutputStream;
import java.util.ArrayList;

import static seedu.duke.common.Messages.INDENTATION;
import static seedu.duke.common.Messages.NEWLINE;

class SortLessonsCommandTest extends LessonCommandTest {

    public static final String EXPECTED_OUTPUT = "Sorting list of lessons based on lesson type..." + NEWLINE
            + "1. lecture - " + "Friday 9 am - 10am" + NEWLINE + INDENTATION
            + "https://www.youtube.com/watch?v=PGNiXGX2nLU" + NEWLINE + INDENTATION + "Alicia Tay" + NEWLINE
            + INDENTATION + "aliciatay@zls.com" + NEWLINE
            + "2. tutorial - " + TIME + NEWLINE + INDENTATION + ONLINE_LINK + NEWLINE + INDENTATION
            + TEACHER_NAME + NEWLINE + INDENTATION + TEACHER_EMAIL + NEWLINE
            + "3. lab - " + TIME1 + NEWLINE + INDENTATION + ONLINE_LINK1 + NEWLINE + INDENTATION
            + TEACHER_NAME1 + NEWLINE + INDENTATION + TEACHER_EMAIL1 + NEWLINE;

    @Test
    void execute_ui_expectPrintsCorrectOutput() {
        TestUtilAndConstants.removeFiles();
        ModuleList.loadModuleNames();
        UI ui = new UI();

        OutputStream os = getOutputStream();
        ModuleList.addModule(MODULE_CODE);
        ModuleList.setSelectedModule(MODULE_CODE);
        addLessonsToList(ui);
        Lesson newLesson = initialiseLesson("Alicia Tay", "aliciatay@zls.com", LessonType.LECTURE,
                "Friday 9 am - 10am", "https://www.youtube.com/watch?v=PGNiXGX2nLU");
        ArrayList<Lesson> lessonList = ModuleList.getSelectedModule().getLessonList();
        lessonList.add(newLesson);
        removeOutputStream();

        OutputStream newOs = getOutputStream();
        Command command = new SortLessonsCommand();
        try {
            command.execute(ui);
        } catch (CommandException e) {
            printFailedToExecuteCommand();
        }
        assert (EXPECTED_OUTPUT.equals(newOs.toString()));
        removeOutputStream();
    }
}