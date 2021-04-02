package seedu.logic.parser;

import seedu.exceptions.HealthVaultException;
import seedu.logic.command.Command;
import seedu.logic.command.InventoryActions;
import seedu.logic.command.inventory.InventoryAdd;
import seedu.logic.command.inventory.InventoryDelete;
import seedu.logic.command.inventory.InventoryHelp;
import seedu.logic.command.inventory.InventoryList;
import seedu.logic.command.inventory.InventoryReturn;
import seedu.logic.errorchecker.InventoryChecker;
import seedu.logic.errorchecker.MainChecker;
import seedu.ui.UI;

import static seedu.ui.UI.smartCommandRecognition;

public class InventoryParser {
    static final String[] COMMANDS = {"add", "delete", "list", "return", "help"};
    private InventoryChecker checker;

    public Command inventoryParse(String fullCommand, InventoryActions inventories)
            throws ArrayIndexOutOfBoundsException,
            HealthVaultException {
        String[] stringTokens = fullCommand.trim().split("/");
        int numberOfTokens = stringTokens.length;

        String command = smartCommandRecognition(COMMANDS, stringTokens[0]);
        Command c = null;
        checker = new InventoryChecker(inventories, stringTokens, numberOfTokens);
        switch (command) {
        case "list":
            int numberOfInputs = 1;
            MainChecker.checkNumInput(fullCommand, numberOfInputs, numberOfInputs);
            c = new InventoryList();
            break;
        case "add":
            numberOfInputs = 4;
            MainChecker.checkNumInput(fullCommand, numberOfInputs, numberOfInputs);
            MainChecker.checkBlankInput(fullCommand);
            checker.checkAdd();
            String[] addFormat = parseToAddFormat(stringTokens);
            c = new InventoryAdd(addFormat);
            break;
        case "delete":
            numberOfInputs = 2;
            MainChecker.checkNumInput(fullCommand, numberOfInputs, numberOfInputs);
            MainChecker.checkBlankInput(fullCommand);
            checker.checkDelete();
            c = new InventoryDelete(stringTokens[1]);
            break;
        case "help":
            numberOfInputs = 1;
            MainChecker.checkNumInput(fullCommand, numberOfInputs, numberOfInputs);
            c = new InventoryHelp();
            break;
        case "return":
            numberOfInputs = 1;
            MainChecker.checkNumInput(fullCommand, numberOfInputs, numberOfInputs);
            c = new InventoryReturn();
            break;
        default:
            UI.invalidCommandErrorMessage();
            break;
        }
        return c;
    }
    private String[] parseToAddFormat(String[] stringTokens) {
       String[] addFormat;
       addFormat = new String[] {stringTokens[1], stringTokens[2], stringTokens[3]};
       return addFormat;
    }
}
