package seedu.logic.parser;

import seedu.exceptions.HealthVaultException;
import seedu.exceptions.UnrecognizedCommandException;
import seedu.logic.command.Command;
import seedu.logic.command.patient.*;
import seedu.logic.errorchecker.PatientChecker;
import seedu.ui.UI;
import seedu.logic.command.PatientActions;

import java.util.ArrayList;

public class PatientParser {

    private PatientChecker checker;

    public Command patientParse(String fullCommand, PatientActions patients) throws ArrayIndexOutOfBoundsException,
            HealthVaultException, NumberFormatException {
        String[] stringTokens = fullCommand.trim().split("/");
        int numberOfTokens = stringTokens.length;
        ArrayList<String> cleanString = new ArrayList<>();
        for (int i = 0; i < numberOfTokens; i++) {
            cleanString.add(UI.cleanseInput(stringTokens[i]));
        }
        String command = stringTokens[0];
        Command c = null;
        checker = new PatientChecker(patients, cleanString, command, numberOfTokens);
        switch (command) {
        case "list":
            checker.checkLength();
            c = new PatientList();
            break;
        case "add":
            checker.checkAdd();
            String[] addFormat = parseToAddFormat(cleanString);
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

    private String[] parseToAddFormat(ArrayList<String> cleanString) {
        String[] addFormat;
        addFormat = new String[] {cleanString.get(1), cleanString.get(2), cleanString.get(3),
                cleanString.get(4), cleanString.get(5), cleanString.get(6)};
        return addFormat;
    }

}
