package movieApp;

import movieApp.user.Customer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Booking implements Serializable, Cloneable {

    private Date date = null;
    private String bookingID = null;
    private Customer customer = null;
    private Status status = Status.PROCESSING;
    private ArrayList<String> seats = new ArrayList<>();

    public Booking(Customer customer, Date date, String bookingID){
        //this.show = show;
        this.customer= customer;
        this.date = date;
        this.bookingID = bookingID;
    }

    public String getBookingID() {
        return bookingID;
    }

    public Customer getCustomer(){
        return customer;
    }


    public void print(){
        System.out.println("==========================================");
        System.out.println("Booking No:      " + bookingID);
        System.out.println("Customer No:     " + customer.getName());
        System.out.println("Show Details:    ");
        System.out.println("Seats Booked:    "+ seats);
        System.out.println("Status:          "+ status);
        System.out.println("==========================================");
    }

    public ArrayList<String> getSeats(){
        return seats;
    }

    public enum Status {
        COMPLETED, AWAITING_PAYMENT, PROCESSING, FAILED
    }
}
