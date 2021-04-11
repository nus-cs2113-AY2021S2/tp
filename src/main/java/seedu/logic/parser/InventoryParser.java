package seedu.logic.parser;

import seedu.exceptions.HealthVaultException;
import seedu.logic.command.Command;
import seedu.model.inventory.InventoryList;
import seedu.logic.command.inventory.InventoryAdd;
import seedu.logic.command.inventory.InventoryDelete;
import seedu.logic.command.inventory.InventoryHelp;
import seedu.logic.command.inventory.InventoryReturn;
import seedu.logic.errorchecker.InventoryChecker;
import seedu.logic.errorchecker.MainChecker;
import seedu.ui.UI;

import java.util.Locale;

import static seedu.ui.UI.smartCommandRecognition;

public class InventoryParser {
    static final String[] COMMANDS = {"add", "delete", "list", "return", "help"};
    private InventoryChecker checker;

    /**
     * Returns a Command object which dictates the actions to be carried out on the Inventory objects.
     *
     * @param fullCommand Entire input command.
     * @param inventories InventoryList object that contains all the Inventory object.
     * @return Command object.
     * @throws ArrayIndexOutOfBoundsException If array is accessed with an illegal index.
     * @throws HealthVaultException If any invalid input given.
     */
    public Command inventoryParse(String fullCommand, InventoryList inventories)
            throws ArrayIndexOutOfBoundsException,
            HealthVaultException {
        String[] stringTokens = fullCommand.trim().split("/");
        int numberOfTokens = stringTokens.length;
        for(int i = 0; i < numberOfTokens; i++) {
            stringTokens[i] = stringTokens[i].trim();
        }
        MainChecker.checkNumInput(fullCommand, 4, 1);

        String command = smartCommandRecognition(COMMANDS, stringTokens[0]);
        Command c = null;
        checker = new InventoryChecker(inventories, stringTokens, numberOfTokens);
        switch (command) {
        case "list":
            int numberOfInputs = 1;
            MainChecker.checkNumInput(fullCommand, numberOfInputs, numberOfInputs);
            c = new seedu.logic.command.inventory.InventoryList();
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
            numberOfInputs = 3;
            MainChecker.checkNumInput(fullCommand, numberOfInputs, numberOfInputs);
            MainChecker.checkBlankInput(fullCommand);
            checker.checkDelete();
            c = new InventoryDelete(stringTokens);
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

    /**
     * Returns array of Inventory object fields.
     *
     * @param stringTokens represent the fields of Inventory object.
     * @return array of Inventory object fields.
     */
    private String[] parseToAddFormat(String[] stringTokens) {
        String[] addFormat;
        addFormat = new String[] {stringTokens[1], stringTokens[2], stringTokens[3]};
        return addFormat;
    }
}