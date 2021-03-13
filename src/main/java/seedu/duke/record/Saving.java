package seedu.duke.record;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Saving extends Record {
    private static final String TYPE_SAVING = "S";

    public Saving(BigDecimal amount, LocalDate issueDate, String description) {
        super(amount, issueDate, description);
    }

    @Override
    public String toString() {
        String formattedRecordType = "[" + TYPE_SAVING + "]";
        return formattedRecordType + super.toString();
    }
}
