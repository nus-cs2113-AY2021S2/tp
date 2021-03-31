package seedu.logic.parser;

import seedu.exceptions.ExcessInputException;
import seedu.exceptions.InsufficientInputException;
import seedu.exceptions.NoInputException;
import seedu.exceptions.nurseschedules.WrongInputsException;
import seedu.exceptions.patient.IllegalCharacterException;
import seedu.logic.command.Command;
import seedu.logic.command.nurseschedule.*;
import seedu.logic.errorchecker.MainChecker;
import seedu.logic.errorchecker.NurseScheduleChecker;
import seedu.ui.NurseScheduleUI;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static seedu.ui.UI.smartCommandRecognition;

public class NurseSchedulesParser {

    static final String[] COMMANDS = {"ADD", "DELETE", "LIST", "RETURN", "HELP"};

    NurseScheduleChecker checker = new NurseScheduleChecker();

    /**
     * Returns the command of user.
     *
     * @param text User input
     * @return First word of user input
     */
    public String getFirstWord(String text) {
        int index = text.indexOf('/');

        if (index > -1) {

            return text.substring(0, index).trim();

        } else {

            return text;
        }
    }

    public String[] getDetails(String input, String command) throws WrongInputsException, NoInputException, ExcessInputException, InsufficientInputException, IllegalCharacterException {
        NurseScheduleChecker.checkEmptyInput(input);
        String[] details = new String[3];

        String[] parts = input.split("/");

        assert parts.length > 0;

        if (parts.length <= 1) {
            throw new WrongInputsException();
        }
        switch (command) {
        case "ADD":
            if (checker.isValidDate(parts[3])) {
                MainChecker.checkNumInput(input, 4, 4);
                details[0] = parts[1];
                details[1] = parts[2];
                details[2] = parts[3];
                checker.illegalCharacterChecker(details[0], "Nurse ID");
                checker.illegalCharacterChecker(details[1], "Patient ID");
            }
            break;
        case "DELETE":
            if (checker.isValidDate(parts[2])) {
                MainChecker.checkNumInput(input, 3, 3);
                details[0] = parts[1];
                details[1] = parts[2];
                checker.illegalCharacterChecker(details[0], "Nurse ID");
            }
            break;
        case "LIST":
            MainChecker.checkNumInput(input, 2, 2);
            details[0] = parts[1];
            break;
        }
        return details;
    }

    public static String formatDate(String datetime) throws ParseException {
        SimpleDateFormat parser = new SimpleDateFormat("ddMMyyyy");
        Date date = parser.parse(datetime);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        return formatter.format(date);
    }

    public Command nurseParse(String input, NurseScheduleUI ui) throws NoInputException, InsufficientInputException, ExcessInputException, IllegalCharacterException {
        assert input != null : "user input should not be null";
        assert !(input.isEmpty()) : "user input should not be empty";

        NurseSchedulesParser parser = new NurseSchedulesParser();
        String line = input.toUpperCase();
        String command = smartCommandRecognition(COMMANDS, parser.getFirstWord(line));
        Command c = null;

        switch (command) {
        case "ADD":
            try {
                String[] details = parser.getDetails(line, command);
                c = new NurseScheduleAdd(details);
            } catch (ArrayIndexOutOfBoundsException | WrongInputsException e) {
                ui.formatHelpMessage();
                ui.addHelpMessage();
            }
            break;
        case "LIST":
            try {
                String[] details = parser.getDetails(line, command);
                c = new NurseScheduleList(details);
            } catch (ArrayIndexOutOfBoundsException | WrongInputsException e) {
                ui.formatHelpMessage();
                ui.listHelpMessage();
            }
            break;
        case "DELETE":
            try {
                String[] details = parser.getDetails(line, command);
                c = new NurseScheduleDelete(details);
            } catch(ArrayIndexOutOfBoundsException | WrongInputsException e) {
                ui.formatHelpMessage();
                ui.deleteHelpMessage();
            }
            break;
        case "HELP":
            c = new NurseScheduleHelp();
            break;
        case "RETURN":
            c = new NurseScheduleReturn();
            break;
        default:
            ui.invalidInputsMessage();
            break;
        }
        return c;
    }
}
