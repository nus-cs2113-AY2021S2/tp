package seedu.duke.record;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * A type of record for savings.
 */
public class Saving extends Record {
    private static final String TYPE_SAVING = "S";
    private static final String FILE_OUTPUT_STRING_FORMAT = "%s | %s | %f | %s";

    /**
     * Constructor to create saving record.
     *
     * @param amount saving amount.
     * @param issueDate date of saving.
     * @param description saving details.
     */
    public Saving(BigDecimal amount, LocalDate issueDate, String description) {
        super(amount, issueDate, description);
    }

    /**
     * Rearrange the saving information to the format to be saved in the file.
     *
     * @return the formatted string of a saving record.
     */
    @Override
    public String convertFileFormat() {
        return String.format(FILE_OUTPUT_STRING_FORMAT, TYPE_SAVING, super.getDescription(),
                super.getAmount(), super.getIssueDate());
    }

    /**
     * Refine saving information to be printed when the object is printed.
     * The type of record is added.
     *
     * @return the formatted string of a saving record.
     */
    @Override
    public String toString() {
        String formattedRecordType = "[" + TYPE_SAVING + "]";
        return formattedRecordType + super.toString();
    }
}
