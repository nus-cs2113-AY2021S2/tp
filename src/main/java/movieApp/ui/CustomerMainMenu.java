package movieApp.ui;

import movieApp.Movie;
import movieApp.user.User;
import movieApp.parser.MovieFilter;
import movieApp.command.MovieMenu;
import movieApp.storage.Database;

import java.util.ArrayList;
import java.util.Scanner;

public class CustomerMainMenu implements MainMenu{
	public static void displayMenu(int currentUserIndex, ArrayList<User> user){
		final String LOGO = "\n" +
				"___  ___           _       ___                    \n" +
				"|  \\/  |          (_)     / _ \\                 \n" +
				"| .  . | _____   ___  ___/ /_\\ \\_ __  _ __      \n" +
				"| |\\/| |/ _ \\ \\ / / |/ _ \\  _  | '_ \\| '_ \\ \n" +
				"| |  | | (_) \\ V /| |  __/ | | | |_) | |_) |     \n" +
				"\\_|  |_/\\___/ \\_/ |_|\\___\\_| |_/ .__/| .__/  \n" +
				"                               | |   | |          \n" +
				"                               |_|   |_|            ";

		System.out.println(LOGO);
		System.out.println("Welcome, " + user.get(currentUserIndex).getName());
		getOption(user.get(currentUserIndex));
	}

	public static void doOption(int option, User user) {
		ArrayList<Movie> MovieList = new ArrayList<>(Database.MovieDatabase);

		switch(option){
		case 1:
			Movie movie = MovieFilter.filter(MovieList, Database.CineplexDatabase);
			if (movie != null) {
				MovieMenu.movieAction(movie, user);
			}
			break;
		case 2:
			exit();
		default:
			System.out.println("Invalid input. Please try again.");
			getOption(user);
		}
	}


	public static void exit() {
		System.out.println("\nThank you for your time.");
		System.out.println("Have a good day!");
		System.out.println();
		System.out.println("System Exiting...");
		System.exit(0);
	}

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
		//return menu_choice;
	}
}
