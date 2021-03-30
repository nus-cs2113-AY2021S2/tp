package seedu.logic.command.doctorappointment;

import seedu.exceptions.doctorappointment.*;
import seedu.logic.command.AppointmentActions;
import seedu.logic.command.Command;
import seedu.logic.parser.DoctorAppointmentParser;
import seedu.logic.parser.NurseSchedulesParser;
import seedu.ui.DoctorAppointmentUI;

import javax.print.Doc;
import java.io.IOException;

public class DoctorAppointmentAdd extends Command {

    private String[] input;

    public DoctorAppointmentAdd(String[] parsedInput) {
        input = parsedInput;
    }

    @Override
    public void execute(AppointmentActions appointment, DoctorAppointmentUI ui) throws IOException {
        AppointmentActions.addAppointment(input);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
