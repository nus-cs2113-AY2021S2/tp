package seedu.logic.errorchecker;

import seedu.exceptions.ExcessInputException;
import seedu.exceptions.InsufficientInputException;
import seedu.exceptions.InvalidIntegerException;
import seedu.exceptions.NoInputException;
import seedu.exceptions.InvalidGenderException;
import seedu.exceptions.patient.IllegalCharacterException;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static seedu.duke.Constants.VALID_GENDER_INPUT;

public class MainChecker {

    private static final String ILLEGAL_CHARACTERS = "[~#@*+%{}<>\\[\\]|\"_^\\\\]";

    public static void checkNumInput(String line, int max, int min) throws InsufficientInputException, ExcessInputException {

        if (line.split("/").length < min) {
            throw new InsufficientInputException();
        }
        if (line.split("/").length > max) {
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
        if (!Arrays.stream(VALID_GENDER_INPUT).anyMatch(gender::contains)) {
            throw new InvalidGenderException();
        }
    }

    public void illegalCharacterChecker(String stringToken, String fieldInput) throws IllegalCharacterException {
        String nameString = stringToken.toLowerCase();
        Pattern pattern = Pattern.compile(ILLEGAL_CHARACTERS);
        Matcher matcher = pattern.matcher(nameString);
        if (matcher.find()) {
            throw new IllegalCharacterException(fieldInput);
        }
    }
}
