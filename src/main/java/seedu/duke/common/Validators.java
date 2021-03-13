package seedu.duke.common;

import java.math.BigDecimal;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import seedu.duke.exception.CustomException;
import seedu.duke.record.RecordList;

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
    private static LocalDate parseDateString(DateTimeFormatter format, String dateInput) {
        try {
            return LocalDate.parse(dateInput, format);
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    // @@author marklowsk-reused
    // Reused from https://github.com/marklowsk/ip/blob/master/src/main/java/duke/common/Utils.java
    // Utils.parseDate(String) with minor edits.
    /**
     * Parses dateInput into a LocalDateTime object.
     * Returns null if dateInput cannot be parsed into a LocalDateTime object.
     *
     * @param dateInput a string containing the date supplied from the user.
     * @return a LocalDateTime object or null if failed to parse dateInput.
     * @see #parseDateString(DateTimeFormatter, String)
     */
    public static LocalDate validateDate(String dateInput) throws DateTimeException {
        for (DateTimeFormatter dtf : POSSIBLE_DATE_FORMATS) {
            LocalDate date = parseDateString(dtf, dateInput);
            if (date != null) {
                return date;
            }
        }
        throw new DateTimeException("input \"" + dateInput + "\" is not an acceptable Date Format.");
    }

    public static int validateIndex(String inputToCheck, RecordList records) throws NumberFormatException,
            IndexOutOfBoundsException {
        int recordNumberInList = Integer.parseInt(inputToCheck) - 1;
        records.getRecordAt(recordNumberInList);
        return recordNumberInList;
    }

    public static BigDecimal validateAmount(String inputToCheck) throws NumberFormatException,
            CustomException {
        BigDecimal amount = new BigDecimal(inputToCheck);
        if (!(amount.compareTo(new BigDecimal("0")) == 1)) {
            throw new CustomException("amount must be greater than 0.");
        }
        return amount;
    }
}
