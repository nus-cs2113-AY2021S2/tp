package movieApp.ui;

import movieApp.Movie;
import movieApp.command.MovieMenu;
import movieApp.parser.MovieFilter;
import movieApp.storage.Database;
import movieApp.user.User;

import java.util.ArrayList;
import java.util.Scanner;

public class AdminMainMenu implements MainMenu{

	private static int currentUserIndex;
	private static ArrayList<User> user;
	private static int functionSelection;
	private static int choice;
	private static Scanner sc = new Scanner(System.in);

	public static int displayMenu(int currentUserIndex, ArrayList<User> user) throws Exception {
		System.out.println("\nWelcome, " + user.get(currentUserIndex).getName());

		do
		{
			System.out.println("======== Menu Choice =======");
			System.out.println(" 1 View Movies");
			System.out.println(" 2 Add Movie");
			System.out.println(" 3 Delete Movie");
			System.out.println(" 4 Update Movie");
			System.out.println(" 5 Logout");
			System.out.println("============================");
			System.out.println("Please indicate your choice:");
			
			try {
				functionSelection = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException nfe) {
				System.out.println("Invalid selection, please select again!");
				continue;
			}

			switch(functionSelection) {
			case 1:
				Movie movie = MovieFilter.filter(Database.MovieDatabase, Database.CineplexDatabase);
				if (movie != null) {
					MovieMenu.movieAction(movie, user.get(currentUserIndex));
				}
				break;
			case 2:
				Database.addMovie();
                break;
			case 3:
				choice = AdminMainMenu.displayDeleteMovieMenu(Database.MovieDatabase);
				Database.deleteMovie(choice);
				break;
			case 4:
				choice = displayEditMovieMenu(Database.MovieDatabase);
				int type = displayEditMovieSectionMenu(Database.MovieDatabase);
				Database.editMovie(choice, type);
				break;
			case 5:
				System.out.println("Logging out..");
				System.out.println();
				return 5;
			default:
				System.out.println("Invalid selection, please select again!");
			}
		}while(functionSelection != 8);
		return -1;
	}

	public static int displayDeleteMovieMenu(ArrayList<Movie> movieDatabase){
		System.out.println("Select a movie to be deleted from the list (enter the number)");
		int i = 1;
		for(Movie movie : movieDatabase){
			System.out.println(i + ". " + movie.getMovieTitle());
			i++;
		}

		Scanner sc = new Scanner(System.in);
		int choice = -1;
		while ((choice < 1) || (choice > movieDatabase.size())) {
			System.out.println("Please enter your choice: ");
			if (!sc.hasNextInt()) {
				System.out.println("Please input an integer.\n");
				sc.next();
				continue;
			}
			choice = sc.nextInt();
			if ((choice <= 0) ||(choice > movieDatabase.size())) {
				System.out.println("Please input an integer within the range.\n");
			}
		}
		return choice;
	}

	public static int displayEditMovieMenu(ArrayList<Movie> movieDatabase){
		System.out.println("Select a movie to be edited from the list (enter the number)");
		int i = 1;
		for(Movie movie : movieDatabase){
			System.out.println(i + ". " + movie.getMovieTitle());
			i++;
		}

		Scanner sc = new Scanner(System.in);
		int choice = -1;
		while ((choice < 1) || (choice > movieDatabase.size())) {
			System.out.println("Please enter your choice: ");
			if (!sc.hasNextInt()) {
				System.out.println("Please input an integer.\n");
				sc.next();
				continue;
			}
			choice = sc.nextInt();
			if ((choice <= 0) ||(choice > movieDatabase.size())) {
				System.out.println("Please input an integer within the range.\n");
			}
		}
		return choice;
	}

	public static int displayEditMovieSectionMenu(ArrayList<Movie> movieDatabase){
		Movie selectedMovie = movieDatabase.get(choice - 1);
		System.out.println("You have selected " + selectedMovie.getMovieTitle() + "\n");
		Scanner select = new Scanner(System.in);
		int type = -1;
		while ((type < 1) || (type > 4)) {
			System.out.println("======= Edit Movie =======");
			System.out.println(" 1 Edit title\n 2 Edit director\n 3 Edit synopsis\n ============================\nPlease indicate your choice:");
			if (!select.hasNextInt()) {
				System.out.println("Please input an integer.\n");
				select.next();
				continue;
			}
			type = select.nextInt();
			if ((type < 1) || (type > 4)) {
				System.out.println("Please input a integer between 1 and 3.\n");
				continue;
			}
		}
		return type;
	}
}
