package seedu.logic.command.doctorappointment;

import seedu.logic.command.AppointmentActions;
import seedu.logic.command.Command;
import seedu.storage.DoctorAppointmentStorage;
import seedu.ui.DoctorAppointmentUI;

import java.io.IOException;

public class DoctorAppointmentDelete extends Command {

    private String[] input;

    public DoctorAppointmentDelete(String[] parsedInput) {
        input = parsedInput;
    }

    @Override
    public void execute(AppointmentActions appointment, DoctorAppointmentUI ui) throws IOException {
        AppointmentActions.deleteAppointment(input);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
