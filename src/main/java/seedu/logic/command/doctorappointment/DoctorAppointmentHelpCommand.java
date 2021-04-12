package seedu.logic.command.doctorappointment;

import seedu.model.doctorappointment.AppointmentList;
import seedu.logic.command.Command;
import seedu.ui.DoctorAppointmentUI;

/**
 * DoctorAppointmentHelpCommand executes the necessary action for deleting a DoctorAppointment object.
 */

public class DoctorAppointmentHelpCommand extends Command {

    /**
     * Displays the help message for DoctorAppointment Menu.
     *
     * @param appointment  Not utilised here.
     * @param ui Instance of DoctorAppointmentUI used by the DoctorAppointmentHelpCommand for displaying help message.
     */

    @Override
    public void execute(AppointmentList appointment, DoctorAppointmentUI ui) {
        AppointmentList.helpAppointment();
    }

    /**
     * Returns true if return command is given to exit the menu.
     *
     * @return false.
     */
    @Override
    public boolean isExit() {
        return false;
    }
}
