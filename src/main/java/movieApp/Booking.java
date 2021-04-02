package movieApp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Booking implements Serializable {
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
        showtimes.printSeats();
        System.out.println("Seats Booked:");
        for(int i = 0; i<seats.size(); i++){
            System.out.println("[" + seats.get(i).getRow()
                    + "," + seats.get(i).getColumn()+"]");
        }
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
