package movieApp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReviewTest {

    public static Review review = new Review("The movie is nice!", 5);

    @Test
    void testGetComment() {
        assertEquals("The movie is nice!", review.getComment());
    }

    @Test
    void testGetRating() {
        assertEquals(5, review.getRating());
    }
}