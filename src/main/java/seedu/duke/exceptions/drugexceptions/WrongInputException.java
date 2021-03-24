package seedu.duke.exceptions.drugexceptions;

import seedu.duke.ui.DrugUI;

public class WrongInputException extends Exception{
    protected String error;
    public WrongInputException(String error) {
        this.error = error;
    }
    public void getError(String input) {
        switch (error) {
            case "price":
                System.out.println("Please enter valid price e.g 3.50 or 3");
                break;
            case "empty":
                System.out.println("The description of " + input + " cannot be empty");
                break;
            case "doesNotExist":
                DrugUI.drugNotFoundMessage();
                break;
            case "emptyList":
                DrugUI.emptyDrugListMessage();
                break;
        }
    }
}
