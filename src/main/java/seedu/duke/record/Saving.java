package seedu.duke.record;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Saving extends Record {
    private static final String TYPE_SAVING = "S";
    private static final String FILE_OUTPUT_STRING_FORMAT = "%s | %s | %f | %s";

    public Saving(BigDecimal amount, LocalDate issueDate, String description) {
        super(amount, issueDate, description);
    }

    @Override
    public String convertFileFormat() {
        return String.format(FILE_OUTPUT_STRING_FORMAT, TYPE_SAVING, super.getDescription(),
                super.getAmount(), super.getIssueDate());
    }

    @Override
    public String toString() {
        String formattedRecordType = "[" + TYPE_SAVING + "]";
        return formattedRecordType + super.toString();
    }
}
