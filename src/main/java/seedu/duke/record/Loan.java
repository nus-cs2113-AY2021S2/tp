package seedu.duke.record;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Loan extends Record {
    private static final String TYPE_LOAN = "L";
    private boolean isReturn;

    public Loan(BigDecimal amount, LocalDate issuedDate, String description) {
        super(amount, issuedDate, description);
        isReturn = false;
    }

    public void markAsReturned() {
        isReturn = true;
    }

    @Override
    public String toString() {
        String formattedRecordType = "[" + TYPE_LOAN + "]";
        String formattedLoanStatus = "[" + (isReturn ? "v" : " ") + "]";
        return formattedRecordType + super.toString() + formattedLoanStatus;
    }
}
