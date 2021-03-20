package seedu.duke.record;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * A type of record for loans.
 */
public class Loan extends Record {
    private static final String TYPE_LOAN = "L";
    private static final String FILE_OUTPUT_STRING_FORMAT = "%s | %s | %f | %s | %d";

    private boolean isReturn;

    /**
     * Constructor to create loan record.
     *
     * @param amount loan amount.
     * @param issuedDate date of loan.
     * @param description loan details.
     */
    public Loan(BigDecimal amount, LocalDate issuedDate, String description) {
        super(amount, issuedDate, description);
        isReturn = false;
    }

    /**
     * Constructor to create loan record with predefined isReturn.
     *
     * @param amount loan amount.
     * @param issuedDate date of loan.
     * @param description loan details.
     * @param isReturn if the loan has been returned.
     */
    public Loan(BigDecimal amount, LocalDate issuedDate, String description, boolean isReturn) {
        super(amount, issuedDate, description);
        this.isReturn = isReturn;
    }

    /**
     * Marks a loan as returned.
     */
    public void markAsReturned() {
        isReturn = true;
    }

    /**
     * Rearrange the loan information to the format to be saved in the file.
     *
     * @return the formatted string of each loan record.
     */
    @Override
    public String convertFileFormat() {
        return String.format(FILE_OUTPUT_STRING_FORMAT, TYPE_LOAN, super.getDescription(),
                super.getAmount(), super.getIssueDate(), this.isReturn ? 1 : 0);
    }

    /**
     * Refine loan information to be printed when the object is printed.
     * The type of record is added.
     *
     * @return the formatted string of a loan record.
     */
    @Override
    public String toString() {
        String formattedRecordType = "[" + TYPE_LOAN + "]";
        String formattedLoanStatus = "[" + (isReturn ? "v" : " ") + "]";
        return formattedRecordType + super.toString() + formattedLoanStatus;
    }

    /**
     * Method to check if the loan is returned.
     *
     * @return true if loan is returned, false if loan is not return.
     */
    public boolean checkIsReturn() {
        return isReturn;
    }
}
