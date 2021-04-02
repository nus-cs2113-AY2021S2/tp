package movieApp.ui;

import movieApp.storage.Database;
import movieApp.user.Admin;
import movieApp.user.Customer;
import movieApp.user.User;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class CustomerMainMenuTest {

    @Test
    void testCustomerMainMenu() throws Exception {
        new Database();

        String input = "2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals(-1, CustomerMainMenu.displayMenu(0,Database.users));
    }

}