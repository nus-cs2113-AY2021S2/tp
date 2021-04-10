package seedu.logic.command.doctorappointment;


import seedu.model.doctorappointment.AppointmentList;
import seedu.logic.command.Command;
import seedu.ui.DoctorAppointmentUI;

import java.io.IOException;

/**
 * DoctorAppointmentDeleteCommand executes the necessary action for deleting a DoctorAppointment object.
 */
public class DoctorAppointmentDeleteCommand extends Command {

    private String[] input;
    private String iD;
    /**
     * Constructor for DoctorAppointmentDeleteCommand.
     *
     * @param parsedInput Array of inputs for DoctorAppointment object.
     */

    public DoctorAppointmentDeleteCommand(String[] parsedInput) {
        iD = parsedInput[1];
        input = parsedInput;
    }

    /**
     * Deletes a DoctorAppointment object to the appointmentList and write the DoctorAppointment object data to a text file.
     *
     * @param appointment  Instance of AppointmentList used by the AppointmentDeleteCommand.
     * @param ui Not utilised here.
     *
     */

    @Override
    public void execute(AppointmentList appointment, DoctorAppointmentUI ui) throws IOException {
        AppointmentList.deleteAppointment(iD);
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
