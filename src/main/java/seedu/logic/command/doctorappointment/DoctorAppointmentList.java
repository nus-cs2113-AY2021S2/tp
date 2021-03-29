package seedu.logic.command.doctorappointment;

import seedu.exceptions.doctorappointment.InvalidIDException;
import seedu.logic.command.AppointmentActions;
import seedu.logic.command.Command;
import seedu.logic.parser.DoctorAppointmentParser;
import seedu.storage.DoctorAppointmentStorage;
import seedu.ui.DoctorAppointmentUI;

public class DoctorAppointmentList extends Command {

    private String[] input;
    private String ID;

    public DoctorAppointmentList(String[] parsedInput) {
        ID = parsedInput[0];
        input = parsedInput;
    }

    @Override
    public void execute(AppointmentActions appointment, DoctorAppointmentUI ui) throws Exception {
        if (!DoctorAppointmentParser.isValidDocID(ID) && !DoctorAppointmentParser.isValidAppointmentID(ID)) {
            throw new InvalidIDException();
        }
        AppointmentActions.listAppointment(input);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
