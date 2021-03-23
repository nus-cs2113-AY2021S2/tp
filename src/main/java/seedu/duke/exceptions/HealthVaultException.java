package seedu.duke.exceptions;

public class HealthVaultException extends Exception {

    protected String error;

    /**
     * Instantiates this exception
     *
     * @param error error type
     */
    public HealthVaultException(String error) {
        this.error = error;
    }

    public HealthVaultException() {
    }

    /**
     * Shows the error encountered by the user
     *
     * @param input error type
     */
    public void getError(String input) {
        switch (error) {
        case "loadFile":
            System.out.println("OOPS! The file format is wrong! It may have been corrupted! \n" +
                    "Please delete the file \"data/PatientList.txt\" so we can make a new file for you! ");
            break;
        case "add":
            System.out.println("OOPS! You have inputted the wrong number of parameters! \n" +
                    "There should not be any space in the name! \n" +
                    "There should only be 7 inputted terms including \"add\" \n" +
                    "Please type \"help\" to see the right command format!");
            break;
        case "find":
            System.out.println("OOPS! You have inputted the wrong number of parameters! \n" +
                    "There should only be 2 inputted terms including \"find\" \n" +
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
        case "help":
            System.out.println("OOPS! You have inputted the wrong number of parameters! \n" +
                    "There should only be 1 inputted term which is \"help\"");
            break;
        case "list":
            System.out.println("OOPS! You have inputted the wrong number of parameters! \n" +
                    "There should only be 1 inputted term which is \"list\" \n" +
                    "Please type \"help\" to see the right command format!");
            break;
        case "IDLength":
            System.out.println("OOPS! Looks like your ID length is incorrect! \n" +
                    "Please ensure that the ID has 6 characters!");
            break;
        case "IDType":
            System.out.println("OOPS! Looks like your ID type is incorrect! \n" +
                    "Please ensure that the ID starts with \"P\"!");
            break;
        case "IDValue":
            System.out.println("OOPS! Looks like your ID value is incorrect! \n" +
                    "Please ensure that the ID includes 5 numbers after \"P\"! \n" +
                    "eg. P12345 or P67891");
            break;
        case "IDTaken":
            System.out.println("OOPS! Looks like the ID has been taken! \n" +
                    "Try a different ID! You can use the \"list\" command to see which IDs have been taken!");
            break;
        case "IDDoesNotExist":
            System.out.println("OOPS! Looks like the ID does not exist! \n" +
                    "Check that you have inputted the right ID! \n" +
                    "You can use the \"list\" command to see which IDs exist!");
            break;
        default:
            System.out.println("OOPS! Your command may not be valid! \n" +
                    "Please check the list of available commands using \"help\"");
            break;
        }
    }
}
