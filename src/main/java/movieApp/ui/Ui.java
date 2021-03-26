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
                "___  ___           _       ___                    \n" +
                "|  \\/  |          (_)     / _ \\                 \n" +
                "| .  . | _____   ___  ___/ /_\\ \\_ __  _ __      \n" +
                "| |\\/| |/ _ \\ \\ / / |/ _ \\  _  | '_ \\| '_ \\ \n" +
                "| |  | | (_) \\ V /| |  __/ | | | |_) | |_) |     \n" +
                "\\_|  |_/\\___/ \\_/ |_|\\___\\_| |_/ .__/| .__/  \n" +
                "                               | |   | |          \n" +
                "                               |_|   |_|          \n";

        System.out.println(LOGO);
        getOption();
    }

    public static void doOption(int option) {
        ArrayList<Movie> MovieList = new ArrayList<>(Database.MovieDatabase);

        switch(option){
        case 1:
            Movie movie = MovieFilter.filter(MovieList, Database.CineplexDatabase);
            if (movie != null) {
                MovieMenu.movieAction(movie);
            }
            break;
        case 2:
            exit();
        default:
            System.out.println("Invalid input. Please try again.");
            getOption();
        }
    }


    public static void exit() {
        System.out.println("\nThank you for your time.");
        System.out.println("Have a good day!");
        System.out.println("");
        System.out.println("System Exiting...");
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
                doOption(menu_choice);
            }
        }
        //return menu_choice;
    }
}
