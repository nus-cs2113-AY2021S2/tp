package seedu.logic.parser;

import seedu.exceptions.ExcessInputException;
import seedu.exceptions.InsufficientInputException;
import seedu.exceptions.InvalidDateException;
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
import java.util.logging.Level;

import static seedu.logic.instance.NurseScheduleInstance.logger;
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

    private String[] trimInputs(String[] parts) {
        String[] trimmedArray = new String[parts.length];
        for (int i = 0; i< parts.length; i++) {
            trimmedArray[i] = parts[i].trim();
        }
        return trimmedArray;
    }

    public String[] getDetails(String input, String command) throws WrongInputsException, NoInputException, ExcessInputException, InsufficientInputException, IllegalCharacterException, InvalidDateException {
        NurseScheduleChecker.checkEmptyInput(input);
        String[] details = new String[3];

        String[] parts = input.split("/");
        parts = trimInputs(parts);

        assert parts.length > 0;

        if (parts.length <= 1) {
            throw new WrongInputsException();
        }
        switch (command) {
        case "ADD":
            checker.isValidDate(parts[3]);
            MainChecker.checkNumInput(input, 4, 4);
            details[0] = parts[1];
            details[1] = parts[2];
            details[2] = parts[3];
            MainChecker.illegalCharacterChecker(details[0], "Nurse ID");
            MainChecker.illegalCharacterChecker(details[1], "Patient ID");
            break;
        case "DELETE":
            checker.isValidDate(parts[2]);
            MainChecker.checkNumInput(input, 3, 3);
            details[0] = parts[1];
            details[1] = parts[2];
            MainChecker.illegalCharacterChecker(details[0], "Nurse ID");
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

    public Command nurseParse(String input, NurseScheduleUI ui) throws NoInputException, InsufficientInputException, ExcessInputException, IllegalCharacterException, InvalidDateException {
        assert input != null : "user input should not be null";
        assert !(input.isEmpty()) : "user input should not be empty";

        NurseSchedulesParser parser = new NurseSchedulesParser();
        String line = input.toUpperCase();
        String command = smartCommandRecognition(COMMANDS, parser.getFirstWord(line));
        Command c = null;

        logger.info("Parsing command...");

        switch (command) {
        case "ADD":
            try {
                String[] details = parser.getDetails(line, command);
                c = new NurseScheduleAdd(details);
            } catch (ArrayIndexOutOfBoundsException | WrongInputsException e) {
                ui.formatHelpMessage();
                ui.addHelpMessage();
                logger.log(Level.WARNING, "Parameter error in add command!");
            }
            break;
        case "LIST":
            try {
                String[] details = parser.getDetails(line, command);
                c = new NurseScheduleList(details);
            } catch (ArrayIndexOutOfBoundsException | WrongInputsException e) {
                ui.formatHelpMessage();
                ui.listHelpMessage();
                logger.log(Level.WARNING, "Parameter error in list command!");
            }
            break;
        case "DELETE":
            try {
                String[] details = parser.getDetails(line, command);
                c = new NurseScheduleDelete(details);
            } catch(ArrayIndexOutOfBoundsException | WrongInputsException e) {
                ui.formatHelpMessage();
                ui.deleteHelpMessage();
                logger.log(Level.WARNING, "Parameter error in delete command!");
            }
            break;
        case "HELP":
            c = new NurseScheduleHelp();
            break;
        case "RETURN":
            c = new NurseScheduleReturn();
            break;
        default:
            logger.log(Level.WARNING, "Command not successfully parsed!");
            ui.invalidInputsMessage();
            break;
        }
        return c;
    }
}
