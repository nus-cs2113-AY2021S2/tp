package seedu.duke.common;

import static seedu.duke.common.Constant.FILE_DELIMITER_CHAR;

public class Messages {
    public static final String ERROR_NON_NUM_AMOUNT = "Amount contains a non-numeric value.";
    public static final String ERROR_FUTURE_ISSUE_DATE = "Issue date cannot be in the future!";
    public static final String ERROR_INVALID_OPTION_P = "option -p not valid for this record type.";
    public static final String ERROR_MISSING_RECORD_OPTIONS = "missing option: {-e | -l | -s}";
    public static final String ERROR_MISSING_RECORD_OPTIONS_2 = "missing option: {-e | -l | -s | -a}";
    public static final String ERROR_INVALID_BORROWER_NAME = "Borrower name cannot contain '"
            + FILE_DELIMITER_CHAR + "' as input.";
    public static final String ERROR_INVALID_DATE_SF = "input \"%s\" is an invalid date.";
}
