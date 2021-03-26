package movieApp.parser;

import java.util.*;

import movieApp.Cineplex;
import movieApp.Movie;
import movieApp.storage.Database;

public class MovieFilter {

	public static void printMovieList(ArrayList<Movie> MovieList) {
		int i;
		System.out.println("\n===========================");
		System.out.println("Movie List:");
		for (i=0;i<MovieList.size();i++) {
			System.out.println((i+1)+". "+MovieList.get(i).getMovieTitle());
		}
		System.out.println("===========================\n");
	}
	

	public static int getFilter() {
		int filter = -1;
		Scanner sc = new Scanner(System.in);
		
		while ((filter < 1) || (filter > 10)) {
			System.out.println("======= Movie Filter =======");
			System.out.println(" 1 Filter by genre\n 2 Filter by rating\n 3 Filter by showing status\n 4 Filter by cineplex\n 5 Filter by title\n 6 Select movie\n 7 Clear all filters\n 8 Back to Main Menu\n============================\nPlease indicate your choice:");
			if (!sc.hasNextInt()) {
				System.out.println("Please input an integer.\n");
				sc.next();
				continue;
			} 
			filter = sc.nextInt();
			if ((filter < 1) ||(filter > 8)) {
				System.out.println("Please input an integer between 1 and 10.\n");
				continue;
			}
		}
		return filter;
	}
	
	////////////////////////////////////////////////////////////////////////////
	public static String getGenre() {
		int genre_choice = -1;
		Scanner sc = new Scanner(System.in);
		
		while ((genre_choice < 1) || (genre_choice > 7)) {
			System.out.println("======= Select Genre =======");
			System.out.println(" 1 Sci-fi\n 2 Action\n 3 Comedy\n 4 Family\n 5 Horror\n 6 Romance\n 7 Drama\n============================\nPlease indicate your choice:");
			if (!sc.hasNextInt()) {
				System.out.println("Please input an integer.\n");
				sc.next();
				continue;
			} 
			genre_choice = sc.nextInt();
			if ((genre_choice < 1) ||(genre_choice >3)) {
				System.out.println("Please input an integer between 1 and 7.\n");
				continue;
			}
		}
		
		switch (genre_choice) {
			case 1:
					return "Sci-fi";
			case 2:
					return "Action";
			case 3:
					return "Comedy";
			case 4:
					return "Family";
			case 5:
					return "Horror";
			case 6:
					return "Romance";
			case 7:
					return "Drama";
		}
	return "No such genre.";
}
	
	////////////////////////////////////////////////////////////////////////////

	public static ArrayList<Movie> filterByGenre(ArrayList<Movie> movieList){
		int i=0;
		String genre = getGenre();
		System.out.println("\nThe selected genre is: "+genre);
		
		while (i<movieList.size()) {
			if (!genre.equals(movieList.get(i).getGenre())){
				movieList.remove(i);
				i--;
			}
			i++;
		}
		return movieList;
	}
	////////////////////////////////////////////////////////////////////////////
	public static float getRating() {
		float rating = -1;
		Scanner sc = new Scanner(System.in);
		
		while ((rating < 0) || (rating > 5)) {
			System.out.println("Select the cut-off rating (0-5): ");
			if (!sc.hasNextFloat()) {
				System.out.println("Please input a float.\n");
				sc.next();
				continue;
			} 
			rating = sc.nextFloat();
			if ((rating < 0) ||(rating >5)) {
				System.out.println("Please input a float between 0 and 5.\n");
				continue;
			}
		}
		return rating;
	}
	
	////////////////////////////////////////////////////////////////////////////
	
	public static ArrayList<Movie> filterByRating(ArrayList<Movie> movieList){
		int i=0;
		float rating = getRating();
		System.out.println("\nThe selected cut-off rating is: "+rating);
		
		while (i<movieList.size()) {
			if (rating > (movieList.get(i).getOverallRating())){
				movieList.remove(i);
				i--;
			}
			i++;
		}
		return movieList;
		
	}
	
	////////////////////////////////////////////////////////////////////////////
	
	
	public static String getShowingStatus() {
		int showing_status_choice = -1;
		Scanner sc = new Scanner(System.in);
		
		while ((showing_status_choice < 1) || (showing_status_choice > 4)) {
			System.out.println("======= Select Genre =======");
			System.out.println("== Select Showing Status ===");
			System.out.println(" 1 Coming Soon\n 2 Pre-Order\n 3 Now Showing\n 4 End of Showing\n ============================\nPlease indicate your choice:");
			if (!sc.hasNextInt()) {
				System.out.println("Please input an integer.\n");
				sc.next();
				continue;
			} 
			showing_status_choice = sc.nextInt();
			if ((showing_status_choice < 1) ||(showing_status_choice > 4)) {
				System.out.println("Please input an integer between 1 and 4.\n");
				continue;
			}
		}
	
		switch (showing_status_choice) {
			case 1:
				return "COMINGSOON";
			case 2:
				return "PREORDER";
			case 3:
				return "NOWSHOWING";
			case 4:
				return "ENDSHOWING";
		}
		return "No such showing status.";
	}

	////////////////////////////////////////////////////////////////////////////
	
	
	public static ArrayList<Movie> filterByShowingStatus(ArrayList<Movie> movieList){
		int i=0;
		String showingStatus = getShowingStatus();
		System.out.println("\nThe selected showing status is: "+showingStatus);
		
		while (i<movieList.size()) {
			if (!showingStatus.equals(movieList.get(i).getShowingStatus())){
				movieList.remove(i);
				i--;
			}
			i++;
		}
		return movieList;
	}
	
	////////////////////////////////////////////////////////////////////////////
	public static int getCineplex() {
		int cineplex_choice = -1;
		Scanner sc = new Scanner(System.in);
		
		while ((cineplex_choice < 1) || (cineplex_choice > 3)) {
			System.out.println(" 1 Jurong Point\n 2 VivoCity\n 3 Bishan\n============================\nPlease indicate your choice:");
			if (!sc.hasNextInt()) {
				System.out.println("Please input an integer.\n");
				sc.next();
				continue;
			} 
			cineplex_choice = sc.nextInt();
			if ((cineplex_choice < 1) ||(cineplex_choice > 3)) {
				System.out.println("Please input an integer between 1 and 3.\n");
				continue;
			}
		}
		return (cineplex_choice-1);
	}
	
	////////////////////////////////////////////////////////////////////////////
	
	
	public static ArrayList<Movie> filterByCineplex(ArrayList<Movie> movieList, ArrayList<Cineplex> CineplexDatabase){
		
		int cineplexID = getCineplex();
		Cineplex cineplex = CineplexDatabase.get(cineplexID);
		System.out.println("\nThe selected cineplex is: " + cineplex.getCineplexName());
		ArrayList<Integer> cineplexMovies = cineplex.getMovieList();
		int i=0;
		
		while (i<movieList.size()){
			if (!cineplexMovies.contains(movieList.get(i).getMovieID())){
				movieList.remove(i);
				i--;
			}
			i++;
		}
		return movieList;
	}	
	////////////////////////////////////////////////////////////////////////////
		
	public static String getTitle() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Search: ");
		return sc.nextLine();
	}
	
	////////////////////////////////////////////////////////////////////////////
	
	public static ArrayList<Movie> filterByTitle(ArrayList<Movie> movieList){
		String title = getTitle();
		System.out.println("movies containing "+title);
		int i=0;
		while (i<movieList.size()){
			if (movieList.get(i).getMovieTitle().toLowerCase().contains(title.toLowerCase()) != true){
				movieList.remove(i);
				i--;
			}
			i++;
		}
		return movieList;
		
	}
	////////////////////////////////////////////////////////////////////////////
		
	public static int getMovieChoice(int size) {
		int movie_choice = -1;
		Scanner sc = new Scanner(System.in);
		
		while ((movie_choice < 0) || (movie_choice > size)) {
			System.out.println("Please indicate your choice:");
			if (!sc.hasNextInt()) {
				System.out.println("Please input an integer.\n");
				sc.next();
				continue;
			} 
			movie_choice = sc.nextInt();
			if ((movie_choice < 0) ||(movie_choice > size)) {
				System.out.println("Please input an integer between 0 and "+size+".\n");
				continue;
			}
		}
		return movie_choice;
	}
	
	////////////////////////////////////////////////////////////////////////////
	
	
	public static ArrayList<Movie> selectMovie(ArrayList<Movie> movieList){
		ArrayList<Movie> result = new ArrayList<Movie>();
		result.add(movieList.get(getMovieChoice(movieList.size()-1)));
		return result;
		
	}

	
	////////////////////////////////////////////////////////////////////////////
	public static Movie filter(ArrayList<Movie> movieList,ArrayList<Cineplex> CineplexDatabase) {
		int Filter;
		while (movieList.size() != 1) {

			ArrayList<Movie> movieListCopy = new ArrayList<Movie>(movieList);

				Filter = getFilter();
				if(Filter==8) {return null;}
				printMovieList(movieList);
				
				switch(Filter) {	
					case 1: 
						System.out.println("===== Filter by Genre ======");
						movieList = filterByGenre(movieList);
						break;
						
					case 2:
						System.out.println("===== Filter by Rating =====");
						movieList = filterByRating(movieList);
						break;
					case 3:
						System.out.println("= Filter by Showing Status =");
						movieList = filterByShowingStatus(movieList);
						break;
					case 4:
						System.out.println("==== Filter by Cineplex ====");
						movieList = filterByCineplex(movieList,CineplexDatabase);
						break;
					case 5:
						System.out.println("===== Filter by Title ======");
						movieList = filterByTitle(movieList);
						break;
					case 6:
						System.out.println("======= Select Movie =======");
						movieList = selectMovie(movieList);
						break;
					case 7:
						movieList = new ArrayList<Movie>(Database.MovieDatabase);
						break;
					case 8:
						return null;

				}

				if (movieList.size() == 0) {
					System.out.println("\nSorry! We couldn't find any matches.\nWould you like to try something else?");
					movieList = movieListCopy;
				} 
				else {
					printMovieList(movieList);
				}
		}

		return movieList.get(0);
	}
}