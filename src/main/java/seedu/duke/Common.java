package seedu.duke;

import seedu.duke.exception.InvalidInputException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

/**
 * This is a common class providing some miscellaneous functionalities.
 */
public class Common {
    /**
     * Checks whether the patient's ID is valid.
     *
     * @param id Unique identifier of the patient to be retrieved
     * @return Flag on whether the patient's ID is valid
     */
    public static Boolean isValidID(String id) {
        int stringLength = id.length();

        // Checks if ID has 9 characters
        if (stringLength != Constants.ID_NUMBER_OF_CHARACTERS) {
            return false;
        }

        int checksum = 0;
        char firstLetter = id.charAt(Constants.INDEX_OF_FIRST_CHARACTER);
        char[] st = {'J', 'Z', 'I', 'H', 'G', 'F', 'E', 'D', 'C', 'B', 'A'};
        char[] fg = {'X', 'W', 'U', 'T', 'R', 'Q', 'P', 'N', 'M', 'L', 'K'};
        // Checks if ID is valid
        for (int i = 0; i < stringLength; i++) {
            char c = id.charAt(i);
            if (i == Constants.INDEX_OF_FIRST_CHARACTER) {
                // Checks if first index of ID is S,T,F or G
                if (c != 'S' && c != 'T' && c != 'F' && c != 'G') {
                    return false;
                }
            } else if (i == Constants.INDEX_OF_LAST_CHARACTER) {
                // Checks if last index of ID is a letter
                if (!Character.isLetter(c)) {
                    return false;
                }
                if (firstLetter == 'T' || firstLetter == 'G') {
                    checksum += Constants.CHECKSUM_DIGIT;
                }
                checksum = checksum % Constants.CHECKSUM_MOD;
                if (firstLetter == 'S' || firstLetter == 'T') {
                    if (c != st[checksum]) {
                        return false;
                    }
                } else {
                    if (c != fg[checksum]) {
                        return false;
                    }
                }
            } else {
                // Checks if the rest of the indexes are digits
                if (!Character.isDigit(c)) {
                    return false;
                }
                // Calculates the checksum of digits
                switch (i) {
                case Constants.FIRST_DIGIT:
                case Constants.LAST_DIGIT:
                    checksum += Integer.parseInt(String.valueOf(c)) * 2;
                    break;
                case Constants.SECOND_DIGIT:
                    checksum += Integer.parseInt(String.valueOf(c)) * 7;
                    break;
                case Constants.THIRD_DIGIT:
                    checksum += Integer.parseInt(String.valueOf(c)) * 6;
                    break;
                case Constants.FOURTH_DIGIT:
                    checksum += Integer.parseInt(String.valueOf(c)) * 5;
                    break;
                case Constants.FIFTH_DIGIT:
                    checksum += Integer.parseInt(String.valueOf(c)) * 4;
                    break;
                case Constants.SIXTH_DIGIT:
                    checksum += Integer.parseInt(String.valueOf(c)) * 3;
                    break;
                default:
                }
            }
        }
        return true;
    }

    /**
     * Parses a string in the format dd/MM/yyyy, and returns its corresponding date.
     *
     * @param dateString the string to be parsed
     * @return a LocalDate object corresponding to the input string
     * @throws DateTimeParseException if the date provided is invalid
     */
    public static LocalDate parseDate(String dateString) throws InvalidInputException {
        if (dateString.isEmpty()) {
            return LocalDate.now();
        }
        LocalDate date = null;
        try {
            date = LocalDate.parse(
                    dateString,
                    DateTimeFormatter.ofPattern(Constants.DATE_PATTERN).withResolverStyle(ResolverStyle.STRICT)
            );
        } catch (DateTimeParseException e) {
            throw new InvalidInputException(InvalidInputException.Type.INVALID_DATE, e);
        }
        if (date.isAfter(LocalDate.now())) {
            // We don't allow a record to be inserted for a future date
            throw new InvalidInputException(InvalidInputException.Type.FUTURE_DATE);
        }
        return date;
    }

    /**
     * Converts the specified date into a string following the format dd/MM/yyyy.
     *
     * @param date the date to be formatted
     * @return a string representation of the date, in the format dd/MM/yyyy
     */
    public static String formatDate(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern(Constants.DATE_PATTERN));
    }
}
