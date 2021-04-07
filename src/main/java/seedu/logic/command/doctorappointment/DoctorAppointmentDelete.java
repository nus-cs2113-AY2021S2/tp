package seedu.logic.command.doctorappointment;


import seedu.model.doctorappointment.AppointmentList;
import seedu.logic.command.Command;
import seedu.ui.DoctorAppointmentUI;

import java.io.IOException;

public class DoctorAppointmentDelete extends Command {

    private String[] input;
    private String ID;


    public DoctorAppointmentDelete(String[] parsedInput) {
        ID = parsedInput[1];
        input = parsedInput;
    }

    @Override
    public void execute(AppointmentList appointment, DoctorAppointmentUI ui) throws IOException {
        AppointmentList.deleteAppointment(ID);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
