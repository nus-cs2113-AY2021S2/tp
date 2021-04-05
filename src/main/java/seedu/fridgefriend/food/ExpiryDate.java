package seedu.fridgefriend.food;

//@@author kwokyto
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import seedu.fridgefriend.exception.InvalidDateException;

public class ExpiryDate {
    protected LocalDate expiry;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public ExpiryDate(String string) throws InvalidDateException {
        try {
            assert string != null : "date string should not be null";
            LocalDate expiry = LocalDate.parse(string, formatter);
            this.expiry = expiry;            
        } catch (DateTimeParseException e) {
            throw new InvalidDateException("Sorry my friend, the date must be in the form 'dd-mm-yyyy'.");
        }
    }

    public LocalDate getExpiry() {
        return expiry;
    }

    @Override
    public String toString() {
        return this.expiry.format(formatter);
    }
}