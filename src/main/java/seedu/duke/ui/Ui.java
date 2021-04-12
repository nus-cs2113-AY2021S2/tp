package seedu.duke.ui;

import seedu.duke.record.RecordList;
import seedu.duke.record.Record;
import seedu.duke.record.Expense;
import seedu.duke.record.Saving;
import seedu.duke.record.Loan;

import java.io.InputStream;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Handles all user interactions and printing of text to the console.
 */
public class Ui {
    protected static final String DIVIDER = "=====================================================================";
    private static final String logo = "=====================================================================\n"
            + "||          $$$$$$  $$$$$$  $$    $$  $$    $$   $$    $$          ||\n"
            + "||          $$        $$    $$$   $$  $$    $$    $$  $$           ||\n"
            + "||          $$$$$$    $$    $$ $$ $$  $$    $$      $$             ||\n"
            + "||          $$        $$    $$   $$$  $$    $$    $$  $$           ||\n"
            + "||          $$      $$$$$$  $$    $$   $$$$$$    $$    $$          ||\n"
            + "=====================================================================";

    private static final String MESSAGE_GOODBYE =
            "=====================================================================\n"
            + "||   $$  $$  $$    $$   $$$$$   $$$$$$$$     $$$$$   $$  $$  $$    ||\n"
            + "||   $$  $$  $$    $$  $$   $$     $$       $$   $$  $$  $$  $$    ||\n"
            + "||   $$$$$$  $$    $$  $$$$$$$     $$       $$$$$$$  $$$$$$  $$    ||\n"
            + "||   $$  $$  $$    $$  $$   $$     $$       $$   $$  $$  $$        ||\n"
            + "||   $$  $$   $$$$$$   $$   $$     $$       $$   $$  $$  $$  $$    ||\n"
            + "=====================================================================\n";

    private static final String ERROR_PREFIX = "ERROR: ";

    private static final String MESSAGE_LOADING = "Loading from save file... ";
    private static final String MESSAGE_FILE_CREATION_SUCCESS = "New save file created!";
    private static final String MESSAGE_EXPENSE_SUCCESSFULLY_ADDED = "Expense has been added...";
    private static final String MESSAGE_LOAN_SUCCESSFULLY_ADDED = "Loan has been added...";
    private static final String MESSAGE_SAVING_SUCCESSFULLY_ADDED = "Saving has been added...";
    private static final String MESSAGE_TOTAL_EXPENSE = "The total amount for expense is ";
    private static final String MESSAGE_TOTAL_LOAN = "The total amount for loan is ";
    private static final String MESSAGE_TOTAL_SAVING = "The total amount for saving is ";
    private static final String MESSAGE_FAILED_INIT = "File or contents corrupted! Bad Init!\nSystem will now exit!";


    /**
     * Decorative prefix for the FINUX Interface.
     */
    private static final String FINUX_PREFIX = "$$";

    private final Scanner input;

    public Ui() {
        this(System.in);
    }

    public Ui(InputStream in) {
        this.input = new Scanner(in);
    }

    /**
     * Prints the initialization error with the application UI.
     */
    public void printInitError() {
        System.out.println(DIVIDER);
        System.out.println();
        System.out.println(MESSAGE_FAILED_INIT);
        System.out.println();
        System.out.println(DIVIDER);
    }

    /**
     * Prints the success message when the file is created.
     */
    public static void printSuccessfulFileCreation() {
        System.out.println(DIVIDER);
        System.out.println(MESSAGE_FILE_CREATION_SUCCESS);
        System.out.println(DIVIDER);
    }

    /**
     * Prints an error prefix with the error message.
     */
    public static void printError(String errorMessage) {
        System.out.println(DIVIDER);
        System.out.println(ERROR_PREFIX + errorMessage);
        System.out.println(DIVIDER);
    }

    /**
     * Prints the current input that is added into the RecordList.
     *
     * @param recordAdded is the current record that is added into the RecordList.
     * @param index is the index of the current record that is added into the RecordList.
     */
    public void printSuccessfulAdd(Record recordAdded, int index) {
        System.out.println(DIVIDER);
        System.out.println();
        if (recordAdded instanceof Expense) {
            System.out.println(MESSAGE_EXPENSE_SUCCESSFULLY_ADDED);
        } else if (recordAdded instanceof Loan) {
            System.out.println(MESSAGE_LOAN_SUCCESSFULLY_ADDED);
        } else {
            System.out.println(MESSAGE_SAVING_SUCCESSFULLY_ADDED);
        }
        int formattedIndex = index - 1;
        System.out.println();
        System.out.println(getId(formattedIndex) + recordAdded);
        System.out.println();
        System.out.println(DIVIDER);
    }

    /**
     * Prints the FINUX CLI prefix and gets the user input.
     *
     * @return the current user input.
     */
    public String getUserInput() {
        System.out.print(FINUX_PREFIX + " ");
        try {
            return input.nextLine().strip();
        } catch (NoSuchElementException e) {
            return "exit";
        }
    }

    /**
     * Prints the FINUX welcome message with the FINUX logo.
     */
    public void printWelcomeMessage() {
        System.out.println(logo);
        System.out.println(DIVIDER);
        System.out.println(MESSAGE_LOADING);
        System.out.println(DIVIDER);
    }

    /**
     * Prints the exit message.
     */
    public void printGoodByeMessage() {
        System.out.println(MESSAGE_GOODBYE);
    }

    /**
     * Prints the message parsed into it with the dividers.
     *
     * @param message is the concatenated message and the Record object string.
     */
    public void printMessage(String message) {
        System.out.println(DIVIDER);
        System.out.println(message);
        System.out.println(DIVIDER);
    }

    /**
     * Prints the entire list of all Expenses from the RecordList.
     *
     * @param recordList is the RecordList of all Records.
     */
    public void printExpenses(RecordList recordList) {
        System.out.println(DIVIDER);
        System.out.println("Here is your Expense list:");
        for (int i = 0; i < recordList.getRecordCount(); i++) {
            Record currentRecord = recordList.getRecordAt(i);
            if (currentRecord instanceof Expense) {
                System.out.println(getId(i) + currentRecord);
            }
        }
        System.out.println(DIVIDER);
    }

    /**
     * Prints the entire list of all Loans from the RecordList.
     *
     * @param recordList is the RecordList of all Records.
     */
    public void printLoans(RecordList recordList) {
        System.out.println(DIVIDER);
        System.out.println("Here is your Loan list:");
        for (int i = 0; i < recordList.getRecordCount(); i++) {
            Record currentRecord = recordList.getRecordAt(i);
            if (currentRecord instanceof Loan) {
                System.out.println(getId(i) + currentRecord);
            }
        }
        System.out.println(DIVIDER);
    }

    /**
     * Prints the entire list of all Savings from the RecordList.
     *
     * @param recordList is the RecordList of all Records.
     */
    public void printSavings(RecordList recordList) {
        System.out.println(DIVIDER);
        System.out.println("Here is your Saving list:");
        for (int i = 0; i < recordList.getRecordCount(); i++) {
            Record currentRecord = recordList.getRecordAt(i);
            if (currentRecord instanceof Saving) {
                System.out.println(getId(i) + currentRecord);
            }
        }
        System.out.println(DIVIDER);
    }

    /**
     * Prints the entire list of all Records from the RecordList.
     *
     * @param recordList is the RecordList of all Records.
     */
    public void printAllRecords(RecordList recordList) {
        System.out.println(DIVIDER);
        System.out.println("Here is you Records list:");
        for (int i = 0; i < recordList.getRecordCount(); i++) {
            Record currentRecord = recordList.getRecordAt(i);
            System.out.println(getId(i) + currentRecord);
        }
        System.out.println(DIVIDER);
    }

    /**
     * Prints the total expenses in 2 decimal place.
     *
     * @param recordList contains the full list of records.
     */
    public void printTotalAmountExpense(RecordList recordList) {
        System.out.println(DIVIDER);
        BigDecimal totalAmount = new BigDecimal("0");
        for (int i = 0; i < recordList.getRecordCount(); i++) {
            Record currentRecord = recordList.getRecordAt(i);
            if (currentRecord instanceof Expense) {
                totalAmount = totalAmount.add(currentRecord.getAmount());
            }
        }
        assert !(totalAmount.compareTo(BigDecimal.ZERO) == -1) : "Expenses cannot be negative!";
        System.out.println(MESSAGE_TOTAL_EXPENSE + NumberFormat.getCurrencyInstance(Locale.US).format(totalAmount));
        System.out.println(DIVIDER);
    }

    /**
     * Prints the total loan in 2 decimal place.
     *
     * @param recordList contains the full list of records.
     */
    public void printTotalAmountLoan(RecordList recordList) {
        System.out.println(DIVIDER);
        BigDecimal totalAmount = new BigDecimal("0");
        for (int i = 0; i < recordList.getRecordCount(); i++) {
            Record currentRecord = recordList.getRecordAt(i);
            if (currentRecord instanceof Loan && !((Loan) currentRecord).isReturn()) {
                totalAmount = totalAmount.add(currentRecord.getAmount());
            }
        }
        assert !(totalAmount.compareTo(BigDecimal.ZERO) == -1) : "Loans cannot be negative!";
        System.out.println(MESSAGE_TOTAL_LOAN + NumberFormat.getCurrencyInstance(Locale.US).format(totalAmount));
        System.out.println(DIVIDER);
    }

    /**
     * Prints the total saving in 2 decimal place.
     *
     * @param recordList contains the full list of records.
     */
    public void printTotalAmountSaving(RecordList recordList) {
        System.out.println(DIVIDER);
        BigDecimal totalAmount = new BigDecimal("0");
        for (int i = 0; i < recordList.getRecordCount(); i++) {
            Record currentRecord = recordList.getRecordAt(i);
            if (currentRecord instanceof Saving) {
                totalAmount = totalAmount.add(currentRecord.getAmount());
            }
        }
        assert !(totalAmount.compareTo(BigDecimal.ZERO) == -1) : "Savings cannot be negative!";
        System.out.println(MESSAGE_TOTAL_SAVING + NumberFormat.getCurrencyInstance(Locale.US).format(totalAmount));
        System.out.println(DIVIDER);
    }

    /**
     * Prints the amount of all record type in 2 decimal place.
     *
     * @param recordList contains the full list of records.
     */
    public void printTotalAmountAllType(RecordList recordList) {
        System.out.println(DIVIDER);
        BigDecimal totalExpense = new BigDecimal("0");
        BigDecimal totalLoan = new BigDecimal("0");
        BigDecimal totalSaving = new BigDecimal("0");
        for (int i = 0; i < recordList.getRecordCount(); i++) {
            Record currentRecord = recordList.getRecordAt(i);
            if (currentRecord instanceof Expense) {
                totalExpense = totalExpense.add(currentRecord.getAmount());
            }
            if (currentRecord instanceof Loan && !((Loan) currentRecord).isReturn()) {
                totalLoan = totalLoan.add(currentRecord.getAmount());
            }
            if (currentRecord instanceof Saving) {
                totalSaving = totalSaving.add(currentRecord.getAmount());
            }
        }
        assert !(totalExpense.compareTo(BigDecimal.ZERO) == -1) : "Expenses cannot be negative!";
        assert !(totalLoan.compareTo(BigDecimal.ZERO) == -1) : "Loans cannot be negative!";
        assert !(totalSaving.compareTo(BigDecimal.ZERO) == -1) : "Savings cannot be negative!";
        System.out.println(MESSAGE_TOTAL_EXPENSE + NumberFormat.getCurrencyInstance(Locale.US).format(totalExpense));
        System.out.println(MESSAGE_TOTAL_LOAN + NumberFormat.getCurrencyInstance(Locale.US).format(totalLoan));
        System.out.println(MESSAGE_TOTAL_SAVING + NumberFormat.getCurrencyInstance(Locale.US).format(totalSaving));
        System.out.println(DIVIDER);
    }

    /**
     * Prints the commonly understood index of the record.
     *
     * @param index is the index of the record.
     */
    public String getId(int index) {
        int formattedIndex = index + 1;
        return "[ID: " + formattedIndex + "] ";
    }
}
