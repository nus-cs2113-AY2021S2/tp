package seedu.duke.common;

import seedu.duke.exception.CommandException;

public class Validators {

    public static void validateIndex() {

    }

    public static String validateDate(String inputToCheck) throws CommandException {
        if (inputToCheck.contains("dummy")) {
            throw new CommandException("");
        } else {
            return inputToCheck;
        }
    }

    public static double validateAmount(String inputToCheck) throws NumberFormatException {
        return Double.parseDouble(inputToCheck);
    }
}
