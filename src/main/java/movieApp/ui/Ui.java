package movieApp.ui;

import movieApp.movie.Movie;
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

        int option = getOption();
        ArrayList<Movie> MovieList = new ArrayList<>(Database.MovieDatabase);

        if (option != 2) {
            Movie movie = MovieFilter.filter(MovieList, Database.CineplexDatabase);
            if (movie != null) MovieMenu.movieAction(movie);
        }

        System.out.println("\n\nThank you for your time.\nHave a good day!\n\nSystem Exiting...");
        System.exit(0);
    }

    public static int getOption() {
        int menu_choice = -1;
        Scanner sc = new Scanner(System.in);
        while ((menu_choice < 1) || (menu_choice > 2)) {
            System.out.println("======== Menu Choice =======");
            System.out.println(" 1 Select a movie\n 2 Exit\n============================\nPlease indicate your choice:");
            if (!sc.hasNextInt()) {
                System.out.println("Please input an integer.\n");
                sc.next();
                continue;
            }
            menu_choice = sc.nextInt();
            if ((menu_choice < 1) || (menu_choice > 2)) {
                System.out.println("Please input an integer between 1 and 2.\n");
            }
        }
        return menu_choice;
    }



}
