package seedu.hdbuy.ui;

import seedu.hdbuy.data.QueryKey;

import java.util.HashMap;
import java.util.Scanner;

public class TextUi {

    /** Number of dashes for the separator */
    private static final int SEPARATOR_LENGTH = 80;

    public void showSeparator() {
        for(int i = 0; i < SEPARATOR_LENGTH; i++) {
            System.out.print('-');
        }
        System.out.print('\n');
    }

    public void showWelcome() {
        showSeparator();
        System.out.print("Welcome to HDBuy!\nHow may I help you today?\n");
        showSeparator();
    }

    public void showExit() {
        System.out.print("HDBuy Bye Bye!\n");
    }

    public String readCommand() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

    public void showInvalidInput(String input) {
        System.out.print("I'm sorry. \"" + input + "\" is not a valid command.\n");
    }

    public void showHelp() {
        System.out.print("*HELP PLACEHOLDER*\n");
    }

    public void showParameters(HashMap<QueryKey, String> inputs) {
        System.out.print("Parameters:\n" + inputs + "\n");
    }

    public void showInvalidFilter(String criteria) {
        System.out.print("\"" + criteria + "\" is not a valid filter.\n");
    }
}
