package movieApp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Booking implements Serializable {
    private static final long serialVersionUID = 7709150072267421383L;
    private Showtimes showtimes;
    private ArrayList<Seat> seats;
    private Status status;
    private Date date;

    public Booking(Showtimes showtimes, ArrayList<Seat> seats){
        this.showtimes = showtimes;
        this.seats = seats;
        this.status = Status.COMPLETED;
        this.date = new Date();
        printBookingDetails();
    }


    public void printBookingDetails(){
        System.out.println("==========================================");
        System.out.println("Showtimes No:     " + showtimes.getMovieTitle());
        System.out.print("Seats Booked: ");
        for(int i = 0; i<seats.size(); i++){
            System.out.print("[" + (seats.get(i).getRow()+1)
                    + "," + (seats.get(i).getColumn()+1)+"] ");
        }
        System.out.println();
        System.out.println("Status:          "+ status);
        System.out.println("Date:          "+ date);
        System.out.println("==========================================");
    }

    public ArrayList<Seat> getSeats(){
        return seats;
    }

    public Showtimes getShowtimes(){
        return this.showtimes;
    }

    public enum Status {
        COMPLETED, AWAITING_PAYMENT, PROCESSING, FAILED
    }
}
