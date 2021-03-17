package seedu.duke.ui;

import java.util.Scanner;

public class Ui {

    static Scanner scanner = new Scanner(System.in);
    static String LINEBREAK = "____________________________________________________________\n";
    static String LOGO = " ____        _        \n"
            + "|  _ \\ _   _| | _____ \n"
            + "| | | | | | | |/ / _ \\\n"
            + "| |_| | |_| |   <  __/\n"
            + "|____/ \\__,_|_|\\_\\___|\n";

    public static String scanInput() {
        String input = scanner.nextLine().trim();
        return input;
    }

    public static void printPatientHelpList() {
        System.out.println("Here is a list of patient commands: ");
        System.out.println("\"help\" brings up this list of commands!");
        System.out.println("\"add [Patient ID] [Name] [Age] [Gender] [Illness] [Drugs Needed]\" adds a patient to the patient list!");
        System.out.println("\"list\" brings up the list of all current patients!");
        System.out.println("\"delete [index in list]\" deletes the patient at that index from the list!");
        System.out.println("\"find [keyword or phrase]\" finds a keyword or phrase and shows its corresponding patient!");
        System.out.println("\"return\" returns you to the Start Menu!");
    }

    public static void unrecognizedCommandMessage() {
        System.out.println("OOPS! I cant recognize that command! ");
    }

    public static void invalidFormatMessage() {
        System.out.println("OOPS! Please check to see if your command is properly formatted! ");
    }

    public void showLine() {
        System.out.println(LINEBREAK);
    }

    public static void printWelcome() {
        System.out.println("Hello from\n" + LOGO + "What is your name?");
    }

    public static void printUserName(String userName) {
        System.out.println("Hello " + userName + "!");
    }

    public static void printStartMenu() {
        System.out.println("Start Menu");
        System.out.println("Commands:");
        System.out.println("\"1\" to go to staff");
        System.out.println("\"2\" to go to patients");
        System.out.println("\"3\" to go to doctors appointments");
        System.out.println("\"4\" to go to nurse schedules");
        System.out.println("\"5\" to go to drugs inventory");
        System.out.println("\"help\" to see what each of the sections contain");
        System.out.println("\"bye\" to exit the application");
    }

    public static void patientAddedMessage(String name) {
        System.out.println(name + " is now a patient here!");
    }

    public static void printPatientList(int i, String patientDetails) {
        System.out.println(i + "." + patientDetails);
    }

    public static void emptyPatientListMessage() {
        System.out.println("OOPS! It seems like you have no patients in the list now!");
    }

    public static void notEmptyPatientListMessage() {
        System.out.println("Here are the patients currently in the list!");
    }

    public static void incorrectInput() {
        System.out.println("OOPS! Please check to see if your command is properly formatted! ");
    }

    public static void deletePatientMessage(String deletedPatientDetails, int inputInt) {
        System.out.println("Noted. I've removed this patient: \n" + deletedPatientDetails);
        System.out.println("Now you have " + inputInt + " patients in the list");
    }

    public static void printGoodbye() {
        System.out.println("Goodbye! Have a nice day!");
    }

    public void patientCommandWelcome() {
        System.out.println("Welcome to the patient Commands section!");
        System.out.println("Here is a list of patient commands: ");
        System.out.println("\"add [Patient ID] [Name] [Age] [Gender] [Illness] [Drugs Needed]\" adds a patient to the patient list!");
        System.out.println("\"list\" brings up the list of all current patients!");
        System.out.println("\"delete [index in list]\" deletes the patient at that index from the list!");
        System.out.println("\"find [keyword or phrase]\" finds a keyword or phrase and shows its corresponding patient!");
        System.out.println("\"help\" brings up a list of commands!");
        System.out.println("\"return\" returns you to the Start Menu!");
    }

    public void returningToStartMenuMessage() {
        System.out.println("Returning to start Menu!");
    }

    public void showLoadingError() {
        System.out.println("OOPS! There was an error loading the file!");
    }
}
