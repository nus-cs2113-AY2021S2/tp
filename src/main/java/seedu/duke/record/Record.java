package seedu.duke.record;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.math.BigDecimal;
import java.util.Locale;

/**
 * Represents a financial-related record to be stored in a list.
 */
public abstract class Record {
    private BigDecimal amount;
    private LocalDate issueDate;
    private String description;

    /**
     * Constructor to create a record.
     *
     * @param amount amount to record.
     * @param issueDate date of issue to record.
     * @param description description of record.
     */
    public Record(BigDecimal amount, LocalDate issueDate, String description) {
        this.amount = amount;
        this.issueDate = issueDate;
        this.description = description;
    }

    /**
     * Gets the description or details of a record.
     *
     * @return description of record.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the amount in dollars of the record.
     *
     * @return amount of the record.
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * Gets the date of issuance of the record.
     *
     * @return issue date of the record.
     */
    public LocalDate getIssueDate() {
        return issueDate;
    }

    /**
     * Rearrange the record information to the format to be saved in the file.
     *
     * @return the formatted string of a record.
     */
    public abstract String convertFileFormat();

    /**
     * Rearrange record information to be printed when the object is printed.
     *
     * @return the formatted string of a record.
     */
    @Override
    public String toString() {
        String formattedDate = "[" + this.issueDate + "] ";
        String formattedAmount = "[" + NumberFormat.getCurrencyInstance(Locale.US).format(this.amount) + "]";
        String formattedDescription = " " + this.description + " ";
        return formattedDate + formattedAmount + formattedDescription;
    }
}
