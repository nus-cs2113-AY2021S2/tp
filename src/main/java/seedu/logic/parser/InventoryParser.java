package seedu.logic.parser;

import seedu.exceptions.ExcessInputException;
import seedu.exceptions.InsufficientInputException;
import seedu.exceptions.InvalidIntegerException;
import seedu.exceptions.NoInputException;
import seedu.exceptions.inventory.DuplicateDrugException;
import seedu.exceptions.inventory.InvalidPriceException;
import seedu.exceptions.inventory.NonExistentDrugException;
import seedu.logic.command.Command;
import seedu.logic.command.InventoryActions;
import seedu.logic.command.inventory.*;
import seedu.logic.errorchecker.InventoryChecker;
import seedu.logic.errorchecker.MainChecker;
import seedu.ui.UI;

import static seedu.ui.UI.smartCommandRecognition;

public class InventoryParser {
    static final String[] COMMANDS = {"add", "delete", "list", "return", "help"};
    private InventoryChecker checker;

    private void isNameExist(String userInput, InventoryActions drugs, String command) throws NonExistentDrugException, DuplicateDrugException {
       if (drugs.isDrugStored(userInput)) {
           if (command.equals("add")) {
               throw new DuplicateDrugException();
           }
       } else {
           if(command.equals("delete")) {
               throw new NonExistentDrugException("NameDoesNotExist");
           }
       }
    }

    public Command inventoryParse(String fullCommand, InventoryActions drugs) {
        String[] stringTokens = fullCommand.trim().split("/");
        String firstWord = stringTokens[0];
        String command = smartCommandRecognition(COMMANDS, firstWord);
        Command c = null;
        try {
            switch (command) {
                case "list":
                    int numberOfInputs = 1;
                    MainChecker.checkNumInput(fullCommand, numberOfInputs, numberOfInputs);
                    c = new InventoryList();
                    break;
                case "add":
                    numberOfInputs = 4;
                    MainChecker.checkNumInput(fullCommand, numberOfInputs, numberOfInputs);
                    String quantity = stringTokens[3];
                    MainChecker.checkNumericInput(quantity);
                    MainChecker.checkBlankInput(fullCommand);
                    checker.duplicateChecker(command);
                    String price = stringTokens[2];
                    checker.isValidPrice(price);
                    if (nameParser(drugs, stringTokens, command)) {
                        String[] addFormat = parseToAddFormat(stringTokens);
                        c = new InventoryAdd(addFormat);
                    }
                    break;
                case "delete":
                    MainChecker.checkBlankInput(fullCommand);
                    numberOfInputs = 2;
                    MainChecker.checkNumInput(fullCommand, numberOfInputs, numberOfInputs);
                    if (nameParser(drugs, stringTokens, command)) {
                        c = new InventoryDelete(stringTokens[1]);
                    }
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
        } catch (DuplicateDrugException e) {
            e.getError("DrugStored");
        } catch (InvalidPriceException e) {
            e.getError("InvalidPrice");
        } catch (InvalidIntegerException | NumberFormatException | InsufficientInputException | ExcessInputException | NoInputException e) {
            System.out.println(e.getMessage());
        }
        return c;
    }
    private String[] parseToAddFormat(String[] stringTokens) {
       String[] addFormat;
       addFormat = new String[] {stringTokens[1], stringTokens[2], stringTokens[3]};
       return addFormat;
    }
    private boolean nameParser(InventoryActions inventory, String[] stringTokens, String command) {
       try {
           isNameExist(stringTokens[1], inventory, command);
       } catch (NonExistentDrugException e) {
           e.getError("NameDoesNotExist");
           return false;
       } catch (DuplicateDrugException e) {
           e.getError("DrugStored");
           return false;
       }
       return true;
    }
}
