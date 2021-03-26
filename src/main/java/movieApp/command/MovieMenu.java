package movieApp.command;

import movieApp.Cineplex;
import movieApp.Movie;
import movieApp.Showtimes;
import movieApp.storage.Database;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class MovieMenu {

	public static int getAction() {
		int action = -1;
		Scanner sc = new Scanner(System.in);
		while ((action < 1) || (action > 4)) {
			System.out.println("\n\n======== Menu Choice =======");
			System.out.println(" 1 Buy ticket");
			System.out.println(" 2 View movie details");
			System.out.println(" 3 Add review");
			System.out.println(" 4 Go back");
			System.out.println(" ============================");
			System.out.println(" Please indicate your choice:");

			if (!sc.hasNextInt()) {
				System.out.println("Please input an integer.\n");
				sc.next();
				continue;
			} 
			action = sc.nextInt();
			if ((action < 1) ||(action > 4)) {
				System.out.println("Please input an integer between 1 and 4.\n");
			}
		}
		return action;
	}


	public static void bookTicket(ArrayList<Movie> MovieDatabase, ArrayList<Showtimes> ShowtimeDatabase,
								  ArrayList<Cineplex> CineplexDatabase, int movieID) {
		String ms = "NOT FOUND";
		for (Movie movie : MovieDatabase) {
			if (movie.getMovieID() == movieID) {
				ms = movie.getShowingStatus();
				break;
			}
		}
		if(!ms.equals("PREORDER") && !ms.equals("NOWSHOWING")) {
			System.out.println("The movie is not available for sale. COMING SOON");
			return; 
		}
			
		int n = 0;
		ArrayList<Integer> showtime_index = new ArrayList<>();
		for(int i=0; i<ShowtimeDatabase.size(); i++) {
			if(ShowtimeDatabase.get(i).getMovieID() == movieID) {
				System.out.println("\nEnter "+ n + " for the timing below: ");
				System.out.println("--------------------------");
				Calendar d = ShowtimeDatabase.get(i).getDateTime();
				System.out.print("[Timing] " + d.get(Calendar.YEAR) + "/" + (d.get(Calendar.MONTH)+1) + "/" + d.get(Calendar.DATE) + " ");
				System.out.printf("%02d:%02d%n", d.get(Calendar.HOUR_OF_DAY), d.get(Calendar.MINUTE) );
				System.out.println("[Location] Cineplex: " + CineplexDatabase.get(ShowtimeDatabase.get(i).getCineplexID()).getCineplexName()+ " -> " +"Cinema: " + (ShowtimeDatabase.get(i).getCinemaID()+1));
				showtime_index.add(i); 
				n++; 
			}
			
		}
		
		
		Scanner sc = new Scanner(System.in);
		int choice = -1;
		while ((choice < 0) || (choice > (n-1))) {
			System.out.println("\n>>Please enter your choice: ");
			if (!sc.hasNextInt()) {
				System.out.println("Please input an integer.\n");
				sc.next();
				continue;
			} 
			choice = sc.nextInt();
			if ((choice < 0) ||(choice > (n-1))) {
				System.out.println("Please input an integer within the range.\n");
			}
		}
		
		int index_st = showtime_index.get(choice);
		int cinemaID = ShowtimeDatabase.get(index_st).getCinemaID(); 
		int cineplexID = ShowtimeDatabase.get(index_st).getCineplexID();

		System.out.println("You have selected: ");
		System.out.println("--------------------------");
		Calendar d = ShowtimeDatabase.get(index_st).getDateTime();
		System.out.print("[Timing] " + d.get(Calendar.YEAR) + "/" + (d.get(Calendar.MONTH)+1) + "/" + d.get(Calendar.DATE) + " ");
		System.out.printf("%02d:%02d%n", d.get(Calendar.HOUR_OF_DAY), d.get(Calendar.MINUTE) );
		System.out.println("[Location] Cineplex: " + CineplexDatabase.get(cineplexID).getCineplexName()+ " -> " +"Cinema: " + (cinemaID+1));

		 
		int num_tic = -1;
		while (num_tic < 0) {
			System.out.println("How many tickets do you need? ");
			if (!sc.hasNextInt()) {
				System.out.println("Please input an integer.\n");
				sc.next();
				continue;
			} 
			num_tic = sc.nextInt();
			if (num_tic < 0) {
				System.out.println("Please input a positive integer.\n");
			}
		}
		
		int max_row = ShowtimeDatabase.get(index_st).getMaxRow();
		int max_column = ShowtimeDatabase.get(index_st).getMaxColumn();

		int[][] seatChoice = new int[num_tic][2];
		for (int i=0;i<num_tic;i++) {
			seatChoice[i][0] = -1 ;
			seatChoice[i][1] = -1 ;
		}

		ShowtimeDatabase.get(index_st).printSeats();
		for(int b = 0; b<num_tic; b++) {
			
			System.out.println("\nPlease select the seat for buyer No. " + (b+1));
			
			int row = -1;
			while ((row <1) || (row > max_row)) {
				System.out.println("Please enter the row number:  " );
				if (!sc.hasNextInt()) {
					System.out.println("Please input an integer.\n");
					sc.next();
					continue;
				} 
				row = sc.nextInt();
				if ((row <1) || (row > max_row)) {
					System.out.println("Please input a row number that is within the range.\n");
				}
			}

			
			int col = -1;
			while ((col <1) || (col > max_column)) {
				System.out.println("Please enter the column number: ");
				if (!sc.hasNextInt()) {
					System.out.println("Please input an integer.\n");
					sc.next();
					continue;
				} 
				col = sc.nextInt();
				if ((col <1) || (col > max_column)) {
					System.out.println("Please input a column number that is within the range.\n");
				}
			}

			int[] RC = new int[2];
			RC[0] = row;
			RC[1] = col;
			System.out.println("Buyer no " + (b+1) + "'s seat = [" + row + ", " + col + "]");
			boolean selectAgain = false;
			for (int i = 0; i < num_tic; i++) {
				if(seatChoice[i][0]==RC[0] && seatChoice[i][1]==RC[1]) {
					selectAgain=true;
				}
			}
			
			while(ShowtimeDatabase.get(index_st).checkSeatTaken(RC) || selectAgain) {
				System.out.println("Sorry, the seat has been taken, Please choose another seat. ");
				
				row = -1;
				while ((row <1) || (row > max_row)) {
					System.out.println("Please enter the row number:  " );
					if (!sc.hasNextInt()) {
						System.out.println("Please input an integer.\n");
						sc.next();
						continue;
					} 
					row = sc.nextInt();
					if ((row <1) || (row > max_row)) {
						System.out.println("Please input a row number that is within the range.\n");
					}
				}
				
				col = -1;
				while ((col <1) || (col > max_column)) {
					System.out.println("Please enter the column number: ");
					if (!sc.hasNextInt()) {
						System.out.println("Please input an integer.\n");
						sc.next();
						continue;
					} 
					col = sc.nextInt();
					if ((col <1) || (col > max_column)) {
						System.out.println("Please input a column number that is within the range.\n");
					}
				}

				RC[0] = row;
				RC[1] = col;
				System.out.println("Buyer no " + (b+1) + "'s seat = [" + row + ", " + col + "]");
				selectAgain = false;
				for (int i = 0;i<b;i++) {
					if(seatChoice[i] == RC) {
						selectAgain=true;
					}
				}
			}
			seatChoice[b] = RC;
			
		}

		System.out.println("\nThe Transaction is made, total ticket number: "+ num_tic+" ");

// TODO: print seats
 
	}
	
	public static void addReview(Movie movie) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Comment:");
		String comment = sc.nextLine();
		int rating = ratingVerification();
		movie.addReview(comment, rating);
		System.out.println("The comment ' " + comment + " ' and the rating " + rating +
				" have been successfully added to the movie " + movie.getMovieTitle() + ".");
		System.out.println("Thank you for your review!");
		System.out.println();
	}
	
	public static int ratingVerification() {
		Scanner sc = new Scanner(System.in);
		int value = -1;
		while ((value < 1) || (value > 5)) {
			System.out.print("Rating: ");
			if (!sc.hasNextInt()) {
				System.out.println("Please input an integer.\n");
				sc.next();
				continue;
			} 
			value = sc.nextInt();
			if ((value < 1) ||(value > 5)) {
				System.out.println("Please input a integer between 1 and 5.\n");
			}
		}		
		return value;
	}
	
	
	public static void viewMovieDetails(Movie movie) {
		movie.displayMovie();
	}

	public static void movieAction(Movie movie) {
		int action;
		do {
			action = getAction();
			
			switch(action) {
			case 1:
				action = -1;
					System.out.println("\n======== Book Ticket ========");
					bookTicket(Database.MovieDatabase, Database.ShowtimesDatabase,
							Database.CineplexDatabase, movie.getMovieID());
				break;	
			case 2:
				action = -1;
				viewMovieDetails(movie);
				break;
			case 3:
				action = -1;
				addReview(movie);
				break;
			default:
				System.out.println("Please input a integer between 1 and 4.\n");
			}			
		} while (action != 4);
		//TODO: Is this supposed to quit the app when action 4 is chosen?
	}
	
}