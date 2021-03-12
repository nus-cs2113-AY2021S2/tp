package seedu.duke.ui;

import seedu.duke.record.RecordList;
import seedu.duke.record.Record;
import seedu.duke.record.Expense;
import seedu.duke.record.Saving;
import seedu.duke.record.Loan;

import java.io.InputStream;
import java.util.Scanner;

public class Ui {
    private static final String logo = "=========================================================\n"
            + "||    $$$$$$  $$$$$$  $$    $$  $$    $$   $$    $$    ||\n"
            + "||    $$        $$    $$$   $$  $$    $$    $$  $$     ||\n"
            + "||    $$$$$$    $$    $$ $$ $$  $$    $$      $$       ||\n"
            + "||    $$        $$    $$   $$$  $$    $$    $$  $$     ||\n"
            + "||    $$      $$$$$$  $$    $$   $$$$$$    $$    $$    ||\n"
            + "=========================================================\n";

    protected static final String DIVIDER = "=========================================================";
    private static final String MESSAGE_GREETING = "";
    private static final String MESSAGE_GOODBYE = "HUAT AH!";
    private static final String MESSAGE_LOADING = "Loading from save... ";
    private static final String MESSAGE_EXPENSE_SUCCESSFULLY_ADDED = "Expense has been added...";
    private static final String MESSAGE_LOAN_SUCCESSFULLY_ADDED = "Loan has been added...";
    private static final String MESSAGE_SAVING_SUCCESSFULLY_ADDED = "Saving has been added...";
    private static final String MESSAGE_TOTAL_EXPENSE = "The total amount for expense is ";
    private static final String MESSAGE_TOTAL_LOAN = "The total amount for loan is ";
    private static final String MESSAGE_TOTAL_SAVING = "The total amount for saving is ";


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
        printIndex(formattedIndex);
        System.out.println(recordAdded);
        System.out.println();
        System.out.println(DIVIDER);
    }

    public String getUserInput() {
        System.out.print(FINUX_PREFIX + " ");
        String userInput = input.nextLine().strip();
        return userInput;
    }

    public void printWelcomeMessage() {
        System.out.println(logo);
        System.out.println(MESSAGE_LOADING + fileLoadStatus());
    }

    public void printGoodByeMessage() {
        System.out.println(DIVIDER);
        System.out.println();
        System.out.println(MESSAGE_GOODBYE);
        System.out.println();
        System.out.println(DIVIDER);
    }

    public void printMessage(String message) {
        System.out.println(DIVIDER);
        System.out.println(message);
        System.out.println(DIVIDER);
    }

    private String fileLoadStatus() {
        return "Successful";
    }

    public void printExpenses(RecordList recordList) {
        System.out.println(DIVIDER);
        System.out.println("Here is your Expense list:" + "\n");
        for (int i = 0; i < recordList.getRecordCount(); i++) {
            Record currentRecord = recordList.getRecordAt(i);
            if (currentRecord instanceof Expense) {
                printIndex(i);
                System.out.println(currentRecord);
            }
        }
        System.out.println(DIVIDER);
    }

    public void printLoans(RecordList recordList) {
        System.out.println(DIVIDER);
        System.out.println("Here is your Loan list:" + "\n");
        for (int i = 0; i < recordList.getRecordCount(); i++) {
            Record currentRecord = recordList.getRecordAt(i);
            if (currentRecord instanceof Loan) {
                printIndex(i);
                System.out.println(currentRecord);
            }
        }
        System.out.println(DIVIDER);
    }

    public void printSavings(RecordList recordList) {
        System.out.println(DIVIDER);
        System.out.println("Here is your Saving list:" + "\n");
        for (int i = 0; i < recordList.getRecordCount(); i++) {
            Record currentRecord = recordList.getRecordAt(i);
            if (currentRecord instanceof Saving) {
                printIndex(i);
                System.out.println(currentRecord);
            }
        }
        System.out.println(DIVIDER);
    }

    public void printTotalAmountExpense(RecordList recordList) {
        System.out.println(DIVIDER);
        double totalAmount = 0;
        for (int i = 0; i < recordList.getRecordCount(); i++) {
            Record currentRecord = recordList.getRecordAt(i);
            if (currentRecord instanceof Expense) {
                totalAmount = totalAmount + currentRecord.getAmount();
            }
        }
        System.out.println(MESSAGE_TOTAL_EXPENSE + totalAmount);
        System.out.println(DIVIDER);
    }

    public void printTotalAmountLoan(RecordList recordList) {
        System.out.println(DIVIDER);
        double totalAmount = 0;
        for (int i = 0; i < recordList.getRecordCount(); i++) {
            Record currentRecord = recordList.getRecordAt(i);
            if (currentRecord instanceof Loan) {
                totalAmount = totalAmount + currentRecord.getAmount();
            }
        }
        System.out.println(MESSAGE_TOTAL_LOAN + totalAmount);
        System.out.println(DIVIDER);
    }

    public void printTotalAmountSaving(RecordList recordList) {
        System.out.println(DIVIDER);
        double totalAmount = 0;
        for (int i = 0; i < recordList.getRecordCount(); i++) {
            Record currentRecord = recordList.getRecordAt(i);
            if (currentRecord instanceof Saving) {
                totalAmount = totalAmount + currentRecord.getAmount();
            }
        }
        System.out.println(MESSAGE_TOTAL_SAVING + totalAmount);
        System.out.println(DIVIDER);
    }

    public void printIndex(int index) {
        int formattedIndex = index + 1;
        System.out.print(formattedIndex + ". ");
    }
}
