package seedu.logic.parser;


import seedu.exceptions.HealthVaultException;
import seedu.exceptions.UnrecognizedCommandException;
import seedu.logic.command.AppointmentActions;
import seedu.logic.command.Command;
import seedu.logic.command.doctorappointment.*;
import seedu.logic.errorchecker.DoctorAppointmentChecker;
import seedu.logic.errorchecker.MainChecker;
import seedu.ui.DoctorAppointmentUI;

import static seedu.ui.UI.smartCommandRecognition;

public class DoctorAppointmentParser {

    public static Command parse(String input, AppointmentActions details) throws HealthVaultException {
        final String[] COMMANDS = {"add", "delete", "list", "return", "help"};

        String[] inputArray = input.split("/");
        assert inputArray.length > 0;
        assert inputArray.length < 7;
        Command c = null;
        MainChecker.checkBlankInput(input);

        switch (smartCommandRecognition(COMMANDS, input.split("/")[0])) {
        case "add": {
            MainChecker.checkNumInput(input, 6, 6);
            DoctorAppointmentChecker.checkValidDataForAdd(inputArray);
            c = new DoctorAppointmentAdd(inputArray);
            break;
        }
        case "list": {
            MainChecker.checkNumInput(input, 2, 2);
            DoctorAppointmentChecker.checkValidDataForList(inputArray);
            c = new DoctorAppointmentList(inputArray);
            break;
        }
        case "delete": {
            MainChecker.checkNumInput(input, 2, 2);
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
            throw new UnrecognizedCommandException();
        }
        return c;
    }


}
