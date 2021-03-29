package seedu.logic.parser;


import seedu.logic.command.AppointmentActions;
import seedu.logic.command.Command;
import seedu.logic.command.doctorappointment.*;
import seedu.ui.DoctorAppointmentUI;
import seedu.ui.UI;

public class DoctorAppointmentParser {

    public static Command parse(String input, AppointmentActions details) throws Exception {
        String[] inputArray = input.split("/");
        Command c = null;

        switch (inputArray[0]) {
        case "add":
            c = new DoctorAppointmentAdd(inputArray);
            break;
        case "list":
            c = new DoctorAppointmentList(inputArray);
            break;
        case "delete":
            c = new DoctorAppointmentDelete(inputArray);
            break;
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
