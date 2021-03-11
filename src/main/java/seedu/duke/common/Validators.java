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

    public static double validateAmount(String inputToCheck) throws NumberFormatException,
            CommandException {
        double amount = Double.parseDouble(inputToCheck);
        if (amount <= 0) {
            throw new CommandException("amount must be greater than 0");
        }
        return amount;
    }
}
