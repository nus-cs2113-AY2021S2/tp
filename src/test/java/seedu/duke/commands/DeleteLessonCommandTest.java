package seedu.duke.commands;

import org.junit.jupiter.api.Test;
import seedu.duke.module.Module;
import seedu.duke.module.ModuleList;
import seedu.duke.ui.UI;

import java.io.OutputStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DeleteLessonCommandTest extends LessonCommandTest {

    public static final String EXPECTED_OUTPUT = "Removed tutorial." + System.lineSeparator() + "Removed lab."
            + System.lineSeparator();

    @Test
    void deleteLessonsFromList() {

        ModuleList moduleList = new ModuleList();
        UI ui = new UI();

        Module module = new Module(MODULE_CODE);
        String moduleCode = module.getModuleCode();
        moduleList.selectedModule= module;

        OutputStream os = getOutputStream();
        addLessonsToList(moduleList, ui);
        ArrayList<Integer> indexes = new ArrayList<>();
        initialisedIndexes(indexes);
        removeOutputStream();

        OutputStream newOs = getOutputStream();
        DeleteLessonCommand.deleteLessonsFromList(module, module.getLessonList(), indexes);
        assertEquals(EXPECTED_OUTPUT, newOs.toString());
        removeOutputStream();
    }
}