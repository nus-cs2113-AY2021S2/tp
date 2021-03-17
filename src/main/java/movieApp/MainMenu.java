package movieApp;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainMenu {
    static ArrayList<Movie> MovieDatabase;
    static ArrayList<Cineplex> CineplexDatabase;
    static ArrayList<Showtimes> ShowtimesDatabase;
        

    public static ArrayList<Movie> importMovieDatabase() throws Exception {
        File f_movie = new File("data\\movieList.txt");
        FileInputStream fis_movie = new FileInputStream(f_movie);
        ObjectInputStream ois_movie = new ObjectInputStream(fis_movie);

        ArrayList<Movie> MList = (ArrayList<Movie>) ois_movie.readObject();
        System.out.println(MList);
        ois_movie.close();
        return MList;
    }

    public static ArrayList<Cineplex> importCineplexDatabase() throws Exception {
        File f_cineplex = new File("data\\cineplexList.txt");
        FileInputStream fis_cineplex = new FileInputStream(f_cineplex);
        ObjectInputStream ois_cineplex = new ObjectInputStream(fis_cineplex);

        ArrayList<Cineplex> CPList = (ArrayList<Cineplex>) ois_cineplex.readObject();
        System.out.println(CPList);
        ois_cineplex.close();
        return CPList;
    }

    private static ArrayList<Showtimes> importShowtimesDatabase() throws Exception {
        File f_showtime = new File("data\\showtimeList.txt");
        FileInputStream fis_showtime = new FileInputStream(f_showtime);
        ObjectInputStream ois_showtime = new ObjectInputStream(fis_showtime);

        ArrayList<Showtimes> STList = (ArrayList<Showtimes>) ois_showtime.readObject();
        System.out.println(STList);
        ois_showtime.close();
        return STList;
    }

    public static int getOption() {
        int menu_choice = -1;
        Scanner sc = new Scanner(System.in);
        while ((menu_choice < 1) || (menu_choice > 2)) {
            System.out.println("======== Menu Choice =======");
            System.out.println(" 1 Select a movie\n 2 Exit\n============================\nPlease indicate your choice:");
            if (!sc.hasNextInt()) {
                System.out.println("Please input an integer.\n");
                sc.next();
                continue;
            }
            menu_choice = sc.nextInt();
            if ((menu_choice < 1) || (menu_choice > 2)) {
                System.out.println("Please input an integer between 1 and 2.\n");
            }
        }
        return menu_choice;
    }

    public static void importDatabase() throws Exception {
        MovieDatabase = importMovieDatabase();
        CineplexDatabase = importCineplexDatabase();
        ShowtimesDatabase = importShowtimesDatabase();
    }

    public static void main(String[] args) throws Exception {
        int Option;

        importDatabase();
        ArrayList<Movie> MovieList = new ArrayList<>(MovieDatabase);

        Option = getOption();

        if (Option != 2) {
            Movie movie = MovieFilter.filter(MovieList, CineplexDatabase);
            if (movie != null) MovieMenu.movieAction(movie);
        }

        System.out.println("\n\nThank you for your time.\nHave a good day!\n\nSystem Exiting...");
        System.exit(0);
    }
}