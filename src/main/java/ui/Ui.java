package ui;

import canteens.Canteen;
import menus.Menu;

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
        System.out.println("You are now viewing canteen The Deck");
        System.out.println(LINESPACING);
    }

    public void showGoodbye() {
        System.out.println(LINESPACING);
        System.out.println("Thank you for using our application! See you again!");
        System.out.println(LINESPACING);
    }

    public void showError(String errorMessage) {
        System.out.println(errorMessage);
    }

    public void showDisplayStoreMessage() {
        System.out.println("Here's a list of the stores in the canteen: The Deck");
    }

    public void showDisplayMenu(String storeName, ArrayList<Menu> menus) {
        System.out.println("Here are the menus of the " + storeName + ":");
        for (Menu menuItem: menus) {
            System.out.println(menuItem.toString());
        }
    }
}
