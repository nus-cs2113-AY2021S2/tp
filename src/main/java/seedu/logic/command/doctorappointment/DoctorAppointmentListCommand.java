package seedu.logic.command.doctorappointment;

import seedu.exceptions.EmptyListException;
import seedu.exceptions.HealthVaultException;
import seedu.model.doctorappointment.AppointmentList;
import seedu.logic.command.Command;
import seedu.ui.DoctorAppointmentUI;

import java.text.ParseException;

public class DoctorAppointmentListCommand extends Command {

    private String[] input;
    private String Id;

    public DoctorAppointmentListCommand(String[] parsedInput) {
        Id = parsedInput[1];
        input = parsedInput;
    }

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
