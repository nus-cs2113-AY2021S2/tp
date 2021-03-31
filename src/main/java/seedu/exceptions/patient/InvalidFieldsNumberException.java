package seedu.exceptions.patient;

import seedu.exceptions.HealthVaultException;

public class InvalidFieldsNumberException extends HealthVaultException {

    String error;

    public InvalidFieldsNumberException(String error) {
        this.error = error;
    }

    public String getMessage() {
        switch (error) {
        case "add":
            return "You have inputted the wrong number of parameters! \n" +
                    "There should only be 7 inputted terms including \"add\" \n" +
                    "Please type \"help\" to see the right command format!";
        case "find":
            return "You have inputted the wrong number of parameters! \n" +
                    "There should only be 2 inputted terms including \"find\" \n" +
                    "Please type \"help\" to see the right command format!";
        case "delete":
            return "You have inputted the wrong number of parameters! \n" +
                    "There should only be 2 inputted terms including \"delete\" \n" +
                    "Please type \"help\" to see the right command format!";
        case "return":
            return "OOPS! You have inputted the wrong number of parameters! \n" +
                    "There should only be 1 inputted term which is \"return\" \n" +
                    "Please type \"help\" to see the right command format!";
        case "help":
            return "OOPS! You have inputted the wrong number of parameters! \n" +
                    "There should only be 1 inputted term which is \"help\"";
        case "list":
            return "OOPS! You have inputted the wrong number of parameters! \n" +
                    "There should only be 1 inputted term which is \"list\" \n" +
                    "Please type \"help\" to see the right command format!";
        default:
            return "You have inputted the wrong number of parameters!";
        }
    }
}

