package movieApp.ui;

import movieApp.user.User;

import java.util.ArrayList;

public interface MainMenu {

    /**
     * Display the main landing page a user will encounter when using the app
     *
     * @param currentUserIndex the position in ArrayList of User objects, that corresponds to the current user
     * @param user             the ArrayList of all User objects.
     */
    static int displayMenu(int currentUserIndex, ArrayList<User> user) {
        System.out.println("\nWelcome, " + user.get(currentUserIndex).getName());
        return -1;
    }

}
