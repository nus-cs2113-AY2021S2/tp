package seedu.logic.parser;

import seedu.exceptions.nurseschedules.WrongInputsException;
import seedu.logic.command.Command;
import seedu.logic.command.nurseschedule.*;
import seedu.logic.errorchecker.NurseScheduleChecker;
import seedu.ui.NurseScheduleUI;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

import static seedu.ui.UI.smartCommandRecognition;

public class NurseSchedulesParser {

    static final String[] COMMANDS = {"add", "delete", "list", "return", "help"};

    NurseScheduleChecker checker = new NurseScheduleChecker();

    public static boolean isValidDate(String date) {
        return true;
    }

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
        int index = text.indexOf('/');

        if (index > -1) {

            return text.substring(0, index).trim();

        } else {

            return text;
        }
    }

    public String removeDuplicate(char[] str, int n)
    {
        // Used as index in the modified string
        int index = 0;

        // Traverse through all characters
        for (int i = 0; i < n; i++)
        {
            // Check if str[i] is present before it
            int j;
            for (j = 0; j < i; j++)
            {
                if (str[i] == '/')
                {
                    if (str[j] == '/') {
                        break;
                    }
                }
            }

            // If not present, then add it to
            // result.
            if (j == i)
            {
                str[index++] = str[i];
            }
        }
        return String.valueOf(Arrays.copyOf(str, index));
    }

    public String[] getDetails(String text) throws WrongInputsException {
        //String text = removeDuplicate(input.toCharArray(), input.length());
        String[] details = new String[3];

        String[] parts = text.toUpperCase().split("/", 0);
        String command = smartCommandRecognition(COMMANDS, getFirstWord(text));

        assert parts.length > 0;

        if (parts.length <= 1) {
            throw new WrongInputsException();
        } else if (command.equals("add")) {
            if (checker.isValidDate(parts[3])) {
                details[0] = parts[1].replaceAll("[^A-Za-z0-9]","");;
                details[1] = parts[2].replaceAll("[^A-Za-z0-9]","");;
                details[2] = parts[3].replaceAll("[^A-Za-z0-9]","");;
            }
        } else if (command.equals("delete")) {
            if (checker.isValidDate(parts[2])) {
                details[0] = parts[1].replaceAll("[^A-Za-z0-9]","");;
                details[1] = parts[2].replaceAll("[^A-Za-z0-9]","");;
            }
        } else if (command.equals("list")) {
            details[0] = parts[1].replaceAll("[^A-Za-z0-9]","");;
        }
        return details;
    }

    public static String formatDate(String datetime) throws ParseException {
        SimpleDateFormat parser = new SimpleDateFormat("ddMMyyyy");
        Date date = parser.parse(datetime);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        return formatter.format(date);
    }

    public Command nurseParse(String line, NurseScheduleUI ui) {
        assert line != null : "user input should not be null";
        assert !(line.isEmpty()) : "user input should not be empty";

        NurseSchedulesParser parser = new NurseSchedulesParser();
        String command = parser.getFirstWord(line);
        Command c = null;

        switch (smartCommandRecognition(COMMANDS, command)) {
        case "add":
            try {
                String[] details = parser.getDetails(line);
                c = new NurseScheduleAdd(details);
            } catch (ArrayIndexOutOfBoundsException | WrongInputsException e) {
                ui.formatHelpMessage();
                ui.addHelpMessage();
            }
            break;
        case "list":
            try {
                String[] details = parser.getDetails(line);
                c = new NurseScheduleList(details);
            } catch (ArrayIndexOutOfBoundsException | WrongInputsException e) {
                ui.formatHelpMessage();
                ui.listHelpMessage();
            }
            break;
        case "delete":
            try {
                String[] details = parser.getDetails(line);
                c = new NurseScheduleDelete(details);
            } catch(ArrayIndexOutOfBoundsException | WrongInputsException e) {
                ui.formatHelpMessage();
                ui.deleteHelpMessage();
            }
            break;
        case "help":
            c = new NurseScheduleHelp();
            break;
        case "return":
            c = new NurseScheduleReturn();
            break;
        default:
            ui.invalidInputsMessage();
            break;
        }
        return c;
    }
}
