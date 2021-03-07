package ui;

import canteens.Canteen;

import java.util.ArrayList;
import java.util.Scanner;

public class Ui {
    private static final String LINESPACING = "-----------------------";
    private static Scanner userInputScanner;
    private static String line;

    public Ui() {
        userInputScanner = new Scanner(System.in);
    }

    public static String readCommand() {
        line = userInputScanner.nextLine();
        return line;
    }

    public void showWelcome() {
        System.out.println(LINESPACING);
        System.out.println("Welcome to our amazing canteen review application!!");
        System.out.println(LINESPACING);
        System.exit(0);
    }

    public void showGoodbye() {
        System.out.println(LINESPACING);
        System.out.println("Thank you for using our application! See you again!");
        System.out.println(LINESPACING);
    }

    public void showGetCanteen(ArrayList<Canteen> canteens) {
        System.out.println(LINESPACING);
        System.out.println("Please select a canteen:");
        for (int i = 0; i < canteens.size(); i++) {
            System.out.printf("%s.", i + 1);
            canteens.get(i).displayCanteen();
        }
        System.out.println(LINESPACING);
    }

    public void showError() {
        System.out.println("Error with input");
    }
}
