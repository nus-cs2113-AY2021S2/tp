package seedu.logic.parser;

import seedu.exceptions.HealthVaultException;
import seedu.logger.HealthVaultLogger;
import seedu.logic.command.Command;
import seedu.logic.command.staff.*;
import seedu.logic.errorchecker.MainChecker;
import seedu.logic.errorchecker.StaffChecker;
import seedu.model.staff.StaffList;
import seedu.ui.StaffUI;
import seedu.ui.UI;

import java.util.logging.Level;
import java.util.logging.Logger;

import static seedu.ui.UI.smartCommandRecognition;

public class StaffParser {
    static final String[] COMMANDS = {"add", "delete", "list", "find", "return", "help"};
    private StaffChecker staffChecker = new StaffChecker();
    public Logger logger = HealthVaultLogger.getLogger();

    /**
     * Returns a Command Object which dictates the actions to be carried out on the Staff objects.
     *
     * @param line  Entire input command.
     * @param staffList StaffList object that contains all Staff objects.
     * @return Command object.
     * @throws HealthVaultException  If any invalid input given.
     * @throws NumberFormatException  If any invalid input given to a field expecting numeral input.
     */
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
            logger.log(Level.INFO, "Add Command recognised");
            array = staffChecker.checkValidDataForAdd(line, staffList);
            StaffUI.staffHiredOutput(array[0], array[1]);
            c = new StaffAdd(array);
            logger.log(Level.INFO, "Staff Add Command executed");
            break;

        case ("list"):
            logger.log(Level.INFO, "List Command recognised");
            array = staffChecker.checkListCommand(line);
            c = new seedu.logic.command.staff.StaffList(array);
            logger.log(Level.INFO, "Staff List Command executed");
            break;

        case ("delete"):
            logger.log(Level.INFO, "Delete Command recognised");
            String input = staffChecker.checkDeleteCommand(line);
            c = new StaffDelete(input);
            logger.log(Level.INFO, "Staff Delete Command executed");
            break;

        case ("help"):
            logger.log(Level.INFO, "Help Command recognised");
            c = new StaffHelp();
            logger.log(Level.INFO, "Staff Help Command executed");
            break;

        case ("find"):
            logger.log(Level.INFO, "Find Command recognised");
            MainChecker.checkNumInput(line,2,2);
            c = new StaffFind(line);
            logger.log(Level.INFO, "Staff Find Command executed");
            break;

        case ("return"):
            logger.log(Level.INFO, "Return Command recognised");
            logger.log(Level.INFO, "Staff Return Command executed");
            return new StaffReturn();

        default:
            UI.invalidCommandErrorMessage();
        }
        return c;
    }

}
