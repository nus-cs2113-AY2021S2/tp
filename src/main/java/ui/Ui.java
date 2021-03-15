package ui;

import menus.Menu;
import reviews.Review;

import java.util.ArrayList;
import java.util.Scanner;

public class Ui {
    public static final String LINESPACING = "====================================================";
    private static Scanner userInputScanner;
    private static String line;

    public Ui() {
        userInputScanner = new Scanner(System.in);
    }

    public static String readCommand() {
        line = userInputScanner.nextLine();
        return line;
    }

    public void userShowWelcome() {
        System.out.println(LINESPACING);
        System.out.println("Welcome to our amazing canteen review application!!");
        System.out.println("You are now viewing canteen The Deck");
        System.out.println(LINESPACING);
    }

    public void adminShowWelcome() {
        System.out.println("Welcome Admin! ");
        System.out.println("Please enter your password: ");
        System.out.println(LINESPACING);
    }

    public void adminPasswordReenter() {
        System.out.println("Re-enter your password: ");
        System.out.println(LINESPACING);
    }

    public void showAdminVerified() {
        System.out.println(LINESPACING);
        System.out.println("Successfully verified!");
        System.out.println(LINESPACING);
    }

    public void showAdminOptions() {
        System.out.println("Please select task:");
        System.out.println("1) Add stores");
        System.out.println(LINESPACING);
    }

    public void printStoreAdded(String storeName) {
        System.out.println(LINESPACING);
        System.out.println("Got it ! Successfully added " + storeName + " to The Deck");
        System.out.println(LINESPACING);
    }

    public void showAddStore() {
        System.out.println(LINESPACING);
        System.out.println("Please enter store name");
        System.out.println(LINESPACING);
    }


    public void showLoginPage() {
        System.out.println(LINESPACING);
        System.out.println("Enter 1 for Public User");
        System.out.println("Enter 2 for Admin");
        System.out.println(LINESPACING);
    }

    public void showGoodbye() {
        System.out.println(LINESPACING);
        System.out.println("Thank you for using our application! See you again!");
        System.out.println(LINESPACING);
    }

    public void showError(String errorMessage) {
        System.out.println(LINESPACING);
        System.out.println(errorMessage);
        System.out.println(LINESPACING);
    }

    public void showDisplayStoreMessage() {
        System.out.println("Here's a list of the stores in the canteen: The Deck");
    }


    public void showDisplayMenu(String storeName, ArrayList<Menu> menus) {
        System.out.println("Here are the menus of the " + storeName + ":");
        for (Menu menuItem: menus) {
            System.out.println(menuItem.toString());
        }
        System.out.println(LINESPACING);
    }

    public void showReviews(String storeName, ArrayList<Review> reviews) {
        System.out.println("Here are the reviews of the " + storeName + ":");
        for (Review review: reviews) {
            System.out.println(review.toString());
        }
        System.out.println(LINESPACING);
    }
}
