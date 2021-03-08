package seedu.duke.commands;

import org.junit.jupiter.api.Test;
import seedu.duke.module.Module;
import seedu.duke.module.ModuleList;
import seedu.duke.ui.UI;

import java.io.OutputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ViewTeachingStaffCommandTest extends LessonCommandTest {

    public static final String EXPECTED_OUTPUT = "1. " + TEACHER_NAME + " - " + TEACHER_EMAIL + System.lineSeparator()
            + "2. " + TEACHER_NAME1 + " - " + TEACHER_EMAIL1 + System.lineSeparator();

    @Test
    void execute() {
        ModuleList moduleList = new ModuleList();
        UI ui = new UI();

        OutputStream os = getOutputStream();
        Module module = new Module(MODULE_CODE);
        String moduleCode = module.getModuleCode();
        boolean isModuleSelected = ModuleList.setSelectedModule(module);
        addLessonsToList(moduleList, ui);
        Command command = new ViewTeachingStaffCommand();
        removeOutputStream();

        OutputStream newOs = getOutputStream();
        command.execute(moduleList, ui);
        assertEquals(EXPECTED_OUTPUT, newOs.toString());
        removeOutputStream();
    }
}