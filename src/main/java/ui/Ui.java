package ui;

import canteens.Canteen;

import java.util.*;

public class Ui {
    private final static String LINESPACING = "-----------------------";
    private String line;
    private Scanner userInputScanner;

    public Ui() {
        userInputScanner = new Scanner(System.in);
    }

    public String readCommand() {
        line = userInputScanner.nextLine();
        return line;
    }

    public void showWelcome() {
        System.out.println(LINESPACING);
        System.out.println("Welcome to our amazing canteen review application!");
        System.out.println(LINESPACING);
    }

    public void showGoodbye() {
        System.out.println(LINESPACING);
        System.out.println("Thank you for using our application! See you again!");
        System.out.println(LINESPACING);
    }

    public void showGetCanteen(ArrayList<Canteen> canteens) {
        System.out.println(LINESPACING);
        System.out.println("Please select a canteen:");
        for (int i=0; i< canteens.size(); i++) {
            System.out.printf("%s.", i + 1);
            canteens.get(i).displayCanteen();
        }
        System.out.println(LINESPACING);
    }

    public void showError() {
        System.out.println("Error with input");
    }
}
