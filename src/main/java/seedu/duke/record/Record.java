package seedu.duke.record;

import java.time.LocalDate;

public abstract class Record {
    private double amount;
    private LocalDate issueDate;
    private String description;
    private static final String FILE_OUTPUT_STRING_FORMAT = "%s | %f | %s";

    public Record(double amount, LocalDate issueDate, String description) {
        this.amount = amount;
        this.issueDate = issueDate;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
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
        //temporary placeholder. output format to be discussed.
        return "Common description across Loan, Saving & Expense classes";
    }
}
