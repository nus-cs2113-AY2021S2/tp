package movieApp;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BookingTest {

    public static Calendar date = Calendar.getInstance();
    public static String[] cast = new String[10];
    public static ArrayList<Review> reviews = new ArrayList<>();
    public static Cinema cinema = new Cinema("1", 1, 1, 1, 1, 1);
    public static Movie movie = new Movie("1", 1, 1, 1, 1, 1, 1,
            1, "1", cast, "1", "1", 1, reviews);
    public static Showtimes showtimes = new Showtimes(1, date, cinema, movie);
    public static ArrayList<Seat> seats = new ArrayList<>();

    @Test
    void testPrint() {
        assertDoesNotThrow(() -> new Booking(showtimes, seats).printBookingDetails());
    }

    @Test
    void testGetSeats() {
        assertEquals(seats, new Booking(showtimes, seats).getSeats());
    }
}