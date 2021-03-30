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
        this.status = Status.PROCESSING;
        this.date = new Date();
        print();
    }


    public void print(){
        System.out.println("==========================================");
        System.out.println("Showtimes No:     " + showtimes.getMovieTitle());
        showtimes.printSeats();
        System.out.println("seats:     " + seats);
        /*
        for(int i = 0; i<seats.size(); i++){
            System.out.println("Seats Booked:    "+ seats.get(i).getRow());
            System.out.println("Seats Booked:    "+ seats.get(i).getColumn());
        }
         */
        System.out.println("Status:          "+ status);
        System.out.println("Date:          "+ date);
        System.out.println("==========================================");
    }

    public ArrayList<Seat> getSeats(){
        return seats;
    }

    public enum Status {
        COMPLETED, AWAITING_PAYMENT, PROCESSING, FAILED
    }
}
