package seedu.logic.parser;


import seedu.exceptions.HealthVaultException;
import seedu.exceptions.UnrecognizedCommandException;
import seedu.logger.HealthVaultLogger;
import seedu.logic.command.doctorappointment.DoctorAppointmentAddCommand;
import seedu.logic.command.doctorappointment.DoctorAppointmentDeleteCommand;
import seedu.logic.command.doctorappointment.DoctorAppointmentListCommand;
import seedu.logic.command.doctorappointment.DoctorAppointmentReturnCommand;
import seedu.logic.command.doctorappointment.DoctorAppointmentHelpCommand;
import seedu.model.doctorappointment.AppointmentList;
import seedu.logic.command.Command;

import seedu.logic.errorchecker.DoctorAppointmentChecker;
import seedu.logic.errorchecker.MainChecker;

import java.util.logging.Level;
import java.util.logging.Logger;

import static seedu.ui.UI.smartCommandRecognition;

public class DoctorAppointmentParser {

    public static Logger logger = HealthVaultLogger.getLogger();
    static final String[] COMMANDS = {"add", "delete", "list", "return", "help"};

    /**
     * Returns a Command Object which dictates the actions to be carried out on the DoctorAppointment objects.
     *
     * @param input   Entire input command.
     * @param details AppointmentList object that contains all AppointmentList.
     * @return Command object.
     * @throws HealthVaultException         If any invalid input given.
     * @throws UnrecognizedCommandException If the input is not recognized by the system.
     */

    public static Command parse(String input, AppointmentList details) throws HealthVaultException {

        String[] inputArray = input.split("/");
        assert inputArray.length > 0;
        assert inputArray.length < 7;
        Command c = null;
        MainChecker.checkBlankInput(input);
        MainChecker.checkNumInput(input, 6, 1);
        switch (smartCommandRecognition(COMMANDS, input.split("/")[0])) {
        case "add": {
            logger.log(Level.INFO, "Parsing Add command");
            MainChecker.checkNumInput(input, 6, 6);
            DoctorAppointmentChecker.checkValidDataForAdd(inputArray);
            c = new DoctorAppointmentAddCommand(inputArray);
            break;
        }
        case "list": {
            logger.log(Level.INFO, "Parsing List command");
            MainChecker.checkNumInput(input, 2, 2);
            DoctorAppointmentChecker.checkValidDataForList(inputArray);
            c = new DoctorAppointmentListCommand(inputArray);
            break;
        }
        case "delete": {
            logger.log(Level.INFO, "Parsing Delete command");
            MainChecker.checkNumInput(input, 2, 2);
            DoctorAppointmentChecker.checkValidDataForDelete(inputArray);
            c = new DoctorAppointmentDeleteCommand(inputArray);
            break;
        }
        case "return":
            logger.log(Level.INFO, "Parsing Return command");
            c = new DoctorAppointmentReturnCommand();
            break;
        case "help":
            logger.log(Level.INFO, "Parsing Help command");
            c = new DoctorAppointmentHelpCommand();
            break;
        default:
            logger.log(Level.WARNING, "Unrecognized Command Exception being handled");
            throw new UnrecognizedCommandException();
        }
        return c;
    }


}
