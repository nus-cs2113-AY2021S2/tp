package movieApp.parser;

import movieApp.Movie;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MovieFilterTest {

    public static ArrayList<Movie> MovieDatabase = new ArrayList<>();

    @Test
    void testPrintMovieList() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        new MovieFilter().printMovieList(MovieDatabase);
        String expected = "";
        assertArrayEquals(expected.getBytes(), output.toByteArray());
    }

    @Test
    void testGetFilter() {
        /*
        int input = 1;
        BigInteger bigInt = BigInteger.valueOf(input);
        InputStream in = new ByteArrayInputStream(bigInt.toByteArray());
        System.setIn(in);
        assertEquals(1, new MovieFilter().getFilter());
        */
        assertThrows(Exception.class, () -> new MovieFilter().getFilter());
    }

    @Test
    void testGetGenre() {
        assertThrows(Exception.class, () -> new MovieFilter().getGenre());
    }

    @Test
    void testFilterByGenre() {
        /*
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        new MovieFilter().filterByGenre(MovieDatabase);
        String expected = "";
        assertArrayEquals(expected.getBytes(), output.toByteArray());
        */
        assertThrows(Exception.class, () -> new MovieFilter().getGenre());
    }

    @Test
    void testGetRating() {
        assertThrows(Exception.class, () -> new MovieFilter().getGenre());
    }

    @Test
    void testFilterByRating() {
        assertThrows(Exception.class, () -> new MovieFilter().getGenre());
    }

    @Test
    void testGetShowingStatus() {
        assertThrows(Exception.class, () -> new MovieFilter().getGenre());
    }

    @Test
    void testFilterByShowingStatus() {
        assertThrows(Exception.class, () -> new MovieFilter().getGenre());
    }

    @Test
    void testGetCineplex() {
        assertThrows(Exception.class, () -> new MovieFilter().getGenre());
    }

    @Test
    void testFilterByCineplex() {
        assertThrows(Exception.class, () -> new MovieFilter().getGenre());
    }

    @Test
    void testGetTitle() {
        assertThrows(Exception.class, () -> new MovieFilter().getGenre());
    }

    @Test
    void testFilterByTitle() {
        assertThrows(Exception.class, () -> new MovieFilter().getGenre());
    }

    @Test
    void testGetMovieChoice() {
        assertThrows(Exception.class, () -> new MovieFilter().getGenre());
    }

    @Test
    void testSelectMovie() {
        assertThrows(Exception.class, () -> new MovieFilter().getGenre());
    }

    @Test
    void testFilter() {
        assertThrows(Exception.class, () -> new MovieFilter().getGenre());
    }
}