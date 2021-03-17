package seedu.duke.commands;

import org.junit.jupiter.api.Test;
import seedu.duke.TestUtilAndConstants;
import seedu.duke.exception.CommandException;
import seedu.duke.module.ModuleList;
import seedu.duke.ui.UI;

import java.io.OutputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.duke.common.Messages.MESSAGE_TEACHING_STAFF_TO_LIST;
import static seedu.duke.common.Messages.NEWLINE;

class ViewTeachingStaffCommandTest extends LessonCommandTest {

    //@@author H-horizon
    @Test
    void execute_ui_expectPrintsCorrectOutput() {
        TestUtilAndConstants.removeFiles();
        ModuleList.loadModuleNames();
        UI ui = new UI();

        ModuleList.addModule(MODULE_CODE);
        ModuleList.setSelectedModule(MODULE_CODE);
        addLessonsToList(ui);
        Command command = new ViewTeachingStaffCommand();

        OutputStream newOs = getOutputStream();
        try {
            command.execute(ui);
        } catch (CommandException e) {
            printFailedToExecuteCommand();
        }
        String expectedOutput = String.format(MESSAGE_TEACHING_STAFF_TO_LIST, MODULE_CODE) + NEWLINE
                + "1. " + TEACHER_NAME + " - " + TEACHER_EMAIL + NEWLINE
                + "2. " + TEACHER_NAME1 + " - " + TEACHER_EMAIL1 + NEWLINE;
        assertEquals(expectedOutput, newOs.toString());
        removeOutputStream();
    }
}