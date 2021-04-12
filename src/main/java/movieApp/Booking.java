package movieApp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Booking implements Serializable {
    private static final long serialVersionUID = 7709150072267421383L;
    private Showtimes showtimes;
    private ArrayList<Seat> seats;
    private Status status;
    private Date date;

    /**
     * Class constructor.
     */
    public Booking(Showtimes showtimes, ArrayList<Seat> seats) {
        this.showtimes = showtimes;
        this.seats = seats;
        this.status = Status.COMPLETED;
        this.date = new Date();
        printBookingDetails();
    }

    /**
     * Display the booking details.
     */
    public void printBookingDetails() {
        Calendar d = getShowtimes().getDateTime();
        Date movieDate = d.getTime();
        System.out.println("==========================================");
        System.out.println("Movie Title:     " + showtimes.getMovieTitle());
        System.out.println("Show Time:       " + movieDate);
        System.out.print("Seats Booked:    ");
        for (int i = 0; i < seats.size(); i++) {
            System.out.print("[" + (seats.get(i).getRow() + 1)
                    + "," + (seats.get(i).getColumn() + 1) + "] ");
        }
        System.out.println();
        System.out.println("Status:          " + status);
        System.out.println("Date Booked:     " + date);
        System.out.println("==========================================");
    }

    public ArrayList<Seat> getSeats() {
        return seats;
    }

    public Showtimes getShowtimes() {
        return this.showtimes;
    }

    public enum Status {
        COMPLETED, AWAITING_PAYMENT, PROCESSING, FAILED
    }
}
