package movieApp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CinemaTest {

    public static Cinema cinema = new Cinema("1", 1, 1, 1, 1, 1);

    @Test
    void testGetCinemaCode() {
        assertEquals("1", cinema.getCinemaCode());
    }

    @Test
    void testGetCapacity() {
        assertEquals(1, cinema.getCapacity());
    }

    @Test
    void testGetCinemaID() {
        assertEquals(1, cinema.getCinemaID());
    }

    @Test
    void testGetCineplexID() {
        assertEquals(1, cinema.getCineplexID());
    }

    @Test
    void testGetR() {
        assertEquals(1, cinema.getR());
    }

    @Test
    void testGetC() {
        assertEquals(1, cinema.getC());
    }
}