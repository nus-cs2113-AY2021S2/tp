package seedu.logic.command.doctorappointment;

import seedu.exceptions.doctorappointment.AppointmentIDTakenException;
import seedu.exceptions.doctorappointment.InvalidDocIDException;
import seedu.exceptions.doctorappointment.InvalidIDException;
import seedu.logic.command.AppointmentActions;
import seedu.logic.command.Command;
import seedu.logic.parser.DoctorAppointmentParser;
import seedu.storage.DoctorAppointmentStorage;
import seedu.ui.DoctorAppointmentUI;

import java.io.IOException;

public class DoctorAppointmentDelete extends Command {

    private String[] input;
    private String ID;


    public DoctorAppointmentDelete(String[] parsedInput) {
        ID = parsedInput[0];
        input = parsedInput;
    }

    @Override
    public void execute(AppointmentActions appointment, DoctorAppointmentUI ui) throws IOException, InvalidIDException, AppointmentIDTakenException {
        if (!DoctorAppointmentParser.isValidDocID(ID) && !DoctorAppointmentParser.isValidAppointmentID(ID)) {
            throw new InvalidIDException();
        }
        AppointmentActions.deleteAppointment(input);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
