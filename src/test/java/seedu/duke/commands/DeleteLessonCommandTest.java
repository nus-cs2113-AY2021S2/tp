package seedu.duke.commands;

import org.junit.jupiter.api.Test;
import seedu.duke.TestUtilAndConstants;
import seedu.duke.module.ModuleList;
import seedu.duke.ui.UI;

import java.io.OutputStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.duke.TestUtilAndConstants.EXPECTED_DELETE_LESSON;

class DeleteLessonCommandTest extends LessonCommandTest {

    //@@author H-horizon
    @Test
    void deleteLessonsFromList_moduleLessonListIndexes_expectPrintsCorrectOutput() {

        TestUtilAndConstants.removeFiles();
        ModuleList.loadModuleCodes();

        UI ui = new UI();

        ModuleList.addModule(MODULE_CODE);
        ModuleList.setSelectedModule(MODULE_CODE);

        OutputStream os = getOutputStream();
        addLessonsToList(ui);
        ArrayList<Integer> indexes = new ArrayList<>();
        initialisedIndexes(indexes);
        removeOutputStream();

        OutputStream newOs = getOutputStream();
        DeleteLessonCommand.deleteLessonsFromList(ModuleList.getSelectedModule().getLessonList(), indexes, ui);
        assertEquals(EXPECTED_DELETE_LESSON, newOs.toString());
        removeOutputStream();
    }
}