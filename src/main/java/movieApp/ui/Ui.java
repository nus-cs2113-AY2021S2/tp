package movieApp.ui;

import movieApp.Movie;
import movieApp.parser.MovieFilter;
import movieApp.command.MovieMenu;
import movieApp.storage.Database;

import java.util.ArrayList;
import java.util.Scanner;

public class Ui {
    public Ui(){
        final String LOGO = "\n" +
                "___  ___           _       ___              \n" +
                "|  \\/  |          (_)     / _ \\             \n" +
                "| .  . | _____   ___  ___/ /_\\ \\_ __  _ __  \n" +
                "| |\\/| |/ _ \\ \\ / / |/ _ \\  _  | '_ \\| '_ \\ \n" +
                "| |  | | (_) \\ V /| |  __/ | | | |_) | |_) |\n" +
                "\\_|  |_/\\___/ \\_/ |_|\\___\\_| |_/ .__/| .__/ \n" +
                "                               | |   | |    \n" +
                "                               |_|   |_|    ";

        System.out.println(LOGO);

        getOption();
        // go back

    }

    public static void doOption(int option) {
        ArrayList<Movie> MovieList = new ArrayList<>(Database.MovieDatabase);

        if (option == 1) {
            //MovieFilter.printMovieList(MovieList);
            Movie movie = MovieFilter.filter(MovieList, Database.CineplexDatabase);
            if (movie != null) MovieMenu.movieAction(movie);
        } else if (option == 2) {
            exit();
        }
    }


    public static void exit() {
        System.out.println("\n\nThank you for your time.\nHave a good day!\n\nSystem Exiting...");
        System.exit(0);
    }

    /**
     *
     * @return
     */
    public static void getOption() {
        int menu_choice = -1;
        Scanner sc = new Scanner(System.in);
        while (menu_choice != 2) {
            System.out.println("\n======== Menu Choice =======");
            System.out.println(" 1 View Movies\n " +
                                "2 Exit\n============================\nPlease indicate your choice:");
            if (!sc.hasNextInt()) {
                System.out.println("Please input an integer.\n");
                sc.next();
                continue;
            }
            menu_choice = sc.nextInt();
            if ((menu_choice < 1) || (menu_choice > 2)) {
                System.out.println("Please input an integer between 1 and 2.\n");
            } else {
                doOption(menu_choice);
            }
        }
        //return menu_choice;
    }
}
