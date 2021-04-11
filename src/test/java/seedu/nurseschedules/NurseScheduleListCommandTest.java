package seedu.nurseschedules;

import org.junit.jupiter.api.Test;
import seedu.exceptions.nurseschedules.InvalidiDTypeException;
import seedu.model.nurseschedule.NurseScheduleList;

import static org.junit.jupiter.api.Assertions.assertThrows;

class NurseScheduleListCommandTest {

    NurseScheduleList actions = new NurseScheduleList();

    @Test
    void testAddInvalidInput() {
        String[] details = {"N123456", "P12345", "30012020"};
        assertThrows(InvalidiDTypeException.class, () -> actions.addSchedule(details));
    }
}
