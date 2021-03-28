package seedu.logic.parser;

import seedu.exceptions.DukeException;
import seedu.exceptions.UnrecognizedCommandException;
import seedu.logic.command.Command;
import seedu.logic.command.startmenu.*;

import java.util.Locale;

import static seedu.duke.Constants.*;

public class StartMenuParser {

    public Command startMenuParse(String userInput) {
        assert userInput != null : "user input should not be null";
        assert !(userInput.isEmpty()) : "user input should not be empty";

        Command c = null;
        try {
            String formattedMessage = userInput.toLowerCase(Locale.ROOT).trim();
            switch (formattedMessage) {
            case TO_STAFF_INSTANCE:
                c = new ToStaffInstance();
                break;
            case TO_PATIENT_INSTANCE:
                c = new ToPatientInstance();
                break;
            case TO_SCHEDULES_INSTANCE:
                c = new ToNurseScheduleInstance();
                break;
            case TO_APPOINTMENTS_INSTANCE:
                c = new ToDoctorAppointmentInstance();
                break;
            case TO_INVENTORY_INSTANCE:
                c = new ToInventoryInstance();
                break;
            case HELP_COMMAND:
                c = new MainHelp();
                break;
            case EXIT_COMMAND:
                c = new MainExit();
                break;
            default:
                throw new UnrecognizedCommandException();
            }
        } catch (UnrecognizedCommandException e) {
            e.getError();
        }
        return c;
    }
}
