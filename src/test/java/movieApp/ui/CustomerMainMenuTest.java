package movieApp.ui;

import movieApp.user.Admin;
import movieApp.user.Customer;
import movieApp.user.User;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CustomerMainMenuTest {

    @Test
    void testCustomerMainMenu(){
        ArrayList<User> users = new ArrayList<>();
        users.add(new Admin("zul", "hello"));
        users.add(new Customer("alex", "12345"));

        String input = "2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals(-1, CustomerMainMenu.displayMenu(0,users));
    }

}