package seedu.exceptions.inventory;

public class WrongInputException extends Exception{
    protected String error;
    public WrongInputException(String error) {
        this.error = error;
    }
    public void getError(String error) {
        switch (error) {
        case "loadFile":
            System.out.println("OOPS! There is an error loading the file!");
            break;
        case "add":
            System.out.println("OOPS! You have inputted the wrong number of parameters! \n" +
                    "There should not be any space in the name! \n" +
                    "There should only be 4 inputted terms including \"add\" \n" +
                    "Please type \"help\" to see the right command format!");
            break;
        case "delete":
            System.out.println("OOPS! You have inputted the wrong number of parameters! \n" +
                    "There should only be 2 inputted terms including \"delete\" \n" +
                    "Please type \"help\" to see the right command format!");
            break;
        case "return":
            System.out.println("OOPS! You have inputted the wrong number of parameters! \n" +
                    "There should only be 1 inputted term which is \"return\" \n" +
                    "Please type \"help\" to see the right command format!");
            break;
        case "list":
            System.out.println("OOPS! You have inputted the wrong number of parameters! \n" +
                    "There should only be 1 inputted term which is \"list\" \n" +
                    "Please type \"help\" to see the right command format!");
            break;
            /*case "doesNotExist":
                InventoryUI.drugNotFoundMessage();
                break;
            case "emptyList":
                InventoryUI.emptyInventoryListMessage();
                break;*/
        }
    }
}