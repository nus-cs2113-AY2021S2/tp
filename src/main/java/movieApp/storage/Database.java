package movieApp.storage;

import movieApp.*;
import movieApp.user.Admin;
import movieApp.user.Customer;
import movieApp.user.User;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Database {
    public static ArrayList<Movie> MovieDatabase;
    public static ArrayList<Cineplex> CineplexDatabase;
    public static ArrayList<Showtimes> ShowtimesDatabase;
    public static ArrayList<User> users;

    public Database() throws Exception {
        importDatabase();
    }

    private static void importDatabase() throws Exception {
        MovieDatabase = importMovieDatabase();
        CineplexDatabase = importCineplexDatabase();
        ShowtimesDatabase = importShowtimesDatabase();
        users = importUserDatabase();
    }

    private static ArrayList<User> importUserDatabase() throws Exception {
        ArrayList<User> users = new ArrayList<>();
        users.add(new Admin("zul", "hello"));
        users.add(new Customer("alex", "12345"));
        return users;
    }

    private static ArrayList<Movie> importMovieDatabase() throws Exception {
        File f_movie = new File("data/movieList.txt");
        FileInputStream fis_movie = new FileInputStream(f_movie);
        ObjectInputStream ois_movie = new ObjectInputStream(fis_movie);

        ArrayList<Movie> MList = (ArrayList<Movie>) ois_movie.readObject();
        // System.out.println(MList);
        ois_movie.close();
        return MList;
    }

    private static ArrayList<Cineplex> importCineplexDatabase() throws Exception {
        File f_cineplex = new File("data/cineplexList.txt");
        FileInputStream fis_cineplex = new FileInputStream(f_cineplex);
        ObjectInputStream ois_cineplex = new ObjectInputStream(fis_cineplex);

        ArrayList<Cineplex> CPList = (ArrayList<Cineplex>) ois_cineplex.readObject();
        // System.out.println(CPList);
        ois_cineplex.close();
        return CPList;
    }

    private static ArrayList<Showtimes> importShowtimesDatabase() throws Exception {
        File f_showtime = new File("data/showtimeList.txt");
        FileInputStream fis_showtime = new FileInputStream(f_showtime);
        ObjectInputStream ois_showtime = new ObjectInputStream(fis_showtime);

        ArrayList<Showtimes> STList = (ArrayList<Showtimes>) ois_showtime.readObject();
        // System.out.println(STList);
        ois_showtime.close();
        return STList;
    }

    public static void deleteMovie(int choice) throws Exception {
        MovieDatabase.remove(choice - 1);
        try {
            File f_movie = new File("data/movieList.txt");
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

    public static void editMovie(int choice, int type) throws Exception {
        Movie selectedMovie = MovieDatabase.get(choice - 1);
        Scanner select = new Scanner(System.in);
        switch(type){
            case 1:
                System.out.println("Current title: " + selectedMovie.getMovieTitle() + ".\nInsert new title:");
                String newTitle = select.next();
                selectedMovie.setMovieTitle(newTitle);
                break;
            case 2:
                System.out.println("Current director: " + selectedMovie.getDirector() + ".\nInsert new director:");
                String newDirector = select.next();
                selectedMovie.setMovieTitle(newDirector);
                break;
            case 3:
                System.out.println("Current synopsis: " + selectedMovie.getSynopsis() + ".\nInsert new synopsis:");
                String newSynopsis = select.next();
                selectedMovie.setMovieTitle(newSynopsis);
                break;
        }

        try {
            File f_movie = new File("data/movieList.txt");
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
        System.out.println("The changes have been saved to the database.");
    }
}
