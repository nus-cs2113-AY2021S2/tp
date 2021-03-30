package movieApp.app;

import movieApp.ui.Login;
import movieApp.storage.Database;
import movieApp.ui.AdminMainMenu;
import movieApp.ui.CustomerMainMenu;
import movieApp.user.User;

import java.util.ArrayList;

public class MovieApp {

    private static int currentUserIndex;
    private static String SALT = "sLUm7IkYrQhKrNQNIYcyMaCero3bk5";
    private static ArrayList<User> user;

    public static void main(String[] args) throws Exception {
        new Database();
        user = new ArrayList<>(Database.users);

        while (true) {
            currentUserIndex = Login.login(user, SALT);

            if(currentUserIndex < 0) {
                System.out.println("Exiting...");
                return;
            }

            if(user.get(currentUserIndex).getUserType().equals("Customer")) {
                CustomerMainMenu.displayMenu(currentUserIndex, user);
            } else {
                AdminMainMenu.displayMenu(currentUserIndex, user);
            }
        }
    }
}