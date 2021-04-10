package seedu.logic.command.doctorappointment;

import seedu.exceptions.EmptyListException;
import seedu.exceptions.HealthVaultException;
import seedu.model.doctorappointment.AppointmentList;
import seedu.logic.command.Command;
import seedu.ui.DoctorAppointmentUI;

import java.text.ParseException;

/**
 * DoctorAppointmentListCommand executes the necessary action for listing DoctorAppointment Objects.
 */
public class DoctorAppointmentListCommand extends Command {

    private String[] input;
    private String Id;

    /**
     * Constructor for DoctorAppointmentListCommand.
     *
     * @param parsedInput Array of inputs for DoctorAppointment object.
     */
    public DoctorAppointmentListCommand(String[] parsedInput) {
        Id = parsedInput[1];
        input = parsedInput;
    }

    /**
     * Lists the DoctorAppointment objects in the appointmentList.
     *
     * @param appointment  Instance of AppointmentList used by the DoctorAppointmentListCommand to list objects.
     * @param ui Not utilised here.
     *
     */
    @Override
    public void execute(AppointmentList appointment, DoctorAppointmentUI ui) throws ParseException,
            HealthVaultException {
        AppointmentList.listAppointment(Id);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
