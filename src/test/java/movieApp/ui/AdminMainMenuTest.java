package movieApp.ui;

import movieApp.storage.Database;
import movieApp.user.Admin;
import movieApp.user.Customer;
import movieApp.user.User;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AdminMainMenuTest {

    @Test
    void testDisplayMenu() throws Exception {
        new Database();

        String input = "5\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals(5, AdminMainMenu.displayMenu(0,Database.users));

    }
}