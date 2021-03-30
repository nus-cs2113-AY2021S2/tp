package seedu.logic.errorchecker;

import seedu.exceptions.ExcessInputException;
import seedu.exceptions.InsufficientInputException;
import seedu.exceptions.staff.BlankInputException;
import seedu.exceptions.staff.PositiveNumberOnlyException;

public class MainChecker {
    public static void checkNumInput(String line, int max, int min) throws InsufficientInputException, ExcessInputException {
        if (line.split("/").length < min) {
            throw new InsufficientInputException();
        }
        if (line.split("/").length > max) {
            throw new ExcessInputException();
        }
    }

    public static void checkNumericInput(String number) throws NumberFormatException, PositiveNumberOnlyException {
        try {
            Integer.parseInt(number);     // Check age is numeric
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }
        if (Integer.parseInt(number) < 0) {
            throw new PositiveNumberOnlyException();
        }
    }

    public static void checkBlankInput(String line) throws BlankInputException {
       String[] array = line.split("/");
        for (String s : array) {
            if (s.trim().equals("")) {
                throw new BlankInputException();
            }
        }
    }
}
