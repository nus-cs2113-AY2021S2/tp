package movieApp;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Database {
    static ArrayList<Movie> MovieDatabase;
    static ArrayList<Cineplex> CineplexDatabase;
    static ArrayList<Showtimes> ShowtimesDatabase;

    public Database() throws Exception {
        importDatabase();
    }

    public static void importDatabase() throws Exception {
        MovieDatabase = importMovieDatabase();
        CineplexDatabase = importCineplexDatabase();
        ShowtimesDatabase = importShowtimesDatabase();
    }

    public static ArrayList<Movie> importMovieDatabase() throws Exception {
        File f_movie = new File("data\\movieList.txt");
        FileInputStream fis_movie = new FileInputStream(f_movie);
        ObjectInputStream ois_movie = new ObjectInputStream(fis_movie);

        ArrayList<Movie> MList = (ArrayList<Movie>) ois_movie.readObject();
        // System.out.println(MList);
        ois_movie.close();
        return MList;
    }

    public static ArrayList<Cineplex> importCineplexDatabase() throws Exception {
        File f_cineplex = new File("data\\cineplexList.txt");
        FileInputStream fis_cineplex = new FileInputStream(f_cineplex);
        ObjectInputStream ois_cineplex = new ObjectInputStream(fis_cineplex);

        ArrayList<Cineplex> CPList = (ArrayList<Cineplex>) ois_cineplex.readObject();
        // System.out.println(CPList);
        ois_cineplex.close();
        return CPList;
    }

    private static ArrayList<Showtimes> importShowtimesDatabase() throws Exception {
        File f_showtime = new File("data\\showtimeList.txt");
        FileInputStream fis_showtime = new FileInputStream(f_showtime);
        ObjectInputStream ois_showtime = new ObjectInputStream(fis_showtime);

        ArrayList<Showtimes> STList = (ArrayList<Showtimes>) ois_showtime.readObject();
        // System.out.println(STList);
        ois_showtime.close();
        return STList;
    }

    // If you need to update any of the databases, can rip some of the code from here
    // TODO: Need edit Ui class, constructor and getOption, to use this function.
    // TODO: Create a more generic function that can be used to update any of the databases so don't keep repeating code
    public static void deleteMovie() throws Exception {
        System.out.println("Select a movie to be deleted from the list (enter the number)");
        int i = 1;
        for(Movie movie : MovieDatabase){
            System.out.println(i + ". " + movie.getMovieTitle() + " , ID: " + movie.getMovieID());
            i++;
        }

        Scanner sc = new Scanner(System.in);
        int choice = -1;
        while ((choice < 1) || (choice > MovieDatabase.size())) {
            System.out.println("Please enter your choice: ");
            if (!sc.hasNextInt()) {
                System.out.println("Please input an integer.\n");
                sc.next();
                continue;
            }
            choice = sc.nextInt();
            if ((choice < 0) ||(choice > MovieDatabase.size())) {
                System.out.println("Please input an integer within the range.\n");
            }
        }
        sc.close();

        MovieDatabase.remove(choice - 1);
        try {
            File f_movie = new File("data\\movieList.txt");
            FileOutputStream fos_movie = new FileOutputStream(f_movie);
            ObjectOutputStream oos_movie = new ObjectOutputStream(fos_movie);
            oos_movie.writeObject(MovieDatabase);
            oos_movie.close();
            fos_movie.close();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
        System.out.println("The movie has been removed from the database.");
    }
}
