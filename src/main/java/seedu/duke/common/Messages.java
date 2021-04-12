package seedu.duke.common;

import static seedu.duke.common.Constant.FILE_DELIMITER_CHAR;

/**
 * Container for most user visible messages.
 */
public class Messages {
    public static final String ERROR_NON_NUM_AMOUNT = "Amount contains a non-numeric value.";
    public static final String ERROR_FUTURE_ISSUE_DATE = "Issue date cannot be in the future!";
    public static final String ERROR_INVALID_OPTION_P = "option -p not valid for this record type.";
    public static final String ERROR_MISSING_RECORD_OPTIONS = "missing option: {-e | -l | -s}";
    public static final String ERROR_MISSING_RECORD_OPTIONS_2 = "missing option: {-e | -l | -s | -a}";
    public static final String ERROR_INVALID_BORROWER_NAME = "Borrower name cannot contain '"
            + FILE_DELIMITER_CHAR + "' as input.";
    public static final String ERROR_INVALID_DATE_SF = "input \"%s\" is an invalid date.";
    public static final String ERROR_SAVE_DATA = "Error in saving data!";
    public static final String ERROR_FILE_CREATION = "File creation unsuccessful!";
    public static final String ERROR_FILE_INPUT = "Invalid File Inputs!";
    public static final String ERROR_AMOUNT_LESS_THAN_ZERO = "amount must be greater than 0.";
    public static final String ERROR_AMOUNT_MORE_THAN_2DP = "amount should be at most 2 decimal place.";
    public static final String ERROR_DOLLAR_AMOUNT_MISSING = "please enter the dollar amount.";
    public static final String ERROR_CENT_AMOUNT_MISSING = "please enter the cent amount.";
    public static final String ERROR_MISSING_ID_OPTION = "missing option: -i";
    public static final String ERROR_INCORRECT_ID_FRONT = "ID: \"";
    public static final String ERROR_INCORRECT_ID_FRONT2 = "\"";
    public static final String ERROR_INCORRECT_ID_DATA_TYPE = "\" is not an ID of Loan!";
    public static final String ERROR_INCORRECT_ID_NON_INTEGER = "\" is not an integer!";
    public static final String ERROR_INCORRECT_ID_OUT_OF_BOUNDS = "\" is out of bounds!";
    public static final String MESSAGE_REMOVE_SUCCESS = "This record will be removed:";
    public static final String ERROR_RETURN_DATE_BEFORE_ISSUE_DATE = "Return date cannot be before Loan's issue date!";
    public static final String ERROR_RETURN_DATE_FUTURE_DATE = "Return date cannot be in the future!";
    public static final String MESSAGE_RETURN_SUCCESS = "Loan marked as returned:";
}
