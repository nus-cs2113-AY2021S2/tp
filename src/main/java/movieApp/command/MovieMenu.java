package movieApp.command;

import movieApp.*;
import movieApp.storage.Database;
import movieApp.user.Admin;
import movieApp.user.Customer;
import movieApp.user.User;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class MovieMenu {

    /**
     * Display the menu choice users can make and prompt users to make a choice.
     * @return an int value that indicates user's choice.
     */
    public static int getAction() {
        int action = -1;
        Scanner sc = new Scanner(System.in);
        while ((action < 1) || (action > 4)) {
            System.out.println("\n======== Menu Choice =======");
            System.out.println(" 1 Buy ticket");
            System.out.println(" 2 View movie details");
            System.out.println(" 3 Add review");
            System.out.println(" 4 Go back");
            System.out.println("============================");
            System.out.println("Please indicate your choice:");

            if (!sc.hasNextInt()) {
                System.out.println("Please input an integer.\n");
                sc.next();
                continue;
            }
            action = sc.nextInt();
            if ((action < 1) || (action > 4)) {
                System.out.println("Please input an integer between 1 and 4.\n");
            }
        }
        return action;
    }

    /**
     * Allows users to book a movie ticket.
     * @param user user to make a booking.
     * @param CineplexDatabase the list of cineplex.
     * @param movie the movie to book
     */
    public static void bookTicket(Movie movie, ArrayList<Cineplex> CineplexDatabase, User user) {
        ArrayList<Showtimes> ShowtimeDatabase = Database.ShowtimesDatabase;
        String ms = movie.getShowingStatus();

        if (!ms.equals("PREORDER") && !ms.equals("NOWSHOWING")) {
            System.out.println("The movie is not available for sale. Status: " + ms);
            return;
        }

        int n = 0;
        boolean gotShowtime = false;
        ArrayList<Integer> showtime_index = new ArrayList<>();
        for (int i = 0; i < ShowtimeDatabase.size(); i++) {
            if (ShowtimeDatabase.get(i).getMovieID() == movie.getMovieID()) {
                gotShowtime = true;
                System.out.println("\nEnter " + n + " for the timing below: ");
                System.out.println("--------------------------");
                Calendar d = ShowtimeDatabase.get(i).getDateTime();
                System.out.print("[Timing] " + d.get(Calendar.YEAR) + "/" + (d.get(Calendar.MONTH) + 1) + "/" + d.get(Calendar.DATE) + " ");
                System.out.printf("%02d:%02d%n", d.get(Calendar.HOUR_OF_DAY), d.get(Calendar.MINUTE));
                System.out.println("[Location] Cineplex: " + CineplexDatabase.get(ShowtimeDatabase.get(i).getCineplexID() - 1).getCineplexName() + " -> " + "Cinema: " + (ShowtimeDatabase.get(i).getCinemaID() + 1));
                showtime_index.add(i);
                n++;
            }
        }
        if (!gotShowtime) {
            System.out.println("Waiting for administrator to add the show timings. Please come back later.");
            return;
        }

        Scanner sc = new Scanner(System.in);
        int choice = -1;
        while ((choice < 0) || (choice > (n - 1))) {
            System.out.println("\n>>Please enter your choice: (input \"back\" to go back)");
            if (!sc.hasNextInt()) {
                if (checkForBackKeyword(sc)) {
                    return;
                }
                System.out.println("Please input an integer.\n");
                continue;
            }
            choice = sc.nextInt();
            if ((choice < 0) || (choice > (n - 1))) {
                System.out.println("Please input an integer within the range.\n");
            }
        }

        int index_st = showtime_index.get(choice);
        int cinemaID = ShowtimeDatabase.get(index_st).getCinemaID();
        int cineplexID = ShowtimeDatabase.get(index_st).getCineplexID() - 1;

        System.out.println("You have selected: ");
        System.out.println("--------------------------");
        Calendar d = ShowtimeDatabase.get(index_st).getDateTime();
        System.out.print("[Timing] " + d.get(Calendar.YEAR) + "/" + (d.get(Calendar.MONTH) + 1) + "/" + d.get(Calendar.DATE) + " ");
        System.out.printf("%02d:%02d%n", d.get(Calendar.HOUR_OF_DAY), d.get(Calendar.MINUTE));
        System.out.println("[Location] Cineplex: " + CineplexDatabase.get(cineplexID).getCineplexName() + " -> " + "Cinema: " + (cinemaID + 1));

        if (checkIfCurrDateOverBookingDate(ShowtimeDatabase.get(index_st).getDateTime())) {
            System.out.println("Booking failed. Showtime for this timing is over.");
            return;
        }

        int num_tic = -1;
        while (num_tic < 1 || num_tic > ShowtimeDatabase.get(index_st).getEmptySeats()) {
            System.out.println("There are " + ShowtimeDatabase.get(index_st).getEmptySeats() + " empty seats.");
            System.out.println("How many tickets do you need? ");
            if (!sc.hasNextInt()) {
                System.out.println("Please input an integer.\n");
                sc.next();
                continue;
            }
            num_tic = sc.nextInt();
            if (num_tic < 1 || num_tic > ShowtimeDatabase.get(index_st).getEmptySeats()) {
                System.out.println("Please input a positive integer between 1 and " + ShowtimeDatabase.get(index_st).getEmptySeats() + ".\n");
            }
        }

        int max_row = ShowtimeDatabase.get(index_st).getMaxRow();
        int max_column = ShowtimeDatabase.get(index_st).getMaxColumn();

        int[][] seatChoice = new int[num_tic][2];
        for (int i = 0; i < num_tic; i++) {
            seatChoice[i][0] = -1;
            seatChoice[i][1] = -1;
        }

        ArrayList<Seat> seatsBooked = new ArrayList<>();
        ShowtimeDatabase.get(index_st).printSeats();
        for (int b = 0; b < num_tic; b++) {

            System.out.println("\nPlease select the seat for buyer No. " + (b + 1));

            int row = -1;
            while ((row < 1) || (row > max_row)) {
                System.out.println("Please enter the row number:  ");
                if (!sc.hasNextInt()) {
                    System.out.println("Please input an integer.\n");
                    sc.next();
                    continue;
                }
                row = sc.nextInt();
                if ((row < 1) || (row > max_row)) {
                    System.out.println("Please input a row number that is within the range.\n");
                }
            }

            int col = -1;
            while ((col < 1) || (col > max_column)) {
                System.out.println("Please enter the column number: ");
                if (!sc.hasNextInt()) {
                    System.out.println("Please input an integer.\n");
                    sc.next();
                    continue;
                }
                col = sc.nextInt();
                if ((col < 1) || (col > max_column)) {
                    System.out.println("Please input a column number that is within the range.\n");
                }
            }

            int[] RC = new int[2];
            RC[0] = row;
            RC[1] = col;
            System.out.println("Buyer no " + (b + 1) + "'s seat = [" + row + ", " + col + "]");
            boolean selectAgain = false;
            for (int i = 0; i < num_tic; i++) {
                if (seatChoice[i][0] == RC[0] && seatChoice[i][1] == RC[1]) {
                    selectAgain = true;
                }
            }

            while (ShowtimeDatabase.get(index_st).checkSeatTaken(RC) || selectAgain) {
                System.out.println("Sorry, the seat has been taken, Please choose another seat. ");

                row = -1;
                while ((row < 1) || (row > max_row)) {
                    System.out.println("Please enter the row number:  ");
                    if (!sc.hasNextInt()) {
                        System.out.println("Please input an integer.\n");
                        sc.next();
                        continue;
                    }
                    row = sc.nextInt();
                    if ((row < 1) || (row > max_row)) {
                        System.out.println("Please input a row number that is within the range.\n");
                    }
                }

                col = -1;
                while ((col < 1) || (col > max_column)) {
                    System.out.println("Please enter the column number: ");
                    if (!sc.hasNextInt()) {
                        System.out.println("Please input an integer.\n");
                        sc.next();
                        continue;
                    }
                    col = sc.nextInt();
                    if ((col < 1) || (col > max_column)) {
                        System.out.println("Please input a column number that is within the range.\n");
                    }
                }

                RC[0] = row;
                RC[1] = col;
                System.out.println("Buyer no " + (b + 1) + "'s seat = [" + row + ", " + col + "]");
                selectAgain = false;
                for (int i = 0; i < b; i++) {
                    if (seatChoice[i] == RC) {
                        selectAgain = true;
                    }
                }
            }
            seatChoice[b] = RC;
            ShowtimeDatabase.get(index_st).setSeatStatus((row - 1), (col - 1), true);
            ShowtimeDatabase.get(index_st).printSeats();
            seatsBooked.add(ShowtimeDatabase.get(index_st).getSeat((row - 1), (col - 1)));
        }

        System.out.println("\nThe Transaction is made, total ticket number: " + num_tic + " ");
        if (user.getUserType().equals("Customer")) {
            ((Customer) user).addNewBooking(new Booking(ShowtimeDatabase.get(index_st), seatsBooked));
        } else {
            ((Admin) user).addNewBooking(new Booking(ShowtimeDatabase.get(index_st), seatsBooked));
        }
        Database.updateDatabase();
    }

    /**
     * Check whether current date is after the booking date.
     * @param showingDate the booking date made by the user.
     * @return a boolean value that indicate whether current date is after the booking date.
     */
    private static boolean checkIfCurrDateOverBookingDate(Calendar showingDate) {
        Date currentDate = new Date();
        Date showDate = showingDate.getTime();
        return currentDate.compareTo(showDate) > 0;
    }

    /**
     * Check whether the keyword back exists.
     * @param sc the scanner.
     * @return a boolean value that indicate whether the keyword back exists.
     */
    private static boolean checkForBackKeyword(Scanner sc) {
        return sc.next().trim().toLowerCase().equals("back");
    }

    /**
     * Allows users to add a review to a movie.
     * @param movie the movie that users want to add a review on.
     */
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
        Database.updateDatabase();
    }

    /**
     * Check whether the rating input is valid.
     * @return an int value that is a valid rating input.
     */
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
            if ((value < 1) || (value > 5)) {
                System.out.println("Please input a integer between 1 and 5.\n");
            }
        }
        return value;
    }

    /**
     * Displays the detailed information of a movie.
     * @param movie the movie that users want to view details.
     */
    public static void viewMovieDetails(Movie movie) {
        movie.displayMovie();
    }

    /**
     * Executes the action that users want to do on the movie.
     * @param movie the movie that users choose.
     * @param user the user that make the command.
     * @return a boolean value that indicate the action the user chooses.
     */
    public static Boolean movieAction(Movie movie, User user) {
        int action;
        do {
            action = getAction();

            switch (action) {
                case 1:
                    action = -1;
                    System.out.println("\n======== Book Ticket ========");
                    bookTicket(movie, Database.CineplexDatabase, user);
                    break;
                case 2:
                    action = -1;
                    viewMovieDetails(movie);
                    break;
                case 3:
                    action = -1;
                    addReview(movie);
                    break;
                case 4:
                    return true;
                default:
                    System.out.println("Please input a integer between 1 and 4.\n");
            }
        } while (action != 4);
        return false;
    }
}