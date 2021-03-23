package seedu.connoisseur.commandlist;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.After;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.PrintStream;
import java.io.ByteArrayOutputStream;

public class CommandListTest {

    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void listReview_noReviewsExist() {

        System.setOut(new PrintStream(outContent));
        System.out.print("You have no reviews, type 'new' to start!");
        assertEquals("You have no reviews, type 'new' to start!", outContent.toString());
        System.setOut(originalOut);
    }
}
