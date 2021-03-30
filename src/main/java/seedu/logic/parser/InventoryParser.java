package seedu.logic.parser;

import seedu.exceptions.DukeException;

import seedu.exceptions.inventory.DuplicateDrugException;
import seedu.exceptions.inventory.InvalidPriceException;
import seedu.exceptions.inventory.NonExistentDrugException;
//import seedu.exceptions.inventory.WrongInputException;
import seedu.logic.command.Command;
import seedu.logic.command.InventoryActions;
import seedu.logic.command.inventory.*;
import seedu.ui.UI;

public class InventoryParser {

    //protected InventoryActions inventoryActions;

   /* public InventoryParser(InventoryActions inventoryActions) {
        this.inventoryActions = inventoryActions;
    }*/
   public void lengthCheck(int numberOfTokens, String command) throws DukeException {
       if (command.equals("add") && numberOfTokens != 7) {
           throw new DukeException(command);
       } else if (command.equals("delete") && numberOfTokens != 2) {
           throw new DukeException(command);
       } else if ((command.equals("list") || command.equals("return") || command.equals("help")) && numberOfTokens != 1) {
           throw new DukeException(command);
       }
   }
    private void isValidPrice(String price) throws InvalidPriceException {
        try {
            double priceDouble = Double.parseDouble(price); //check if price is a double
        } catch (NumberFormatException e) {
            throw new InvalidPriceException("price");
        }
    }
    private void isNameExist(String userInput, InventoryActions drugs, String command) throws NonExistentDrugException, DuplicateDrugException {
       if (drugs.isDrugStored(userInput)) {
           if (command.equals("add")) {
               throw new DuplicateDrugException("DrugStored");
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
        String command = stringTokens[0];
        Command c = null;
        try {
            switch (command) {
                case "list":
                    lengthCheck(numberOfTokens, command);
                    c = new InventoryList();
                    break;
                case "add":
                    lengthCheck(numberOfTokens, command);
                    if (nameParser(drugs, stringTokens, command)) {
                        String[] addFormat = parseToAddFormat(stringTokens);
                        c = new InventoryAdd(addFormat);
                    }
                    break;
                case "delete":
                    lengthCheck(numberOfTokens, command);
                    if (nameParser(drugs, stringTokens, command)) {
                        c = new InventoryDelete(stringTokens[0]);
                    }
                    break;
                case "help":
                    lengthCheck(numberOfTokens, command);
                    c = new InventoryHelp();
                    break;
                case "return":
                    lengthCheck(numberOfTokens, command);
                    c = new InventoryReturn();
                    break;
                default:
                    UI.invalidCommandErrorMessage();
                    break;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            UI.invalidFormatErrorMessage();
        } catch (DukeException e) {
            e.getError(command);
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
           isValidPrice(stringTokens[1]);
           isNameExist(stringTokens[0], drugs, command);
       } catch (InvalidPriceException e) {
           e.getError("price");
           return false;
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
