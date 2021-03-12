package seedu.duke.record;

import java.time.LocalDate;

public class Saving extends Record {
    public Saving(double amount, LocalDate issueDate, String description) {
        super(amount, issueDate, description);
    }

    @Override
    public String toString() {
        //temporary placeholder. output format to be discussed.
        return "List savings!";
    }
}
