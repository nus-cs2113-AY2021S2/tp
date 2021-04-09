package seedu.logic.command.doctorappointment;


import seedu.model.doctorappointment.AppointmentList;
import seedu.logic.command.Command;
import seedu.ui.DoctorAppointmentUI;

import java.io.IOException;

public class DoctorAppointmentDeleteCommand extends Command {

    private String[] input;
    private String Id;


    public DoctorAppointmentDeleteCommand(String[] parsedInput) {
        Id = parsedInput[1];
        input = parsedInput;
    }

    @Override
    public void execute(AppointmentList appointment, DoctorAppointmentUI ui) throws IOException {
        AppointmentList.deleteAppointment(Id);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
