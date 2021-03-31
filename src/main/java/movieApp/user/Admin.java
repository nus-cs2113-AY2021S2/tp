package movieApp.user;

import movieApp.Booking;

import java.util.ArrayList;

public class Admin extends User{

	private ArrayList<Booking> bookings;

	public Admin(String name, String password){
		super(name, password, "Admin");
		bookings = new ArrayList<>();
	}

	public void addNewBooking(Booking booking){
		bookings.add(booking);
	}

}
