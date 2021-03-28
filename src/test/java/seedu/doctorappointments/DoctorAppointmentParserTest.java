package seedu.doctorappointments;

import org.junit.jupiter.api.Test;
import seedu.logic.command.AppointmentActions;
import seedu.logic.parser.DoctorAppointmentParser;

import static org.junit.jupiter.api.Assertions.*;

public class DoctorAppointmentParserTest {
    private DoctorAppointmentParser parser;
    private AppointmentActions actions;

    @Test
    public void returnCommand() throws Exception {
        boolean output = DoctorAppointmentParser.parse("return");
        assertTrue(output);
    }

    @Test
    public void unknownCommand() throws Exception {
        boolean output = DoctorAppointmentParser.parse("unknown");
        assertFalse(output);
    }

}