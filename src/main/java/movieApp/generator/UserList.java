package movieApp.generator;

import movieApp.user.Admin;
import movieApp.user.Customer;
import movieApp.user.User;

import java.util.ArrayList;
import java.util.Arrays;

public class UserList {

    public static ArrayList<User> getDefaultUsers(){

        return new ArrayList<User>(Arrays.asList(
                new Admin("ADMIN1", "6lcnRS7gdK90CYsb3mIu9A==~TzgBIVrD5za8LiAWhZGSgg=="),
                new Customer("CUSTOMER1", "6lcnRS7gdK90CYsb3mIu9A==~TzgBIVrD5za8LiAWhZGSgg==")));
    }
}
