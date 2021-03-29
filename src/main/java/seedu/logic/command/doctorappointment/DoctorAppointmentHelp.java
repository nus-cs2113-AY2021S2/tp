package seedu.logic.command.doctorappointment;

import seedu.logic.command.AppointmentActions;
import seedu.logic.command.Command;
import seedu.ui.DoctorAppointmentUI;

public class DoctorAppointmentHelp extends Command {

    @Override
    public void execute(AppointmentActions appointment, DoctorAppointmentUI ui) {
        AppointmentActions.helpAppointment();
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
