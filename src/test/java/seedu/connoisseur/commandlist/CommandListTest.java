package seedu.connoisseur.commandlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.PrintStream;
import java.io.ByteArrayOutputStream;

public class CommandListTest {

    @Test
    void listReview_noReviewsExist() {

        PrintStream saveOut = System.out;
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        System.out.println("You have no reviews, type 'new' to start!");
        assertEquals("You have no reviews, type 'new' to start!\n", out.toString());

        System.setOut(saveOut);
    }
}
