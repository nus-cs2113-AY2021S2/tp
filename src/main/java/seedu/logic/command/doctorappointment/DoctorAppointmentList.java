package seedu.logic.command.doctorappointment;

import seedu.exceptions.EmptyListException;
import seedu.exceptions.HealthVaultException;
import seedu.model.doctorappointment.AppointmentList;
import seedu.logic.command.Command;
import seedu.ui.DoctorAppointmentUI;

import java.text.ParseException;

public class DoctorAppointmentList extends Command {

    private String[] input;
    private String ID;

    public DoctorAppointmentList(String[] parsedInput) {
        ID = parsedInput[1];
        input = parsedInput;
    }

    @Override
    public void execute(AppointmentList appointment, DoctorAppointmentUI ui) throws ParseException, EmptyListException, HealthVaultException {
        AppointmentList.listAppointment(ID);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
