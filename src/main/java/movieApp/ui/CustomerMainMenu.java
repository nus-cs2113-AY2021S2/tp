package movieApp.ui;

import movieApp.Movie;
import movieApp.command.MovieMenu;
import movieApp.parser.MovieFilter;
import movieApp.storage.Database;
import movieApp.user.User;

import java.util.ArrayList;
import java.util.Scanner;

public class CustomerMainMenu implements MainMenu {

    /**
     * Display the main landing page a Customer will encounter when using the app
     * @param currentUserIndex the position in ArrayList of User objects, that corresponds to the current Customer
     * @param user the ArrayList of all User objects.
     */
    public static int displayMenu(int currentUserIndex, ArrayList<User> user) {
        System.out.println("\nWelcome, " + user.get(currentUserIndex).getName());
        getOption(user.get(currentUserIndex));
        return -1;
    }

    /**
     * Execute the option selected by the customer.
     * @param option the option number selected by the user.
     * @param user the user who selects the option.
     */
    public static void doOption(int option, User user) {
        boolean goBack = false;
        Movie movie;

        switch (option) {
            case 1:
                do {
                    ArrayList<Movie> movieList = new ArrayList<>(Database.MovieDatabase);
                    movie = MovieFilter.filter(movieList, Database.CineplexDatabase, user);
                    if (movie != null) {
                        goBack = MovieMenu.movieAction(movie, user);
                    }
                } while (goBack && movie != null);
                break;
            case 2:
                exit();
                break;
            default:
                System.out.println("Invalid input. Please try again.");
                getOption(user);
        }
    }

    /**
     * Display goodbye message and log the user out the program.
     */
    public static void exit() {
        System.out.println("\nThank you for your time.");
        System.out.println("Have a good day!");
        System.out.println();
        System.out.println("Logging out...");
    }

    /**
     * Prompt the user to input an option.
     * @param user the user who selects the option.
     */
    public static void getOption(User user) {
        int menu_choice = -1;
        Scanner sc = new Scanner(System.in);
        while (menu_choice != 2) {
            System.out.println("\n======== Menu Choice =======");
            System.out.println(" 1 View Movies");
            System.out.println(" 2 Exit");
            System.out.println("============================");
            System.out.println("Please indicate your choice:");

            if (!sc.hasNextInt()) {
                System.out.println("Please input an integer.\n");
                sc.next();
                continue;
            }
            menu_choice = sc.nextInt();
            if ((menu_choice < 1) || (menu_choice > 2)) {
                System.out.println("Please input an integer between 1 and 2.\n");
            } else {
                doOption(menu_choice, user);
            }
        }
    }
}
