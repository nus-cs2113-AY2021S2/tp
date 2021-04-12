package movieApp.user;

import movieApp.Booking;

import java.util.ArrayList;

public class Admin extends User{

	private ArrayList<Booking> bookings;

	/**
	 * Class constructor, extends User class.
	 */
	public Admin(String name, String password){
		super(name, password, "Admin");
		bookings = new ArrayList<>();
	}

	/**
	 * Tags a Booking object that was made, to the user that made the booking
	 * @param  booking   a Booking object containing information about the user's booking made
	 */
	public void addNewBooking(Booking booking){
		bookings.add(booking);
	}

	/**
	 * Returns an ArrayList of all Booking objects the admin has, for use by operations
	 * @return      an ArrayList containing all Booking objects the admin has.
	 */
	public ArrayList<Booking> getBookings(){
		return bookings;
	}
}
