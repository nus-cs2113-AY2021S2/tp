package seedu.duke.record;

import java.time.LocalDate;

public class Loan extends Record {
    private boolean isReturn;

    public Loan(double amount, LocalDate issuedDate, String description) {
        super(amount, issuedDate, description);
        isReturn = false;
    }

    public void markAsReturned() {
        isReturn = true;
    }

    @Override
    public String toString() {
        //temporary placeholder. output format to be discussed.
        return "List loans!";
    }
}
