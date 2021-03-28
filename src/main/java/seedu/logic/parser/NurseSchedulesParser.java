package seedu.logic.parser;

import seedu.exceptions.nurseschedules.EmptyListException;
import seedu.exceptions.nurseschedules.NurseIdNotFound;
import seedu.exceptions.nurseschedules.WrongInputsException;
import seedu.exceptions.staffexceptions.AbortException;
import seedu.logic.command.NurseScheduleActions;
import seedu.model.object.NurseSchedule;
import seedu.storage.NurseScheduleStorage;
import seedu.ui.NurseScheduleUI;
import seedu.ui.UI;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class NurseSchedulesParser {

    /**
     * Gets user input.
     *
     * @return User input
     */
    public String getUserInput() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

    /**
     * Returns the command of user.
     *
     * @param text User input
     * @return First word of user input
     */
    public String getFirstWord(String text) {
        int index = text.indexOf(' ');

        if (index > -1) {

            return text.substring(0, index).trim();

        } else {

            return text;
        }
    }

    public String[] getDetails(String text) throws WrongInputsException {
        String[] details = new String[3];

        String[] parts = text.split(" ", 0);

        assert parts.length > 0;

        if (parts.length == 1) {
            throw new WrongInputsException();
        } else if (getFirstWord(text).equals("add")) {
            details[0] = parts[1];
            details[1] = parts[2];
            details[2] = parts[3];
        } else if (getFirstWord(text).equals("delete")) {
            details[0] = parts[1];
            details[1] = parts[2];
        } else if (getFirstWord(text).equals("list")) {
            details[0] = parts[1];
        }
        return details;
    }

    public static String formatDate(String datetime) throws ParseException {
        SimpleDateFormat parser = new SimpleDateFormat("ddMMyyyy");
        Date date = parser.parse(datetime);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        return formatter.format(date);
    }

    public boolean commandHandler(List<NurseSchedule> nurseSchedules, String command, String line) {
        NurseScheduleActions actions = new NurseScheduleActions();
        NurseScheduleStorage storage = new NurseScheduleStorage();
        NurseSchedulesParser parser = new NurseSchedulesParser();

        switch (command) {
        case "add":
            try {
                actions.addSchedule(nurseSchedules, parser.getDetails(line));
                storage.writeToFile(nurseSchedules);
            } catch (WrongInputsException e) {
                System.out.println(e.getMessage());
                NurseScheduleUI.addHelpMessage();
            }
            break;
        case "list":
            try {
                actions.listSchedules(nurseSchedules, parser.getDetails(line));
            } catch (WrongInputsException e) {
                NurseScheduleUI.invalidInputsMessage();
                NurseScheduleUI.listHelpMessage();
            } catch (EmptyListException e) {
                System.out.println(e.getMessage());
            } catch (NurseIdNotFound e) {
                System.out.println(e.getMessage());
            }
            break;
        case "delete":
            try {
                actions.deleteSchedule(nurseSchedules, parser.getDetails(line));
                storage.writeToFile(nurseSchedules);
            } catch (WrongInputsException e) {
                System.out.println(e.getMessage());
                NurseScheduleUI.deleteHelpMessage();
            }
            break;
        case "help":
            NurseScheduleUI.printNurseScheduleHelpList();
            break;
        case "return":
            storage.writeToFile(nurseSchedules);
            NurseScheduleUI.returningToStartMenuMessage();
            return false;
        default:
            NurseScheduleUI.invalidCommandMessage();
            break;
        }
        return true;
    }
}
