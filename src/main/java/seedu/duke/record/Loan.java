package seedu.duke.record;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Loan extends Record {
    private static final String TYPE_LOAN = "L";
    private static final String FILE_OUTPUT_STRING_FORMAT = "%s | %s | %f | %s | %d";
    private boolean isReturn;

    public Loan(BigDecimal amount, LocalDate issuedDate, String description) {
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
        String formattedRecordType = "[" + TYPE_LOAN + "]";
        String formattedLoanStatus = "[" + (isReturn ? "v" : " ") + "]";
        return formattedRecordType + super.toString() + formattedLoanStatus;
    }
}
