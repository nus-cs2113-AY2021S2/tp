package seedu.duke.record;

import java.time.LocalDate;
import java.math.BigDecimal;

public abstract class Record {
    private BigDecimal amount;
    private LocalDate issueDate;
    private String description;
    private static final String FILE_OUTPUT_STRING_FORMAT = "| %s | %f | %s";

    public Record(BigDecimal amount, LocalDate issueDate, String description) {
        this.amount = amount;
        this.issueDate = issueDate;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public String convertFileFormat() {
        return String.format(FILE_OUTPUT_STRING_FORMAT, description, amount, issueDate);
    }

    @Override
    public String toString() {
        String formattedDate = "[" + this.issueDate + "]";
        String formattedDescription = " " + this.description + " ";
        return formattedDate + formattedDescription;
    }
}
