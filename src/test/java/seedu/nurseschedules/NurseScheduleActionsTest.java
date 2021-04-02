package seedu.nurseschedules;

import org.junit.jupiter.api.Test;
import seedu.exceptions.nurseschedules.InvalidIDTypeException;
import seedu.logic.command.NurseScheduleActions;
import seedu.model.NurseSchedule;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class NurseScheduleActionsTest {

    NurseScheduleActions actions = new NurseScheduleActions();
    //ArrayList<NurseSchedule> nurseSchedules = new ArrayList<>();

    @Test
    void testAddInvalidInput() {
        String[] details = {"N123456", "P12345", "30012020"};
        assertThrows(InvalidIDTypeException.class,
                () -> actions.addSchedule(details));
    }
}
