package seedu.logic.parser;

import seedu.exceptions.ExcessInputException;
import seedu.exceptions.InsufficientInputException;
import seedu.exceptions.NoInputException;
import seedu.exceptions.nurseschedules.WrongInputsException;
import seedu.exceptions.staff.BlankInputException;

import seedu.logic.command.Command;
import seedu.logic.command.nurseschedule.*;
import seedu.logic.errorchecker.MainChecker;
import seedu.logic.errorchecker.NurseScheduleChecker;
import seedu.ui.NurseScheduleUI;
import seedu.ui.UI;

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

    public String[] getDetails(String input, String command) throws WrongInputsException, NoInputException, ExcessInputException, InsufficientInputException {
        NurseScheduleChecker.checkEmptyInput(input);
        String text = input.toUpperCase();
        String[] details = new String[3];

        String[] parts = text.split("/", 0);

        assert parts.length > 0;

        if (parts.length <= 1) {
            throw new WrongInputsException();
        }
        if (command.equals("ADD")) {
            if (checker.isValidDate(parts[3])) {
                MainChecker.checkNumInput(text, 4, 4);
                details[0] = UI.cleanseInput(parts[1]);
                details[1] = UI.cleanseInput(parts[2]);
                details[2] = UI.cleanseInput(parts[3]);
            }
        } else if (command.equals("DELETE")) {
            if (checker.isValidDate(parts[2])) {
                MainChecker.checkNumInput(text, 3, 3);
                details[0] = UI.cleanseInput(parts[1]);
                details[1] = UI.cleanseInput(parts[2]);
            }
        } else if (command.equals("LIST")) {
            MainChecker.checkNumInput(text, 2, 2);
            details[0] = UI.cleanseInput(parts[1]);
        }
        return details;
    }

    public static String formatDate(String datetime) throws ParseException {
        SimpleDateFormat parser = new SimpleDateFormat("ddMMyyyy");
        Date date = parser.parse(datetime);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        return formatter.format(date);
    }

    public Command nurseParse(String line, NurseScheduleUI ui) throws NoInputException, InsufficientInputException, ExcessInputException {
        assert line != null : "user input should not be null";
        assert !(line.isEmpty()) : "user input should not be empty";

        NurseSchedulesParser parser = new NurseSchedulesParser();
        String command = smartCommandRecognition(COMMANDS, parser.getFirstWord(line).toUpperCase());
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
