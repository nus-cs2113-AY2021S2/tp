package seedu.logic.parser;

import seedu.exceptions.*;
import seedu.exceptions.staff.WrongListInputException;
import seedu.exceptions.staff.WrongStaffIdException;
import seedu.logic.command.Command;
import seedu.logic.command.StaffAggregation;
import seedu.logic.command.staff.*;
import seedu.logic.errorchecker.MainChecker;
import seedu.logic.errorchecker.StaffChecker;
import seedu.ui.StaffUI;
import seedu.ui.UI;

import java.util.Arrays;

import static seedu.ui.UI.smartCommandRecognition;

public class StaffParser {
    static final String[] COMMANDS = {"add", "delete", "list", "find", "return", "help"};


    public Command commandHandler(String line, StaffAggregation staffAggregation) throws WrongStaffIdException,
            WrongListInputException, ExcessInputException,
            InsufficientInputException, NoInputException, NumberFormatException, InvalidIntegerException, DuplicateIDException {
        Command c = null;
        if (line.equals(" ")) {
            UI.noCommandErrorMessage();
            return new StaffReturn();
        }
        switch (smartCommandRecognition(COMMANDS, line.split("/")[0])) {

        case ("add"):
            StaffChecker.checkValidDataForAdd(line, staffAggregation);
            String [] cleanArray = Arrays.copyOfRange(line.split("/"), 1, 5);
            for (int i=0; i< cleanArray.length; i++) {
                cleanArray[i] = UI.cleanseInput(cleanArray[i]);
            }
            StaffUI.staffHiredOutput(cleanArray[0], cleanArray[1]);
            c = new StaffAdd(cleanArray);
            break;

        case ("list"):
            StaffChecker.checkListCommand(line);
            MainChecker.checkNumInput(line,2,1);
            c = new StaffList(line);
            break;

        case ("delete"):
            MainChecker.checkNumInput(line,2,2);
            StaffChecker.checkStaffID(line.split("/")[1]);

            c = new StaffDelete(line);
            break;

        case ("help"):
            c = new StaffHelp();
            break;

        case ("find"):
            MainChecker.checkNumInput(line,2,2);
            c = new StaffFind(line);
            break;

        case ("return"):
            return new StaffReturn();

        default:
            UI.invalidCommandErrorMessage();
        }
        return c;
    }

}
