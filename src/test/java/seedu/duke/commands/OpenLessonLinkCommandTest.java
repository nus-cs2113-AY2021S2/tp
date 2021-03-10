package seedu.duke.commands;

import org.junit.jupiter.api.Test;
import seedu.duke.module.Module;
import seedu.duke.module.ModuleList;
import seedu.duke.ui.UI;

import java.io.OutputStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OpenLessonLinkCommandTest extends LessonCommandTest {

    public static final String EXPECTED_OUTPUT = "Opening tutorial link in browser." + System.lineSeparator()
            + "Opening lab link in browser." + System.lineSeparator();

    @Test
    void printLessonsLink() {
        ModuleList moduleList = new ModuleList();
        UI ui = new UI();

        OutputStream os = getOutputStream();

        Module module = new Module(MODULE_CODE);
        String moduleCode = module.getModuleCode();
        moduleList.selectedModule= module;
        addLessonsToList(moduleList, ui);
        ArrayList<Integer> indexes = new ArrayList<>();
        initialisedIndexes(indexes);
        removeOutputStream();

        OutputStream newOs = getOutputStream();
        OpenLessonLinkCommand.printLessonsLink(module.getLessonList(), indexes);
        assertEquals(EXPECTED_OUTPUT, newOs.toString());
        removeOutputStream();
    }
}