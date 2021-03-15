package seedu.duke;

import org.junit.jupiter.api.Test;
import seedu.duke.task.TaskList;

import java.time.format.DateTimeParseException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TaskListTest {

    @Test
    void isValidTaskType_invalidTasktype_printErrorMessage() {
        String invalidTaskType = "5";

        assertFalse(TaskList.isValidTaskType(invalidTaskType));
    }

    @Test
    void validTime_invalidTimeFormat_DateTimeParseException() {
        String inputTime = "2.00 pm";
        assertThrows(DateTimeParseException.class, () -> {
            TaskList.validTime(inputTime);
        });
    }

    @Test
    void validDate_invalidDateFormat_DateTimeParseException() {
        String inputDate = "23 march 2021";
        assertThrows(DateTimeParseException.class, () -> {
            TaskList.validTime(inputDate);
        });
    }
}