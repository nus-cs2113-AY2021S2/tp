package seedu.duke.record;

import java.time.LocalDate;

public class Loan extends Record {
    private static final String TYPE_LOAN = "L";
    private static final String FILE_OUTPUT_STRING_FORMAT = "%s | %s | %f | %s | %d";
    private boolean isReturn;

    public Loan(double amount, LocalDate issuedDate, String description) {
        super(amount, issuedDate, description);
        isReturn = false;
    }

    public Loan(double amount, LocalDate issuedDate, String description, boolean isReturn) {
        super(amount, issuedDate, description);
        this.isReturn = isReturn;
    }

    public void markAsReturned() {
        isReturn = true;
    }

    @Override
    public String convertFileFormat() {
        return String.format(FILE_OUTPUT_STRING_FORMAT, TYPE_LOAN, super.getDescription(),
                super.getAmount(), super.getIssueDate(), this.isReturn ? 1 : 0);
    }

    @Override
    public String toString() {
        //temporary placeholder. output format to be discussed.
        return "List loans!";
    }
}
