package seedu.duke.commands;

import org.junit.jupiter.api.Test;
import seedu.duke.ui.UI;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.duke.TestUtilAndConstants.FORMATTER;
import static seedu.duke.TestUtilAndConstants.MODULE_CODE_1;
import static seedu.duke.TestUtilAndConstants.initialiseModuleList;
import static seedu.duke.TestUtilAndConstants.initialiseTaskList;
import static seedu.duke.common.Messages.HEADER_DONE;
import static seedu.duke.common.Messages.HEADER_UNDONE;
import static seedu.duke.common.Messages.MESSAGE_TASKS_TO_LIST;
import static seedu.duke.common.Messages.NEWLINE;


class ListTasksCommandTest {
    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream bos = new ByteArrayOutputStream();

    //@@author aliciatay-zls
    @Test
    void execute_void_expectSuccess() {
        System.setOut(new PrintStream(bos));
        
        initialiseModuleList();

        initialiseTaskList();

        UI ui = new UI();
        LocalDate dueDate1 = LocalDate.parse("23-02-2021", FORMATTER);
        LocalDate dueDate2 = LocalDate.parse("26-02-2021", FORMATTER);
        
        ListTasksCommand listTasksCommand = new ListTasksCommand();
        listTasksCommand.execute(ui);

        String output = String.format(MESSAGE_TASKS_TO_LIST, MODULE_CODE_1) + NEWLINE + NEWLINE
                + HEADER_UNDONE + NEWLINE
                + "1. weekly exercise (graded) - 23 Feb 2021" + ui.getDaysRemainingMessage(dueDate1) + NEWLINE
                + "\t\tDo before 2359." + NEWLINE
                + "2. lecture quiz - 26 Feb 2021" + ui.getDaysRemainingMessage(dueDate2) + NEWLINE
                + "\t\tComplete before next lecture." + NEWLINE
                + "3. read up notes - 26 Feb 2021" + ui.getDaysRemainingMessage(dueDate2) + NEWLINE + NEWLINE
                + HEADER_DONE + NEWLINE
                + "1. watch video snippets - 25 Feb 2021" + NEWLINE
                + "2. iP submission (graded) - 3 Mar 2021" + NEWLINE
                + "\t\tRemember to attach the jar file." + NEWLINE;

        // checks displayed output to user
        assertEquals(output, bos.toString());

        System.setOut(originalOut);
    }
}
