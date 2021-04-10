package seedu.doctorappointments;

import org.junit.jupiter.api.Test;
import seedu.model.doctorappointment.AppointmentList;
import seedu.logic.errorchecker.DoctorAppointmentChecker;

import static org.junit.jupiter.api.Assertions.*;

public class DoctorAppointmentCheckerTest {

    @Test
    public void testValidAppointmentId() {
        String Id = "A12345";
        assertDoesNotThrow(() -> DoctorAppointmentChecker.checkAptID(Id));
    }

    @Test
    public void testInvalidName() {
        String name = "App.le";
        String path = "name";
        String message = "You have an illegal character in your: name";
        try {
            DoctorAppointmentChecker.illegalCharacterChecker(name, path);
            fail();
        } catch (Exception e) {
            assertEquals(message, e.getMessage());
        }
    }

    @Test
    public void testValidId() {
        String doctorId = "D12345";
        String appointmentId = "A12345";
        assertDoesNotThrow(() -> DoctorAppointmentChecker.checkID(doctorId, appointmentId));

    }

    @Test
    public void ValidGender() {
        boolean output = DoctorAppointmentChecker.isValidGender("M");
        assertTrue(output);
    }

    @Test
    void testValidDate() {
        String datetime = "30012020";
        assertDoesNotThrow(() -> DoctorAppointmentChecker.checkValidDate(datetime));
    }

    @Test
    void testInvalidDate() {
        String datetime = "091283109823092830";
        String message = "The date format is invalid!";
        try {
            DoctorAppointmentChecker.checkValidDate(datetime);
            fail();
        } catch (Exception e) {
            assertEquals(message, e.getMessage());
        }
    }

}