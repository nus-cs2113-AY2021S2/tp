package movieApp;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CineplexTest {

    public static ArrayList<Integer> movieList = new ArrayList<>();
    public static Cineplex cineplex = new Cineplex(1, "1", movieList);

    @Test
    void testGetCineplexID() {
        assertEquals(1, cineplex.getCineplexID());
    }

    @Test
    void testGetCineplexName() {
        assertEquals("1", cineplex.getCineplexName());
    }

    @Test
    void testGetMovieList() {
        assertEquals(movieList, cineplex.getMovieList());
    }

    @Test
    void testGetCinemaList() {
        assertEquals(new ArrayList<>(), cineplex.getCinemaList());
    }
}