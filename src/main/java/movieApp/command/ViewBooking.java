package movieApp.command;

import movieApp.Booking;
import movieApp.user.Admin;
import movieApp.user.Customer;
import movieApp.user.User;

import java.util.ArrayList;
import java.util.Scanner;

public class ViewBooking {

    private static Scanner sc = new Scanner(System.in);
    private ArrayList<Booking> bookings = null;
    private User user = null;

    /**
     * Class constructor.
     */
    public ViewBooking(User user) {
        this.bookings = downcastToSpecificUser(user);
        this.user = user;
    }

    /**
     * Display the bookings made by the user.
     */
    public void printBookings() {
        if (bookings.size() == 0) {
            System.out.println("No bookings available.");
            System.out.println();
        } else {
            printAllBookings();
            displayCancelBookingMenu(bookings);
        }
    }

    /**
     * Display the cancel booking menu choice and prompt users to make a choice.
     * @param bookings  the list of bookings.
     */
    private void displayCancelBookingMenu(ArrayList<Booking> bookings) {
        int functionSelection = -1;
        do {
            System.out.println("======== Menu Choice =======");
            System.out.println(" 1 Cancel a booking");
            System.out.println(" 2 Go Back");
            System.out.println("============================");
            System.out.println("Please indicate your choice:");

            try {
                functionSelection = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException nfe) {
                System.out.println("Invalid selection, please select again!");
                continue;
            }

            switch (functionSelection) {
                case 1:
                    printAllBookings();
                    CancelBooking cancelUserBooking = new CancelBooking(user, bookings);
                    cancelUserBooking.cancelOneBooking();
                    break;
                case 2:
                    return;
                default:
                    System.out.println("Invalid selection, please select again!");
            }
        } while (functionSelection != 2);
    }

    /**
     * Display all the bookings and their indexes.
     */
    private void printAllBookings() {
        for (int i = 0; i < bookings.size(); i++) {
            System.out.println("Booking Number " + (i + 1));
            bookings.get(i).printBookingDetails();
        }
    }

    /**
     * Gets the list of booking of a specific user.
     * @param user the user to get bookings from.
     * @return a list of bookings of the user.
     */
    private ArrayList<Booking> downcastToSpecificUser(User user) {
        if (user.getUserType().equals("Customer")) {
            return ((Customer) user).getBookings();
        } else {
            return ((Admin) user).getBookings();
        }
    }
}
