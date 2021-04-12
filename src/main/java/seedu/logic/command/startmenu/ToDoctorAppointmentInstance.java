package seedu.logic.command.startmenu;

import seedu.logic.command.Command;
import seedu.logic.instance.DoctorAppointmentInstance;

import static seedu.duke.Constants.APPOINTMENT_FILE_PATH;

public class ToDoctorAppointmentInstance extends Command {

    public void execute() {
        DoctorAppointmentInstance appointmentInstance = new DoctorAppointmentInstance(APPOINTMENT_FILE_PATH);
        appointmentInstance.run();
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
