package ui;

import canteens.Canteen;
import menus.Menu;
import reviews.Review;
import stores.Store;

import java.util.ArrayList;
import java.util.Scanner;

public class Ui {
    public static final String LINESPACING = "====================================================";
    private static Scanner userInputScanner;
    private static String line;

    public Ui() {
        userInputScanner = new Scanner(System.in);
    }

    public void showLogo() {
        System.out.println(" _    _   _    _   ______     ______   _____   _____   ____   \n"
                + "|  \\ | | | |  | | |  ____|   |  ____| |  _  | |  _  | |  _ \\  \n"
                + "| |\\\\| | | |  | | | |____    | |___   | | | | | | | | | | | |\n"
                + "| | \\  | | |__| |  ____| |   |  ___|  | |_| | | |_| | | |_| |  \n"
                + "|_|  \\_| |______| |______|   |__|     |_____| |_____| |____/\n"
                + " _____   _____  __      __  _   _____   _       _\n"
                + "|  _  \\ | ____| \\ \\    / / | | | ____| | |  _  | |\n"
                + "| |_|_/ | |___   \\ \\  / /  | | | |___  | | | | | |\n"
                + "| |\\ \\  | |___    \\ \\/ /   | | | |___  | \\_| |_/ |\n"
                + "|_| \\_\\ |_____|    \\__/    |_| |_____| |_________| \n"
                + "Welcome to NUS FOOD REVIEW");
    }

    public static String readCommand() {
        try {
            line = userInputScanner.nextLine();
        } catch (NullPointerException e) {
            System.out.println("Input cannot be empty.");
        }
        return line;
    }

    public void userShowWelcome() {
        System.out.println(LINESPACING);
        System.out.println("Welcome to our amazing canteen review application!!");
        System.out.println("You are now viewing canteen: The Deck");
        System.out.println(LINESPACING);
    }

    public void adminShowWelcome() {
        System.out.println(LINESPACING);
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
        System.out.println("1. View canteens");
        System.out.println("2. Add canteen");
        System.out.println("3. Add store in canteen");
        System.out.println("4. Delete canteen");
        System.out.println("5. Delete store in canteen");
        System.out.println("6. Exit");
        System.out.println(LINESPACING);
    }

    public void printStoreAdded(String storeName) {
        System.out.println(LINESPACING);
        System.out.println("Got it ! Successfully added " + storeName + " to The Deck");
        System.out.println(LINESPACING);
    }

    public static void showAddStore() {
        System.out.println("Please enter the new store's name");
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

    public void showDisplaySelectStores(Canteen canteen) {
        if (canteen.getNumStores() <= 0) {
            System.out.println("There are currently no stores in " + canteen.getCanteenName() + "!");
        }
        System.out.println(LINESPACING);
        ArrayList<Store> stores = canteen.getStores();
        System.out.println("Here's a list of the stores in the canteen: " + canteen.getCanteenName());
        System.out.println("Please select one of the following stores:");
        for (int i = 0; i < stores.size(); i++) {
            System.out.print((i + 1) + ". ");
            stores.get(i).displayStore();
        }
        System.out.println(Ui.LINESPACING);
    }

    public static void showDisplayStores(Canteen canteen) {
        if (canteen.getNumStores() <= 0) {
            System.out.println("There are currently no stores in " + canteen.getCanteenName() + "!");
        }
        System.out.println(LINESPACING);
        ArrayList<Store> stores = canteen.getStores();
        System.out.println("Here's a list of the stores in the canteen: " + canteen.getCanteenName());
        for (int i = 0; i < stores.size(); i++) {
            System.out.print((i + 1) + ". ");
            stores.get(i).displayStore();
        }
        System.out.println(Ui.LINESPACING);
    }

    public void showDisplayMenu(String storeName, ArrayList<Menu> menus) {
        System.out.println(LINESPACING);
        System.out.println("Here are the menus of the " + storeName + ":");
        for (Menu menuItem: menus) {
            System.out.println(menuItem.toString());
        }
    }
    
    public static void showDisplaySelectCanteens(ArrayList<Canteen> canteens) {
        System.out.println(LINESPACING);
        System.out.println("Select one of the following NUS canteens:");
        for (int i = 0; i < canteens.size(); i++) {
            System.out.println(i + 1 + ". " + canteens.get(i).getCanteenName());
        }
        System.out.println(LINESPACING);
    }

    public void showDisplayCanteens(ArrayList<Canteen> canteens) {
        System.out.println(LINESPACING);
        System.out.println("Here is a list of NUS canteens:");
        for (int i = 0; i < canteens.size(); i++) {
            System.out.println(i + 1 + ". " + canteens.get(i).getCanteenName());
        }
        System.out.println(LINESPACING);
    }

    public void showReviews(String storeName, ArrayList<Review> reviews,double averageRating) {
        System.out.println(LINESPACING);
        System.out.println("Here are the reviews of the " + storeName + ":");
        System.out.println("Recommended: " + Math.round(averageRating * 100.0) / 100.0 + "/5.0");
        System.out.println(LINESPACING);
        int count = 1;
        for (Review review: reviews) {
            System.out.println(count++ + ")" + review.toString());
            System.out.println("Customer rating: " + review.getRating());
            System.out.println(LINESPACING);
        }

    }

    public void showStoreOptions(String canteenName, String storeName) {
        System.out.println(LINESPACING);
        System.out.println("You are now viewing: " + canteenName + ", " + storeName);
        System.out.println("Enter 'menu' to view sample menu");
        System.out.println("Enter 'reviews' to show reviews of " + storeName);
        System.out.println("Enter 'add' to add a new review");
        System.out.println("Enter 'home' to select a new canteen");
        System.out.println("Enter 'list' to select a new store");
        System.out.println("Enter 'exit' to exit the application");
        System.out.println(LINESPACING);
    }

    public static void enterReview() {
        System.out.println(LINESPACING);
        System.out.println("Please type your review:");
    }

    public static void enterRating() {
        System.out.println(LINESPACING);
        System.out.println("Please give your rating from 1 to 5");
    }

    public static void reviewAdded() {
        System.out.println(LINESPACING);
        System.out.println("Review successfully added!");
    }

    public static void showAddCanteen() {
        System.out.println(LINESPACING);
        System.out.println("Please type the name of the new canteen:");
    }

    public void showAddCanteenSuccess(String canteenName) {
        System.out.println("The canteen '" + canteenName + "' has been added!");
    }
}
