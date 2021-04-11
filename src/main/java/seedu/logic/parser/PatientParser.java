package seedu.logic.parser;

import seedu.exceptions.HealthVaultException;
import seedu.exceptions.UnrecognizedCommandException;
import seedu.logger.HealthVaultLogger;
import seedu.logic.command.Command;
import seedu.logic.command.patient.PatientAddCommand;
import seedu.logic.command.patient.PatientDeleteCommand;
import seedu.logic.command.patient.PatientFindCommand;
import seedu.logic.command.patient.PatientHelpCommand;
import seedu.logic.command.patient.PatientListCommand;
import seedu.logic.command.patient.PatientReturnCommand;
import seedu.model.patient.PatientList;
import seedu.logic.errorchecker.MainChecker;
import seedu.logic.errorchecker.patientchecker.PatientChecker;

import java.util.logging.Level;
import java.util.logging.Logger;

import static seedu.ui.UI.smartCommandRecognition;

/**
 * Parses the user inputs for patient related features into a format usable by the program.
 */
public class PatientParser {

    protected static final String[] COMMANDS = {"add", "delete", "list", "find", "return", "help"};
    private PatientChecker checker;
    public Logger logger = HealthVaultLogger.getLogger();

    /**
     * Converts the user input into usable and non-volatile data.
     *
     * @param fullCommand the string inputted by the user.
     * @param patients the current list of patients in the database.
     * @return the command that the user is trying to utilize.
     * @throws ArrayIndexOutOfBoundsException when there is more or less than the required number of tokens.
     * @throws HealthVaultException collection of exceptions from previous checks.
     * @throws NumberFormatException when the value inputted by the user is not an integer.
     */
    public Command patientParse(String fullCommand, PatientList patients) throws ArrayIndexOutOfBoundsException,
            HealthVaultException, NumberFormatException {
        String[] stringTokens = fullCommand.trim().split("/");
        int numberOfTokens = stringTokens.length;
        //check for number of inputs.
        MainChecker.checkNumInput(fullCommand,7,1);
        //trim the inputs and alters greedy white spaces.
        for (int i = 0; i < numberOfTokens; i++) {
            stringTokens[i] = stringTokens[i].trim().replaceAll("\\s{2,}", " ");
        }
        String command = smartCommandRecognition(COMMANDS, stringTokens[0]);
        Command c = null;
        //checker class will sanitize the user's input.
        checker = new PatientChecker(patients, stringTokens, command, numberOfTokens);
        switch (command) {
        case "list":
            logger.log(Level.INFO, "Patient list command accessed");
            checker.checkLength();
            c = new PatientListCommand();
            break;
        case "add":
            logger.log(Level.INFO, "Patient add command accessed");
            checker.checkAdd();
            String[] addFormat = parseToAddFormat(stringTokens);
            c = new PatientAddCommand(addFormat);
            break;
        case "delete":
            logger.log(Level.INFO, "Patient delete command accessed");
            checker.checkLength();
            checker.checkId();
            c = new PatientDeleteCommand(stringTokens[1]);
            break;
        case "find":
            logger.log(Level.INFO, "Patient find command accessed");
            checker.checkFind();
            c = new PatientFindCommand(stringTokens[1]);
            break;
        case "help":
            logger.log(Level.INFO, "Patient help command accessed");
            checker.checkLength();
            c = new PatientHelpCommand();
            break;
        case "return":
            logger.log(Level.INFO, "Patient return command accessed");
            checker.checkLength();
            c = new PatientReturnCommand();
            break;
        default:
            logger.log(Level.WARNING, "Patient command Unrecognized!");
            throw new UnrecognizedCommandException();
        }
        return c;
    }

    private String[] parseToAddFormat(String[] input) {
        String[] addFormat;
        addFormat = new String[] {input[1], input[2], input[3],
                input[4], input[5], input[6]};
        return addFormat;
    }

}
