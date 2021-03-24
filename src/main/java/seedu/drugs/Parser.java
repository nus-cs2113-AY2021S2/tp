package seedu.drugs;

import seedu.duke.exceptions.drugexceptions.WrongInputException;
import seedu.duke.ui.DrugUI;

import java.util.Scanner;

public class Parser {

    protected DrugAction drugAction;

    public Parser(DrugAction drugAction) {
        this.drugAction = drugAction;
    }

    public void parseMethod() {
        DrugUI.drugMenuPrompt();
        Scanner myObj = new Scanner(System.in);
        String command = myObj.nextLine();
        while (!command.equals("return")) {
            try {
                switch (command) {
                    case "list":
                        drugAction.printList();
                        break;
                    case "add":
                        Scanner addIn = new Scanner(System.in);
                        DrugUI.drugNamePrompt();
                        String name = addIn.nextLine();
                        DrugUI.drugPricePrompt();
                        String price = addIn.nextLine();
                        DrugUI.drugQuantityPrompt();
                        String quantity = addIn.nextLine();
                        drugAction.addDrugs(name, price, quantity);
                        break;
                    case "delete":
                        Scanner deleteIn = new Scanner(System.in);
                        drugAction.checkDrugsSize();
                        DrugUI.drugNamePrompt();
                        name = deleteIn.nextLine();
                        drugAction.deleteDrugs(name);
                        break;
                    case "help":
                        DrugUI.printDrugHelpList();
                        break;
                    default:
                        DrugUI.invalidCommandMessage();
                }
                DrugUI.drugMenuPrompt();
                command = myObj.nextLine();
            } catch (WrongInputException w) {
                w.getError(command);
                DrugUI.drugMenuPrompt();
                command = myObj.nextLine();
            }
        }
    }
}
