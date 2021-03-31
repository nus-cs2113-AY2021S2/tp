package seedu.logic.parser;

import seedu.exceptions.ExcessInputException;
import seedu.exceptions.InsufficientInputException;
import seedu.exceptions.InvalidIntegerException;
import seedu.exceptions.inventory.DuplicateDrugException;
import seedu.exceptions.inventory.InvalidPriceException;
import seedu.exceptions.inventory.NonExistentDrugException;
import seedu.exceptions.inventory.WrongInputException;
import seedu.logic.command.Command;
import seedu.logic.command.InventoryActions;
import seedu.logic.command.inventory.*;
import seedu.logic.errorchecker.InventoryChecker;
import seedu.logic.errorchecker.MainChecker;
import seedu.ui.UI;

import static seedu.ui.UI.smartCommandRecognition;

public class InventoryParser {
    static final String[] COMMANDS = {"add", "delete", "list", "return", "help"};

   /*public void lengthCheck(int numberOfTokens, String command) throws WrongInputException {
       if (command.equals("add") && numberOfTokens != 4) {
           throw new WrongInputException(command);
       } else if (command.equals("delete") && numberOfTokens != 2) {
           throw new WrongInputException(command);
       } else if ((command.equals("list") || command.equals("return") || command.equals("help")) && numberOfTokens != 1) {
           throw new WrongInputException(command);
       }
   }*/

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
        int numberOfTokens = stringTokens.length;
        String firstWord = stringTokens[0];
        String price = stringTokens[2];
        String quantity = stringTokens[3];
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
                    InventoryChecker.duplicateChecker(command);
                    InventoryChecker.isValidPrice(price);
                    MainChecker.checkNumericInput(quantity);
                    MainChecker.checkNumInput(fullCommand, numberOfInputs, numberOfInputs);
                    if (nameParser(drugs, stringTokens, command)) {
                        String[] addFormat = parseToAddFormat(stringTokens);
                        c = new InventoryAdd(addFormat);
                    }
                    break;
                case "delete":
                    numberOfInputs = 2;
                    MainChecker.checkNumInput(fullCommand, numberOfInputs, numberOfInputs);
                    if (nameParser(drugs, stringTokens, command)) {
                        c = new InventoryDelete(stringTokens[0]);
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
        } catch (InvalidIntegerException | NumberFormatException e) {
            e.getMessage();
        } catch (InsufficientInputException | ExcessInputException e) {
            e.getMessage();
        }
        return c;
    }
    private String[] parseToAddFormat(String[] stringTokens) {
       String[] addFormat;
       addFormat = new String[] {stringTokens[1], stringTokens[2], stringTokens[3]};
       return addFormat;
    }
    private boolean nameParser(InventoryActions drugs, String[] stringTokens, String command) {
       try {
           isNameExist(stringTokens[1], drugs, command);
       } catch (NonExistentDrugException e) {
           e.getError("NameDoesNotExist");
           return false;
       } catch (DuplicateDrugException e) {
           e.getError("DrugStored");
           return false;
       }
       return true;
    }
   /* public void parseMethod() {
        InventoryUI.drugMenuPrompt();
        Scanner myObj = new Scanner(System.in);
        String command = myObj.nextLine();
        while (!command.equals("return")) {
            try {
                switch (command) {
                    case "list":
                        inventoryActions.listDrugs();
                        break;
                    case "add":
                        Scanner addIn = new Scanner(System.in);
                        InventoryUI.drugNamePrompt();
                        String name = addIn.nextLine();
                        InventoryUI.drugPricePrompt();
                        String price = addIn.nextLine();
                        InventoryUI.drugQuantityPrompt();
                        String quantity = addIn.nextLine();
                        inventoryActions.addDrugs(name, price, quantity);
                        break;
                    case "delete":
                        Scanner deleteIn = new Scanner(System.in);
                        inventoryActions.checkDrugsSize();
                        InventoryUI.drugNamePrompt();
                        name = deleteIn.nextLine();
                        inventoryActions.deleteDrugs(name);
                        break;
                    case "help":
                        InventoryUI.printDrugHelpList();
                        break;
                    default:
                        InventoryUI.invalidCommandMessage();
                }
                InventoryUI.drugMenuPrompt();
                command = myObj.nextLine();
            } catch (WrongInputException w) {
                w.getError(command);
                InventoryUI.drugMenuPrompt();
                command = myObj.nextLine();
            }
        }
    }*/
}
