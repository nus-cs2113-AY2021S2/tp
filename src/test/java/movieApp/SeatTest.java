package movieApp;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SeatTest {
    public static Seat seatTaken = new Seat(1, 2, true);
    public static Seat seatNotTaken = new Seat(1, 2, false);
    public static Seat changeable = new Seat(1, 2, false);

    @Test
    void testGetStatusTrue() {
        assertTrue(seatTaken.getStatus());
    }

    @Test
    void testGetStatusFalse() {
        assertFalse(seatNotTaken.getStatus());
    }

    @Test
    void testSetStatus(){
        changeable.setStatus(false);
        assertFalse(seatNotTaken.getStatus());
    }
}
