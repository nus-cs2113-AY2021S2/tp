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

}
