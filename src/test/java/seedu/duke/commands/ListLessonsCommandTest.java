package seedu.duke.commands;

import org.junit.jupiter.api.Test;
import seedu.duke.TestUtilAndConstants;
import seedu.duke.exception.CommandException;
import seedu.duke.module.ModuleList;
import seedu.duke.ui.UI;

import java.io.OutputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.duke.common.Messages.INDENTATION;
import static seedu.duke.common.Messages.MESSAGE_LESSONS_LIST_EMPTY;
import static seedu.duke.common.Messages.MESSAGE_LESSONS_TO_LIST;
import static seedu.duke.common.Messages.NEWLINE;

class ListLessonsCommandTest extends LessonCommandTest {

    public static final String EXPECTED_OUTPUT = String.format(MESSAGE_LESSONS_TO_LIST, MODULE_CODE) + NEWLINE
            + "1. Lab - " + TIME1 + NEWLINE + INDENTATION + ONLINE_LINK1 + NEWLINE + INDENTATION
            + TEACHER_NAME1 + NEWLINE + INDENTATION + TEACHER_EMAIL1 + NEWLINE
            + "2. Tutorial - " + TIME + NEWLINE + INDENTATION + ONLINE_LINK + NEWLINE + INDENTATION
            + TEACHER_NAME + NEWLINE + INDENTATION + TEACHER_EMAIL + NEWLINE;

    //@@author H-horizon
    @Test
    void printLessonsFromList_lessonList_expectPrintsCorrectOutput() {
        TestUtilAndConstants.removeFiles();
        ModuleList.loadModuleCodes();
        UI ui = new UI();

        OutputStream os = getOutputStream();
        ModuleList.addModule(MODULE_CODE);
        ModuleList.setSelectedModule(MODULE_CODE);
        addLessonsToList(ui);
        removeOutputStream();

        OutputStream newOs = getOutputStream();
        ListLessonsCommand listLessonsCommand = new ListLessonsCommand();
        listLessonsCommand.execute(ui);
        assertEquals(EXPECTED_OUTPUT, newOs.toString());
        removeOutputStream();
    }

    @Test
    void execute_ui_expectsPrintEmpty() {
        TestUtilAndConstants.removeFiles();
        ModuleList.loadModuleCodes();
        ModuleList.addModule(MODULE_CODE);
        ModuleList.setSelectedModule(MODULE_CODE);

        UI ui = new UI();
        OutputStream os = getOutputStream();
        Command command = new ListLessonsCommand();
        try {
            command.execute(ui);
            boolean isEqual = false;
            if (os.toString().equals(MESSAGE_LESSONS_LIST_EMPTY + "\n")
                    || os.toString().equals(MESSAGE_LESSONS_LIST_EMPTY + "\r\n")) {
                isEqual = true;
            }
            assertTrue(isEqual);
        } catch (CommandException e) {
            printFailedToExecuteCommand();
        }
    }
}