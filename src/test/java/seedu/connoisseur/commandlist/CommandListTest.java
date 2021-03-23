package seedu.connoisseur.commandlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.*;

public class CommandListTest {

    @Test
     void listReview_noReviewsExist() {

        PrintStream save_out=System.out;
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        System.out.println("You have no reviews, type 'new' to start!");
        assertEquals("You have no reviews, type 'new' to start!\n", out.toString());

        System.setOut(save_out);
    }
}
