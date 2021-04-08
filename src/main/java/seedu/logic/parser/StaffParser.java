package seedu.logic.parser;

import seedu.exceptions.HealthVaultException;
import seedu.logic.command.Command;
import seedu.logic.command.staff.*;
import seedu.logic.errorchecker.MainChecker;
import seedu.logic.errorchecker.StaffChecker;
import seedu.model.staff.StaffList;
import seedu.ui.StaffUI;
import seedu.ui.UI;

import static seedu.ui.UI.smartCommandRecognition;

public class StaffParser {
    static final String[] COMMANDS = {"add", "delete", "list", "find", "return", "help"};
    private StaffChecker staffChecker = new StaffChecker();


    public Command commandHandler(String line, StaffList staffList) throws HealthVaultException, NumberFormatException {
        Command c = null;
        if (line.equals(" ")) {
            UI.noCommandErrorMessage();
            return new StaffReturn();
        }
        String[] array;
        staffChecker.checkNumInput(line, 5,1);
        switch (smartCommandRecognition(COMMANDS, line.split("/")[0])) {

        case ("add"):
            array = staffChecker.checkValidDataForAdd(line, staffList);
            StaffUI.staffHiredOutput(array[0], array[1]);
            c = new StaffAdd(array);
            break;

        case ("list"):
            array = staffChecker.checkListCommand(line);
            c = new seedu.logic.command.staff.StaffList(array);
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
