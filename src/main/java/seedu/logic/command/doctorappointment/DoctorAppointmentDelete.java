package seedu.logic.command.doctorappointment;

import seedu.logic.command.AppointmentActions;
import seedu.logic.command.Command;
import seedu.storage.DoctorAppointmentStorage;

public class DoctorAppointmentDelete extends Command {

    private String arg;

    public DoctorAppointmentDelete(String arg) {
        this.arg = arg;
    }

    @Override
    public void execute(AppointmentActions appointment, DoctorAppointmentStorage storage) {
        //fill in the blanks
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
