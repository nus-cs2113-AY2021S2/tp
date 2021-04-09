package seedu.logic.parser;

import seedu.duke.Constants;
import seedu.exceptions.UnrecognizedCommandException;
import seedu.logic.command.Command;
import seedu.logic.command.startmenu.ToDoctorAppointmentInstance;
import seedu.logic.command.startmenu.ToNurseScheduleInstance;
import seedu.logic.command.startmenu.ToPatientInstance;
import seedu.logic.command.startmenu.ToStaffInstance;
import seedu.logic.command.startmenu.ToInventoryInstance;
import seedu.logic.command.startmenu.MainExit;
import seedu.logic.command.startmenu.MainHelp;

import java.util.Locale;

import static seedu.ui.UI.cleanseInput;
import static seedu.ui.UI.smartCommandRecognition;

public class StartMenuParser {
    static final String[] COMMANDS = {"staff", "patient", "appointments", "schedules", "inventory", "help", "exit"};

    public Command startMenuParse(String userInput) {
        assert userInput != null : "user input should not be null";
        assert !(userInput.isEmpty()) : "user input should not be empty";

        Command c = null;
        try {
            String formattedMessage = userInput.toLowerCase(Locale.ROOT).trim();
            switch (smartCommandRecognition(COMMANDS, cleanseInput(formattedMessage))) {
            case Constants.TO_STAFF_INSTANCE:
                c = new ToStaffInstance();
                break;
            case Constants.TO_PATIENT_INSTANCE:
                c = new ToPatientInstance();
                break;
            case Constants.TO_SCHEDULES_INSTANCE:
                c = new ToNurseScheduleInstance();
                break;
            case Constants.TO_APPOINTMENTS_INSTANCE:
                c = new ToDoctorAppointmentInstance();
                break;
            case Constants.TO_INVENTORY_INSTANCE:
                c = new ToInventoryInstance();
                break;
            case Constants.HELP_COMMAND:
                c = new MainHelp();
                break;
            case Constants.EXIT_COMMAND:
                c = new MainExit();
                break;
            default:
                throw new UnrecognizedCommandException();
            }
        } catch (UnrecognizedCommandException e) {
            System.out.println(e.getMessage());
        }
        return c;
    }
}
