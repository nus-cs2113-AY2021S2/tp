package seedu.duke.commands;

import org.junit.jupiter.api.Test;
import seedu.duke.TestUtil;
import seedu.duke.exceptions.CommandException;
import seedu.duke.module.ModuleList;
import seedu.duke.task.Task;
import seedu.duke.ui.UI;

import java.io.OutputStream;
import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.duke.commands.CommandTestUtil.formatter;
import static seedu.duke.common.Constants.NEWLINE;

class ModuleInfoCommandTest extends LessonCommandTest {

    private static final String EXPECTED_OUTPUT = "<CS3235>" + NEWLINE + "tutorial - Wednesday 9 am - 10am" + NEWLINE
            + "lab - Wednesday 9 pm - 10 pm" + NEWLINE + NEWLINE + "Undone tasks:" + NEWLINE + "1. iP submission"
            + NEWLINE;

    @Test
    void execute_ui_expectPrintsCorrectOutput() {
        TestUtil.removeFiles();
        ModuleList.loadModuleNames();
        UI ui = new UI();

        OutputStream os = getOutputStream();
        ModuleList.addModule(MODULE_CODE);
        ModuleList.setSelectedModule(MODULE_CODE);
        addLessonsToList(ui);
        LocalDate deadline = LocalDate.parse("3-3-2021", formatter);
        Task task = new Task("iP submission", deadline, "remember to attach JAR file");
        task.setGraded(true);
        ArrayList<Task> tasksList = ModuleList.getSelectedModule().getTaskList();
        tasksList.add(task);
        removeOutputStream();

        OutputStream newOs = getOutputStream();
        Command command = new ModuleInfoCommand();
        try {
            command.execute(ui);
        } catch (CommandException e) {
            printFailedToExecuteCommand();
        }
        assertEquals(EXPECTED_OUTPUT, newOs.toString());
        removeOutputStream();
    }
}