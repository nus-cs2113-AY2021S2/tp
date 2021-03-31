package movieApp;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MovieTest {
    public static String[] testStringCast = new String[]{"Test1", "Test2", "Test3"};
    public static ArrayList<Review> testReviews = new ArrayList<Review>(Arrays.asList(new Review("Good", 5),
            new Review("Bad", 1)));
    public static Movie movie = new Movie("Movie Test", 1, 2020, 3, 20, 2020,
            12, 1, "Director Test", testStringCast, "Test Genre", "Test Synopsis",
            1, testReviews);

    public static Movie changeable = new Movie("Movie Test", 1, 2020, 3, 20,
            2020, 12, 1, "Director Test", new String[]{}, "Test Genre",
            "Test Synopsis", 1, new ArrayList<Review>());

    public static Movie changeable2 = new Movie("Movie Test", 1, 2020, 3, 20,
            2020, 12, 1, "Director Test", new String[]{}, "Test Genre",
            "Test Synopsis", 1, new ArrayList<Review>());
    //create dummy movie
    //assertTrue, assertFalse, assertEquals



    @Test
    void testGetMovieTitle() {
        assertEquals("Movie Test", movie.getMovieTitle());
    }

    @Test
    void testSetMovieTitle(){
        changeable.setMovieTitle("Changed");
        assertEquals("Changed", changeable.getMovieTitle());
    }

    @Test
    void testGetMovieID(){
        assertEquals(1, movie.getMovieID());
    }

    @Test
    void testGetOverallRatingNoReviews (){
        assertEquals((float) -1, changeable.getOverallRating());
    }
    @Test
    void testGetOverallRatingHasReviews (){
        assertEquals((float) 3, movie.getOverallRating());
    }

    @Test
    void testGetStartDate(){
        Calendar startDate = Calendar.getInstance();
        movie.getStartDate().set(Calendar.MILLISECOND, 0);
        startDate.set(Calendar.MILLISECOND, 0);
        startDate.set(2020, 2, 20,0,0,0);
        assertEquals(startDate, movie.getStartDate());
    }

    @Test
    void testGetEndDate(){
        Calendar endDate = Calendar.getInstance();
        movie.getEndDate().set(Calendar.MILLISECOND, 0);
        endDate.set(Calendar.MILLISECOND, 0);
        endDate.set(2020, 11, 1,0,0,0);
        assertEquals(endDate, movie.getEndDate());
    }

    @Test
    void testGetDirector(){
        assertEquals("Director Test", movie.getDirector());
    }

    @Test
    void testSetDirector(){
        changeable.setDirector("Changed");
        assertEquals("Changed", changeable.getDirector());
    }

    @Test
    void testPrintCast(){
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        changeable.printCast();
        String expected = "";
        assertArrayEquals(expected.getBytes(), output.toByteArray());
    }

    @Test
    void testGetGenre(){
        assertEquals("Test Genre", movie.getGenre());
    }

    @Test
    void testGetSynopsis(){
        assertEquals("Test Synopsis", movie.getSynopsis());
    }

    @Test
    void testSetSynopsis(){
        changeable.setSynopsis("Changed Synopsis");
        assertEquals("Changed Synopsis", changeable.getSynopsis());
    }

    @Test
    void testPrintReviews(){
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        changeable.printReviews();
        String expected = "";
        assertArrayEquals(expected.getBytes(), output.toByteArray());
    }

    @Test
        //also tests getShowingStatus
    void testSetMovieStatus(){
        changeable.setMovieStatus(1);
        assertEquals(Movie.movieStatus.COMINGSOON.name(), changeable.getShowingStatus());
    }

    @Test
    void testAddReview() {
        changeable2.addReview("Change", 1);
        changeable2.addReview("Change", 100);
        assertEquals(50.5, changeable2.getOverallRating());
    }

    //Did not test displayMovie as it involves using the previously tested getters.
}