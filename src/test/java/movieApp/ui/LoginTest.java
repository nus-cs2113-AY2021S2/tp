package movieApp.ui;

import movieApp.user.Admin;
import movieApp.user.Customer;
import movieApp.user.User;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LoginTest {

    @Test
    void TestLogin() throws Exception {
        ArrayList<User> users = new ArrayList<>();
        users.add(new Admin("IRVIN", "LgTVP/ep+g6U0Bx9DDSQvw==~3vlnbgaXMv92c9PNMY5iUA=="));
        users.add(new Customer("HELLO", "bTf+0p5Kownivvj2Q9ffeA==~liBWY/KKtUmUT9w5NYOyww=="));


        String input = "IRVIN\npassword1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals(0, Login.login(users));
    }

}