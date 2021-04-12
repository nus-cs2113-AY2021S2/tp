package seedu.logic.command.doctorappointment;

import seedu.model.doctorappointment.AppointmentList;
import seedu.logic.command.Command;
import seedu.ui.DoctorAppointmentUI;

import java.io.IOException;

/**
 * DoctorAppointmentAddCommand executes the necessary action for adding a DoctorAppointment object.
 */
public class DoctorAppointmentAddCommand extends Command {

    private String[] input;

    /**
     * Constructor for DoctorAppointmentAddCommand.
     *
     * @param parsedInput Array of inputs for DoctorAppointment object.
     */

    public DoctorAppointmentAddCommand(String[] parsedInput) {
        input = parsedInput;
    }

    /**
     * Adds a DoctorAppointment object to the appointmentList and write the DoctorAppointment
     * object data to a text file.
     *
     * @param appointment Instance of AppointmentList used by the AppointmentAddCommand.
     * @param ui          Not utilised here.
     */
    @Override
    public void execute(AppointmentList appointment, DoctorAppointmentUI ui) throws IOException {
        AppointmentList.addAppointment(input);
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
