package seedu.logic.parser;

import seedu.exceptions.*;
import seedu.exceptions.patient.IllegalCharacterException;
import seedu.exceptions.staff.InvalidStaffAgeException;
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
            InvalidIntegerException, DuplicateIDException, IllegalCharacterException,
            InvalidStaffAgeException {
        Command c = null;
        if (line.equals(" ")) {
            UI.noCommandErrorMessage();
            return new StaffReturn();
        }
        String[] array;
        staffChecker.checkNumInput(line, 5,1);
        switch (smartCommandRecognition(COMMANDS, line.split("/")[0])) {

        case ("add"):
            array = staffChecker.checkValidDataForAdd(line, staffAggregation);
            StaffUI.staffHiredOutput(array[0], array[1]);
            c = new StaffAdd(array);
            break;

        case ("list"):
            array = staffChecker.checkListCommand(line);
            c = new StaffList(array);
            break;

        case ("delete"):
            String input = staffChecker.checkDeleteCommand(line);
            c = new StaffDelete(input);
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
