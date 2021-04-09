package seedu.logic.parser;

import seedu.exceptions.HealthVaultException;
import seedu.exceptions.UnrecognizedCommandException;
import seedu.logic.command.Command;
import seedu.model.patient.PatientList;
import seedu.logic.command.patient.*;
import seedu.logic.errorchecker.MainChecker;
import seedu.logic.errorchecker.PatientChecker;

import static seedu.ui.UI.smartCommandRecognition;

public class PatientParser {

    protected static final String[] COMMANDS = {"add", "delete", "list", "find", "return", "help"};
    private PatientChecker checker;

    public Command patientParse(String fullCommand, PatientList patients) throws ArrayIndexOutOfBoundsException,
            HealthVaultException, NumberFormatException {
        String[] stringTokens = fullCommand.trim().split("/");
        int numberOfTokens = stringTokens.length;
        //check for number of inputs
        MainChecker.checkNumInput(fullCommand,7,1);
        //trim the inputs and alters greedy white spaces
        for (int i = 0; i < numberOfTokens; i++) {
            stringTokens[i] = stringTokens[i].trim().replaceAll("\\s{2,}", " ");
        }
        String command = smartCommandRecognition(COMMANDS, stringTokens[0]);
        Command c = null;
        checker = new PatientChecker(patients, stringTokens, command, numberOfTokens);
        switch (command) {
        case "list":
            checker.checkLength();
            c = new PatientListCommand();
            break;
        case "add":
            checker.checkAdd();
            String[] addFormat = parseToAddFormat(stringTokens);
            c = new PatientAddCommand(addFormat);
            break;
        case "delete":
            checker.checkLength();
            checker.checkId();
            c = new PatientDeleteCommand(stringTokens[1]);
            break;
        case "find":
            checker.checkFind();
            c = new PatientFindCommand(stringTokens[1]);
            break;
        case "help":
            checker.checkLength();
            c = new PatientHelpCommand();
            break;
        case "return":
            checker.checkLength();
            c = new PatientReturnCommand();
            break;
        default:
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
