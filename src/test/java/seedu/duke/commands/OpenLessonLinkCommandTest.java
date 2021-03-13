package seedu.duke.commands;

import org.junit.jupiter.api.Test;
import seedu.duke.TestUtilAndConstants;
import seedu.duke.module.ModuleList;
import seedu.duke.ui.UI;

import java.io.OutputStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.duke.TestUtilAndConstants.EXPECTED_OPEN_LINK;

class OpenLessonLinkCommandTest extends LessonCommandTest {

    //@@author H-horizon
    @Test
    void printLessonsLink_lessonListIndexes_expectPrintsCorrectOutput() {
        TestUtilAndConstants.removeFiles();
        ModuleList.loadModuleNames();
        UI ui = new UI();

        OutputStream os = getOutputStream();
        ModuleList.addModule(MODULE_CODE);
        ModuleList.setSelectedModule(MODULE_CODE);
        addLessonsToList(ui);
        ArrayList<Integer> indices = new ArrayList<>();
        initialisedIndexes(indices);
        removeOutputStream();

        OutputStream newOs = getOutputStream();
        OpenLessonLinkCommand.printLessonsLink(ModuleList.getSelectedModule().getLessonList(), indices, ui);
        assertEquals(EXPECTED_OPEN_LINK, newOs.toString());
        removeOutputStream();
    }
}