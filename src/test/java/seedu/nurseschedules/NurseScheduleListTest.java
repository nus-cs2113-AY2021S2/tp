package seedu.nurseschedules;

import org.junit.jupiter.api.Test;
import seedu.exceptions.nurseschedules.InvalidIDTypeException;
import seedu.model.nurseschedule.NurseScheduleList;

import static org.junit.jupiter.api.Assertions.*;

class NurseScheduleListTest {

    NurseScheduleList actions = new NurseScheduleList();
    //ArrayList<NurseSchedule> nurseSchedules = new ArrayList<>();

    @Test
    void testAddInvalidInput() {
        String[] details = {"N123456", "P12345", "30012020"};
        assertThrows(InvalidIDTypeException.class,
                () -> actions.addSchedule(details));
    }
}
