package seedu.logic.errorchecker;

import seedu.exceptions.ExcessInputException;
import seedu.exceptions.InsufficientInputException;
import seedu.exceptions.InvalidGenderException;
import seedu.exceptions.InvalidIntegerException;
import seedu.exceptions.NoInputException;
import seedu.exceptions.IllegalCharacterException;
import seedu.logger.HealthVaultLogger;
import seedu.ui.UI;

import java.util.Arrays;
import java.util.logging.Logger;

import static seedu.duke.Constants.VALID_GENDER_INPUT;

public class MainChecker {
    public Logger logger = HealthVaultLogger.getLogger();

    public static void checkNumInput(String line, int max, int min) throws InsufficientInputException, ExcessInputException {
        if (line.split("/").length < min) {
            throw new InsufficientInputException();
        }
        if (line.split("/").length > max) {
            throw new ExcessInputException();
        }
    }

    public static void checkNumInput(String[] array, int max, int min) throws InsufficientInputException, ExcessInputException {

        if (array.length < min) {
            throw new InsufficientInputException();
        }
        if (array.length > max) {
            throw new ExcessInputException();
        }
    }

    public static void checkDataNumInput(String line, int max, int min) throws InsufficientInputException, ExcessInputException {
        if (line.split("\\|").length < min) {
            throw new InsufficientInputException();
        }
        if (line.split("\\|").length > max) {
            throw new ExcessInputException();
        }
    }

    public static void checkNumericInput(String number) throws NumberFormatException, InvalidIntegerException {
        try {
            Integer.parseInt(number);     // Check age is numeric
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }
        if (Integer.parseInt(number) < 0) {
            throw new InvalidIntegerException();
        }
    }

    public static void checkBlankInput(String line) throws NoInputException {
        String[] array = line.split("/");
        for (String s : array) {
            if (s.trim().equals("")) {
                throw new NoInputException();
            }
        }
    }
    public static void checkBlankInput(String[] array) throws NoInputException {
        for (String s : array) {
            if (s.trim().equals("")) {
                throw new NoInputException();
            }
        }
    }

    public static void checkBlankInputForStorage(String line) throws NoInputException {
        String[] array = line.split("\\|");
        for (String s : array) {
            if (s.trim().equals("")) {
                throw new NoInputException();
            }
        }
    }

    public void checkGender(String stringToken) throws InvalidGenderException {
        String gender = stringToken;
        if (!Arrays.stream(VALID_GENDER_INPUT).anyMatch(gender::equals)) {
            throw new InvalidGenderException();
        }
    }

    public static void illegalCharacterChecker(String stringToken, String fieldInput) throws IllegalCharacterException {

        String cleanedInput = UI.cleanseInput(stringToken.trim());
        if (!stringToken.equals(cleanedInput)){
            throw new IllegalCharacterException(fieldInput);
        }
    }
}
