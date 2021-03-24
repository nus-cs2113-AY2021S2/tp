package movieApp;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import movieApp.storage.Database;
import movieApp.ui.Ui;

public class MovieApp {

    public static void main(String[] args) throws Exception {
        new Database();
        new Ui();
    }
}