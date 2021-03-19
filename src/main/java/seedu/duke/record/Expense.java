package seedu.duke.record;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * A type of record for expenses.
 */
public class Expense extends Record {
    private static final String TYPE_EXPENSE = "E";
    private static final String FILE_OUTPUT_STRING_FORMAT = "%s | %s | %f | %s";

    /**
     * Constructor to create expense record.
     *
     * @param amount expense amount.
     * @param issuedDate date of expenditure.
     * @param description expense details.
     */
    public Expense(BigDecimal amount, LocalDate issuedDate, String description) {
        super(amount, issuedDate, description);
    }

    /**
     * Rearrange the expense information to the format to be saved in the file.
     *
     * @return the formatted string of an expense record.
     */
    @Override
    public String convertFileFormat() {
        return String.format(FILE_OUTPUT_STRING_FORMAT, TYPE_EXPENSE, super.getDescription(),
                super.getAmount(), super.getIssueDate());
    }

    /**
     * Refine expense information to be printed when the object is printed.
     * The type of record is added.
     *
     * @return the formatted string of an expense record.
     */
    @Override
    public String toString() {
        String formattedRecordType = "[" + TYPE_EXPENSE + "]";
        return formattedRecordType + super.toString();
    }
}
