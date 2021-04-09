package seedu.logic.command.doctorappointment;

import seedu.model.doctorappointment.AppointmentList;
import seedu.logic.command.Command;
import seedu.ui.DoctorAppointmentUI;

public class DoctorAppointmentHelpCommand extends Command {

    @Override
    public void execute(AppointmentList appointment, DoctorAppointmentUI ui) {
        AppointmentList.helpAppointment();
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
