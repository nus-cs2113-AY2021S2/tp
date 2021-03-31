package movieApp;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShowtimesTest {
    public static Calendar date = Calendar.getInstance();
    public static String[] testStringCast = new String[]{"Test1", "Test2", "Test3"};
    public static ArrayList<Review> testReviews = new ArrayList<Review>(Arrays.asList(new Review("Good", 5),
            new Review("Bad", 1)));
    public static Cinema cinema = new Cinema("1", 1, 1, 1, 1, 1);
    public static Movie movie = new Movie("Movie Test", 1, 2020, 3, 20, 2020,
            12, 1, "Director Test", testStringCast, "Test Genre", "Test Synopsis",
            1, testReviews);
    public static Showtimes showtimes = new Showtimes(1, date, cinema, movie);

    @Test
    void testGetShowtimeID() {
        assertEquals(1, showtimes.getShowtimeID());
    }

    @Test
    void testGetMovieID() {
        assertEquals(1, showtimes.getMovieID());
    }

    @Test
    void testGetMovieTitle() {
        assertEquals("Movie Test", showtimes.getMovieTitle());
    }

    @Test
    void testGetDateTime() {
        assertEquals(date, showtimes.getDateTime());
    }

    @Test
    void testGetCinemaID() {
        assertEquals(1, showtimes.getCinemaID());
    }

    @Test
    void testGetCineplexID() {
        assertEquals(1, showtimes.getCineplexID());
    }

    @Test
    void testGetMaxRow() {
        assertEquals(1, showtimes.getMaxRow());
    }

    @Test
    void testGetMaxColumn() {
        assertEquals(1, showtimes.getMaxColumn());
    }

    @Test
    void testGetSeat() {
        assertTrue(showtimes.getSeat(0,0) instanceof Seat);
    }

    @Test
    void testCheckSeatTaken() {
        assertEquals(false, showtimes.checkSeatTaken(new int[]{1,1}));
    }
}
