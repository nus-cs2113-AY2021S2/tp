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
    String doctorID ;
    String appointmentID ;
    String gender ;
    String date ;

    public DoctorAppointmentAdd(String[] parsedInput) {
        doctorID = parsedInput[1];
        appointmentID = parsedInput[2];
        gender = parsedInput[4];
        date = parsedInput[5];
        input = parsedInput;
    }

    @Override
    public void execute(AppointmentActions appointment, DoctorAppointmentUI ui) throws IOException, InvalidDocIDException, InvalidAppIDException, InvalidGenderException, InvalidDateException, AppointmentIDTakenException {

        if (!DoctorAppointmentParser.isValidDocID(doctorID)) {
            throw new InvalidDocIDException();
        }
        if (!DoctorAppointmentParser.isValidAppointmentID(appointmentID)){
            throw new InvalidAppIDException();
        }if (!DoctorAppointmentParser.isValidGender(gender)){
            throw new InvalidGenderException();
        }
//        if (!NurseSchedulesParser.isValidDate(date)){
//            throw new InvalidDateException();
//        }
        AppointmentActions.addAppointment(input);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
