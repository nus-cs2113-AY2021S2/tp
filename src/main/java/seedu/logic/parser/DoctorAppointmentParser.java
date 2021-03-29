package seedu.logic.parser;


import seedu.logic.command.AppointmentActions;
import seedu.ui.DoctorAppointmentUI;
import seedu.ui.UI;

public class DoctorAppointmentParser {

    public static boolean parse(String input) throws Exception {
        String[] inputArray = input.split(" ");

        switch (inputArray[0]) {
        case "add":
            AppointmentActions.addAppointment(input);
            break;
        case "list":
            AppointmentActions.listAppointment(input);
            break;
        case "delete":
            AppointmentActions.deleteAppointment(input);
            break;
        case "return":
            return true;
        case "help":
            AppointmentActions.helpAppointment();
            break;
        default:
            DoctorAppointmentUI.invalidCommandPrompt();
        }
        return false;
    }
}
