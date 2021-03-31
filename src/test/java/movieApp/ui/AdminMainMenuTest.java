package movieApp.ui;

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
        ArrayList<User> users = new ArrayList<>();
        users.add(new Admin("zul", "hello"));
        users.add(new Customer("alex", "12345"));

        String input = "5\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals(5, AdminMainMenu.displayMenu(0,users));

    }
}