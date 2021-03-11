package seedu.duke.common;

import seedu.duke.exception.CommandException;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Validators {

    // @@author marklowsk-reused
    // Reused from https://github.com/marklowsk/ip/blob/master/src/main/java/duke/common/Utils.java
    private static final DateTimeFormatter[] POSSIBLE_DATE_FORMATS = {
        DateTimeFormatter.ofPattern("ddMMyyyy"),
        DateTimeFormatter.ofPattern("d.M.yyyy"),
        DateTimeFormatter.ofPattern("d-M-yyyy"),
        DateTimeFormatter.ofPattern("d/M/yyyy"),
        DateTimeFormatter.ofPattern("yyyy.M.d"),
        DateTimeFormatter.ofPattern("yyyy-M-d"),
        DateTimeFormatter.ofPattern("yyyy/M/d")
    };

    // @@author marklowsk-reused
    // Reused from https://github.com/marklowsk/ip/blob/master/src/main/java/duke/common/Utils.java
    // with minor edits.
    /**
     * Parses dateInput into a LocalDateTime object.
     * Returns null if dateInput cannot be parsed into a LocalDateTime object.
     *
     * @param dateInput a string containing the date supplied from the user.
     * @return a LocalDateTime object or null if failed to parse dateInput.
     * @see #parseDateString(DateTimeFormatter, String)
     */
    public static LocalDate parseDate(String dateInput) {
        for (DateTimeFormatter dtf : POSSIBLE_DATE_FORMATS) {
            LocalDate date = parseDateString(dtf, dateInput);
            if (date != null) {
                return date;
            }
        }
        throw new DateTimeException("input \"" + dateInput+ "\" is not an acceptable Date Format.");
    }

    // @@author marklowsk-reused
    // Reused from https://github.com/marklowsk/ip/blob/master/src/main/java/duke/common/Utils.java
    private static LocalDate parseDateString(DateTimeFormatter format, String dateInput) {
        try {
            return LocalDate.parse(dateInput, format);
        } catch (DateTimeParseException e) {
            return null;
        }
    }

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
