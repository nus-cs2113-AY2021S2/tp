package seedu.duke.commands;

import org.junit.jupiter.api.Test;
import seedu.duke.ui.UI;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.duke.TestUtilAndConstants.initialiseModuleList;
import static seedu.duke.TestUtilAndConstants.initialiseTaskList;
import static seedu.duke.common.Messages.MESSAGE_EDITED_FIELD;
import static seedu.duke.common.Messages.MESSAGE_TASK_BEING_EDITED;
import static seedu.duke.common.Messages.MESSAGE_TASK_DEADLINE_TO_EDIT;
import static seedu.duke.common.Messages.MESSAGE_TASK_FIELDS_SELECT_INFO;
import static seedu.duke.common.Messages.MESSAGE_TASK_FIELDS_TO_EDIT;
import static seedu.duke.common.Messages.MESSAGE_TASK_REMARKS_TO_EDIT;
import static seedu.duke.common.Messages.MESSAGE_TASK_TO_EDIT;
import static seedu.duke.common.Messages.NEWLINE;

class EditTaskCommandTest {
    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    
    @Test
    void execute_validIndicesAndInput_expectSuccess() {
        String input = "3" + NEWLINE
                + "2 3" + NEWLINE
                + "2-3-2021" + NEWLINE
                + "Both quizzes 1 and 2." + NEWLINE;
        ByteArrayInputStream bis = new ByteArrayInputStream(input.getBytes());
        System.setIn(bis);
        System.setOut(new PrintStream(bos));

        initialiseModuleList();

        initialiseTaskList();
        
        EditTaskCommand editTaskCommand = new EditTaskCommand();
        editTaskCommand.execute(new UI());
        
        String before = "lecture quiz" + NEWLINE;
        String fields = "1. Description" + NEWLINE
                + "2. Deadline" + NEWLINE
                + "3. Remarks" + NEWLINE
                + "4. Graded/not graded";
        String output = MESSAGE_TASK_TO_EDIT + NEWLINE
                + "1. weekly exercise - 23 Feb 2021" + NEWLINE
                + "\t\tDo before 2359." + NEWLINE
                + "\t\tGraded" + NEWLINE
                + "2. watch video snippets - 25 Feb 2021" + NEWLINE
                + "\t\tNot graded" + NEWLINE
                + "3. lecture quiz - 26 Feb 2021" + NEWLINE
                + "\t\tComplete before next lecture." + NEWLINE
                + "\t\tNot graded" + NEWLINE
                + "4. read up notes - 26 Feb 2021" + NEWLINE
                + "\t\tNot graded" + NEWLINE
                + "5. iP submission - 3 Mar 2021" + NEWLINE
                + "\t\tRemember to attach the jar file." + NEWLINE
                + "\t\tGraded" + NEWLINE
                + String.format(MESSAGE_TASK_BEING_EDITED, before)
                + MESSAGE_TASK_FIELDS_TO_EDIT + NEWLINE
                + fields + NEWLINE
                + MESSAGE_TASK_FIELDS_SELECT_INFO + NEWLINE
                + MESSAGE_TASK_DEADLINE_TO_EDIT + NEWLINE
                + String.format(MESSAGE_EDITED_FIELD, "deadline") + NEWLINE
                + MESSAGE_TASK_REMARKS_TO_EDIT + NEWLINE
                + String.format(MESSAGE_EDITED_FIELD, "remarks") + NEWLINE;

        // checks displayed output to user
        assertEquals(output, bos.toString());

        System.setIn(originalIn);
        System.setOut(originalOut);
    }
}