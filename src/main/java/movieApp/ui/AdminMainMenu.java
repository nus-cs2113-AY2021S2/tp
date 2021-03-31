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
				System.out.println("case 2");
                break;
			case 3:
				int choice = AdminMainMenu.displayDeleteMovieMenu(Database.MovieDatabase);
				Database.deleteMovie(choice);
				break;
			case 4:
				System.out.println("case 4");
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
}
