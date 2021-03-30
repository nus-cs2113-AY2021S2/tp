package seedu.logic.parser;


import seedu.logic.command.AppointmentActions;
import seedu.logic.command.Command;
import seedu.logic.command.doctorappointment.*;
import seedu.logic.errorchecker.DoctorAppointmentChecker;
import seedu.ui.DoctorAppointmentUI;

public class DoctorAppointmentParser {

    public static Command parse(String input, AppointmentActions details) throws Exception {
        String[] inputArray = input.split("/");
        assert inputArray.length > 0;
        assert inputArray.length < 7;
        Command c = null;

        switch (inputArray[0]) {
        case "add": {
            DoctorAppointmentChecker.checkValidDataForAdd(inputArray);
            c = new DoctorAppointmentAdd(inputArray);
            break;
        }
        case "list": {
            DoctorAppointmentChecker.checkValidDataForList(inputArray);
            c = new DoctorAppointmentList(inputArray);
            break;
        }
        case "delete": {
            DoctorAppointmentChecker.checkValidDataForDelete(inputArray);
            c = new DoctorAppointmentDelete(inputArray);
            break;
        }
        case "return":
            c = new DoctorAppointmentReturn();
            break;
        case "help":
            c = new DoctorAppointmentHelp();
            break;
        default:
            DoctorAppointmentUI.invalidCommandPrompt();
        }
        return c;
    }


}
