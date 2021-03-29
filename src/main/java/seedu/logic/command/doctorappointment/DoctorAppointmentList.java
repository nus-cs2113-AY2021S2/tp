package seedu.logic.command.doctorappointment;

import seedu.logic.command.AppointmentActions;
import seedu.logic.command.Command;
import seedu.storage.DoctorAppointmentStorage;
import seedu.ui.DoctorAppointmentUI;

public class DoctorAppointmentList extends Command {

    private String[] input;

    public DoctorAppointmentList(String[] parsedInput) {
        input = parsedInput;
    }

    @Override
    public void execute(AppointmentActions appointment, DoctorAppointmentUI ui) throws Exception {
        AppointmentActions.listAppointment(input);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
