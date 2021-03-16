package seedu.fridgefriend.food;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import seedu.fridgefriend.exception.InvalidDateException;

public class ExpiryDate {
    protected LocalDate expiry;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public ExpiryDate(String string) throws InvalidDateException {
        try {
            LocalDate expiry = LocalDate.parse(string, formatter);
            this.expiry = expiry;            
        } catch (DateTimeParseException e) {
            String message = e.getLocalizedMessage();
            throw new InvalidDateException(message);
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