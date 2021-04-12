package movieApp.command;

import movieApp.Cinema;
import movieApp.Movie;
import movieApp.Review;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

class MovieMenuTest {
    public static Calendar date = Calendar.getInstance();
    public static String[] testStringCast = new String[]{"Test1", "Test2", "Test3"};
    public static ArrayList<Review> testReviews = new ArrayList<Review>(Arrays.asList(new Review("Good", 5),
            new Review("Bad", 1)));
    public static Cinema cinema = new Cinema("1", 1, 1, 1, 1, 1);
    public static Movie movie = new Movie("Movie Test", 1, 2020, 3, 20, 2020,
            12, 1, "Director Test", testStringCast, "Test Genre", "Test Synopsis",
            1, testReviews);

    @Test
    void testViewMovieDetails() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        new MovieMenu().viewMovieDetails(movie);
        String expected = "";
        assertArrayEquals(expected.getBytes(), output.toByteArray());
    }

    @Test
    void testRatingVerification() {
        InputStream sysInBackup = System.in; // backup System.in to restore it later
        ByteArrayInputStream in = new ByteArrayInputStream("2".getBytes());
        System.setIn(in);
        assertEquals(2, new MovieMenu().ratingVerification());
        System.setIn(sysInBackup);
    }

}