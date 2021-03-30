package seedu.logic.parser;

import seedu.exceptions.ExcessInputException;
import seedu.exceptions.InsufficientInputException;
import seedu.exceptions.NoInputException;
import seedu.exceptions.staff.*;
import seedu.logic.command.Command;
import seedu.logic.command.staff.*;
import seedu.logic.errorchecker.MainChecker;
import seedu.logic.errorchecker.StaffChecker;
import seedu.ui.UI;

import java.util.Arrays;

import static seedu.ui.UI.smartCommandRecognition;

public class StaffParser {
    static final String[] COMMANDS = {"add", "delete", "list", "addline", "find", "return", "help"};


    public Command  commandHandler(String line) throws WrongStaffIdException,
            WrongListInputException, NoInputException, AbortException, ExcessInputException,
            InsufficientInputException, BlankInputException, NumberFormatException, PositiveNumberOnlyException {
        Command c = null;
        if (line.equals(" ")) {
            UI.noCommandErrorMessage();
            return new StaffReturn();
        }
        switch (smartCommandRecognition(COMMANDS, line.split("/")[0])) {

        case ("add"):
            StaffChecker.checkValidDataForAdd(line);
            String [] cleanArray = Arrays.copyOfRange(line.split("/"), 1, 5);
            for (int i=0; i< cleanArray.length; i++) {
                cleanArray[i] = UI.cleanseInput(cleanArray[i]);
            }
            c = new StaffAdd(cleanArray);
            break;

        case ("list"):
            StaffChecker.checkListCommand(line);
            MainChecker.checkNumInput(line,2,1);
            c = new StaffList(line);
            break;

        case ("delete"):
            MainChecker.checkNumInput(line,2,1);
            StaffChecker.checkStaffID(line.split("/")[1]);

            c = new StaffDelete(line);
            break;

        case ("help"):
            c = new StaffHelp();
            break;

        case ("find"):
            MainChecker.checkNumInput(line,2,1);
            c = new StaffFind(line);
            break;

        case ("return"):
            return new StaffReturn();

        default:
            UI.invalidCommandErrorMessage();
        }
        return c;
    }


/* to be deleted
    public static String[] addFunctionParser(String line) {
        int length = line.split(" ").length;
        String[] input = new String[4];
        String[] array = line.split(" ");

        for (int i = 1; i < length; i++) {
            try {
                if (i <= 4) {
                    input[i - 1] = array[i];
                } else {
                    input[3] = input[3] + " " + array[i];
                }
            } catch (IndexOutOfBoundsException e) {
                input[i - 1] = " ";
            }
        }
        return input;add/D55555/pop/12/asd
    }
    */

}
