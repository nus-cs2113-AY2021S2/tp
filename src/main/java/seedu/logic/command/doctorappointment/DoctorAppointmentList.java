package seedu.logic.command.doctorappointment;

import seedu.exceptions.HealthVaultException;
import seedu.logic.command.AppointmentActions;
import seedu.logic.command.Command;
import seedu.ui.DoctorAppointmentUI;

public class DoctorAppointmentList extends Command {

    private String[] input;
    private String ID;

    public DoctorAppointmentList(String[] parsedInput) {
        ID = parsedInput[1];
        input = parsedInput;
    }

    @Override
    public void execute(AppointmentActions appointment, DoctorAppointmentUI ui) throws Exception {
        AppointmentActions.listAppointment(ID);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
