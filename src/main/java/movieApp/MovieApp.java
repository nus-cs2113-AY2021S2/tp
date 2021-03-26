package movieApp;

import movieApp.storage.Database;
import movieApp.ui.Ui;

public class MovieApp {

    public static void main(String[] args) throws Exception {
        new Database();
        new Ui();
    }
}