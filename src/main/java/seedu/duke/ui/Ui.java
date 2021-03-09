package seedu.duke.ui;

import seedu.duke.record.Record;

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

    private static final String DIVIDER = "=========================================================";
    private static final String MESSAGE_GREETING = "";
    private static final String MESSAGE_GOODBYE = "HUAT AH!";
    private static final String MESSAGE_LOADING = "Loading from save... ";
    private static final String MESSAGE_SUCCESSFULLY_ADDED = "Record has been added...";

    /** Decorative prefix for the FINUX Interface. */
    private static final String FINUX_PREFIX = "$$";

    private final Scanner input;

    public Ui() {
        this(System.in);
    }

    public Ui(InputStream in) {
        this.input = new Scanner(in);
    }

    public static void printSuccessfulAdd(Record recordToAdd) {
        System.out.println(DIVIDER);
        System.out.println();
        System.out.println(MESSAGE_SUCCESSFULLY_ADDED);
        System.out.println("\n" + recordToAdd.getDescription() + " " + recordToAdd.getAmount()
                + " " + recordToAdd.getIssueDate());
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
}
