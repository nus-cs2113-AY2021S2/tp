package seedu.duke.commands;

import org.junit.jupiter.api.Test;
import seedu.duke.TestUtilAndConstants;
import seedu.duke.exception.CommandException;
import seedu.duke.module.ModuleList;
import seedu.duke.ui.UI;

import java.io.OutputStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
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

    @Test
    void execute_ui_expectPrintsEmptyList() {

        TestUtilAndConstants.removeFiles();
        ModuleList.loadModuleCodes();
        ModuleList.addModule(MODULE_CODE);
        ModuleList.setSelectedModule(MODULE_CODE);

        UI ui = new UI();
        OutputStream os = getOutputStream();

        Command command = new DeleteLessonCommand();

        try {
            command.execute(ui);
        } catch (CommandException e) {
            printFailedToExecuteCommand();
        }

        String entireInput = "1 2";
        initialiseUserInput(entireInput);
        boolean isEqual = false;
        if (os.toString().equals("Your list of lessons is empty.\n")
                || os.toString().equals("Your list of lessons is empty.\r\n")) {
            isEqual = true;
        }
        removeOutputStream();
        assertTrue(isEqual);
    }

    @Test
    void execute_ui_expectPrintsCorrectOutput() {
        TestUtilAndConstants.removeFiles();
        ModuleList.loadModuleCodes();
        ModuleList.addModule(MODULE_CODE);
        ModuleList.setSelectedModule(MODULE_CODE);

        UI ui = new UI();
        addLessonsToList(ui);
        Command command = new DeleteLessonCommand();
        try {
            command.execute(ui);
        } catch (CommandException e) {
            printFailedToExecuteCommand();
        }
        String entireInput = "1 2";
        initialiseUserInput(entireInput);
        assertEquals(ModuleList.getSelectedModule().getLessonList().size(), 0);
    }
}