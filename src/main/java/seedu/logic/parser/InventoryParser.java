package seedu.logic.parser;

import seedu.exceptions.*;
import seedu.exceptions.inventory.DuplicateDrugException;
import seedu.exceptions.inventory.InvalidPriceException;
import seedu.exceptions.inventory.NonExistentDrugException;
import seedu.exceptions.inventory.IllegalCharacterException;
import seedu.logic.command.Command;
import seedu.logic.command.InventoryActions;
import seedu.logic.command.inventory.*;
import seedu.logic.errorchecker.InventoryChecker;
import seedu.logic.errorchecker.MainChecker;
import seedu.ui.UI;

import java.util.ArrayList;

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
       /*int numberOfTokens = stringTokens.length;
        ArrayList<String> cleanString = new ArrayList<>();
        for (int i = 0; i < numberOfTokens; i++) {
            cleanString.add(UI.cleanseInput(stringTokens[i]).trim());
        }*/
        String command = smartCommandRecognition(COMMANDS, stringTokens[0]);
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
                    checker.checkAdd();
                    String quantity = stringTokens[3];
                    checker.isValidQuantity(quantity);
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
                    numberOfInputs = 2;
                    MainChecker.checkNumInput(fullCommand, numberOfInputs, numberOfInputs);
                    MainChecker.checkBlankInput(fullCommand);
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
        }  /*catch (HealthVaultException e) {
            System.out.println(e.getMessage());
        }*/ catch (HealthVaultException e) {
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
