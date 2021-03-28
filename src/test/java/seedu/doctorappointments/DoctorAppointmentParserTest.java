package seedu.doctorappointments;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class DoctorAppointmentParserTest {
    private Parser parser;
    private AppointmentActions actions;

    @Test
    public void returnCommand() throws Exception {
        boolean output = Parser.parse("return");
        assertTrue(output);
    }

    @Test
    public void unknownCommand() throws Exception {
        boolean output = Parser.parse("unknown");
        assertFalse(output);
    }

    @Test
    public void offCommand() throws Exception {
        boolean output = Parser.parse("off");
        assertFalse(output);
    }

}