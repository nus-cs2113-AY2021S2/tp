package seedu.duke.ui;

import seedu.duke.exceptions.staffexceptions.AbortException;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.*;

public class UI {
    static final int LARGE_NUMBER = 100;
    static final String UNKNOWN_COMMAND = "unknown";
    static Scanner scanner = new Scanner(System.in);
    static String LINEBREAK = "____________________________________________________________";
    static String LOGO = " __   __  ______  _______  _  ________  __   __  __  __  _______  __   __  _             __   \n"
            + "|  | |  ||   ___||   _   || ||___    _||  | |  ||  ||  ||   _   ||  | |  || | _   _     /  \\  \n"
            + "|  |_|  ||  |___ |  |_|  || |    |  |  |  |_|  ||  ||  ||  |_|  ||  | |  || || |_| |___/ / \\\\ \n"
            + "|   _   ||   ___||   _   || |    ||=|  |   _   |\\  \\/  /|   _   ||  | |  || ||_________  | | |\n"
            + "|  | |  ||  |___ |  | |  || |___ ||=|  |  | |  | \\    / |  | |  ||  |_|  || |_____     \\ \\ // \n"
            + "|__| |__||______||__| |__||_____||__|  |__| |__|  \\__/  |__| |__||_______||_______|     \\__/  \n";

    public static String scanInput() {
        return scanner.nextLine().trim();
    }
    public static String abortEnabledScanInput() throws AbortException {
        String input = scanner.nextLine().trim();
        if (input.equals("\\abort")) {
            throw new AbortException();
        }
        else {
            return input;
        }
    }
    public static String smartCommandRecognition(String[] commands, String input) {
        int diff = LARGE_NUMBER;
        int index = -1;
        for (int i = 0; i<commands.length; i++) {
            int temp = checkCommandDifference(commands[i], input);
            if (temp < diff) {
                diff = temp;
                index = i;
            }
        }
        if (diff == 0 || isTypo(commands[index])) {
            return commands[index];
        }
        return UNKNOWN_COMMAND;
    }

    public static boolean contains(char[] array, char input) {
        for (char c : array) {
            if (input == c) {
                return true;
            }
        }
        return false;
    }

    public static int checkCommandDifference(String expected, String actual) {
        char[] first = expected.toLowerCase().toCharArray();
        char[] second = actual.toLowerCase().toCharArray();
        Arrays.sort(first);
        Arrays.sort(second);
        int numDiff = 0;
        int lengthDiff = abs(first.length-second.length);
        if (lengthDiff > 2) {
            return LARGE_NUMBER;
        }
        int i = 0;
        if (second.length >= first.length) {
            while (i < first.length) {
                if (!contains(first, second[i])) {
                    numDiff++;
                }
                i++;
            }
        } else {
            while (i<second.length-1) {
                if (first[i] != (second[i]) && lengthDiff > 0) {
                    i++; numDiff++; lengthDiff--;
                    continue;
                } else if (first[i] != second[i]) {
                    numDiff++;
                }
                i++;
            }
        }
        return max(lengthDiff, numDiff);
    }

    public static void abortInputErrorMessage() {
        System.out.println("Input has been aborted");
    }
    public static void invalidCommandErrorMessage() {
        System.out.println("OOPS! I cant recognize that command! ");
    }

    public static void noInputErrorMessage() {
        System.out.println("Command is missing input parameter");
    }

    public static void noCommandErrorMessage() {
        System.out.println("OOPS! There is no command entered! ");
    }

    public static void invalidFormatErrorMessage() {
        System.out.println("OOPS! Please check to see if your command is properly formatted! ");
    }



    public static void showLine() {
        System.out.println(LINEBREAK);
    }

    public static void emptyLine() {
        System.out.print("\n");
    }

    public static void printWelcome() {
        System.out.println("Welcome to \n" + LOGO + "What is your name?");
        showLine();
    }

    public static void printUserName(String userName) {
        System.out.println("Hello " + userName + "!");
        showLine();
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

    public static void printGoodbye() {
        System.out.println("Goodbye! Have a nice day!");
    }

    public static void startMenuPrompt() {
        System.out.print("Start Menu --> ");
    }

    public static void userNamePrompt() {
        System.out.print("User Name --> ");
    }

    public static void returningToStartMenuMessage() {
        System.out.println("Returning to start menu!");
    }

    public void showLoadingError() {
        System.out.println("OOPS! There was an error loading the file!");
    }


    public static String prettyPrint(String string, int length) {
        return String.format("%1$-" + length + "s", string);
    }

    public static boolean isTypo(String command) {
        System.out.println("Do you mean \"" + command +"\" (y/n)");
        return scanInput().equals("y");
    }
}
