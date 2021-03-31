package seedu.logic.parser;

import seedu.exceptions.HealthVaultException;
import seedu.exceptions.UnrecognizedCommandException;
import seedu.logic.command.Command;
import seedu.logic.command.patient.*;
import seedu.logic.errorchecker.PatientChecker;
import seedu.logic.command.PatientActions;

import static seedu.ui.UI.smartCommandRecognition;

public class PatientParser {

    protected static final String[] COMMANDS = {"add", "delete", "list", "find", "return", "help"};
    private PatientChecker checker;

    public Command patientParse(String fullCommand, PatientActions patients) throws ArrayIndexOutOfBoundsException,
            HealthVaultException, NumberFormatException {
        String[] stringTokens = fullCommand.trim().split("/");
        int numberOfTokens = stringTokens.length;
        /*ArrayList<String> cleanString = new ArrayList<>();
        for (int i = 0; i < numberOfTokens; i++) {
            cleanString.add(UI.cleanseInput(stringTokens[i]));
        }*/
        String command = smartCommandRecognition(COMMANDS, stringTokens[0]);
        Command c = null;
        checker = new PatientChecker(patients, stringTokens, command, numberOfTokens);
        switch (command) {
        case "list":
            checker.checkLength();
            c = new PatientList();
            break;
        case "add":
            checker.checkAdd();
            String[] addFormat = parseToAddFormat(stringTokens);
            c = new PatientAdd(addFormat);
            break;
        case "delete":
            checker.checkLength();
            checker.checkID();
            c = new PatientDelete(stringTokens[1]);
            break;
        case "find":
            checker.checkFind();
            c = new PatientFind(stringTokens[1]);
            break;
        case "help":
            checker.checkLength();
            c = new PatientHelp();
            break;
        case "return":
            checker.checkLength();
            c = new PatientReturn();
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
