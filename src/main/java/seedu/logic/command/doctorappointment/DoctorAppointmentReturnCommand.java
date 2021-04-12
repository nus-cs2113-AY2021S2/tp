package seedu.logic.command.doctorappointment;

import seedu.logic.command.Command;

/**
 *  DoctorAppointmentReturnCommand executes exits the Doctor Appointment Menu.
 */
public class DoctorAppointmentReturnCommand extends Command {

    /**
     * Returns true if return command is given to exit the menu.
     *
     * @return true.
     */
    @Override
    public boolean isExit() {
        return true;
    }
}
