package movieApp.command;

import movieApp.Booking;
import movieApp.user.Admin;
import movieApp.user.Customer;
import movieApp.user.User;

import java.util.ArrayList;
import java.util.Scanner;

public class ViewBooking {

    private ArrayList<Booking> bookings = null;
    private User user = null;
    private static Scanner sc = new Scanner(System.in);

    public ViewBooking(User user) {
        this.bookings = downcastToSpecificUser(user);
        this.user = user;
    }

    public void printBookings() {
        if (bookings.size()==0){
            System.out.println("No bookings available.");
            System.out.println();
        }else{
            printAllBookings();
            displayCancelBookingMenu(bookings);
        }
    }

    private void displayCancelBookingMenu(ArrayList<Booking> bookings) {
        int functionSelection = -1;
        do
        {
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

            switch(functionSelection) {
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
        }while(functionSelection != 2);
    }

    private void printAllBookings() {
        for(int i=0; i<bookings.size();i++){
            System.out.println("Booking Number "+ (i+1));
            bookings.get(i).printBookingDetails();
        }
    }

    private ArrayList<Booking> downcastToSpecificUser(User user) {
        if(user.getUserType().equals("Customer")){
            return ((Customer) user).getBookings();
        } else{
            return ((Admin) user).getBookings();
        }
    }
}
