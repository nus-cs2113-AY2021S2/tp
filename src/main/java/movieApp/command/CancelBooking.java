package movieApp.command;

import movieApp.Booking;
import movieApp.Seat;
import movieApp.Showtimes;
import movieApp.storage.Database;
import movieApp.user.User;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class CancelBooking {

    private static Scanner sc = new Scanner(System.in);
    private ArrayList<Booking> currentBookings = null;
    private User user = null;

    /**
     * Class constructor.
     */
    public CancelBooking(User user, ArrayList<Booking> bookings) {
        this.user = user;
        currentBookings = bookings;
    }

    /**
     * Cancel one booking.
     */
    public void cancelOneBooking() {
        int thisBookingNumber = getBookingNumber();
        if (thisBookingNumber != 0) {
            deleteThisBooking(thisBookingNumber);
        } else {
            System.out.println("No more bookings available.");
            System.out.println();
        }
    }

    /**
     * Delete a user's booking.
     * @param thisBookingNumber the number of the booking to be deleted.
     */
    private void deleteThisBooking(int thisBookingNumber) {
        if (checkIfCurrDateOverBookingDate(currentBookings.get(thisBookingNumber - 1))) {
            System.out.println("The movie screening is over. Cancelling of booking is unsuccessful.");
        } else {
            resetSeatStatus(currentBookings.get(thisBookingNumber - 1));
            currentBookings.remove(thisBookingNumber - 1);
            System.out.println("Booking Number " + thisBookingNumber + " has been removed successfully.");
            Database.updateDatabase();
        }
    }

    /**
     * Check whether current date is after the booking date.
     * @param selectedBooking the booking made by the user.
     * @return a boolean value that indicate whether current date is after the booking date.
     */
    private boolean checkIfCurrDateOverBookingDate(Booking selectedBooking) {
        Date currentDate = new Date();
        Calendar calendar = selectedBooking.getShowtimes().getDateTime();
        Date movieDate = calendar.getTime();
        return currentDate.compareTo(movieDate) > 0;
    }

    /**
     * Reset the status of the seats.
     * @param booking the booking made by users.
     */
    private void resetSeatStatus(Booking booking) {
        Showtimes showtimes = booking.getShowtimes();
        ArrayList<Seat> seats = booking.getSeats();
        for (int i = 0; i < Database.ShowtimesDatabase.size(); i++) {
            if (Database.ShowtimesDatabase.get(i).getShowtimeID() == showtimes.getShowtimeID()) {
                for (int j = 0; j < seats.size(); j++) {
                    showtimes.setSeatStatus(seats.get(j).getRow(), seats.get(j).getRow(), false);
                    Database.ShowtimesDatabase.get(i).setSeatStatus(seats.get(j).getRow(), seats.get(j).getRow(), false);
                }
            }
        }
    }

    /**
     * Enables the users to cancel the number of booking they made.
     * @return an int value that indicate user's input.
     */
    private int getBookingNumber() {
        int booking_choice = 0;

        if (checkIfBookingListIsEmpty()) {
            return booking_choice;
        }

        while ((booking_choice < 1) || (booking_choice > currentBookings.size())) {
            System.out.println("Please indicate the booking number to cancel:");
            if (!sc.hasNextInt()) {
                System.out.println("Please input an integer.\n");
                sc.next();
                continue;
            }
            booking_choice = sc.nextInt();
            if ((booking_choice < 1) || (booking_choice > currentBookings.size())) {
                System.out.println("Please input an integer between 1 and " + currentBookings.size() + ".\n");
            }
        }
        return booking_choice;
    }

    private boolean checkIfBookingListIsEmpty() {
        return this.currentBookings.size() == 0;
    }
}
