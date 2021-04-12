package movieApp.user;

import movieApp.Booking;

import java.util.ArrayList;

public class Customer extends User {

    private ArrayList<Booking> bookings;

    /**
     * Class constructor, extends User class.
     */
    public Customer(String name, String password) {
        super(name, password, "Customer");
        bookings = new ArrayList<>();
    }

    /**
     * Tags a Booking object that was made, to the user that made the booking
     *
     * @param booking a Booking object containing information about the user's booking made
     */
    public void addNewBooking(Booking booking) {
        bookings.add(booking);
    }

    /**
     * Returns an ArrayList of all Booking objects the customer has, for use by operations
     *
     * @return an ArrayList containing all Booking objects the customer has.
     */
    public ArrayList<Booking> getBookings() {
        return bookings;
    }
}
