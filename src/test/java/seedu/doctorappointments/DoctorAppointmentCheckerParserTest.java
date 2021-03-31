package seedu.doctorappointments;

import org.junit.jupiter.api.Test;
import seedu.logic.command.AppointmentActions;
import seedu.logic.command.Command;
import seedu.logic.errorchecker.DoctorAppointmentChecker;
import seedu.logic.parser.DoctorAppointmentParser;
import seedu.ui.DoctorAppointmentUI;

import static org.junit.jupiter.api.Assertions.*;

public class DoctorAppointmentCheckerParserTest {
    private DoctorAppointmentParser parser;
    private AppointmentActions actions;

    @Test
    public void ValidGender(){
        boolean output = DoctorAppointmentChecker.isValidGender("M");
        assertTrue(output);
    }

    @Test
    public void ValidDate() {
        boolean output = DoctorAppointmentChecker.isValidDate("21012021");
        assertTrue(output);
    }

}