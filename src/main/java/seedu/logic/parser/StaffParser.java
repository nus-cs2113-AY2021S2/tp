package seedu.logic.parser;

import seedu.exceptions.*;
import seedu.exceptions.patient.IllegalCharacterException;
import seedu.exceptions.staff.WrongListInputException;
import seedu.exceptions.staff.WrongStaffIdException;
import seedu.logic.command.Command;
import seedu.logic.command.StaffAggregation;
import seedu.logic.command.staff.*;
import seedu.logic.errorchecker.MainChecker;
import seedu.logic.errorchecker.StaffChecker;
import seedu.ui.StaffUI;
import seedu.ui.UI;

import static seedu.ui.UI.smartCommandRecognition;

public class StaffParser {
    static final String[] COMMANDS = {"add", "delete", "list", "find", "return", "help"};
    private StaffChecker staffChecker = new StaffChecker();


    public Command commandHandler(String line, StaffAggregation staffAggregation) throws
            WrongStaffIdException, WrongListInputException, ExcessInputException,
            InsufficientInputException, NoInputException, NumberFormatException,
            InvalidIntegerException, DuplicateIDException, IllegalCharacterException {
        Command c = null;
        if (line.equals(" ")) {
            UI.noCommandErrorMessage();
            return new StaffReturn();
        }
        switch (smartCommandRecognition(COMMANDS, line.split("/")[0])) {

        case ("add"):
            staffChecker.checkValidDataForAdd(line, staffAggregation);
            String[] arr = staffChecker.invalidCharactersStaffChecker(line);
            StaffUI.staffHiredOutput(arr[0], arr[1]);
            c = new StaffAdd(arr);
            break;

        case ("list"):
            staffChecker.checkListCommand(line);
            MainChecker.checkNumInput(line,2,1);
            c = new StaffList(line);
            break;

        case ("delete"):
            staffChecker.checkNumInput(line,2,2);
            staffChecker.checkStaffID(line.split("/")[1]);
            c = new StaffDelete(line);
            break;

        case ("help"):
            c = new StaffHelp();
            break;

        case ("find"):
            staffChecker.checkNumInput(line,2,2);
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
