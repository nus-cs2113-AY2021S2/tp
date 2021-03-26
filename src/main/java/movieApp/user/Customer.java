package movieApp.user;

import movieApp.Booking;

import java.util.ArrayList;

public class Customer extends User{

	private ArrayList<Booking> bookings;

	public Customer(String name, String password){
		super(name, password, "Customer");
	}

}
