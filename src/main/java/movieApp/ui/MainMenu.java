package movieApp.ui;

import movieApp.user.User;

import java.util.ArrayList;

public interface MainMenu {

    static int displayMenu(int currentUserIndex, ArrayList<User> user) {
        System.out.println("\nWelcome, " + user.get(currentUserIndex).getName());
        return -1;
    }

}
